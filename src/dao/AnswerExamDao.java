package dao;
import java.util.List;

import org.hibernate.HibernateException;

import pojo.AnswerExam;

public interface AnswerExamDao {
	//����
    public void saveObject(AnswerExam exam) throws HibernateException;
    //����
	public void updateObject(AnswerExam exam) throws HibernateException;
	//��answerExamid����
	public AnswerExam getById(Integer Id) throws HibernateException;
	//��studentId����
	public List<AnswerExam> getByStudentId(Integer Id) throws HibernateException;
	//��examId����
	public AnswerExam getByExamId(Integer Id) throws HibernateException;
	//ɾ��
	public void delectObject(AnswerExam exam) throws HibernateException;
	//��ȡȫ��
	public List<AnswerExam> getAll() throws HibernateException;
}
