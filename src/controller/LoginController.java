package controller;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import entity.AccInfo;
import entity.User;

@Controller 
public class LoginController {
	
	@RequestMapping("/login.do")
	public ModelAndView execute() {
		ModelAndView mav=new ModelAndView();
		mav.setViewName("login");
		return mav;
	}

	@RequestMapping("/checkup.do")
	public ModelAndView checkup(HttpServletRequest request,HttpServletResponse response ) {
		ModelAndView mav=new ModelAndView();
		HttpSession session=request.getSession();
		String userName=request.getParameter("username");
		String password=request.getParameter("password");
		SqlSessionFactoryBuilder ssfb=new SqlSessionFactoryBuilder();
		Reader reader;
		try {
			reader = Resources.getResourceAsReader("sqlMapConfig.xml");
		
			SqlSessionFactory ssf=ssfb.build(reader);
			SqlSession sSession=ssf.openSession();
			User user=sSession.selectOne("findUserByUsername",userName);
			if(null!=user) {
				System.out.println(user.getName());
				if(password.equals(user.getPassword())) {
					session.setAttribute("user", userName);
					response.sendRedirect("list.do");
					mav.setViewName("list");
					return mav;
				}else {
					request.setAttribute("loginFailed", "密码错误");
				}
			}else {
				request.setAttribute("loginFailed", "用户名不存在");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		mav.setViewName("login");
		return mav;
	}
	@RequestMapping("acclist.do")
	public ModelAndView executeAccList(HttpServletRequest request ) {
		ModelAndView mav=new ModelAndView();
		HttpSession session=request.getSession();
		if(session.getAttribute("user")==null) {
			mav.setViewName("login");
			return mav;
		}
		mav.setViewName("accountList");
		SqlSessionFactoryBuilder ssfb=new SqlSessionFactoryBuilder();
		Reader reader;
		try {
			reader = Resources.getResourceAsReader("sqlMapConfig.xml");
			SqlSessionFactory ssf=ssfb.build(reader);
			SqlSession sSession=ssf.openSession();
			List<AccInfo> accInfos=sSession.selectList("findAll1");
			request.setAttribute("accList", accInfos);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return mav;
	}
}
