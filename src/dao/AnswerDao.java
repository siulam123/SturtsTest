package dao;
import java.util.List;

import org.hibernate.HibernateException;

import pojo.Answer;

public interface AnswerDao {
	//存入
    public boolean saveObject(Answer obj) throws HibernateException;
    //更新
	public boolean updateObject(Answer obj) throws HibernateException;
	//按examId、studentId查找
	public List<Answer> getById(Integer examId,Integer studentId) throws HibernateException;
	//删除
	public boolean delectObject(Answer obj) throws HibernateException;
	//获取全部
	public List<Answer> getAll() throws HibernateException;
}
