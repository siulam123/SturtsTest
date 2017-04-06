package dao;
import java.util.List;

import org.hibernate.HibernateException;

import pojo.Item;

public interface ItemDao {
	//存入题目到数据库
    public void saveObject(Item item) throws HibernateException;
    //获取所有题目
    public List<Item> getItems() throws HibernateException;
    //更新题目
	public void updateObject(Item item) throws HibernateException;
	//按题目id查找题目
	public Item getItemById(String itemId) throws HibernateException;
	//按照题目类型查找
	public List<Item> getItemsByType(String type) throws HibernateException;

}
