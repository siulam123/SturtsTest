package service;

import java.util.List;

import org.hibernate.HibernateException;
import org.springframework.stereotype.Service;

import dao.GradeDao;
import daoImpl.GradeDaoImpl;
import pojo.Grade;
import service.GradeManager;

@Service
public class GradeManagerImpl implements GradeManager{
    private GradeDaoImpl dao;  

    public GradeManagerImpl(){
        dao = new GradeDaoImpl();
        System.out.println("GradeManager IN");
    }
    
    public GradeDao getDao() {
    	return dao;
	}

    public void setDao(GradeDaoImpl dao) {
        this.dao = dao;
    }

    public List<Grade> getGrades(Grade grade) throws HibernateException {  
        return dao.getAllGrades(grade);
    }

	@Override
	public boolean reflect(Grade grade, Double amount) throws HibernateException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean recharge(Grade grade, Double amount) throws HibernateException {
		// TODO Auto-generated method stub
		return false;
	}
	
}
