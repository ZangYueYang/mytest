package cn.itcast.service;

import java.util.List;

import cn.itcast.pojo.Items;

/**
 * ��Ʒ��ҵ���ӿ�
 * 
 * @author Derek Sun
 *
 */
public interface ItemsService {
	
	/**
	 * ȡ��ȫ����Ʒ��Ϣ
	 * 
	 * @return ��Ʒ��Ϣ���б�
	 * @throws Exception
	 */
	public List<Items> getItemsList() throws Exception;
	
	/**
	 * ������Ʒidȡ����Ʒ��ϸ��Ϣ
	 * @param id ��Ʒ������
	 * @return ��Ʒ��ϸ��Ϣ
	 * @throws Exception
	 */
	public Items getItemsInfoById(Integer id) throws Exception;
	
	/**
	 * ������Ʒ��Ϣ
	 * 
	 * @param items �����õ���Ʒ��Ϣ������
	 * @throws Exception
	 */
	public void updateItems(Items items) throws Exception;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
