package service;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.HibernateException;

import dao.AnswerExamDao;
import pojo.AnswerExam;
import pojo.Exam;
import pojo.Item;
import pojo.Student;

public class AnswerExamManagerImpl implements AnswerExamManager{
	
	private AnswerExamDao dao;
	private AnswerManager answerManager;
	
	
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
	
	public boolean marking(Map<String,Object> session) throws HibernateException{
		
		Exam exam = (Exam) session.get("stuExam");
		Student stu = (Student) session.get("student");
		
		AnswerExam aExam = new AnswerExam();
		
		aExam.setExamId(exam.getExamId());
		aExam.setExamName(exam.getExamName());
		aExam.setStudentId(stu.getStudentId());
		aExam.setScore(answerManager.marking(session));
		
		dao.saveObject(aExam);
		
		return true;
//		if(item.getType().equals("choice")||item.getType().equals("judge")){
//			return itemManager.marking(item);
//		}
//		else{
//			return true;
//		}
	}

	public void setDao(AnswerExamDao dao) {
		this.dao = dao;
	}
	
	public void setAnswerManager(AnswerManager answerManager) {
		this.answerManager = answerManager;
	}
	
}
