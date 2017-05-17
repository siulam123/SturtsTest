package service;

import java.util.List;
import java.util.Map;

import org.hibernate.HibernateException;

import pojo.Exam;
import pojo.ExamParamters;
import pojo.Item;

public interface ExamManager {
	//�ϴ��Ծ�
	public boolean Upload(Exam exam) throws HibernateException;
	//����id��ȡ�Ծ�����
	public Exam getExamById(String examId) throws HibernateException;
	//���Ծ���Ŀ���Ծ���Ϣ�������ݿ�
	public boolean setExam(Exam exam) throws HibernateException;
	//��������Ծ�
	public Map<String,Object> RandomExam(ExamParamters examParamters,Map<String,Object> items);
	//��ȡ�����Ծ�
	public List<Exam> getExams() throws HibernateException;
	//����ת������list�����map
    public Map<String,Object> chooie(List<Object> items);
	
	public boolean recharge(Exam exampaper,Double amount) throws HibernateException;
	public boolean reflect(Exam exampaper,Double amount) throws HibernateException;
}
