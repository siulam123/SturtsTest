package service;

import java.util.List;

import org.hibernate.HibernateException;

import pojo.Student;

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
public interface UserManager {
	public String login(Student user) throws HibernateException;
	public boolean register(Student user) throws HibernateException;
	public List<Student> getStudents() throws HibernateException;
	public boolean recharge(Student user,Double amount) throws HibernateException;
	public boolean reflect(Student user,Double amount) throws HibernateException;
}
