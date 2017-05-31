package service;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.HibernateException;

import dao.AnswerDao;
import pojo.Answer;
import pojo.Exam;
import pojo.Item;
import pojo.Student;
import tool.DataTool;

public class AnswerManagerImpl implements AnswerManager{
	
	private AnswerDao dao;
	private ItemManager itemManager;
	
	//����
    public boolean saveObject(Answer obj) throws HibernateException{
    	return dao.saveObject(obj);
    }
    //����
	public boolean updateObject(Answer obj) throws HibernateException{
		return dao.updateObject(obj);
	}
	//��examId��studentId����
	public List<Answer> getById(Integer examId,Integer studentId) throws HibernateException{
		return dao.getById(examId, studentId);
	}
	//ɾ��
	public boolean delectObject(Answer obj) throws HibernateException{
		return dao.delectObject(obj);
	}
	//��ȡȫ��
	public List<Answer> getAll() throws HibernateException{
		return dao.getAll();
	}
	
	public Integer marking(Map<String, Object> session) throws HibernateException{
		
		Exam exam = (Exam) session.get("stuExam");
		Student stu = (Student) session.get("student");
		Map<Integer,Item> items = (Map<Integer,Item>)session.get("stuItems");
		String[] strs= DataTool.getItems(exam.getPlace());//ѡ��-���ж�-�����
		
		Integer score = 0;
		
		//����
		Iterator index = items.entrySet().iterator();
		
		while(index.hasNext()){
			Answer ans = new Answer();//ʵ����
			
			Map.Entry entry = (Map.Entry)index.next();
			Item item = (Item) entry.getValue();
			
			ans.setAnswer(item.getAnswer());
			ans.setExamId(exam.getExamId());
			ans.setItemId(item.getItemId());
			ans.setStudentId(stu.getStudentId());
			
			switch (item.getType()) {
				case "choice":
					if(itemManager.getItemById(item.getItemId()).getAnswer().equals(item.getAnswer())){
						//��ȷ
						ans.setRoW("Y");
						score += Integer.parseInt(strs[0]);
					}
					else{
						ans.setRoW("N");
					}	
					break;
				case "judge":
					if(itemManager.getItemById(item.getItemId()).getAnswer().equals(item.getAnswer())){
						//��ȷ
						ans.setRoW("Y");
						score += Integer.parseInt(strs[1]);
					}
					else{
						ans.setRoW("N");
					}
					break;
				case "blankfiling":
					String ansStr = itemManager.getItemById(item.getItemId()).getAnswer();//��ȡ��
					
					String[] answers = ansStr.split("->");
					
					for(int i = 0; i < answers.length; i++){
						if(answers[i].equals(item.getAnswer())){
							ans.setRoW("Y");
							score += Integer.parseInt(strs[2]);
						}
						else{
							ans.setRoW("N");
						}
					}
				break;
				default:
					break;
			}
		
			dao.saveObject(ans);
		}
		
		return score;
	}

	public void setDao(AnswerDao dao) {
		this.dao = dao;
	}
	
	public void setItemManager(ItemManager itemManager) {
		this.itemManager = itemManager;
	}
}
