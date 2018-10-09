package controller;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import entity.AccInfo;
@Controller
public class ListController {
	@RequestMapping("/list.do")
	public String execute(ModelMap model) {
		List<AccInfo> list=new ArrayList<AccInfo>();
		SqlSessionFactoryBuilder ssfb=new SqlSessionFactoryBuilder();
		try {
			Reader reader=Resources.getResourceAsReader("sqlMapConfig.xml");
			SqlSessionFactory ssf=ssfb.build(reader);
			SqlSession sSession=ssf.openSession();
			list=sSession.selectList("findAll1");
			for(AccInfo a:list) {
				System.out.println(a.getTrade_time()+"  "+a.getManager());
			}
			model.put("AccInfos",list);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "list";
	}
}
