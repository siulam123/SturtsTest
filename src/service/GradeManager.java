package service;

import java.util.List;

import org.hibernate.HibernateException;

import pojo.Grade;


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
public interface GradeManager {
	public List<Grade> getGrades(Grade grade) throws HibernateException;
	public boolean recharge(Grade grade,Double amount) throws HibernateException;
	public boolean reflect(Grade grade,Double amount) throws HibernateException;
}
