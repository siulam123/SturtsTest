package dao;
import java.util.List;

import org.hibernate.HibernateException;

import pojo.Administrator;
import pojo.Student;

public interface AdministratorDao {
	
    public void saveObject(Administrator user) throws HibernateException;
    public List<Administrator> getAdministrators() throws HibernateException;
	public void updateObject(Administrator user) throws HibernateException;

}
