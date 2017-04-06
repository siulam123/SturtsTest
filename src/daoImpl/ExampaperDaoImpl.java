package daoImpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import dao.ExampaperDao;
import pojo.Exampaper;


@Repository
public class ExampaperDaoImpl extends HibernateDaoSupport implements ExampaperDao{

	public ExampaperDaoImpl() {
        System.out.println("ExampaperDao IN");
    }
	
    public void saveObject(Exampaper obj) throws HibernateException {
        getHibernateTemplate().save(obj);       
    }  
    
    public List<Exampaper> getExampaperByExampaperId(String exampaperId)  throws HibernateException{
    	List<?> list =getHibernateTemplate().find("FROM Exampaper U WHERE U.exampaperId = ?0",exampaperId);

    	return (List<Exampaper>)list;
    }

	public void updateObject(Exampaper exampaper) throws HibernateException {
		getHibernateTemplate().update(exampaper);	
	}
	
}
