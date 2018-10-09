package entity;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class TestUser {
	public static void main(String[] args) throws IOException {
		SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
		//����SqlMapConfig.xml �ļ�
		String conf="sqlMapConfig.xml";
		//Reader reader=Resources.getResourceAsReader(conf); 
		InputStream reader=TestUser.class.getClassLoader().getResourceAsStream(conf);
		//��ȡSqlSessionFactory
		SqlSessionFactory factory=builder.build(reader);
		SqlSession session=factory.openSession();
		System.out.println(session);
		
		//����id=findAll��SQL
		List<User> list=session.selectList("findAll");
		
		for(User u:list) {
			System.out.println(u.getName()+" "+u.getUsername());
		}
		
		session.close();
	}
}
