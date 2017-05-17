package daoImpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import dao.AnswerExamDao;
import pojo.AnswerExam;

public class AnswerExamDaoImpl extends HibernateDaoSupport implements AnswerExamDao{
	public AnswerExamDaoImpl() {
    }
	
	public void saveObject(AnswerExam obj) throws HibernateException{
		getHibernateTemplate().save(obj);
	}
	
	public void updateObject(AnswerExam obj) throws HibernateException{
		getHibernateTemplate().update(obj);
	}
	
	public AnswerExam getById(Integer Id) throws HibernateException{
		List<?> list =getHibernateTemplate().find("FROM AnswerExam U WHERE U.answerExamId = ?0",Id);
    	
    	if(list.size()!=0)
    		return (AnswerExam) list.get(0);
    	else
    		return null;
	}
	
	public List<AnswerExam> getByStudentId(Integer Id) throws HibernateException{
		List<AnswerExam> list = (List<AnswerExam>)getHibernateTemplate().find("FROM AnswerExam U WHERE U.studentId = ?0",Id);
		
		return list;
	}
	
	public AnswerExam getByExamId(Integer Id) throws HibernateException{
		List<?> list = getHibernateTemplate().find("FROM AnswerExam U WHERE U.examId = ?0",Id);
    	
		if(list.size()!=0)
    		return (AnswerExam) list.get(0);
    	else
    		return null;
	}
	
	public List<AnswerExam> getAll() throws HibernateException{
		List<AnswerExam> list = (List<AnswerExam>)getHibernateTemplate().loadAll(AnswerExam.class);
		
		return list;
	}
	
	public void delectObject(AnswerExam obj) throws HibernateException{
		getHibernateTemplate().delete(obj);
	}
}
