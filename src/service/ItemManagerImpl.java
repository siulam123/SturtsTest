package service;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.springframework.stereotype.Service;

import dao.ItemDao;
import pojo.Exampaper;
import pojo.Item;
import service.ItemManager;

@Service
public class ItemManagerImpl implements ItemManager{
    private ItemDao dao;  

    public ItemManagerImpl(){
        System.out.println("ItemManager IN");
    }
    
    public ItemDao getDao() {
    	return dao;
	}

    public void setDao(ItemDao dao) {
        this.dao = dao;
    }

    public List<Item> getItems() throws HibernateException {  
        return dao.getItems();
    }
    
    public boolean Upload(Item item) throws HibernateException{
    	dao.saveObject(item);
    	return true;
    }
    
    public List<Item> getItemsByType(String type) throws HibernateException {  
        return dao.getItemsByType(type);
    }
    
    public Item getItemById(int itemId) throws HibernateException {  
        return dao.getItemById(itemId);
    }
   
    public boolean marking(Item item) throws HibernateException {
    	return dao.markingDAO(item);
    }

	@Override
	public boolean reflect(Item item, Double amount) throws HibernateException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean recharge(Item item, Double amount) throws HibernateException {
		// TODO Auto-generated method stub
		return false;
	}
	
}
