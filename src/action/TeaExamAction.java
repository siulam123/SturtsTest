package action;

import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.Action;

import pojo.Exam;
import service.ExamManager;
import service.ExampaperManager;


public class TeaExamAction implements Action, SessionAware   {
	private String contentType = "text/html;charset=utf-8";
	
	private Map<String,Object>session;
	
	private ExamManager examManager;
	private ExampaperManager exampaperManager;
	
	private String items;
	private Exam exam;
	
	public String execute(){
		return "success";
	}
	
	public String addExam(){
		ServletActionContext.getResponse().setContentType(contentType);

		if(session.get("addExam")==null){
			int i = 1;
			session.put("addExam", i);
		}
		else{
			int i = (int) session.get("addExam");
			i++;
		}
		
		exam.setExamId(123);
		exam.setExamName("哈哈哈");
		exam.setExamTime(exam.getNowTime());
		exam.setExamPaperId("123D");
		
		examManager.setExam("1->2->3", exam);

		exampaperManager.setExampaper("1->2->3", "123D");
		
		return "success";
	}

	public String getItems() {
		return items;
	}

	public void setItems(String items) {
		this.items = items;
	}

	public void setExamManager(ExamManager examManager) {
		this.examManager = examManager;
	}
	public void setExam(Exam exam){
		this.exam = exam;
	}
	
	public void setExampaperManager(ExampaperManager exampaperManager){
		this.exampaperManager = exampaperManager;
	}
	
	@Override
	public void setSession(Map<String,Object> session){
		this.session = session;
	}
}
