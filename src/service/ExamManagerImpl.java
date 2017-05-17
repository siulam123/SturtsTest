package service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hibernate.HibernateException;
import org.springframework.stereotype.Service;

import dao.ExamDao;
import pojo.Exam;
import pojo.ExamParamters;
import pojo.Item;
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
    
    public Exam getExamById(String examId) throws HibernateException {
    	Exam exam;
    	//����id��ȡexam
    	List<Exam> examlist = dao.getExamById(Integer.parseInt(examId));
    	
    	if(examlist.size()==1){
    		exam = examlist.get(0);
    	}
    	else{//�����ص��Ծ�ֹһ�ţ��������������һ���Ծ�
    		exam = examlist.get(DataTool.getRandom((examlist.size()-1)));
    	}
    	
    	//����list<exampaper>��ȡlist<item>
//    	List<Object> items = exampaperManager.getItemsByPapers(//����exampaperId��ȡlist<exampaper>
//    			exampaperManager.getExampaperById(exam.getExamPaperId()));
//    	
//    	//����ȡ�����ݴ���map
//    	result.put("exam", exam);
//    	result.put("items", items);
    	
        return exam;
    }
    
    //��������Ծ�
    public Map<String,Object> RandomExam(ExamParamters examParamters,Map<String,Object> items){
    	Map<String,Object> result = new HashMap<String,Object>();
    	
    	Map<Integer,Object> choicelist = (Map<Integer,Object>)items.get("choice");
    	Map<Integer,Object> judgelist = (Map<Integer,Object>)items.get("judge");
    	Map<Integer,Object> blankfilinglist = (Map<Integer,Object>)items.get("blankfiling");
    	
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
    private List<Object> RandomItem(Map<Integer,Object> map, int Mun){
    	List<Object> result = new ArrayList<Object>();
    	//������Ŀ����ѭ�����飬��Ŀ��list�����ѡ��Ŀ
    	for(int i = 0,j; i < Mun; i++){
    		if(i>=map.size()){//��ֹ����Խ��
    			break;
    		}
    		//����list�����ڵ������
    		j = DataTool.getRandom(map.size()-i);
    		//��ӵ����list��
    		result.add(map.get(j));
    		//����ѡ������Ŀ�ŵ�list��󣬲���ѡȡ
    		map.put((map.size()-1-i), map.get(j));
    		
    	}
    	
    	return result;
    }
    
    public Map<String,Object> chooie(List<Object> items){
    	Map<String,Object> map = new HashMap<String,Object>();
    	Map<Integer,Object> choicelist = new HashMap<Integer,Object>();int c=0;
    	Map<Integer,Object> judgelist = new HashMap<Integer,Object>();int j=0;
    	Map<Integer,Object> blankfilinglist = new HashMap<Integer,Object>();int b=0;
    	
    	Iterator index = items.iterator();
    	while(index.hasNext()){
    		Item item = (Item)index.next();
    		switch (item.getType()) {
			case "choice":
				choicelist.put(c, item);
				c++;
				break;

			case "judge":
				judgelist.put(j, item);
				j++;
				break;
			case "blankfiling":
				blankfilinglist.put(b, item);
				b++;
				break;
			default:
				break;
			}
    	}
    	
    	map.put("choice", choicelist);
    	map.put("judge", judgelist);
    	map.put("blankfiling", blankfilinglist);
    	return map;
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
