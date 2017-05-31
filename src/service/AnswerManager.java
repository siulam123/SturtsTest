package service;

import java.util.List;
import java.util.Map;

import org.hibernate.HibernateException;

import pojo.Answer;

public interface AnswerManager {
	//����
    public boolean saveObject(Answer obj) throws HibernateException;
    //����
	public boolean updateObject(Answer obj) throws HibernateException;
	//��examId��studentId����
	public List<Answer> getById(Integer examId,Integer studentId) throws HibernateException;
	//ɾ��
	public boolean delectObject(Answer obj) throws HibernateException;
	//��ȡȫ��
	public List<Answer> getAll() throws HibernateException;
	//���⣬�����𰸴������ݿ⣬���سɼ���
	public Integer marking(Map<String, Object> session) throws HibernateException;
}
