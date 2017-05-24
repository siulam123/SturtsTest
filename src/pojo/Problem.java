package pojo;
/** 
* @author chj E-mail: 865477704@qq.com
* @version 创建时间：2017年5月15日 下午7:22:29 
* 类说明 
*/
public class Problem {
	private Integer problem_id;
	private String title;
	private String description;
	private String input;
	private String output;
	private String sample_input;
	private String sample_output;
	private String spj;
	private String hint;
	private String source;//来源
	private String in_date;
	private Integer time_limit;
	private Integer memory_limit;
	private String defunct; //defunct僵尸进程？暂时不明
	private Integer accepted;
	private Integer submit;
	private Integer solved;
	public Integer getProblem_id() {
		return problem_id;
	}
	public void setProblem_id(Integer problem_id) {
		this.problem_id = problem_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getInput() {
		return input;
	}
	public void setInput(String input) {
		this.input = input;
	}
	public String getOutput() {
		return output;
	}
	public void setOutput(String output) {
		this.output = output;
	}
	public String getSample_input() {
		return sample_input;
	}
	public void setSample_input(String sample_input) {
		this.sample_input = sample_input;
	}
	public String getSample_output() {
		return sample_output;
	}
	public void setSample_output(String sample_output) {
		this.sample_output = sample_output;
	}
	public String getSpj() {
		return spj;
	}
	public void setSpj(String spj) {
		this.spj = spj;
	}
	public String getHint() {
		return hint;
	}
	public void setHint(String hint) {
		this.hint = hint;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getIn_date() {
		return in_date;
	}
	public void setIn_date(String in_date) {
		this.in_date = in_date;
	}
	public Integer getTime_limit() {
		return time_limit;
	}
	public void setTime_limit(Integer time_limit) {
		this.time_limit = time_limit;
	}
	public Integer getMemory_limit() {
		return memory_limit;
	}
	public void setMemory_limit(Integer memory_limit) {
		this.memory_limit = memory_limit;
	}
	public String getDefunct() {
		return defunct;
	}
	public void setDefunct(String defunct) {
		this.defunct = defunct;
	}
	public Integer getAccepted() {
		return accepted;
	}
	public void setAccepted(Integer accepted) {
		this.accepted = accepted;
	}
	public Integer getSubmit() {
		return submit;
	}
	public void setSubmit(Integer submit) {
		this.submit = submit;
	}
	public Integer getSolved() {
		return solved;
	}
	public void setSolved(Integer solved) {
		this.solved = solved;
	}
	
	
	
	
}
