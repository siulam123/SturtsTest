package service;

import java.util.List;
import java.util.Map;

import org.hibernate.HibernateException;

import pojo.AnswerExam;
import pojo.Item;

public interface AnswerExamManager {
	//����
    public boolean saveObject(AnswerExam exam) throws HibernateException;
    //����
	public boolean updateObject(AnswerExam exam) throws HibernateException;
	//��answerExamid����
	public AnswerExam getById(Integer Id) throws HibernateException;
	//��studentId����
	public List<AnswerExam> getByStudentId(Integer Id) throws HibernateException;
	//��examId����
	public AnswerExam getByExamId(Integer Id) throws HibernateException;
	//ɾ��
	public boolean delectObject(AnswerExam exam) throws HibernateException;
	//��ȡȫ��
	public List<AnswerExam> getAll() throws HibernateException;
	//����ϵͳ
	public boolean marking(Map<String, Object> session) throws HibernateException;
}
