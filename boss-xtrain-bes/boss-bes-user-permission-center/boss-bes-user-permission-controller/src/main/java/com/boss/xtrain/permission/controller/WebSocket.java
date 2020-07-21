package com.boss.xtrain.permission.controller;

import com.alibaba.fastjson.JSON;
import com.aliyuncs.exceptions.ErrorCodeConstant;
import com.boss.xtrain.common.core.exception.error.BusinessError;
import com.boss.xtrain.common.core.http.CommonResponse;
import com.boss.xtrain.common.core.http.CommonResponseUtil;
import com.boss.xtrain.permission.pojo.dto.UserOnlineInfoDTO;
import com.boss.xtrain.permission.service.UserOnlineInfoService;
import com.boss.xtrain.permission.utils.ApplicationContextRegister;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
@Component
@ServerEndpoint(value = "/education/bes/v1/system/user/websocket/{userOnlineInfoId}")
public class WebSocket {

    private static int onlineCount = 0;
    private static Map<String, WebSocket> clients = new ConcurrentHashMap<String, WebSocket>();
    private Session session;
    private String userOnlineInfoId;

    @OnOpen
    public void onOpen(@PathParam("userOnlineInfoId") String userOnlineInfoId, Session session) throws IOException {
        this.userOnlineInfoId = userOnlineInfoId;
        this.session = session;
        beforeOpen();

        addOnlineCount();
        clients.put(userOnlineInfoId, this);
        log.info("{}: 上线，已连接: {}", userOnlineInfoId, getOnlineCount());
    }

    @OnClose
    public void onClose() throws IOException {
        beforeClose();
        clients.remove(userOnlineInfoId);
        subOnlineCount();
        log.info("{}: 下线，已连接: {}", userOnlineInfoId, getOnlineCount());
    }

    @OnMessage
    public void onMessage(String message) throws IOException {
        // DataWrapper res = new DataWrapper();
        // System.out.println("message:" + message);
        // JSONObject req = JSONObject.parseObject(message);

        // 发送数据给服务端
        // sendMessageAll(JSON.toJSONString(res));
    }

    @OnError
    public void onError(Session session, Throwable error) {
        error.printStackTrace();
    }

    public void sendMessageTo(CommonResponse commonResponse, String to){
        for (WebSocket item : clients.values()) {
            if (item.userOnlineInfoId.equals(to)){
                item.session.getAsyncRemote().sendText(JSON.toJSONString(commonResponse));
                break;
            }
        }
    }

    public void sendMessageToList(CommonResponse commonResponse, List<String> toList) {
        for (WebSocket item : clients.values()) {
            if(toList.contains(item.userOnlineInfoId)){
                item.session.getAsyncRemote().sendText(JSON.toJSONString(commonResponse));
            }
        }
    }

    /**
     * 连接前的操作，判断该用户是否已连接，若已登录则挤退
     * @throws IOException
     */
    public void beforeOpen() throws IOException {
        for (WebSocket item : clients.values()) {
            if(item.userOnlineInfoId.equals(userOnlineInfoId)){
                sendMessageTo(CommonResponseUtil.error(BusinessError.SYSTEM_MANAGER_ONLINE_INSERT_ERROR), userOnlineInfoId);
                onClose();
                break;
            }
        }
    }

    /**
     * 下线前的操作，调用退出登录请求
     * websocket无法使用注解注入bean ,因为每一次websocket的握手连接就像是new了一个对象
     * @throws IOException
     */
    public void beforeClose() throws IOException {
        UserOnlineInfoDTO userOnlineInfoDto = new UserOnlineInfoDTO();
        userOnlineInfoDto.setId(Long.parseLong(userOnlineInfoId));

        // 方法1，获取spring上下文
        ApplicationContext act = ApplicationContextRegister.getApplicationContext();
        UserOnlineInfoService userOnlineService = act.getBean(UserOnlineInfoService.class);

        // 方法2，获取ApplicationContext上下文，getBean后只能使用接口，不能使用Impl
        //IUserOnlineService userOnlineService = ContextLoader.getCurrentWebApplicationContext().getBean(IUserOnlineService.class);

        userOnlineService.update(userOnlineInfoDto);
    }

    public static synchronized int getOnlineCount() {
        return onlineCount;
    }

    public static synchronized void addOnlineCount() {
        WebSocket.onlineCount++;
    }

    public static synchronized void subOnlineCount() {
        WebSocket.onlineCount--;
    }

    public static synchronized Map<String, WebSocket> getClients() {
        return clients;
    }
}
