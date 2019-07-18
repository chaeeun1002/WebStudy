package model;

import java.util.ArrayList;

public class BBSList {
	private ArrayList<Integer> seqnoList = new ArrayList<Integer>();
	public void setSeqnoList(int index, Integer seqno) {
		seqnoList.add(index,seqno);
	}
	public Integer[] getSeqnoList() {
		return seqnoList.toArray(new Integer[seqnoList.size()]);
	}
	
	private ArrayList<String> titleList = new ArrayList<String>();
	public void setTitleList(int index, String title) {
		titleList.add(index,title);
	}
	public String[] getTitleList() {
		return titleList.toArray(new String[titleList.size()]);
	}
	
	private ArrayList<String> idList = new ArrayList<String>();
	public void setIdList(int index, String id) {
		idList.add(index,id);
	}
	public String[] getIdList() {
		return idList.toArray(new String[idList.size()]);
	}
	
	private ArrayList<String> bbs_dateList = new ArrayList<String>();
	public void setBbs_dateList(int index, String bbs_date) {
		bbs_dateList.add(index,bbs_date);
	}
	public String[] getBbs_dateList() {
		return bbs_dateList.toArray(new String[bbs_dateList.size()]);
	}
	
	public Integer getListSize() {
		return seqnoList.size();
	}
	
	private boolean firstPage = false;
	public boolean isFirstPage() {
		return firstPage;
	}
	public void setFirstPage(boolean firstPage) {
		this.firstPage = firstPage;
	}
	
	private boolean lastPage = false;
	public boolean isLastPage() {
		return lastPage;
	}
	public void setLastPage(boolean lastPage) {
		this.lastPage = lastPage;
	}
	
}
