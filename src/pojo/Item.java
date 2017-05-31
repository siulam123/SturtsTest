package pojo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Item {
	private int 	itemId;
	private	String	Content;	//题目
	private String	Type;		//类型
	private	String	answer;		//答案
	private String	time;		//时间戳
	private int 	degree = 1; //难度	默认为1（1到4难度递增）
	
	public int getDegree() {
		return degree;
	}
	public void setDegree(int degree) {
		this.degree = degree;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public String getContent() {
		return Content;
	}
	public void setContent(String content) {
		Content = content;
	}
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	
}
