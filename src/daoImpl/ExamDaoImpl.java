package daoImpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import dao.ExamDao;
import pojo.Exam;


@Repository
public class ExamDaoImpl extends HibernateDaoSupport implements ExamDao{

	public ExamDaoImpl() {
        System.out.println("ExamDao IN");
    }
	
    public void saveObject(Exam obj) throws HibernateException {
        getHibernateTemplate().save(obj);       
    }  

    public List<Exam> getExams() throws HibernateException{
        List<Exam> exam=getHibernateTemplate().loadAll(Exam.class);
        return exam;
    }
    
    public String getExampaperIdByExamId(Exam exam) throws HibernateException{
    	List<?> list =getHibernateTemplate().find("FROM Exam U WHERE U.examId = ?0",exam.getExamId());

    	if(list.size()!=0){
        	Exam e = new Exam();
    		e = (Exam)list.get(0);
    		return e.getExamPaperId();
    	}
    	else
    		return null;
    }
    
    public Exam getExamById(String examId) throws HibernateException{
    	List<?> list =getHibernateTemplate().find("FROM Exam U WHERE U.examId = ?0",examId);
    	if(list.size()!=0)
    		return (Exam) list.get(0);
    	else
    		return null;
    }

	public void updateObject(Exam exam) throws HibernateException {
		getHibernateTemplate().update(exam);	
	}
	
}
