package service;

import java.util.List;
import java.util.Map;

import org.hibernate.HibernateException;

import pojo.Answer;

public interface AnswerManager {
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
	//判题，并将答案存入数据库，返回成绩数
	public Integer marking(Map<String, Object> session) throws HibernateException;
}
