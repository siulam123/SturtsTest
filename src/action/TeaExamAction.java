package action;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;

import service.ExampaperManagerImpl;

public class TeaExamAction implements Action  {
	private String contentType = "text/html;charset=utf-8";
	
	private String items;
	private ExampaperManagerImpl exampaperManagerImpl;
	
	public String execute(){
		return "success";
	}
	
	public String addExam(){
		ServletActionContext.getResponse().setContentType(contentType);
		
		exampaperManagerImpl.setExampaper(getItems(), 1);
		
		return "success";
	}

	public String getItems() {
		return items;
	}

	public void setItems(String items) {
		this.items = items;
	}

	public void setExampaperManagerImpl(ExampaperManagerImpl exampaperManagerImpl) {
		this.exampaperManagerImpl = exampaperManagerImpl;
	}
	
	
}
