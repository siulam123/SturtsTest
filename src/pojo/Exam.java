package pojo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Exam implements java.io.Serializable{
	private int examId;
	private String examPaperId;
	private String examName;
	private String examTime;
	private String place;
	
	public int getExamId() {
		return examId;
	}
	public void setExamId(int examId) {
		this.examId = examId;
	}
	public String getExamPaperId() {
		return examPaperId;
	}
	public void setExamPaperId(String examPaperId) {
		this.examPaperId = examPaperId;
	}
	public String getExamName() {
		return examName;
	}
	public void setExamName(String examName) {
		this.examName = examName;
	}
	public String getExamTime() {
		return examTime;
	}
	public void setExamTime(String examTime) {
		this.examTime = examTime;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	
	@Override
	public boolean equals(Object o){
		if(o instanceof Exam){
			Exam pk = (Exam)o;
			if(this.examId == pk.getExamId() && this.examName.equals(pk.getExamName())){
				return true;
			}
		}
		return false;
	}
	
	@Override
	public int hashCode(){
		return this.examName.hashCode();
	}
}
