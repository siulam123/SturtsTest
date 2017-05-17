package dao;
import java.util.List;

import org.hibernate.HibernateException;

import pojo.Exam;

public interface ExamDao {
	//存入试卷到数据库
    public void saveObject(Exam exam) throws HibernateException;
    //获取所有试卷
    public List<Exam> getExams() throws HibernateException;
    //更新试卷
	public void updateObject(Exam exam) throws HibernateException;
	//按试卷id查找
	public List<Exam> getExamById(Integer examId) throws HibernateException;
	//按试卷id查找ExampaperId
	public String getExampaperIdByExamId(Exam exam) throws HibernateException;
	    
	//按照试卷类型查找
	//public List<Item> getItemsByType(String type) throws HibernateException;

}
