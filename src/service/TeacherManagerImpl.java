package service;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.HibernateException;
import org.springframework.stereotype.Service;

import daoImpl.TeacherDaoImpl;
import pojo.Teacher;

@Service
public class TeacherManagerImpl implements TeacherManager{
    private TeacherDaoImpl dao;  

	public TeacherManagerImpl(){
        dao = new TeacherDaoImpl();
        System.out.println("TeacherManager IN");
    }
    
    public TeacherDaoImpl getDao() {
    	return dao;
	}

    public void setDao(TeacherDaoImpl dao) {
        this.dao = dao;
    }

    public List<Teacher> getTeachers() throws HibernateException {  
        return dao.getTeachers();
    }
    
    public boolean register(Teacher teacher) throws HibernateException{
    	dao.saveObject(teacher);
    	return true;
    }
    
    public Teacher findObject(Teacher teacher) throws HibernateException{
    	return dao.findTeacher(teacher);
    }
    
    public String login(Teacher teacher) throws HibernateException{
    	Teacher teacherSql = dao.findTeacher(teacher);
    	if(teacherSql!=null)
    		if(teacher.getPassword().equals(teacherSql.getPassword())){
    			System.out.println("教师"+teacherSql.getTeacherId()+"登陆成功");
    			return "success";
    		}
    		else
    			return "error";
    	else
    		return "none";
    }

	@Override
	public boolean reflect(Teacher teacher, Double amount) throws HibernateException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean recharge(Teacher teacher, Double amount) throws HibernateException {
		// TODO Auto-generated method stub
		return false;
	}
}
