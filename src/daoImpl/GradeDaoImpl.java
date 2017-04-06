package daoImpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import dao.GradeDao;
import pojo.Grade;


@Repository
public class GradeDaoImpl extends HibernateDaoSupport implements GradeDao{

	public GradeDaoImpl() {
        System.out.println("GradeDao IN");
    }
	
    public void saveObject(Grade obj) throws HibernateException {
        getHibernateTemplate().save(obj);       
    }  

    public List<Grade> getGrades() throws HibernateException{
        List<Grade> grade=getHibernateTemplate().loadAll(Grade.class);
        return grade;
    }
    
    public List<Grade> getAllGrades(Grade grade) throws HibernateException{
    	List<?> list = getHibernateTemplate().find("FROM Grade U WHERE U.studentId = ?0",grade.getStudentId());
    	List<Grade> result = (List<Grade>)list;
    	return result;
    }
    
	public void updateObject(Grade grade) throws HibernateException {
		getHibernateTemplate().update(grade);	
	}
	
}
