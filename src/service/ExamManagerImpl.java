package service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.HibernateException;
import org.springframework.stereotype.Service;

import dao.ExamDao;
import pojo.Exam;
import service.ExamManager;
import service.ExampaperManager;

@Service
public class ExamManagerImpl implements ExamManager{
    private ExamDao dao;
    private ExampaperManager exampaperManager;

    public ExamManagerImpl(){
        System.out.println("ExamManager IN");
    }
    
    public void setExampaperManager(ExampaperManager exampaperManager){
    	this.exampaperManager = exampaperManager;
    }
    
    public ExamDao getDao() {
    	return dao;
	}

    public void setDao(ExamDao dao) {
        this.dao = dao;
    }
    
    public boolean Upload(Exam exam) throws HibernateException{
    	dao.saveObject(exam);
    	return true;
    }
    
    public boolean setExam(String items,Exam exam) throws HibernateException{
    	
    	Upload(exam);//存入数据库
    	//String paperId = dao.getExampaperIdByExamId(exam);//获取刚存入自增生成的paperId
    		
    	//调用exampapermanager将题目存入数据库
		//exampaperManager.setExampaper(items, paperId);

    	return true;
    }
    
    public String getExampaperIdByExamId(Exam exam){
    	return dao.getExampaperIdByExamId(exam);//获取刚存入自增生成的paperId
    }
    
    public void setExampaper(String items,String paperId){
    	//调用exampapermanager将题目存入数据库
		exampaperManager.setExampaper(items, paperId);
    }
    
    public Map<String,Object> getExamById(String examId) throws HibernateException {
    	Map<String,Object> result = new HashMap<String,Object>();
    	//根据id获取exam
    	Exam exam = dao.getExamById(examId);
    	//根据list<exampaper>获取list<item>
    	List<Object> items = exampaperManager.getItemsByPapers(//根据exampaperId获取list<exampaper>
    			exampaperManager.getExampaperById(exam.getExamPaperId()));
    	
    	//将获取的数据存入map
    	result.put("exam", exam);
    	result.put("items", items);
    	
        return result;
    }
    

	@Override
	public boolean reflect(Exam exam, Double amount) throws HibernateException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean recharge(Exam exam, Double amount) throws HibernateException {
		// TODO Auto-generated method stub
		return false;
	}
	
}
