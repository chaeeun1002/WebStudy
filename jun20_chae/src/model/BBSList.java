package model;

import java.util.ArrayList;

public class BBSList {//역할 : List<BBS> list에 담긴 데이터 5개를 넘겨받는 클래스
	private ArrayList<Integer> seqnoList = new ArrayList<Integer>();//글번호 5개용 변수
	public void setSeqnoList(int index,Integer seqno) {
		seqnoList.add(index,seqno);
	}
	public Integer[] getSeqnoList() {
		//컬렉션프레임워크를 배열로 바꿔준다. -- > toArray()메서드 사용
		return seqnoList.toArray(new Integer[seqnoList.size()]);//배열의 크기 지정 : seqnoList.size
	}
	
	private ArrayList<String> titleList = new ArrayList<String>();//글제목 5개용 변수
	public void setTitleList(int index,String title) {
		titleList.add(index,title);
	}
	public String[] getTitleList(){
		return titleList.toArray(new String[titleList.size()]);
	}
	
	private ArrayList<String> writerList = new ArrayList<String>();//작성자 5개용 변수
	public void setWriterList(int index,String writer) {
		writerList.add(index,writer);
	}
	public String[] getWriterList(){
		return writerList.toArray(new String[writerList.size()]);
	}
	
	private ArrayList<String> dateList = new ArrayList<String>();//작성일 5개용 변수
	public void setDateList(int index,String date) {
		dateList.add(index,date);
	}
	public String[] getDateList() {
		return dateList.toArray(new String[dateList.size()]);
	}
	
	private boolean lastPage = false;
	private boolean firstPage = false;
	
	public int getListSize() {
		return seqnoList.size();//검색된 글의 갯수 리턴
	}
	
	public boolean isLastPage() {
		return lastPage;
	}
	public void setLastPage(boolean lastPage) {
		this.lastPage = lastPage;
	}
	public boolean isFirstPage() {
		return firstPage;
	}
	public void setFirstPage(boolean firstPage) {
		this.firstPage = firstPage;
	}
}
