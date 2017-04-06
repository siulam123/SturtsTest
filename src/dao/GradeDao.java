package dao;
import java.util.List;

import org.hibernate.HibernateException;

import pojo.Grade;

public interface GradeDao {
	
    public void saveObject(Grade grade) throws HibernateException;
    public List<Grade> getGrades() throws HibernateException;
	public void updateObject(Grade grade) throws HibernateException;
	public List<Grade> getAllGrades(Grade grade) throws HibernateException;

}
