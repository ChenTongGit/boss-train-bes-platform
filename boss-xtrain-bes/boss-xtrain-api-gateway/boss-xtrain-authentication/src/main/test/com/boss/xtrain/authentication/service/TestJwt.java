package com.boss.xtrain.authentication.service;

import com.alibaba.fastjson.JSON;
import org.junit.jupiter.api.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.jwt.Jwt;
import org.springframework.security.jwt.JwtHelper;
import org.springframework.security.jwt.crypto.sign.RsaSigner;
import org.springframework.security.jwt.crypto.sign.RsaVerifier;
import org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory;

import java.security.KeyPair;
import java.security.interfaces.RSAPrivateKey;
import java.util.HashMap;
import java.util.Map;

public class TestJwt {
    //创建jwt令牌
    @Test
    public void testCreateJwt(){
        //密钥库文件
        String keystore = "bes.keystore";
        //密钥库的密码
        String keystore_password = "123456";

        //密钥库文件路径
        ClassPathResource classPathResource = new ClassPathResource(keystore);
        //密钥别名
        String alias  = "beskey";
        //密钥的访问密码
        String key_password = "123456";
        //密钥工厂
        KeyStoreKeyFactory keyStoreKeyFactory = new KeyStoreKeyFactory(classPathResource,keystore_password.toCharArray());
        //密钥对（公钥和私钥）
        KeyPair keyPair = keyStoreKeyFactory.getKeyPair(alias, key_password.toCharArray());
        //获取私钥
        RSAPrivateKey aPrivate = (RSAPrivateKey) keyPair.getPrivate();
        //jwt令牌的内容
        Map<String,String> body = new HashMap<>();
        body.put("name","bes");
        String bodyString = JSON.toJSONString(body);
        //生成jwt令牌
        Jwt jwt = JwtHelper.encode(bodyString, new RsaSigner(aPrivate));
        //生成jwt令牌编码
        String encoded = jwt.getEncoded();
        System.out.println(encoded);
    }

    //校验jwt令牌
    @Test
    public void testVerify(){
        //公钥
        String publickey = "-----BEGIN PUBLIC KEY-----MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEApVWk6JIEARrSOeeDqWupXsVBLqMg/a9ktE3T+EcxQ9M78Fi4QOFkMearqn+sDO5tvuPl+Ifq5EtkuIC6MaX4iErglHsO5nufe1O3sCPGXXk39YoLt/IgG9eLvCJkY9qtKDCPj7KlvBagYw+8lcI+A/unj2bIC2S/nlBOFoA0wvb+FwTxalCqmss30/2nrHT+XDosopyA/QtTcF1xSEAyFEh3xCgBgO90+sX5rMdLadd/9ivs8eaUNlVz3dl5oPjNW2V4RnRgJmA9nrwel4wOs29iQuea9qH+7MnUZEQer02XM6L/F6fuSl44v2PAbjaSpamb4/cuZtK2D9dgh/tmeQIDAQAB-----END PUBLIC KEY-----";
        //jwt令牌
        String jwtString = "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJuYW1lIjoiYmVzIn0.RaLbYYdAtJhtRhLWFaUmFFnRbhLtl27fOtKdN3S7R2b9PAFw8oGNpYGP-Whj7mewgELaSt95ZEICxIc2TK6MVWniq0FBId3yJaVkk0mr3VwJXwq06STtLSYRao1jn6WyuJNGme_YwLzW7pxOQ4tZsvVECfJmwda5CyRfkKiXpeGuxSvNhRc-Pv-M3TknRqxYHeuPJTPea6hlAZpPluZhw7w35MlGg6kDuxYPCmHqLltqvU0grUVveDhh_3c3YK1gEhsRofxKgwoYuRriU1XvJjNhOv78fOiRRtA_fzyPgjMnqSrUoXa50qcyNicQn_f_g40536Fuhds1OHZGy412SQ";
        //校验jwt令牌
        Jwt jwt = JwtHelper.decodeAndVerify(jwtString, new RsaVerifier(publickey));
        //拿到jwt令牌中自定义的内容
        String claims = jwt.getClaims();
        System.out.println(claims);
    }
}
