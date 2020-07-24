package com.boss.xtrain.authentication.serializer;

import com.boss.xtrain.authentication.jwt.UserJwt;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.node.MissingNode;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.OAuth2Request;
import org.springframework.security.oauth2.provider.TokenRequest;

import java.io.IOException;
import java.io.Serializable;
import java.util.*;

/**
 * 使用 Jackson 序列化
 *
 * @author lzx
 * @version 1.0.0
 */
public class Jackson2Deserializer extends StdDeserializer<OAuth2Authentication> {
    protected Jackson2Deserializer(Class<?> vc) {
        super(vc);
    }

    private static String readString(ObjectMapper mapper, JsonNode jsonNode) {
        return readValue(mapper, jsonNode, String.class);
    }

    private static <T> T readValue(ObjectMapper mapper, JsonNode jsonNode, Class<T> clazz) {
        if (mapper == null || jsonNode == null || clazz == null) {
            return null;
        }
        try {
            return mapper.readValue(jsonNode.traverse(), clazz);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 读取值
     * @param mapper mapper
     * @param jsonNode jsonNode
     * @param type type
     * @param <T> 泛型
     * @return 结果
     */
    private static <T> T readValue(ObjectMapper mapper, JsonNode jsonNode, TypeReference<T> type) {
        if (mapper == null || jsonNode == null || type == null) {
            return null;
        }
        try {
            return mapper.readValue(jsonNode.traverse(), type);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 进行反序列化
     * @param jp parser
     * @param ctxt 反序列化context
     * @return 返回OAuth2Authentication
     * @throws IOException IOException
     * @throws JsonProcessingException JsonProcessingException
     */
    @Override
    public OAuth2Authentication deserialize(JsonParser jp, DeserializationContext ctxt)
        throws IOException, JsonProcessingException {
        ObjectMapper mapper = (ObjectMapper) jp.getCodec();
        JsonNode jsonNode = mapper.readTree(jp);
        JsonNode requestNode = readJsonNode(jsonNode, "oauth2Request");
        JsonNode userAuthenticationNode = readJsonNode(jsonNode, "userAuthentication");

        Authentication authentication = parseAuthentication(mapper, userAuthenticationNode);
        OAuth2Request request = parseOAuth2Request(mapper, requestNode);
        return new OAuth2Authentication(request, authentication);
    }

    /**
     * 序列化token
     * @param mapper mapper
     * @param json json
     * @return Authentication
     */
    private Authentication parseAuthentication(ObjectMapper mapper, JsonNode json) {
        if (mapper == null || json == null) {
            return null;
        }
        UserJwt principal = parseOAuth2User(mapper, json.get("principal"));
        Object credentials = readValue(mapper, json.get("credentials"), Object.class);
        Set<SimpleGrantedAuthority> grantedAuthorities = parseSimpleGrantedAuthorities(mapper, json.get("authorities"));
        return new UsernamePasswordAuthenticationToken(principal, credentials, grantedAuthorities);
    }

    /**
     * 序列化改对象
     * @param mapper mapper
     * @param json json
     * @return 返回UserJwt
     */
    private UserJwt parseOAuth2User(ObjectMapper mapper, JsonNode json) {
        if (mapper == null || json == null) {
            return null;
        }

        Long companyId = readValue(mapper, json.get("companyId"), Long.class);
        Long departmentId = readValue(mapper, json.get("departmentId"), Long.class);
        Long organizationId = readValue(mapper, json.get("organizationId"), Long.class);
        String companyName = readString(mapper, json.get("companyName"));
        String departmentName = readString(mapper, json.get("departmentName"));
        String username = readString(mapper, json.get("username"));
        String password = readString(mapper, json.get("password"));
        Long id = readValue(mapper, json.get("id"), Long.class);

        Boolean accountNonExpired = readValue(mapper, json.get("accountNonExpired"), Boolean.class);
        Boolean accountNonLocked = readValue(mapper, json.get("accountNonLocked"), Boolean.class);
        Boolean credentialsNonExpired = readValue(mapper, json.get("credentialsNonExpired"), Boolean.class);
        Boolean enabled = readValue(mapper, json.get("enabled"), Boolean.class);

        Set<SimpleGrantedAuthority> grantedAuthorities = parseSimpleGrantedAuthorities(mapper, json.get("authorities"));
        UserJwt userJwt = new UserJwt(username, "123456", enabled, accountNonExpired, credentialsNonExpired,
            accountNonLocked, grantedAuthorities);
        userJwt.setId(id);
        userJwt.setCompanyName(companyName);
        userJwt.setDepartmentName(departmentName);
        userJwt.setCompanyId(companyId);
        userJwt.setDepartmentId(departmentId);
        userJwt.setOrganizationId(organizationId);
        return userJwt;
    }

    /**
     * 序列化OAuth2Request
     * @param mapper mapper
     * @param json json
     * @return 返回OAuth2Request
     */
    private OAuth2Request parseOAuth2Request(ObjectMapper mapper, JsonNode json) {
        if (mapper == null || json == null) {
            return null;
        }
        HashMap<String, String> requestParameters = readValue(mapper, json.get("requestParameters"), HashMap.class);
        String clientId = readString(mapper, json.get("clientId"));
        String grantType = readString(mapper, json.get("grantType"));
        String redirectUri = readString(mapper, json.get("redirectUri"));
        Boolean approved = readValue(mapper, json.get("approved"), Boolean.class);

        Set<String> responseTypes = readValue(mapper, json.get("responseTypes"), Set.class);
        Set<String> scope = readValue(mapper, json.get("scope"), Set.class);
        Set<String> resourceIds = readValue(mapper, json.get("resourceIds"), Set.class);
        Map<String, Serializable> extensions = readValue(mapper, json.get("extensions"),
            new TypeReference<Map<String, Serializable>>() {
            });

        Set<SimpleGrantedAuthority> grantedAuthorities = parseSimpleGrantedAuthorities(mapper, json.get("authorities"));

        OAuth2Request request = new OAuth2Request(requestParameters, clientId,
            grantedAuthorities, approved, scope, resourceIds, redirectUri, responseTypes, extensions);
        TokenRequest tokenRequest = new TokenRequest(requestParameters, clientId, scope, grantType);
        request.refresh(tokenRequest);
        return request;
    }

    /**
     * 序列化权限对象数组
     * @param mapper mapper
     * @param json json
     * @return 返回集合
     */
    private Set<SimpleGrantedAuthority> parseSimpleGrantedAuthorities(ObjectMapper mapper, JsonNode json) {
        Set<LinkedHashMap<String, String>> authorities = readValue(mapper, json, Set.class);
        Set<SimpleGrantedAuthority> grantedAuthorities = new HashSet<>(0);
        if (authorities != null && !authorities.isEmpty()) {
            authorities.forEach(s -> {
                if (s != null && !s.isEmpty()) {
                    grantedAuthorities.add(new SimpleGrantedAuthority(s.get("authority")));
                }
            });
        }
        return grantedAuthorities;
    }

    /**
     * 读取json节点
     * @param jsonNode jsonNode
     * @param field field
     * @return JsonNode
     */
    private JsonNode readJsonNode(JsonNode jsonNode, String field) {
        return jsonNode.has(field) ? jsonNode.get(field) : MissingNode.getInstance();
    }
}
