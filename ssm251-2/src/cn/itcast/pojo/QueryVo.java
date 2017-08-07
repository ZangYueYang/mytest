package cn.itcast.pojo;

import java.util.List;

public class QueryVo {
	
	// 用户信息
	
	// 订单信息
	
	// 商品信息
	private Items items;
	
	private String[] ids;
	
	private List<Items> updItemsLst;

	/**
	 * @return the items
	 */
	public Items getItems() {
		return items;
	}

	/**
	 * @param items the items to set
	 */
	public void setItems(Items items) {
		this.items = items;
	}

	/**
	 * @return the ids
	 */
	public String[] getIds() {
		return ids;
	}

	/**
	 * @param ids the ids to set
	 */
	public void setIds(String[] ids) {
		this.ids = ids;
	}

	/**
	 * @return the updItemsLst
	 */
	public List<Items> getUpdItemsLst() {
		return updItemsLst;
	}

	/**
	 * @param updItemsLst the updItemsLst to set
	 */
	public void setUpdItemsLst(List<Items> updItemsLst) {
		this.updItemsLst = updItemsLst;
	}


}
