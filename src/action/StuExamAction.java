package action;

import java.util.ArrayList;
import java.util.HashMap;
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
import tool.Similarity;
import service.AnswerExamManager;
import service.AnswerManager;

public class StuExamAction implements Action, SessionAware{
	
	/*	
	 * ���ݴ���examId��ȡ�Ծ�ȫ�����ݣ�������Ŀ�������Ծ���Ϣ������session
	 * examId:�Ծ�id����ѧ������
	 * sessionֵ��stuExam:��Exam���Ծ���Ϣ�� stuExamItem:(List<Item>)�Ծ���Ŀ����, score:������Ĭ��0��
	 */
	public String ExamById(){
		//���ݴ���id��ȡ�Ծ���Ϣ
		Exam exam = examManager.getExamById(examId);
		
		//��ȡ��Ŀ����
		String paperId = exam.getExamPaperId();
		List<Exampaper> paperlist = exampaperManager.getExampaperById(paperId);
		
		Iterator index = paperlist.iterator();
		
		List<Item> items = new ArrayList<Item>();
		
		while(index.hasNext()){
			Exampaper paper = (Exampaper)index.next();
			Item item = ItemManager.getItemById(paper.getItemId());
			//����list
			items.add(item);
		}
		
		session.put("score", 0);
		
		Map<Integer,Item> map = new HashMap<Integer,Item>();
		session.put("stuItems", map);//��sessionʵ������Ŀ����
		
		//����idֵ����ֹ��Ϣй¶
//		exam.setExamId(0);
//		exam.setExamPaperId("0");
		
		//����session
		session.put("stuExamItem", items);
		session.put("stuExam", exam);
		return SUCCESS;
	}
	

	public String examSetAnswer(){
		
		
		return SUCCESS;
	}
	
	public String test(){
		Similarity s = new Similarity();
		
		return SUCCESS;
	}
	
	//set/get����
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

	//Ĭ�ϵ��ú���
	public String execute(){
		return SUCCESS;
	}
	
	//����
	private String contentType = "text/html;charset=utf-8";
	
	private Map<String,Object> session;
	
	private ExamManager examManager;
	private ExampaperManager exampaperManager;
	private ItemManager ItemManager;
	private AnswerExamManager answerExamManager;
	private AnswerManager answerManager;
	
	/*	
	 * ����id��ȡ�Ծ�
	 * examId
	 */
	private String examId;
	
}
