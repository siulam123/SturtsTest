package pojo;

public class Answer {
	private Integer answerId;	//����id
	private Integer examId;		//�Ծ�id
	private String 	studentId;	//ѧ��id
	private Integer itemId;		//��Ŀid
	private String 	answer;		//ѧ����
	private String 	RoW;		//�Դ�
	
	public Integer getAnswerId() {
		return answerId;
	}
	public void setAnswerId(Integer answerId) {
		this.answerId = answerId;
	}
	public Integer getExamId() {
		return examId;
	}
	public void setExamId(Integer examId) {
		this.examId = examId;
	}
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public Integer getItemId() {
		return itemId;
	}
	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String getRoW() {
		return RoW;
	}
	public void setRoW(String roW) {
		RoW = roW;
	}
}
