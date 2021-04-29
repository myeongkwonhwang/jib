package com.j2kb.jibapi.global.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;

/**
 * Created by mkhwang on 2021/04/28
 * Email : orange2652@gmail.com
 * Github : https://github.com/myeongkwonhwang
 */
@Component
@Slf4j
public class InterceptorConfig implements HandlerInterceptor{
	
	//파라미터중 로그에 표기하면 안되는 정보의 파라미터명들을 정의 한다.
	private String[] privateStrings = {"password", "pass", "pwd"};
	private List<String> priavteStringsToList = Arrays.asList(privateStrings);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
		
		//TODO : 실제 업무에 필요한 로직 처리
		log.info("##########################");
		log.info("[{}] preHandle > {}", this.getClass().getName(), request);
		log.info("requestURI : {}", request.getRequestURI());
		log.info("method : {}", request.getMethod());
		log.info("parameters : {}", getParameters(request));
		log.info("##########################");
	    
	    return true;
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
		//TODO : 실제 업무에 필요한 로직 처리
	}
	
	/**
	 * 현재요청의 파라미터를 반환 한다.
	 * @param request
	 * @return
	 */
	private String getParameters(HttpServletRequest request) {
		
		StringBuffer	posted		= new StringBuffer();
		Enumeration<?>	enumeration	= request.getParameterNames();
		if(null != enumeration) { posted.append("?"); }
		while(enumeration.hasMoreElements()) {
			if(posted.length() > 1) {
				posted.append("&");
			}
			String curr = (String) enumeration.nextElement();
			posted.append(curr + "=");
			posted.append(privateParamContainsMasking(request, curr));
		}

		posted.append(getRequestIp(request));
		return posted.toString();
	}

	private String privateParamContainsMasking(HttpServletRequest request, String curr) {
		if(this.priavteStringsToList.contains(curr)) {
			return "**masked**";
		}

		return request.getParameter(curr);
	}

	private String getRequestIp(HttpServletRequest request) {
		String ip = request.getHeader("X-FORWARDED-FOR");
		if(ip == null) {
			return this.getRemoteAddr(request);
		}
		return ip;
	}

	/**
	 * proxy 서버로 부터 요청된 현재요청의 실제 IP를 반환 한다.
	 * @param request
	 * @return
	 */
	private String getRemoteAddr(HttpServletRequest request) {
	    String ipFromHeader = request.getHeader("X-FORWARDED-FOR");
	    if(ipFromHeader != null && ipFromHeader.length() > 0) {
	        log.debug("ip from proxy - X-FORWARDED-FOR : " + ipFromHeader);
	        return ipFromHeader;
	    }
	    return request.getRemoteAddr();
	}

}
