package com.travelapi3.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.travelapi3.payload.loginDtp;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class JWTService{

    @Value("${jwt.key}")
    private String key;

    @Value("${jwt.issuer}")
    private String issuer;

    @Value("${jwt.expiry}")
    private int expiry;

    private String USERNAME="username";

    private Algorithm algo;

    @PostConstruct
    public void construct(){

        algo = Algorithm.HMAC256(key);
    }

    public String generatetoken(loginDtp dto){


        return JWT.create()
                .withClaim(USERNAME,dto.getUsername())
                .withExpiresAt(new Date(System.currentTimeMillis()+expiry))
                .withIssuer(issuer)
                .sign(algo);
    }

    public String getusername(String token){
        DecodedJWT dd = JWT.require(algo).withIssuer(issuer).build().verify(token);
        String username = dd.getClaim(USERNAME).asString();
        return username;
    }
}
