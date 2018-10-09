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
 * @description 定义一个拦截器，实现HandlerInterceptor
 * @author 陈兴
 * @tags
 */
public class LoginInterceptor implements HandlerInterceptor {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		System.out.println("preHandle...");
//		HttpSession session=request.getSession();
//		//如果登录过，返回true，继续执行mvc后续流程
//		if(session.getAttribute("user")!=null) {
//			return true;
//		}else {
//			//如果没有登录过，重定向到登录页面，终止mvc后续流程
//			response.sendRedirect("login.do");
//			return false;
//		}
//		String uri=request.getRequestURI();
//		String action=uri.substring(uri.lastIndexOf("/"), uri.lastIndexOf("."));
//		System.out.println(action);
//		if(action.equals("/login")) {
//			String userName=request.getParameter("username");
//			String password=request.getParameter("password");
//	
//			SqlSessionFactoryBuilder ssfb=new SqlSessionFactoryBuilder();
//			Reader reader= Resources.getResourceAsReader("sqlMapConfig.xml");
//			SqlSessionFactory ssf=ssfb.build(reader);
//			SqlSession sSession=ssf.openSession();
//			User user=sSession.selectOne("findUserByUsername",userName);
//			if(null!=user) {
//				System.out.println(user.getName());
//				if(password.equals(user.getPassword())) {
//					session.setAttribute("user", userName);
//					response.sendRedirect("acclist.do");
//					return true;
//				}else {
//					request.setAttribute("loginFailed", "密码错误");
//					System.out.println("密码错误");
//				}
//			}
//		}
//
		return true;
	}
}
