package com.liu.controller;

import java.io.IOException;

import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class CharacterFilter extends OncePerRequestFilter  {



	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
	
		HttpSession session = request.getSession();
		String character = (String) session.getAttribute("character");
		if (character != null) {
			if (character.equals("manager")) {
				filterChain.doFilter(request, response);
			} else {
				request.getRequestDispatcher("http://localhost:8080/group5/Main/Home").forward(request, response);
			}
		} else {
			session.invalidate();
//			request.getRequestDispatcher("").forward(request, response);
			response.sendRedirect("http://localhost:8080/group5/html/Home.html");
		}

		
	}
	
	 @Override
	    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
	        String requestURI = request.getRequestURI();
	        // 指定不需要过滤的路径 /[]*
	        System.out.println(requestURI);
	        if (requestURI.startsWith("/group5/html/")||requestURI.startsWith("/group5/Main/")||requestURI.startsWith("/group5/css/")||requestURI.startsWith("/group5/img/")||requestURI.startsWith("/group5/js/")) {
	        	System.out.println("不用過濾");
	            return true;
	        }

	        // 其他情况都要进行过滤	
	        System.out.println("要過濾");
	        return false;
	    
	    }
}
