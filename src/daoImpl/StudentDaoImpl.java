package daoImpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import dao.StudentDao;
import pojo.Student;

@Repository
public class StudentDaoImpl extends HibernateDaoSupport implements StudentDao{

	public StudentDaoImpl() {
        System.out.println("UserDao IN");
    }
	
    public void saveObject(Student obj) throws HibernateException {
        getHibernateTemplate().save(obj);
        
    }  

    public List<Student> getStudents() throws HibernateException{
        List<Student> stu=getHibernateTemplate().loadAll(Student.class);
        return stu;
    }
    
    public Student findStudent(Student stu) throws HibernateException{
    	List<?> list =getHibernateTemplate().find("FROM Student U WHERE U.studentId = ?0",stu.getStudentId());
    	//
    	if(list.size()!=0)
    		return (Student) list.get(0);
    	else
    		return null;
    }

	public void updateObject(Student stu) throws HibernateException {
		getHibernateTemplate().update(stu);	
	}
	
}
