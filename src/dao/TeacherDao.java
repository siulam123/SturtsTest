package dao;
import java.util.List;

import org.hibernate.HibernateException;

import pojo.Teacher;

public interface TeacherDao {
	
    public void saveObject(Teacher teacher) throws HibernateException;
    public List<Teacher> getTeachers() throws HibernateException;
	public void updateObject(Teacher teacher) throws HibernateException;

}
