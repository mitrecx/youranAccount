package interceptor;

import java.io.Reader;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.web.servlet.HandlerInterceptor;

import entity.User;
/**
 * 
 * @description 拦截器HandlerInterceptor
 * @author cx
 * @tags
 */
public class LoginInterceptor implements HandlerInterceptor {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		System.out.println("preHandle...");
		HttpSession session=request.getSession();
		if(session.getAttribute("user")!=null) {
			System.out.println("session中有user");
			return true;
		}else {
			//为什么这个Attribute没有被login.jsp 接收到？？
			request.setAttribute("loginFailed", "未登录，请先登录");
			response.sendRedirect("login.do");
			System.out.println("没有user");
			return false;
		}
	}
}
