package service;

import java.util.List;

import org.hibernate.HibernateException;

import dao.AnswerDao;
import pojo.Answer;

public class AnswerManagerImpl implements AnswerManager{
	
	private AnswerDao dao;
	
	//����
    public boolean saveObject(Answer obj) throws HibernateException{
    	return dao.saveObject(obj);
    }
    //����
	public boolean updateObject(Answer obj) throws HibernateException{
		return dao.updateObject(obj);
	}
	//��examId��studentId����
	public List<Answer> getById(Integer examId,Integer studentId) throws HibernateException{
		return dao.getById(examId, studentId);
	}
	//ɾ��
	public boolean delectObject(Answer obj) throws HibernateException{
		return dao.delectObject(obj);
	}
	//��ȡȫ��
	public List<Answer> getAll() throws HibernateException{
		return dao.getAll();
	}

	public void setDao(AnswerDao dao) {
		this.dao = dao;
	}
	
}
