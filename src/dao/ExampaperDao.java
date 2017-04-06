package dao;
import java.util.List;

import org.hibernate.HibernateException;

import pojo.Exampaper;

public interface ExampaperDao {
	//存入题目到数据库
    public void saveObject(Exampaper exampaper) throws HibernateException;
    //更新题目
	public void updateObject(Exampaper exampaper) throws HibernateException;
	//按exampaperId查找该试卷所有题目ID
	public List<Exampaper> getExampaperByExampaperId(String exampaperId) throws HibernateException;

}
