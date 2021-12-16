package com.dhis.demo;

import com.auth0.jwt.JWT;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.Claim;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AnyRequestMatcher;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SSOFilter extends AbstractAuthenticationProcessingFilter {

    public SSOFilter(AuthenticationManager authenticationManager) {

        super(AnyRequestMatcher.INSTANCE);
        setAuthenticationManager(authenticationManager);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws JWTDecodeException {

        List<String> tokens = this.parseHeaders(request);
        Map<String, Claim> user = this.mergeTokens(tokens);
    
        return null;
    }

    private Map<String, Claim> mergeTokens(List<String> tokens) throws JWTDecodeException {
        Map<String, Claim> merged = new HashMap<>();

        tokens.forEach(token -> {
            Map<String, Claim> claims = JWT.decode(token).getClaims();

            merged.putAll(claims);
        });

        return merged;
    }

    private List<String> parseHeaders(HttpServletRequest request) {

        String authorization = request.getHeader("Authorization");

        if (authorization != null && !authorization.isEmpty()) {
            List<String> authSplit = List.of(authorization.trim().split(" "));

            authorization = authSplit.get(authSplit.size() - 1);
        }

        return Arrays.asList(
                authorization,
                request.getHeader("x-auth-request-access-token")
        )
                .stream()
                .filter(item -> item != null && !item.isEmpty())
                .collect(Collectors.toList());
    }
}
