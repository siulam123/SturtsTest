package dao;
import java.util.List;

import org.hibernate.HibernateException;

import pojo.AnswerExam;

public interface AnswerExamDao {
	//存入
    public void saveObject(AnswerExam exam) throws HibernateException;
    //更新
	public void updateObject(AnswerExam exam) throws HibernateException;
	//按answerExamid查找
	public AnswerExam getById(Integer Id) throws HibernateException;
	//按studentId查找
	public List<AnswerExam> getByStudentId(Integer Id) throws HibernateException;
	//按examId查找
	public AnswerExam getByExamId(Integer Id) throws HibernateException;
	//删除
	public void delectObject(AnswerExam exam) throws HibernateException;
	//获取全部
	public List<AnswerExam> getAll() throws HibernateException;
}
