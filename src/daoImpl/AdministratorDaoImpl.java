package daoImpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import dao.AdministratorDao;
import dao.StudentDao;
import pojo.Administrator;
import pojo.Student;

@Repository
public class AdministratorDaoImpl extends HibernateDaoSupport implements AdministratorDao{

	public AdministratorDaoImpl() {
        System.out.println("AdminDao IN");
    }
	
    public void saveObject(Administrator obj) throws HibernateException {
        getHibernateTemplate().save(obj);        
    }  

    public List<Administrator> getAdministrators() throws HibernateException{
        List<Administrator> admin=getHibernateTemplate().loadAll(Administrator.class);
        return admin;
    }
    
    public Administrator findAdministrator(Administrator admin) throws HibernateException{
    	List<?> list =getHibernateTemplate().find("FROM Administrator U WHERE U.administratorId = ?0",admin.getAdministratorId());
    	
    	if(list.size()!=0)
    		return (Administrator) list.get(0);
    	else
    		return null;
    }

	public void updateObject(Administrator admin) throws HibernateException {
		getHibernateTemplate().update(admin);	
	}
	
}
