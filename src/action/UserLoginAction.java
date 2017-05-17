package action;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.Action;

import pojo.Administrator;
import pojo.Student;
import pojo.Teacher;
import service.AdministratorManager;
import service.AdministratorManagerImpl;
import service.StudentManagerImpl;
import service.TeacherManager;
import service.TeacherManagerImpl;

@Controller
public class UserLoginAction implements Action,SessionAware{
	
	private static final String TEASUCCESS = "teasuccess";
	
	private Map<String,Object> session;

	private String contentType = "text/html;charset=utf-8";
	
	private StudentManagerImpl studentManager;
	private TeacherManagerImpl teacherManager;
	private AdministratorManagerImpl administratorManager;

	private String user_id;
	private String user_password;
	private String user_type;
	
	private Student student;
	private Administrator administrator;
	private Teacher teacher;

	public String execute() throws Exception
    {
		switch(user_type){
			case "student":return loginStudent();
			
			case "teacher":return loginTeacher();

			case "administrator":return loginAdministrator();
			
			case "register":return register();

			default: return NONE;
		}
    }
	
	private String register(){
        ServletActionContext.getResponse().setContentType(contentType);
		student.setStudentId("04140701");
		student.setPassword("dahuang");
		student.setStudentName("´ó»Æ");
		if(studentManager.register(student)){
			return SUCCESS;
		}
		return NONE;
	}
	
	private String loginTeacher(){
        ServletActionContext.getResponse().setContentType(contentType);
        teacher.setTeacherId(getUser_id());
        teacher.setPassword(getUser_password());
        if(teacherManager.login(teacher).equals("success")){ 
            Teacher teacherinder = teacherManager.findObject(teacher);
            teacherinder.setPassword(null);
        	session.put("teacher",teacherinder);
        	return TEASUCCESS;
        }
        else if(teacherManager.login(teacher).equals("none"))
        	return ERROR;
        else
        	return NONE;
	}
	
	private String loginStudent(){
        ServletActionContext.getResponse().setContentType(contentType);
        student.setStudentId(getUser_id());
        student.setPassword(getUser_password());
        if(studentManager.login(student).equals("success")){
        	Student stuindex = studentManager.findObject(student);
        	stuindex.setPassword(null);
        	session.put("student",stuindex);
        	return SUCCESS;
        }
        else if(studentManager.login(student).equals("error"))
        	return ERROR;
        else
        	return NONE;
	}
	
	private String loginAdministrator(){
		administrator = new Administrator();
        ServletActionContext.getResponse().setContentType(contentType);
        administrator.setAdministratorId(getUser_id());
        administrator.setPassword(getUser_password());
        administratorManager.login(administrator);
        if(administratorManager.login(administrator).equals("success")){
        	Administrator adminindex = administratorManager.findObject(administrator);
        	adminindex.setPassword(null);
        	session.put("admin", adminindex);
        	return SUCCESS;
        }
        else if(administratorManager.login(administrator).equals("error"))
        	return ERROR;
        else
        	return NONE;
	}
	
	public String loginOut(){
		if(session.get("student")!=null){
			session.remove("student");
		}
		else if(session.get("teacher")!=null){
			session.remove("teacher");
		}
		else{
			session.remove("Administrator");
		}
		return "success";
	}
	
	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Administrator getAdministrator() {
		return administrator;
	}

	public void setAdministrator(Administrator administrator) {
		this.administrator = administrator;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	
	public String getUser_type() {
		return user_type;
	}
	
	public void setUser_type(String user_type) {
		this.user_type = user_type;
	}
	
    public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUser_password() {
		return user_password;
	}

	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}

	public StudentManagerImpl getstudentManager() {
		return studentManager;
	}
	
	public TeacherManagerImpl getTeacherManager() {
		return teacherManager;
	}

	public void setTeacherManager(TeacherManagerImpl teacherManager) {
		this.teacherManager = teacherManager;
	}

	public AdministratorManager getAdministratorManager() {
		return administratorManager;
	}

	public void setAdministratorManager(AdministratorManagerImpl administratorManager) {
		this.administratorManager = administratorManager;
	}

	public void setStudentManager(StudentManagerImpl studentManager) {
		this.studentManager = studentManager;
	}
}
