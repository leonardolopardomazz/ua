package ar.com.ua.commons;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import jakarta.servlet.http.HttpSession;

@Component
public class ManejoSesion {
	
	public HttpSession getHttpSession () {
		ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		HttpSession httpSession = attr.getRequest().getSession();
		
		return httpSession;
	}
	
	public void setAttributte (HttpSession httpSession, String key, String value) {
		httpSession.setAttribute(key, value);
	}
	
	public void setAttributte (HttpSession httpSession, String key, List<String> value) {
		httpSession.setAttribute(key, value);
	}
}
