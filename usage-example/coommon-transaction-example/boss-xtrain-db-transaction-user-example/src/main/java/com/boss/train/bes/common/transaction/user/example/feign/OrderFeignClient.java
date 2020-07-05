package com.boss.train.bes.common.transaction.user.example.feign;

import com.boss.train.bes.common.transaction.user.example.entity.Order;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Program Name: springcloud-nacos-seata
 * <p>
 * Description:
 * <p>
 *
 * @author lzx
 * @date
 */
@FeignClient(name = "order-seata-service")
public interface OrderFeignClient {
    @PostMapping("/order_add")
    Boolean orderAdd(@RequestBody Order order);
    @PostMapping("/order_add_fail")
    Boolean orderAddFail(@RequestBody Order order);
}
