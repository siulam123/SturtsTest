package service;

import java.util.List;

import org.hibernate.HibernateException;
import org.springframework.stereotype.Service;

import daoImpl.UserDaoImpl;
import pojo.Student;

@Service
public class UserManagerImpl implements UserManager{
    private UserDaoImpl dao;  

    public UserManagerImpl(){
        dao = new UserDaoImpl();
        System.out.println("UserManager IN");
    }
    
    public UserDaoImpl getDao() {
    	return dao;
	}

    public void setDao(UserDaoImpl dao) {
        this.dao = dao;
    }

    public List<Student> getStudents() throws HibernateException {  
        return dao.getStudents();
    }
    
    public boolean register(Student user) throws HibernateException{
    	dao.saveObject(user);
    	return true;
    }
    
    public String login(Student stu) throws HibernateException{
    	Student userSql = dao.findUser(stu);
    	if(userSql!=null)
    		if(userSql.getPassword().equals(stu.getPassword())){
    			System.out.println("用户"+userSql.getStudentName()+"登陆成功");
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
