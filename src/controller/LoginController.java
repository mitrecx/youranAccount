package controller;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import entity.AccInfo;

@Controller //É¨Ãèµ½SpringÈÝÆ÷
public class LoginController {
	
	@RequestMapping("login.do")
	public ModelAndView execute() {
		ModelAndView mav=new ModelAndView();
		mav.setViewName("login");
		return mav;
	}

	@RequestMapping("success.do")
	public ModelAndView executeSuccess(HttpServletRequest request ) {
		ModelAndView mav=new ModelAndView();
		HttpSession session=request.getSession();
		if(session.getAttribute("user")==null) {
			mav.setViewName("login");
			return mav;
		}
		mav.setViewName("success");
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
