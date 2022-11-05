package br.com.bragarodrigues.filter;



import br.com.bragarodrigues.model.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginFilter implements Filter {

	public static final String LOGIN_PAGE = "/login.jsf";		
	public static final String WELCOME_PAGE = "/welcome.jsf";		
	
	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
		System.out.println("LoginFilter.doFilter()");
		
		HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
		HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;		
		User user = (User)httpServletRequest.getSession().getAttribute("user");
		
		if (user != null) {
			if (httpServletRequest.getRequestURI().endsWith(LOGIN_PAGE)) {
				httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/pages" + WELCOME_PAGE);
			} else {
				filterChain.doFilter(servletRequest, servletResponse);
			}
		} else {
			if (!httpServletRequest.getRequestURI().endsWith(LOGIN_PAGE) && 
					!httpServletRequest.getRequestURI().contains("show.jpg") && 
					!httpServletRequest.getRequestURI().contains("hide.jpg") &&
					!httpServletRequest.getRequestURI().contains("styles.css") &&
					!httpServletRequest.getRequestURI().contains("scripts.js")) {
				httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/pages" + LOGIN_PAGE);
			} else {
				filterChain.doFilter(servletRequest, servletResponse);
			}
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
	}

}
