package com.ayushguru.carpool.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class SignupInterceptor extends HandlerInterceptorAdapter {

        @Override
        public boolean preHandle(HttpServletRequest request, 
               HttpServletResponse response, Object handler) throws Exception {

          String emailAddress = request.getParameter("emailaddress");
          String password = request.getParameter("password");

          if(StringUtils.isEmpty(emailAddress) ||             
          StringUtils.containsWhitespace(emailAddress) ||
          StringUtils.isEmpty(password) || 
          StringUtils.containsWhitespace(password)) {
            throw new Exception("Invalid Email Address or Password. Please try again.");
          }

          return true;
        }
}
