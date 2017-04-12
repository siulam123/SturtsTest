package service;

import java.util.Map;

import org.hibernate.HibernateException;

import pojo.Exam;

public interface ExamManager {
	//上传试卷
	public boolean Upload(Exam exam) throws HibernateException;
	//根据id获取试卷内容
	public Map<String,Object> getExamById(String examId) throws HibernateException;
	//将试卷题目和试卷信息存入数据库
	public boolean setExam(String items,Exam exam) throws HibernateException;
	
	public boolean recharge(Exam exampaper,Double amount) throws HibernateException;
	public boolean reflect(Exam exampaper,Double amount) throws HibernateException;
}
