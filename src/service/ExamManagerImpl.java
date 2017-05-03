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
    	
    	Upload(exam);//�������ݿ�
    	//String paperId = dao.getExampaperIdByExamId(exam);//��ȡ�մ����������ɵ�paperId
    		
    	//����exampapermanager����Ŀ�������ݿ�
		//exampaperManager.setExampaper(items, paperId);

    	return true;
    }
    
    public String getExampaperIdByExamId(Exam exam){
    	return dao.getExampaperIdByExamId(exam);//��ȡ�մ����������ɵ�paperId
    }
    
    public void setExampaper(String items,String paperId){
    	//����exampapermanager����Ŀ�������ݿ�
		exampaperManager.setExampaper(items, paperId);
    }
    
    public Map<String,Object> getExamById(String examId) throws HibernateException {
    	Map<String,Object> result = new HashMap<String,Object>();
    	//����id��ȡexam
    	Exam exam = dao.getExamById(examId);
    	//����list<exampaper>��ȡlist<item>
    	List<Object> items = exampaperManager.getItemsByPapers(//����exampaperId��ȡlist<exampaper>
    			exampaperManager.getExampaperById(exam.getExamPaperId()));
    	
    	//����ȡ�����ݴ���map
    	result.put("exam", exam);
    	result.put("items", items);
    	
        return result;
    }
    
    //��������Ծ�
    public Map<String,Object> RandomExam(ExamParamters examParamters,Map<String,Object> items){
    	Map<String,Object> result = new HashMap<String,Object>();
    	
    	String[] choicelist = (String[])items.get("choice");
    	String[] judgelist = (String[])items.get("judge");
    	String[] blankfilinglist = (String[])items.get("blankfiling");
    	
    	//��������ɵ���Ŀlist��ӵ����
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
    
    //�ڲ����ú������������ѡȡ��Ŀ,RandomExam��������
    private List<String> RandomItem(String[] list, int Mun){
    	List<String> result = new ArrayList<String>();
    	//������Ŀ����ѭ�����飬��Ŀ��list�����ѡ��Ŀ
    	for(int i = 0,j; i < Mun; i++){
    		//����list�����ڵ������
    		j = DataTool.getRandom(list.length-i);
    		//��ӵ����list��
    		result.add(list[j]);
    		//����ѡ������Ŀ�ŵ�list��󣬲���ѡȡ
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
