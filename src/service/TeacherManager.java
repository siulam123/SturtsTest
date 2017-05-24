package service;

import java.util.List;

import org.hibernate.HibernateException;

import pojo.Administrator;
import pojo.Teacher;

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
public interface TeacherManager {
	public String login(Teacher teacher) throws HibernateException;
	public boolean register(Teacher teacher) throws HibernateException;
	public List<Teacher> getTeachers() throws HibernateException;
	public Teacher findObject(Teacher teacher) throws HibernateException;
	public boolean recharge(Teacher teacher,Double amount) throws HibernateException;
	public boolean reflect(Teacher teacher,Double amount) throws HibernateException;
}
