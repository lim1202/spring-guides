package com.example.jwt.common;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.example.jwt.config.PassAuth;
import com.example.jwt.entity.User;
import com.example.jwt.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class AuthenticationInterceptor implements HandlerInterceptor {

    @Autowired
    UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        
        // 如果不是映射到方法直接通过
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }

        HandlerMethod handlerMethod = (HandlerMethod)handler;
        Method method = handlerMethod.getMethod();

        if (method.isAnnotationPresent(PassAuth.class) && method.getAnnotation(PassAuth.class).enabled()) {
            return true;
        }

        String authorization = request.getHeader(TokenConstant.HEADER_NAME);
        if (!StringUtils.hasText(authorization)) throw new ForbiddenException();
        if (!StringUtils.startsWithIgnoreCase(authorization, TokenConstant.HEADER_PREFIX)) throw new ForbiddenException();
        String token = authorization.substring(7);
        
        String audience;
        try {
            audience = JWT.decode(token).getAudience().get(0);
        } catch (JWTDecodeException e) {
            throw new ForbiddenException();
        }

        User user = userService.findByCode(audience);
        if (ObjectUtils.isEmpty(user)) {
            throw new ForbiddenException();
        }
        
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(user.getAccessKey())).build();
        try {
            jwtVerifier.verify(token);
        } catch (JWTVerificationException e) {
            throw new ForbiddenException();
        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			@Nullable ModelAndView modelAndView) throws Exception {
    }
    
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
			@Nullable Exception ex) throws Exception {
	}
    
}