package com.java.app.custom.annotations;

import com.java.app.custom.annotations.impl.AuthorizationImpl;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Configuration
public class AuthAspect {
    @Autowired
    private  AuthorizationImpl authBean;

    @Before("@annotation(com.java.app.custom.annotations.Authorized) && args(request,..)")
    public  void before(HttpServletRequest request){
        if (request == null) {
            throw
                    new RuntimeException("request should be HttpServletRequesttype");
        }

        if(authBean.authorize(request.getHeader("Authorization"))){
            request.setAttribute(
                    "userSession",
                    "session information which cann be acces in controller"
            );
        }else {
            throw new RuntimeException("auth error..!!!");
        }

    }

}