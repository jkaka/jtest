package com.kaka.common.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.impl.PublicClaims;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author jsk
 * @Date 2018/12/14 11:43
 */
public class TokenUtil {
    /**
     * 解压token
     *
     * @param token
     * @param secret
     * @return
     * @throws UnsupportedEncodingException
     */
    public static Map<String, Claim> getClaimsFromToken(String token, String secret) throws UnsupportedEncodingException {
        JWTVerifier verifier = JWT.require(Algorithm.HMAC256(secret))
                .build();
        DecodedJWT jwt = verifier.verify(token);
        return jwt.getClaims();
    }

    /**
     * 生成token
     *
     * @param claims
     * @param secret
     * @return
     * @throws UnsupportedEncodingException
     */
    public static String generateToken(Map<String, Object> claims, String secret) throws UnsupportedEncodingException {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put(PublicClaims.ALGORITHM, "HS256");
        map.put(PublicClaims.TYPE, "JWT");
        JWTCreator.Builder builder = JWT.create();
        for (Map.Entry<String, Object> entry : claims.entrySet()) {
            Object value = entry.getValue();
            if (Date.class.getName().equals(value.getClass().getName())) {
                builder.withClaim(entry.getKey(), (Date) value);
            } else {
                builder.withClaim(entry.getKey(), value.toString());
            }

        }
        return builder.withHeader(map).sign(Algorithm.HMAC256(secret));
    }

    /**
     * 获取当前登入用户名
     *
     * @param token
     * @param secret
     * @return
     */
    public static String getUsernameFromToken(String token, String secret) {
        String username = null;
        try {
            final Map<String, Claim> claims = TokenUtil.getClaimsFromToken(token, secret);
            if (null == claims) {

                throw new RuntimeException("getUsernameFromToken解释token结果返回为空,token=" + token);
            }
            Claim claim = claims.get(PublicClaims.SUBJECT);
            username = claim.asString();
        } catch (Throwable e) {

            throw new RuntimeException("getUsernameFromToken解释token失败,token=" + token, e);
        }
        return username;
    }

    /**
     * 获取token创建时间
     *
     * @param token
     * @param secret
     * @return
     */
    public static Date getCreatedDateFromToken(String token, String secret) {
        Date created;
        try {
            final Map<String, Claim> claims = TokenUtil.getClaimsFromToken(token, secret);
            if (null == claims) {

                throw new RuntimeException("getCreatedDateFromToken解释token结果返回为空,token=" + token);
            }
            Claim claim = claims.get(PublicClaims.ISSUED_AT);
            created = claim.asDate();
        } catch (Throwable e) {
            throw new RuntimeException("getCreatedDateFromToken解释token失败,token=" + token, e);
        }
        return created;
    }

    /**
     * 获取token失效时间
     *
     * @param token
     * @param secret
     * @return
     */
    public static Date getExpirationDateFromToken(String token, String secret) {
        Date expiration;
        try {
            final Map<String, Claim> claims = TokenUtil.getClaimsFromToken(token, secret);
            if (null == claims) {

                throw new RuntimeException("getExpirationDateFromToken解释token结果返回为空,token=" + token);
            }
            Claim claim = claims.get(PublicClaims.EXPIRES_AT);
            expiration = claim.asDate();
        } catch (Throwable e) {

            throw new RuntimeException("getExpirationDateFromToken解释token失败,token=" + token, e);
        }
        return expiration;
    }

    /**
     * token是否失效
     *
     * @param token
     * @param secret
     * @return true 失效 false 有效
     */
    public static Boolean isTokenExpired(String token, String secret) {
        final Date expiration = getExpirationDateFromToken(token, secret);
        if (null == expiration) {
            return Boolean.TRUE;
        }
        //当Date1小于Date2时，返回TRUE，当大于等于时，返回false；
        //date1.before(Date2);
        return expiration.before(new Date());
    }

    /**
     * created 在lastPasswordReset 之前，返回true 否则返回 false
     *
     * @param created
     * @param lastPasswordReset
     * @return
     */
    public static Boolean isCreatedBeforeLastPasswordReset(Date created, Date lastPasswordReset) {
        return (lastPasswordReset != null && (created.before(lastPasswordReset) || lastPasswordReset.equals(created)));
    }

    public static void main(String[] args) throws UnsupportedEncodingException {
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJwaW5nY2h1bnl1IiwidWlkIjoicGluZ2NodW55dSIsImNsaWVudElkIjoiYnJvd3NlciIsImlzcyI6IjAxMDg2NzciLCJleHAiOjE1MDM2NzEyMDAsImlhdCI6MTUwMzA2NjQwMH0.g2agQG0UfMvpckZnMW27CSJfsg1l5njw__bBSSyLHkI";
        Map<String, Claim> claims = (getClaimsFromToken(token, "!&WEOM48"));
        for (Map.Entry<String, Claim> entry : claims.entrySet()) {
            System.out.println(entry.getKey() + "=" + entry.getValue().asDate());
            if (Date.class.getName().equals(entry.getValue().getClass().getName())) {
                System.out.println(entry.getKey() + "=" + entry.getValue().asDate());
            } else {
                System.out.println(entry.getKey() + "=" + entry.getValue().asString());
            }

        }
        Date date = new Date();
        System.out.println(date.getClass().getName());
        Map<String, Object> data = new HashMap<>();
        data.put("aaaa", "aaaaa");
        System.out.println(generateToken(data, "!&WEOM48"));
    }
}
