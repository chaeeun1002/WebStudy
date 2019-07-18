package model;

import java.util.ArrayList;

public class ItemList {
	private ArrayList<Integer> codeList = new ArrayList<Integer>();
	public void setCodeList(int index, Integer code) {
		codeList.add(index,code);
	}
	public Integer[] getCodeList() {
		return codeList.toArray(new Integer[codeList.size()]);
	}
	
	private ArrayList<String> nameList = new ArrayList<String>();
	public void setNameList(int index,String name) {
		nameList.add(index,name);
	}
	public String[] getNameList() {
		return nameList.toArray(new String[nameList.size()]);
	}
	
	private ArrayList<Integer> priceList = new ArrayList<Integer>();
	public void setPriceList(int index,Integer price) {
		priceList.add(index,price);
	}
	public Integer[] getPriceList() {
		return priceList.toArray(new Integer[priceList.size()]);
	}
	
	private ArrayList<String> originList = new ArrayList<String>();
	public void setOriginList(int index,String origin) {
		originList.add(index,origin);
	}
	public String[] getOriginList() {
		return originList.toArray(new String[originList.size()]);
	}
	
	public Integer getListSize() {
		return codeList.size();
	}
	
	private boolean firstPage;
	public boolean isFirstPage() {
		return firstPage;
	}
	public void setFirstPage(boolean firstPage) {
		this.firstPage = firstPage;
	}
	
	private boolean lastPage;
	public boolean isLastPage() {
		return lastPage;
	}
	public void setLastPage(boolean lastPage) {
		this.lastPage = lastPage;
	}
}
