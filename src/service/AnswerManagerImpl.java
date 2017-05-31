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
	
	//存入
    public boolean saveObject(Answer obj) throws HibernateException{
    	return dao.saveObject(obj);
    }
    //更新
	public boolean updateObject(Answer obj) throws HibernateException{
		return dao.updateObject(obj);
	}
	//按examId、studentId查找
	public List<Answer> getById(Integer examId,Integer studentId) throws HibernateException{
		return dao.getById(examId, studentId);
	}
	//删除
	public boolean delectObject(Answer obj) throws HibernateException{
		return dao.delectObject(obj);
	}
	//获取全部
	public List<Answer> getAll() throws HibernateException{
		return dao.getAll();
	}
	
	public Integer marking(Map<String, Object> session) throws HibernateException{
		
		Exam exam = (Exam) session.get("stuExam");
		Student stu = (Student) session.get("student");
		Map<Integer,Item> items = (Map<Integer,Item>)session.get("stuItems");
		String[] strs= DataTool.getItems(exam.getPlace());//选择-》判断-》填空
		
		Integer score = 0;
		
		//遍历
		Iterator index = items.entrySet().iterator();
		
		while(index.hasNext()){
			Answer ans = new Answer();//实例化
			
			Map.Entry entry = (Map.Entry)index.next();
			Item item = (Item) entry.getValue();
			
			ans.setAnswer(item.getAnswer());
			ans.setExamId(exam.getExamId());
			ans.setItemId(item.getItemId());
			ans.setStudentId(stu.getStudentId());
			
			switch (item.getType()) {
				case "choice":
					if(itemManager.getItemById(item.getItemId()).getAnswer().equals(item.getAnswer())){
						//正确
						ans.setRoW("Y");
						score += Integer.parseInt(strs[0]);
					}
					else{
						ans.setRoW("N");
					}	
					break;
				case "judge":
					if(itemManager.getItemById(item.getItemId()).getAnswer().equals(item.getAnswer())){
						//正确
						ans.setRoW("Y");
						score += Integer.parseInt(strs[1]);
					}
					else{
						ans.setRoW("N");
					}
					break;
				case "blankfiling":
					String ansStr = itemManager.getItemById(item.getItemId()).getAnswer();//获取答案
					
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
