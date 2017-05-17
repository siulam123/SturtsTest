package service;

import java.util.List;
import java.util.Map;

import org.hibernate.HibernateException;

import pojo.Item;

public interface ItemManager {
	//�ϴ���Ŀ
	public boolean Upload(Item item) throws HibernateException;
	//��ȡ������Ŀ
	public List<Item> getItems() throws HibernateException;
	//�������ͻ�ȡ��Ŀ
	public List<Item> getItemsByType(String type) throws HibernateException;
	//����id��ȡ��Ŀ
	public Item getItemById(int itemId) throws HibernateException;
		   
	public boolean recharge(Item item,Double amount) throws HibernateException;
	public boolean reflect(Item item,Double amount) throws HibernateException;
}
