package service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.HibernateException;
import org.springframework.stereotype.Service;

import dao.ExamDao;
import pojo.Exam;
import pojo.ExamParamters;
import service.ExamManager;
import service.ExampaperManager;
import tool.DataTool;

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
    
    public List<Exam> getExams() throws HibernateException{
    	return dao.getExams();
    }
    
    public boolean setExam(Exam exam) throws HibernateException{
    	
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
    
    //随机生成试卷
    public Map<String,Object> RandomExam(ExamParamters examParamters,Map<String,Object> items){
    	Map<String,Object> result = new HashMap<String,Object>();
    	
    	String[] choicelist = (String[])items.get("choice");
    	String[] judgelist = (String[])items.get("judge");
    	String[] blankfilinglist = (String[])items.get("blankfiling");
    	
    	//将随机生成的题目list添加到结果
    	if(choicelist != null){
    		result.put("choice", RandomItem(choicelist,examParamters.getChoiceMun()));
    	}
    	if(judgelist != null){
        	result.put("judge", RandomItem(judgelist,examParamters.getJudgeMun()));
    	}
    	if(blankfilinglist != null){
        	result.put("blankfiling", RandomItem(blankfilinglist,examParamters.getBlankfilingMun()));
    	}
    	return result;
    }
    
    //内部调用函数，用于随机选取题目,RandomExam函数调用
    private List<String> RandomItem(String[] list, int Mun){
    	List<String> result = new ArrayList<String>();
    	//根据题目数量循环几遍，从目标list随机挑选题目
    	for(int i = 0,j; i < Mun; i++){
    		//生成list长度内的随机数
    		j = DataTool.getRandom(list.length-i);
    		//添加到结果list中
    		result.add(list[j]);
    		//将已选过的题目放到list最后，不在选取
    		list[j] = list[list.length-1-i];
    	}
    	
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
