package cn.itcast.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.itcast.dao.ItemsMapper;
import cn.itcast.pojo.Items;

/**
 * 商品的业务层实现类
 * @author Derek Sun
 *
 */
@Service
public class ItemsServiceImpl implements ItemsService {
	
	@Autowired
	private ItemsMapper itemsMapper;

	@Override
	public List<Items> getItemsList() throws Exception {
		List<Items> itemsList = itemsMapper.selectByExample(null);
		return itemsList;
	}

	@Override
	public Items getItemsInfoById(Integer id) throws Exception {
		Items items = itemsMapper.selectByPrimaryKey(id);
		return items;
	}

	@Override
	public void updateItems(Items items) throws Exception {
		itemsMapper.updateByPrimaryKeySelective(items);
		
	}

}
