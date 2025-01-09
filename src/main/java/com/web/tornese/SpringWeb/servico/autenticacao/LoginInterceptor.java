package com.web.tornese.SpringWeb.servico.autenticacao;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
// import org.springframework.web.servlet.ModelAndView;

import com.web.tornese.SpringWeb.servico.CookieService;

@Component
public class LoginInterceptor implements HandlerInterceptor {
   @Override
   public boolean preHandle (HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
      
    try{
        if(CookieService.getCookie(request, "usuariosId") != null){
            return true;
        }
    }catch(Exception erro) {}
    
    response.sendRedirect("/login");
    return false;
   }
}
