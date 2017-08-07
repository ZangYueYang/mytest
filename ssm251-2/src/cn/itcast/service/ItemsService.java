package cn.itcast.service;

import java.util.List;

import cn.itcast.pojo.Items;

/**
 * 商品的业务层接口
 * 
 * @author Derek Sun
 *
 */
public interface ItemsService {
	
	/**
	 * 取得全部商品信息
	 * 
	 * @return 商品信息的列表
	 * @throws Exception
	 */
	public List<Items> getItemsList() throws Exception;
	
	/**
	 * 根据商品id取得商品详细信息
	 * @param id 商品的主键
	 * @return 商品详细信息
	 * @throws Exception
	 */
	public Items getItemsInfoById(Integer id) throws Exception;
	
	/**
	 * 更新商品信息
	 * 
	 * @param items 更新用的商品信息的数据
	 * @throws Exception
	 */
	public void updateItems(Items items) throws Exception;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
