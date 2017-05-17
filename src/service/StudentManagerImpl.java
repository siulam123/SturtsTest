package service;

import java.util.List;

import org.hibernate.HibernateException;
import org.springframework.stereotype.Service;

import daoImpl.StudentDaoImpl;
import pojo.Student;

@Service
public class StudentManagerImpl implements StudentManager{
    private StudentDaoImpl dao;  

    public StudentManagerImpl(){
        dao = new StudentDaoImpl();
        System.out.println("StudentManager IN");
    }
    
    public StudentDaoImpl getDao() {
    	return dao;
	}

    public void setDao(StudentDaoImpl dao) {
        this.dao = dao;
    }
    
    public Student findObject(Student student) throws HibernateException{
    	return dao.findStudent(student);
    }

    public List<Student> getStudents() throws HibernateException {  
        return dao.getStudents();
    }
    
    public boolean register(Student user) throws HibernateException{
    	dao.saveObject(user);
    	return true;
    }
    
    public String login(Student stu) throws HibernateException{
    	Student stuSql = dao.findStudent(stu);
    	if(stuSql!=null)
    		if(stuSql.getPassword().equals(stu.getPassword())){
    			System.out.println("用户"+stuSql.getStudentName()+"登陆成功");
    			return "success";
    		}
    		else
    			return "error";
    	else
    		return "null";
    }

	@Override
	public boolean reflect(Student user, Double amount) throws HibernateException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean recharge(Student user, Double amount) throws HibernateException {
		// TODO Auto-generated method stub
		return false;
	}
	
}
