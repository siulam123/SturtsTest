package service;

import java.util.List;

import org.hibernate.HibernateException;
import org.springframework.stereotype.Service;

import daoImpl.AdministratorDaoImpl;
import pojo.Administrator;

@Service
public class AdministratorManagerImpl implements AdministratorManager{
    private AdministratorDaoImpl dao;  

    public AdministratorManagerImpl(){
        dao = new AdministratorDaoImpl();
        System.out.println("StudentManager IN");
    }
    
    public AdministratorDaoImpl getDao() {
    	return dao;
	}

    public void setDao(AdministratorDaoImpl dao) {
        this.dao = dao;
    }

    public List<Administrator> getAdministrators() throws HibernateException {  
        return dao.getAdministrators();
    }
    
    public boolean register(Administrator admin) throws HibernateException{
    	dao.saveObject(admin);
    	return true;
    }
    
    public String login(Administrator admin) throws HibernateException{
    	Administrator adminSql = dao.findAdministrator(admin);
    	if(adminSql!=null)
    		if(admin.getPassword().equals(adminSql.getPassword())){
    			System.out.println("管理员"+adminSql.getAdministratorId()+"登陆成功");
    			return "success";
    		}
    		else
    			return "error";
    	else
    		return "null";
    }

	@Override
	public boolean reflect(Administrator admin, Double amount) throws HibernateException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean recharge(Administrator admin, Double amount) throws HibernateException {
		// TODO Auto-generated method stub
		return false;
	}
	
}
