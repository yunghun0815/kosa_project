package com.kosa.app.common;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.kosa.app.model.MemberVo;

@Component
public class LoginSuccessHandler implements AuthenticationSuccessHandler{

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		HttpSession session = request.getSession();
		MemberVo vo = (MemberVo) authentication.getPrincipal();
		
	    session.setAttribute("memberId", vo.getMemberId()); 
	    session.setAttribute("name", vo.getName());
	    
	    response.sendRedirect("/");
	}

}
