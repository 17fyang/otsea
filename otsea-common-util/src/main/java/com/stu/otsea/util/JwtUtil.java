package com.stu.otsea.util;

import com.alibaba.fastjson.JSONObject;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.Date;

/**
 * @author: 乌鸦坐飞机亠
 * @date: 2020/12/23 17:17
 * @Description:
 */
public class JwtUtil {
    private static final Logger logger = LoggerFactory.getLogger(JwtUtil.class);
    // 签名密钥长度(bits)
    private static final int KEY_BITS_SIZE = 1024;
    // 默认token有效期(一个小时)
    public static final long DEFAULT_TTL = 1000 * 60 * 60;

    private static Algorithm algorithm;
    private static JWTVerifier defaultVerifier;

    static {
        try {
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            keyPairGenerator.initialize(KEY_BITS_SIZE);

            final KeyPair keyPair = keyPairGenerator.genKeyPair();
            final PublicKey publicKey = keyPair.getPublic();
            final PrivateKey privateKey = keyPair.getPrivate();

            algorithm = Algorithm.RSA256((RSAPublicKey) publicKey, (RSAPrivateKey) privateKey);
            defaultVerifier = JWT.require(algorithm).build();

        } catch (NoSuchAlgorithmException e) {
            logger.error("fail to init JwtUtil !!!");
            e.printStackTrace();
        }

    }

    /**
     * 签发一个key为id，内容为String类型的token
     *
     * @param id
     * @return token
     */
    public static String signById(String id) {
        return JwtUtil.signByBuilder(JWT.create().withClaim(TokenKeys.ID, id));
    }

    /**
     * 验证一个token，如果成功则返回payload中key为id的值,失败返回空
     *
     * @param token
     * @return
     */
    public static String verifyId(String token) {
        JSONObject payload = JwtUtil.verify(token);
        if (payload == null) return null;

        return payload.getString(TokenKeys.ID);
    }

    /**
     * 根据已有的JWTBuilder签发一个token并设置为默认的过期时间
     *
     * @param jwtBuilder
     * @return token
     */
    public static String signByBuilder(JWTCreator.Builder jwtBuilder) {
        Date expireDate = new Date(System.currentTimeMillis() + DEFAULT_TTL);
        return jwtBuilder.withExpiresAt(expireDate).sign(algorithm);
    }

    /**
     * 验证一个签名并返回payload,失败则返回null
     *
     * @param token
     * @return payload
     */
    public static JSONObject verify(String token) {
        try {
            String payloadBase64 = defaultVerifier.verify(token).getPayload();
            String payload = new String(Base64.decodeBase64(payloadBase64.getBytes()));
            return (JSONObject) JSONObject.parse(payload);
        } catch (Exception e) {
            return null;
        }
    }

}
