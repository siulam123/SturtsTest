package dao;
import java.util.List;

import org.hibernate.HibernateException;

import pojo.Exam;

public interface ExamDao {
	//�����Ծ����ݿ�
    public void saveObject(Exam exam) throws HibernateException;
    //��ȡ�����Ծ�
    public List<Exam> getExams() throws HibernateException;
    //�����Ծ�
	public void updateObject(Exam exam) throws HibernateException;
	//���Ծ�id����
	public List<Exam> getExamById(Integer examId) throws HibernateException;
	//���Ծ�id����ExampaperId
	public String getExampaperIdByExamId(Exam exam) throws HibernateException;
	    
	//�����Ծ����Ͳ���
	//public List<Item> getItemsByType(String type) throws HibernateException;

}
