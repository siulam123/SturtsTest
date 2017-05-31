package action;

import com.opensymphony.xwork2.ModelDriven;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.Action;

import pojo.Answer;
import pojo.Exam;
import pojo.Item;
import pojo.Student;
import service.AnswerExamManager;
import service.AnswerManager;
import tool.DataTool;

/*
 * 判题调用action
 * 用户上传题目掉用
 * 传入值为item，其他数据从session中获取
 */

public class MarkingSystemAction implements Action,ModelDriven<Item>,SessionAware{
	 private String contentType = "text/html;charset=utf-8";	//编码设置

	 private Map<String,Object> session;
		
	 private Item item=new Item();	//实例化实体类
	 private AnswerExamManager answerExamManager;
	 private AnswerManager answerManager;
	 
	 /*
	  * 判题函数
	  * 根据上传item数据，进行判错与存入数据库
	  */
	 public String marking(){
		ServletActionContext.getResponse().setContentType(contentType);
		
/////////////////////////////////////
		Map<Integer,Item> map = new HashMap<Integer,Item>();
		session.put("stuItems", map);//在session实例化题目数组
		////////////////////////
		Map<Integer,Item> stuItems = (Map<Integer,Item>)session.get("stuItems");
		
		if(stuItems.get(item.getItemId()) != null){
			//如果题目存在map中，即已经提交过，现在进行的是修改操作
			stuItems.remove(item.getItemId());
			stuItems.put(item.getItemId(), item);
		}
		else{
			stuItems.put(item.getItemId(), item);
		}
		
		
		//模拟先///////////////////////
		Student a = new Student();
		a.setStudentId("04140707");
		session.put("student", a);
		Exam e = new Exam();
		e.setExamId(324393);
		e.setExamName("hhh");
		e.setPlace("5->0->5");
		session.put("stuExam", e);
		///////////////////////////////
		
		answerExamManager.marking(session);
	 
		return SUCCESS;
	 }
	 
	 @Override
	 public String execute() throws Exception {
		 return SUCCESS;
	 }

	@Override
	public Item getModel() {
		// TODO Auto-generated method stub
		return item;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public void setAnswerExamManager(AnswerExamManager answerExamManager) {
		this.answerExamManager = answerExamManager;
	}

	public void setAnswerManager(AnswerManager answerManager) {
		this.answerManager = answerManager;
	}

	@Override
	public void setSession(Map<String,Object> session){
		this.session = session;
	}
}
