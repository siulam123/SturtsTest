package action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.Action;

import pojo.Exam;
import pojo.Exampaper;
import pojo.Item;
import pojo.AnswerExam;
import pojo.Answer;
import service.ExamManager;
import service.ExampaperManager;
import service.ItemManager;
import service.AnswerExamManager;
import service.AnswerManager;

public class StuExamAction implements Action, SessionAware{
	
	/*	
	 * 根据传入examId获取试卷全部内容，包括题目内容与试卷信息，存入session
	 * examId:试卷id，由学生输入
	 * session值：stuExam:（Exam）试卷信息， stuExamItem:(List<Item>)试卷题目内容
	 */
	public String ExamById(){
		//根据传入id获取试卷信息
		Exam exam = examManager.getExamById(examId);
		
		//获取题目内容
		String paperId = exam.getExamPaperId();
		List<Exampaper> paperlist = exampaperManager.getExampaperById(paperId);
		
		Iterator index = paperlist.iterator();
		
		List<Item> items = new ArrayList<Item>();
		
		while(index.hasNext()){
			Exampaper paper = (Exampaper)index.next();
			Item item = ItemManager.getItemById(paper.getItemId());
			//存入list
			items.add(item);
		}
		
		//设置id值，防止信息泄露
		exam.setExamId(0);
		exam.setExamPaperId("0");
		
		//存入session
		session.put("stuExamItem", items);
		session.put("stuExam", exam);
		return SUCCESS;
	}
	
	public String test(){
		Answer answer = new Answer();
		answer.setAnswerId(3);
		answer.setExamId(5);
		answer.setItemId(6);
		answer.setStudentId(7);
		answer.setAnswer("testhhh");
		answerManager.delectObject(answer);
		
		return SUCCESS;
	}
	
	//属性
	private String contentType = "text/html;charset=utf-8";
	
	private Map<String,Object> session;
	
	private ExamManager examManager;
	private ExampaperManager exampaperManager;
	private ItemManager ItemManager;
	private AnswerExamManager answerExamManager;
	private AnswerManager answerManager;
	
	/*	根据id获取试卷
	 * 	examId
	 */
	String examId;

	//默认调用函数
	public String execute(){
		return SUCCESS;
	}
	
	//set/get方法
	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public String getExamId() {
		return examId;
	}

	public void setExamId(String examId) {
		this.examId = examId;
	}
	
	public void setExamManager(ExamManager examManager) {
		this.examManager = examManager;
	}

	public void setExampaperManager(ExampaperManager exampaperManager) {
		this.exampaperManager = exampaperManager;
	}

	public void setItemManager(ItemManager itemManager) {
		ItemManager = itemManager;
	}

	public void setAnswerExamManager(AnswerExamManager answerExamManager) {
		this.answerExamManager = answerExamManager;
	}

	public void setAnswerManager(AnswerManager answerManager) {
		this.answerManager = answerManager;
	}
}
