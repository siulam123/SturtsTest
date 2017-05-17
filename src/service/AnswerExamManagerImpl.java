package service;

import java.util.List;

import org.hibernate.HibernateException;

import dao.AnswerExamDao;
import pojo.AnswerExam;

public class AnswerExamManagerImpl implements AnswerExamManager{
	
	private AnswerExamDao dao;
	
    public boolean saveObject(AnswerExam obj) throws HibernateException{
    	dao.saveObject(obj);
    	return true;
    }
    
	public boolean updateObject(AnswerExam obj) throws HibernateException{
		dao.updateObject(obj);
		return true;
	}
	
	public AnswerExam getById(Integer Id) throws HibernateException{
		return dao.getById(Id);
	}
	
	public List<AnswerExam> getByStudentId(Integer Id) throws HibernateException{
		return dao.getByStudentId(Id);
	}
	
	public AnswerExam getByExamId(Integer Id) throws HibernateException{
		return dao.getByExamId(Id);
	}
	
	public boolean delectObject(AnswerExam obj) throws HibernateException{
		dao.delectObject(obj);
		return true;
	}
	
	public List<AnswerExam> getAll() throws HibernateException{
		return dao.getAll();
	}

	public void setDao(AnswerExamDao dao) {
		this.dao = dao;
	}
}
