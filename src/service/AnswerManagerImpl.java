package service;

import java.util.List;

import org.hibernate.HibernateException;

import dao.AnswerDao;
import pojo.Answer;

public class AnswerManagerImpl implements AnswerManager{
	
	private AnswerDao dao;
	
	//存入
    public boolean saveObject(Answer obj) throws HibernateException{
    	return dao.saveObject(obj);
    }
    //更新
	public boolean updateObject(Answer obj) throws HibernateException{
		return dao.updateObject(obj);
	}
	//按examId、studentId查找
	public List<Answer> getById(Integer examId,Integer studentId) throws HibernateException{
		return dao.getById(examId, studentId);
	}
	//删除
	public boolean delectObject(Answer obj) throws HibernateException{
		return dao.delectObject(obj);
	}
	//获取全部
	public List<Answer> getAll() throws HibernateException{
		return dao.getAll();
	}

	public void setDao(AnswerDao dao) {
		this.dao = dao;
	}
	
}
