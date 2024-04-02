package com.project.project.JWT;


import com.project.project.user_config.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.security.Key;
import java.util.function.Function;


@Service
public class JwtService {
    private final Long EXPIRED_IN = (long) (100000 * 60 * 24);
    private String JwtKey = "53A73E5F1C4E0A2D3B5F2D784E6A1B423D6F247D1F6E5C3A596D635A75327855";

    private Date DateExpiration(String token) {
        return ExtractClaim(token, Claims::getExpiration);
    }

    public Claims ExtractAll(String token) {
        return Jwts
                .parser()
                .setSigningKey(Handler())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    private <T> T ExtractClaim(String token,
                               Function<Claims, T> claimsResolvers) {
        final Claims claims = ExtractAll(token);
        return claimsResolvers.apply(claims);
    }

    private String GenerateToken(Map<String, Object> additionalData,
                                     UserDetails userDetails) {
        return Jwts
                .builder()
                .setClaims(additionalData)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() +
                               EXPIRED_IN))
                .signWith(Handler(), SignatureAlgorithm.HS256)
                .compact();
    }

    public String GenerateTokenValue(UserDetails userDetails) {
        Map<String, Object> additionalDataMap = new HashMap<>();
        if(userDetails instanceof User user) {
            additionalDataMap.put("role", user.getRole());
        }

        return GenerateToken(additionalDataMap, userDetails);
    }

    private Key Handler() {
        return Keys
                .hmacShaKeyFor(Decoders
                        .BASE64
                        .decode(JwtKey)
                );
    }

    private boolean IsTokenExpired(String token) {
        return DateExpiration(token)
                .before(new Date());
    }

    public boolean IsTokenValid(String token, UserDetails userDetails) {
        return (UsernameExtraction(token)
                .equals(userDetails
                        .getUsername())) &&
                !IsTokenExpired(token);
    }

    public String UsernameExtraction(String token) {
        return ExtractClaim(token, Claims::getSubject);
    }
}
