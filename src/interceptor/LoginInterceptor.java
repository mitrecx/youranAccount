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
 * @description ����һ����������ʵ��HandlerInterceptor
 * @author ����
 * @tags
 */
public class LoginInterceptor implements HandlerInterceptor {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		System.out.println("preHandle...");
//		HttpSession session=request.getSession();
//		//�����¼��������true������ִ��mvc��������
//		if(session.getAttribute("user")!=null) {
//			return true;
//		}else {
//			//���û�е�¼�����ض��򵽵�¼ҳ�棬��ֹmvc��������
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
//					request.setAttribute("loginFailed", "�������");
//					System.out.println("�������");
//				}
//			}
//		}
//
		return true;
	}
}
