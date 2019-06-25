package crud;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import model.BBS;

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
	
	public Integer insertIntoBbs(BBS bbs) {
		SqlSession s = getSession();
		try {
			String query = "mymapper.insertIntoBbs";
			int result = s.insert(query,bbs);
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
	
	public Integer selectMaxSeqno() {
		SqlSession s = getSession();
		try {
			String query = "mymapper.selectMaxSeqno";
			Integer maxNum = s.selectOne(query);
			if(maxNum != null) {
				return maxNum;
			}else {
				return 0;
			}
		}finally {
			s.close();
		}
	}
	
	public List<BBS> selectBBS(){
		SqlSession s = getSession();
		List<BBS> list = null;
		try {
			String query = "mymapper.selectBBS";
			list = s.selectList(query);
			return list;
		}finally {
			s.close();
		}
	}
	
	public BBS selectBBSBySeqno(int seqno) {
		SqlSession s = getSession();
		BBS bbs = null;
		try {
			String query = "mymapper.selectBBSBySeqno";
			bbs = s.selectOne(query,seqno);
			return bbs;
		}finally {
			s.close();
		}
	}
}
