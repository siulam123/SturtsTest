package action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.Action;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import pojo.Exam;
import pojo.ExamParamters;
import pojo.Item;
import pojo.Problem;
import service.ExamManager;
import service.ExampaperManager;
import service.ExampaperManagerImpl;
import service.chj.ProblemManager;
import tool.DataTool;


public class TeaExamAction implements Action, SessionAware{
	private String contentType = "text/html;charset=utf-8";
	
	private Map<String,Object> session;
	
	private ExamManager examManager;
	private ExampaperManager exampaperManager;
	

	
	//试卷种类
	private String[] strs= {"A","B","C","D","E","F","G","H"};
	
	//上传题目串
	private String items;
	
	private Exam exam;

	private String result;
	
	//上传的题目数量与分值
	private String[] number;
	private String[] score;
	private String topic;

	public String execute(){
		return "success";
	}
	
	//添加试卷
	public String addExam(){
		ServletActionContext.getResponse().setContentType(contentType);

		if(session.get("addExam")==null){
			int i = 0;
			session.put("addExam", i);
		}
		else{
			int i = (int) session.get("addExam");
			i++;
		}
		int id = DataTool.getRandom(999999);
		JSONArray json= (JSONArray)session.get("RandomExam");
		
		Map map = DataTool.getMap(json);
		
		List bf = (List)map.get("blankfiling");
		List cho = (List)map.get("choice");
		List jd = (List)map.get("judge");
		List co = (List)map.get("code");
		JSONObject e = (JSONObject)map.get("examParamters");
		ExamParamters exa = (ExamParamters) JSONObject.toBean(e, ExamParamters.class);
		
		exam.setExamId(id);
		exam.setExamName(exa.getTopic());
		exam.setExamTime(DataTool.getNowTime());
		exam.setExamPaperId(id+strs[(int)session.get("addExam")]);
		
		if(examManager.setExam(exam)){
			setExampaper(bf,exam.getExamPaperId(),"Item");
			setExampaper(cho,exam.getExamPaperId(),"Item");
			setExampaper(jd,exam.getExamPaperId(),"Item");
			setExampaper(co,exam.getExamPaperId(),"Problem");
		}

		//题id串，exampaperId
		//exampaperManager.setExampaper(map, exam.getExamPaperId());
		
		return "success";
	} 
	
	private boolean setExampaper(List items,String id,String classType){
		Iterator item = items.iterator();
    	while(item.hasNext()){
    		Object obj = item.next();
    		if(classType.equals("Item")){
    			Item theItem = (Item) JSONObject.toBean((JSONObject) obj,Item.class);
    			exampaperManager.setExampaper(theItem.getItemId(),id);
    		}else if(classType.equals("Problem")){
    			Problem theProblem = (Problem) JSONObject.toBean((JSONObject) obj,Problem.class);
        		exampaperManager.setExampaper(theProblem.getProblem_id(),id);
    		}
    	}
		return true;
	}
	
	
	//manageexamadd上传选择题目到manageexamitemlist调用函数
	public String itemlist(){
		items = getItems();
		List<Object> obj = new ArrayList<Object>();
		List<Problem> problems = new ArrayList<Problem>();
		if(!getItems().equals("")&&getItems()!=null){
			obj.addAll(exampaperManager.getItemlist(getItems()));
			problems.addAll(exampaperManager.getProblemList(getItems()));
		}
		

		session.put("items", DataTool.getJson(obj));
		session.put("codes", DataTool.getJson(problems));
		return "success";
	}
	
	//随机组卷
	public String RandomExam(){
		ExamParamters examParamters = new ExamParamters();
		examParamters.setBlankfilingMun(5);
		
		Map<String,Object> items = new HashMap<String,Object>();
		String[] str = {"11","2","23","13","12","55","40","77","8"};
		items.put("choice", null);
		items.put("judge", null);
		items.put("blankfiling", str);
		
		examManager.RandomExam(examParamters, items);
		
		return "success";
	}
	
  	public String confirmExam(){
  		//获取数据并存入参数类
		String[] number = getNumber();
		String[] score = getScore();
		ExamParamters examParamters = new ExamParamters();

		examParamters.setChoiceMun(Integer.parseInt(number[0]));
		examParamters.setChoicePlace(Integer.parseInt(score[0]));
		examParamters.setJudgeMun(Integer.parseInt(number[1]));
		examParamters.setJudgePlace(Integer.parseInt(score[1]));
		examParamters.setBlankfilingMun(Integer.parseInt(number[2]));
		examParamters.setBlankfilingPlace(Integer.parseInt(score[2]));
		examParamters.setCodeMun(Integer.parseInt(score[3]));
		examParamters.setCodingPlace(Integer.parseInt(score[3]));
		examParamters.setTopic(getTopic());

		
		//从session中获取题目列表
		List items = DataTool.getJsonItem((JSONArray)session.get("items"));
		//从session中获取编程题列表
		List codes = DataTool.getJsonProblem((JSONArray)session.get("codes"));
		//将list内容按类型分类并存到map中
		Map<String,Object> map = examManager.chooie(items,codes);
		//获取随机生成的试卷题目
		Map<String,Object> mapResult = examManager.RandomExam(examParamters, map);
	
		mapResult.put("examParamters", examParamters);
		
		//将生成的随机题目清单保存到session中
		if(session.get("RandomExam")==null){
			session.put("RandomExam", DataTool.getJson(mapResult));
		}
		else{
			session.remove("RandomExam");
			session.put("RandomExam", DataTool.getJson(mapResult));
		}
		
		return "success";
	}
	
	//添加试卷
	public String getAllExam(){
		List<Exam> exams = examManager.getExams();
		
		result = DataTool.getJsonStr(exams);
		
		return "result";
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
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
	
	public String[] getNumber() {
		return number;
	}

	public void setNumber(String[] number) {
		this.number = number;
	}
	
	public String[] getScore() {
		return score;
	}

	public void setScore(String[] score) {
		this.score = score;
	}
	
	public void setExampaperManager(ExampaperManager exampaperManager){
		this.exampaperManager = exampaperManager;
	}
	
	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}
	
	@Override
	public void setSession(Map<String,Object> session){
		this.session = session;
	}
}
