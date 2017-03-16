package daoImpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import dao.UserDao;
import pojo.Student;

@Repository
public class UserDaoImpl extends HibernateDaoSupport implements UserDao{

	public UserDaoImpl() {
        System.out.println("UserDao IN");
    }
	
    public void saveObject(Student obj) throws HibernateException {
        getHibernateTemplate().save(obj);
        
    }  

    public List<Student> getStudents() throws HibernateException{
        List<Student> stu=getHibernateTemplate().loadAll(Student.class);
        return stu;
    }
    
    public Student findUser(Student user) throws HibernateException{
    	List<?> list =getHibernateTemplate().find("FROM Student U WHERE U.studentName = ?0",user.getStudentName());
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
