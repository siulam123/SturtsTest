package pojo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Item {
	private int 	itemId;
	private	String	Content;	//��Ŀ
	private String	Type;		//����
	private	String	answer;		//��
	private String	time;		//ʱ���
	private int 	degree = 1; //�Ѷ�	Ĭ��Ϊ1��1��4�Ѷȵ�����
	
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
