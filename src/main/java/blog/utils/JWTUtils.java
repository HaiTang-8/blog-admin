package blog.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Calendar;
import java.util.Map;

public class JWTUtils {

    //密钥
    private static String TOKEN = "token!Q@W3e4rScxzchjxzhcjzxhc";

    //生成Token
    public static String getToken(Map<String,String> map){
        JWTCreator.Builder builder = JWT.create();
        //利用循环将传进来的Map中的所有内容写入Token中
        map.forEach((k,v)->{
            builder.withClaim(k,v);
        });
        //获取日期
        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.DATE,1); //默认token1天过期
        //设置token过期时间
        builder.withExpiresAt(instance.getTime());
        //返回token
        return builder.sign(Algorithm.HMAC256(TOKEN)).toString();
    }

    //验证token
    public static void verify(String token){
        JWT.require(Algorithm.HMAC256(TOKEN)).build().verify(token);
    }

    //获取Token中的payload
    public static DecodedJWT getTokenPayload(String token){
        return JWT.require(Algorithm.HMAC256(TOKEN)).build().verify(token);
    }
}
