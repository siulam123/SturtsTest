package daoImpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import dao.StudentDao;
import dao.TeacherDao;
import pojo.Student;
import pojo.Teacher;

@Repository
public class TeacherDaoImpl extends HibernateDaoSupport implements TeacherDao{

	public TeacherDaoImpl() {
        System.out.println("TeacherDao IN");
    }
	
    public void saveObject(Teacher obj) throws HibernateException {
        getHibernateTemplate().save(obj);
        
    }  

    public List<Teacher> getTeachers() throws HibernateException{
        List<Teacher> teacher=getHibernateTemplate().loadAll(Teacher.class);
        return teacher;
    }
    
    public Teacher findTeacher(Teacher teacher) throws HibernateException{
    	List<?> list =getHibernateTemplate().find("FROM Teacher U WHERE U.teacherId = ?0",teacher.getTeacherId());
    	//
    	if(list.size()!=0)
    		return (Teacher) list.get(0);
    	else
    		return null;
    }

	public void updateObject(Teacher teacher) throws HibernateException {
		getHibernateTemplate().update(teacher);	
	}
	
}
