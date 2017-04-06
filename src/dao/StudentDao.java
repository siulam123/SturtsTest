package dao;
import java.util.List;

import org.hibernate.HibernateException;

import pojo.Student;

public interface StudentDao {
	
    public void saveObject(Student user) throws HibernateException;
    public List<Student> getStudents() throws HibernateException;
	public void updateObject(Student user) throws HibernateException;

}
