package daoImpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import dao.ItemDao;
import pojo.Item;


@Repository
public class ItemDaoImpl extends HibernateDaoSupport implements ItemDao{

	public ItemDaoImpl() {
        System.out.println("ItemDao IN");
    }
	
    public void saveObject(Item obj) throws HibernateException {
        getHibernateTemplate().save(obj);       
    }  

    public List<Item> getItems() throws HibernateException{
        List<Item> item=getHibernateTemplate().loadAll(Item.class);
        return item;
    }
    
    public List<Item> getItemsByType(String type) throws HibernateException{
    	List<?> list =getHibernateTemplate().find("FROM Item U WHERE U.Type = ?0",type);
        return (List<Item>) list;
    }
    
    public Item getItemById(int itemId) throws HibernateException{
    	List<?> list =getHibernateTemplate().find("FROM Item U WHERE U.itemId = ?0",itemId);
    	//
    	if(list.size()!=0)
    		return (Item) list.get(0);
    	else
    		return null;
    }
    
    //���⺯���������ж�����ѡ����
    public boolean markingDAO(Item item) throws HibernateException{
    	//"FROM Item U WHERE U.itemId = ?0 AND U.answer = ?1"
    	String sql = "SELECT itemId FROM Item U WHERE U.itemId = ?0 AND U.answer = ?1";
    	List<?> list = getHibernateTemplate().find(sql, item.getItemId(),item.getAnswer());
    	
    	if(list.size()!=0){
    		return true;
    	}
    	else{
    		return false;
    	}
    }

	public void updateObject(Item item) throws HibernateException {
		getHibernateTemplate().update(item);	
	}
	
}
