package pojo;
/*
 * �Ծ�����࣬����Ծ��������Ŀ�����ͷ�ֵ
 */
public class ExamParamters {
	//��Ŀ��Ŀ
	private int choiceMun;
	private int judgeMun;
	private int blankfilingMun;
	//��ֵ
	private int choicePlace;
	private int judgePlace;
	private int blankfilingPlace;
	//����
	private String topic;
	
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	public int getChoiceMun() {
		return choiceMun;
	}
	public void setChoiceMun(int choiceMun) {
		this.choiceMun = choiceMun;
	}
	public int getJudgeMun() {
		return judgeMun;
	}
	public void setJudgeMun(int judgeMun) {
		this.judgeMun = judgeMun;
	}
	public int getBlankfilingMun() {
		return blankfilingMun;
	}
	public void setBlankfilingMun(int blankfilingMun) {
		this.blankfilingMun = blankfilingMun;
	}
	public int getChoicePlace() {
		return choicePlace;
	}
	public void setChoicePlace(int choicePlace) {
		this.choicePlace = choicePlace;
	}
	public int getJudgePlace() {
		return judgePlace;
	}
	public void setJudgePlace(int judgePlace) {
		this.judgePlace = judgePlace;
	}
	public int getBlankfilingPlace() {
		return blankfilingPlace;
	}
	public void setBlankfilingPlace(int blankfilingPlace) {
		this.blankfilingPlace = blankfilingPlace;
	}
	public String Place(){
		String str = "";
		int i = 0;
		if(choiceMun!=0){
			i = choicePlace / choiceMun;
			str += i + "->";
		}
		else{
			str += "0->";
		}
		if(judgeMun!=0){
			i = judgePlace / judgeMun;
			str += i + "->";
		}
		else{
			str += "0->";
		}
		if(blankfilingMun!=0){
			i = blankfilingPlace / blankfilingMun;
			str += i;
		}
		else{
			str += "0";
		}
		
		return str; 
	}
	
}
