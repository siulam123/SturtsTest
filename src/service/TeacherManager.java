package service;

import java.util.List;

import org.hibernate.HibernateException;

import pojo.Administrator;
import pojo.Teacher;

/** 
 * UserManager��ҵ��ӿڶ��壬
 * 
 * 
 * @author Lucifer 
 * @date 2017��3��15�� ����9:42:27 
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
