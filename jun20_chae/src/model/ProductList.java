package model;

import java.util.ArrayList;

public class ProductList {
	private ArrayList<String> codeList = new ArrayList<String>();
	public void setCodeList(int index, String code) {
		codeList.add(index,code);
	}
	public String[] getCodeList() {
		return codeList.toArray(new String[codeList.size()]);
	}
	
	private ArrayList<String> nameList = new ArrayList<String>();
	public void setNameList(int index, String name) {
		nameList.add(index,name);
	}
	public String[] getNameList() {
		return nameList.toArray(new String[nameList.size()]);
	}
	
	private ArrayList<Integer> priceList = new ArrayList<Integer>();
	public void setPriceList(int index, int price) {
		priceList.add(index,price);
	}
	public Integer[] getPriceList() {
		return priceList.toArray(new Integer[priceList.size()]);
	}
	private ArrayList<String> originList = new ArrayList<String>();
	public void setOriginList(int index, String origin) {
		originList.add(index,origin);
	}
	public String[] getOriginList() {
		return originList.toArray(new String[originList.size()]); 
	}
	
}
