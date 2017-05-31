package action;

import java.sql.Timestamp;
import java.util.Date;

import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.Action;

import pojo.Administrator;
import pojo.Student;
import pojo.Teacher;
import service.AdministratorManager;
import service.StudentManager;
import service.TeacherManager;
@Controller
public class UserRegisterAction implements Action {
	private String user_id;
	private String user_name;
	private String user_type;
	
	private StudentManager studentManager;
	private TeacherManager teacherManager;
	private AdministratorManager administratorManager;

	
	public String register(){
		
		switch(user_type){
			case "student":return registerStudent();
			
			case "teacher":return registerTeacher();
	
			case "administrator":return registerAdministrator();
		}
		
		return SUCCESS;
	}
	
	private String registerStudent(){
		String[] ids;
		ids = user_id.split("\r\n");
		String[] names;
		names = user_name.split("\r\n");	//°´ÖÆ±í·ûÇÐ¸î×Ö·û´®
		
		for(int i = 0; i < ids.length; i++){
			Student stu = new Student();	//ÊµÀý»¯
			
			stu.setStudentId(ids[i]);
			stu.setStudentName(names[i]);
			stu.setPassword("123456");		//ÃÜÂëÄ¬ÈÏ
			
			studentManager.register(stu);
		}
		return SUCCESS;
	}

	private String registerTeacher(){
		String[] ids;
		ids = user_id.split("\r\n");
		String[] names;
		names = user_name.split("\r\n");	//°´ÖÆ±í·ûÇÐ¸î×Ö·û´®
		
		for(int i = 0; i < ids.length; i++){
			Teacher tea = new Teacher();	//ÊµÀý»¯
			
			tea.setTeacherId(ids[i]);
			tea.setTeacherName(names[i]);
			tea.setPassword("123456");		//ÃÜÂëÄ¬ÈÏ
			
			teacherManager.register(tea);
		}
			
		return SUCCESS;
	}

	private String registerAdministrator(){
		String[] ids;
		ids = user_id.split("\r\n");
		
		for(int i = 0; i < ids.length; i++){
			Administrator admin = new Administrator();	//ÊµÀý»¯
			
			admin.setAdministratorId(ids[i]);
			admin.setPassword("123456");		//ÃÜÂëÄ¬ÈÏ
			
			administratorManager.register(admin);
		}
		
		return SUCCESS;
	}

	public String execute() throws Exception {
		return SUCCESS;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_type() {
		return user_type;
	}

	public void setUser_type(String user_type) {
		this.user_type = user_type;
	}

	public void setStudentManager(StudentManager studentManager) {
		this.studentManager = studentManager;
	}

	public void setTeacherManager(TeacherManager teacherManager) {
		this.teacherManager = teacherManager;
	}

	public void setAdministratorManager(AdministratorManager administratorManager) {
		this.administratorManager = administratorManager;
	}


	
}
