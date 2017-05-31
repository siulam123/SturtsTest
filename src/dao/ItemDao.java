package dao;
import java.util.List;

import org.hibernate.HibernateException;

import pojo.Item;

public interface ItemDao {
	//������Ŀ�����ݿ�
    public void saveObject(Item item) throws HibernateException;
    //��ȡ������Ŀ
    public List<Item> getItems() throws HibernateException;
    //������Ŀ
	public void updateObject(Item item) throws HibernateException;
	//����Ŀid������Ŀ
	public Item getItemById(int itemId) throws HibernateException;
	//������Ŀ���Ͳ���
	public List<Item> getItemsByType(String type) throws HibernateException;
	//���⺯���������ж�����ѡ����
	public boolean markingDAO(Item item) throws HibernateException;

}
