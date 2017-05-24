package daoImpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import dao.AnswerDao;
import pojo.Answer;

public class AnswerDaoImpl extends HibernateDaoSupport implements AnswerDao{
	public AnswerDaoImpl(){}
	
	public boolean saveObject(Answer obj) throws HibernateException{
		getHibernateTemplate().save(obj);
		return true;
	}
	
	public boolean updateObject(Answer obj) throws HibernateException{
		getHibernateTemplate().update(obj);
		return true;
	}
	
	public boolean delectObject(Answer obj) throws HibernateException{
		getHibernateTemplate().delete(obj);
		return true;
	}
	
	public List<Answer> getAll() throws HibernateException{
		List<Answer> list = (List<Answer>)getHibernateTemplate().loadAll(Answer.class);
		return list;
	}
	
	public List<Answer> getById(Integer examId,Integer studentId) throws HibernateException{
		List<?> list = getHibernateTemplate().find("FROM Answer U WHERE U.examId = ?0 and U.studentId = ?1",examId,studentId);
		return (List<Answer>)list;
	}
}
