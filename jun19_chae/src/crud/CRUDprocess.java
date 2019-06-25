package crud;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import model.Customer;
import model.Product;

public class CRUDprocess {
	private SqlSession getSession() {
		String path = "mybatis_config.xml";
		InputStream is = null;
		try {
			is = Resources.getResourceAsStream(path);
		}catch(Exception e) {
			System.out.println("환경설정 파일 읽는 중 문제발생");
		}
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		SqlSessionFactory factory = builder.build(is);
		SqlSession session = factory.openSession();
		return session;
	}
	
	public Integer insertIntoItemInfo(Product pro) {
		SqlSession s = getSession();
		Integer result = null;
		try {
			result = s.insert("mymapper.insertIntoItemInfo",pro);
			if(result > 0) {
				s.commit();
			}else {
				s.rollback();
			}
			return result;
		}finally {
			s.close();
		}
	}
	
	public List<Product> selectItemInfo(){
		SqlSession s = getSession();
		List<Product> list = null;
		try {
			list = s.selectList("mymapper.selectItemInfo");
			return list;
		}finally {
			s.close();
		}
	}
	
	public Product selectItemInfoByCode(Integer code) {
		SqlSession s = getSession();
		Product pro = null;
		try {
			pro = s.selectOne("mymapper.selectItemInfoByCode",code);
			return pro;
		}finally {
			s.close();
		}
	}
	
	public Integer insertIntoCustomerInfo(Customer cus) {
		SqlSession s = getSession();
		Integer result = null;
		try {
			result = s.insert("mymapper.insertIntoCustomerInfo",cus); 
			if(result > 0) {
				s.commit();
			}else {
				s.rollback();
			}
			return result;
		}finally {
			s.close();
		}
	}
	
	public List<Customer> selectCustomerInfo(){
		SqlSession s = getSession();
		List<Customer> list = null;
		try {
			list = s.selectList("mymapper.selectCustomerInfo");
			return list;
		}finally {
			s.close();
		}
	}
	
	public Customer selectCustomerInfoByCusID(String id) {
		SqlSession s = getSession();
		Customer cus = null;
		try {
			cus = s.selectOne("mymapper.selectCustomerInfoByCusID",id);
			return cus;
		}finally {
			s.close();
		}
	}
}
