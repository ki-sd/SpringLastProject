package com.sist.intercepter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
/*
 *                                            | => preHandle
 *                                            |     => 자동로그인 / ID저장
 *     사용자      ======== DispatcherServlet ======= HandlerMapping
 *       main.do                                        |
 *                                                  @GetMapping("main.do")
 *                                                  public String main(){
 *                                                  	=======
 *                                                      =======
 *                                                      return  ===> ViewResolver 전송  =====>  JSP
 *                                                  }             |                      |
 *                                                                | => postHandle        | => afterCompletion
 */
public class MainIntercepter extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("preHandle() Called....");
		return super.preHandle(request, response, handler);
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("postHandle() Called....");
		super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("afterCompletion() Called....");
		super.afterCompletion(request, response, handler, ex);
	}
	
}
