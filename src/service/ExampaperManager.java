package service;

import java.util.List;

import org.hibernate.HibernateException;

import pojo.Exampaper;

public interface ExampaperManager {
	//上传题目
	public boolean Upload(Exampaper exampaper) throws HibernateException;
	//根据id获取题目
	public List<Exampaper> getExampaperByExampaperId(String exampaperId) throws HibernateException;
		   
	public boolean recharge(Exampaper exampaper,Double amount) throws HibernateException;
	public boolean reflect(Exampaper exampaper,Double amount) throws HibernateException;
}
