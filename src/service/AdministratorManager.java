package service;

import java.util.List;

import org.hibernate.HibernateException;

import pojo.Administrator;

/** 
 * UserManager的业务接口定义，
 * 
 * 
 * @author Lucifer 
 * @date 2017年3月15日 上午9:42:27 
 * @version 1.0 
 * @parameter  
 * @since  
 * @return  
 */
public interface AdministratorManager {
	public String login(Administrator Admin) throws HibernateException;
	public boolean register(Administrator Admin) throws HibernateException;
	public List<Administrator> getAdministrators() throws HibernateException;
	public boolean recharge(Administrator Admin,Double amount) throws HibernateException;
	public boolean reflect(Administrator Admin,Double amount) throws HibernateException;
}
