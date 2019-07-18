package crud;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import model.BBS;
import model.Cart;
import model.CartList;
import model.Condition;
import model.ImageWriting;
import model.ItemInfo;
import model.Member;

public class CRUDprocess {
	private SqlSession getSession() {
		String path="mybatis_config.xml";
		InputStream is = null;
		try {
			is = Resources.getResourceAsStream(path);
		}catch(Exception e) {
			System.out.println("");
		}
		SqlSessionFactoryBuilder builder = 
			new SqlSessionFactoryBuilder();
		SqlSessionFactory factory = builder.build(is);
		SqlSession session = factory.openSession();
		return session;
	}
	
	public Member selectIdAndPwd(String id) {
		SqlSession s = getSession();
		Member member = null;
		try {
			member = s.selectOne("loginmapper.selectIdAndPwd",id);
			return member;
		}finally {
			s.close();
		}
	}
	
	public Integer selectMaxSeqno() {
		SqlSession s = getSession();
		Integer max_num = null;
		try {
			max_num = s.selectOne("loginmapper.selectMaxSeqno");
			if(max_num == null) {
				return 0;
			}else {
				return max_num;
			}
		}finally {
			s.close();
		}
	}
	
	public Integer insertIntoBbs(BBS bbs) {
		SqlSession s = getSession();
		Integer result = null;
		try {
			result = s.insert("loginmapper.insertIntoBbs",bbs);
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
	
	public List<BBS> selectBBS(){
		SqlSession s = getSession();
		List<BBS> list = null;
		try {
			list = s.selectList("loginmapper.selectBBS");
			return list;
		}finally {
			s.close();
		}
	}
	
	public BBS selectBBSBySeqno(Integer seqno) {
		SqlSession s = getSession();
		BBS bbs = null;
		try {
			bbs = s.selectOne("loginmapper.selectBBSBySeqno",seqno);
			return bbs;
		}finally {
			s.close();
		}
	}
	
	public Integer selectMaxCode() {
		SqlSession s = getSession();
		Integer max_num = null;
		try {
			max_num = s.selectOne("loginmapper.selectMaxCode");
			if(max_num == null) {
				return 0;
			}else {
				return max_num;
			}
		}finally {
			s.close();
		}
	}
	
	public Integer insertItemInfo(ItemInfo info) {
		SqlSession s = getSession();
		Integer result = null;
		try {
			result = s.insert("loginmapper.insertItemInfo",info);
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
	
	public List<ItemInfo> selectItemInfo(){
		SqlSession s = getSession();
		List<ItemInfo> list = null;
		try {
			list = s.selectList("loginmapper.selectItemInfo");
			return list;
		}finally {
			s.close();
		}
	}
	
	public ItemInfo selectItemInfoByCode(Integer code) {
		SqlSession s = getSession();
		ItemInfo item = null;
		try {
			item = s.selectOne("loginmapper.selectItemInfoByCode",code);
			return item;
		}finally {
			s.close();
		}
	}
	
	public Integer selectCountOfBBS() {
		SqlSession s = getSession();
		Integer count = null;
		try {
			count = s.selectOne("loginmapper.selectCountOfBBS");
			return count;
		}finally {
			s.close();
		}
	}
	
	public Integer selectCountOfItemInfo() {
		SqlSession s = getSession();
		Integer count = null;
		try {
			count = s.selectOne("loginmapper.selectCountOfItemInfo");
			return count;
		}finally {
			s.close();
		}
	}
	
	public Integer selectCountPrevPageOfBBS(Integer seqno) {
		SqlSession s = getSession();
		Integer count = null;
		try {
			count = s.selectOne("loginmapper.selectCountPrevPageOfBBS",seqno);
			return count;
		}finally {
			s.close();
		}
	}
	
	public Integer selectCountNextPageOfBBS(Integer pageNo) {
		SqlSession s = getSession();
		Integer count = null;
		try {
			count = s.selectOne("loginmapper.selectCountNextPageOfBBS",pageNo);
			return count;
		}finally {
			s.close();
		}
	}
	
	public List<BBS> selectBBSNextPage(Integer seqno){
		SqlSession s = getSession();
		List<BBS> list = null;
		try {
			list = s.selectList("loginmapper.selectBBSNextPage",seqno);
			return list;
		}finally {
			s.close();
		}
	}
	
	public List<BBS> selectBBSPrevPage(Integer seqno){
		SqlSession s = getSession();
		List<BBS> list = null;
		try {
			list = s.selectList("loginmapper.selectBBSPrevPage",seqno);
			return list;
		}finally {
			s.close();
		}
	}
	
	public List<BBS> selectBBSPageNum(Integer pageNo){
		SqlSession s = getSession();
		List<BBS> list = null;
		try {
			list = s.selectList("loginmapper.selectBBSPageNum",pageNo);
			return list;
		}finally {
			s.close();
		}
	}
	
	public List<ItemInfo> selectItemInfoNextPage(Integer code){
		SqlSession s = getSession();
		List<ItemInfo> list = null;
		try {
			list = s.selectList("loginmapper.selectItemInfoNextPage",code);
			return list;
		}finally {
			s.close();
		}
	}
	
	public List<ItemInfo> selectItemInfoPrevPage(Integer code){
		SqlSession s = getSession();
		List<ItemInfo> list = null;
		try {
			list = s.selectList("loginmapper.selectItemInfoPrevPage",code);
			return list;
		}finally {
			s.close();
		}
	}
	
	public Integer selectCountPrevPageOfItemInfo(Integer code) {
		SqlSession s = getSession();
		Integer count = null;
		try {
			count = s.selectOne("loginmapper.selectCountPrevPageOfItemInfo",code);
			return count;
		}finally {
			s.close();
		}
	}
	
	public List<ItemInfo> selectItemInfoPageNum(Integer pageNo){
		SqlSession s = getSession();
		List<ItemInfo> list = null;
		try {
			list = s.selectList("loginmapper.selectItemInfoPageNum",pageNo);
			return list;
		}finally {
			s.close();
		}
	}
	
	public Integer selectCountNextPageOfItemInfo(Integer pageNo) {
		SqlSession s = getSession();
		Integer count = null;
		try {
			count = s.selectOne("loginmapper.selectCountNextPageOfItemInfo",pageNo);
			return count;
		}finally {
			s.close();
		}
	}
	
	public Integer selectMaxCartSeqno() {
		SqlSession s = getSession();
		Integer max_num = null;
		try {
			max_num = s.selectOne("loginmapper.selectMaxCartSeqno");
			if(max_num == null) {
				return 0;
			}else {
				return max_num;
			}
		}finally {
			s.close();
		}
	}
	
	public Integer selectNumByIdAndCode(Cart cart) {
		SqlSession s = getSession();
		Integer num = null;
		try {
			num = s.selectOne("loginmapper.selectNumByIdAndCode",cart);
			if(num == null) {
				return 0;
			}else {
				return num;
			}
		}finally {
			s.close();
		}
	}
	
	public Integer insertIntoCart(Cart cart) {
		SqlSession s = getSession();
		Integer result = null;
		try {
			result = s.insert("loginmapper.insertIntoCart",cart);
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
	
	public Integer updateNumByIdAndCode(Cart cart) {
		SqlSession s = getSession();
		Integer result = null;
		try {
			result = s.update("loginmapper.updateNumByIdAndCode",cart);
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
	
	public List<CartList> selectCartById(String id){
		SqlSession s = getSession();
		List<CartList> list = null;
		try {
			list = s.selectList("loginmapper.selectCartById",id);
			return list;
		}finally {
			s.close();
		}
	}
	
	public Integer insertIntoImageWriting(ImageWriting iw) {
		SqlSession s = getSession();
		Integer result = null;
		try {
			result = s.insert("loginmapper.insertIntoImageWriting",iw);
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
	
	public Integer selectMaxWritingId() {
		SqlSession s = getSession();
		Integer max_num = null;
		try {
			max_num = s.selectOne("loginmapper.selectMaxWritingId");
			if(max_num == null) {
				return 0;
			}else {
				return max_num;
			}
		}finally {
			s.close();
		}
	}
	
	public Integer selectCountImageWriting() {
		SqlSession s = getSession();
		Integer count = null;
		try {
			count = s.selectOne("loginmapper.selectCountImageWriting");
			return count;
		}finally {
			s.close();
		}
	}
	
	public List<ImageWriting> selectImageWritingByCondition(Condition cond){
		SqlSession s = getSession();
		List<ImageWriting> list = null;
		try {
			list = s.selectList("loginmapper.selectImageWritingByCondition",cond);
			return list;
		}finally {
			s.close();
		}
	}
	
	public ImageWriting selectImageWritingById(Integer id) {
		SqlSession s = getSession();
		ImageWriting image = null;
		try {
			image = s.selectOne("loginmapper.selectImageWritingById",id);
			return image;
		}finally {
			s.close();
		}
	}
	
	public Integer deleteImageWritingById(Integer id) {
		SqlSession s = getSession();
		Integer result = null;
		try {
			result = s.delete("loginmapper.deleteImageWritingById",id);
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
	
	public Integer updateImageWritingById(ImageWriting image) {
		SqlSession s = getSession();
		Integer result = null;
		try {
			result = s.update("loginmapper.updateImageWritingById",image);
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
	
	public Integer selectMaxGroupId() {
		SqlSession s = getSession();
		Integer max_num = null;
		try {
			max_num = s.selectOne("loginmapper.selectMaxGroupId");
			if(max_num == null) return 0;
			else return max_num;
		}finally {
			s.close();
		}
	}
	
	public Integer updateOrderNo(ImageWriting image) {
		SqlSession s = getSession();
		Integer result = null;
		try {
			result = s.update("loginmapper.updateOrderNo",image);
			if(result > 0) s.commit();
			else s.rollback();
			return result;
		}finally {
			s.close();
		}
	}
	
	public Integer updateCartToNum(Cart cart) {
		SqlSession s = getSession();
		Integer result = null;
		try {
			result = s.update("loginmapper.updateCartToNum",cart);
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
	
	public Integer deleteCartByIdAndCode(Cart cart) {
		SqlSession s = getSession();
		Integer result = null;
		try {
			result = s.delete("loginmapper.deleteCartByIdAndCode",cart);
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
	
	public String selectIdForCheck(String id) {
		SqlSession s = getSession();
		String checkId = null;
		try {
			checkId = s.selectOne("loginmapper.selectIdForCheck",id);
			return checkId;
		}finally {
			
		}
	}
}









