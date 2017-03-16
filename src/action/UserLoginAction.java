package action;

import java.sql.Timestamp;
import java.util.Date;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.Action;

import pojo.Student;
import service.UserManagerImpl;

@Controller
public class UserLoginAction implements Action{
	
	private String contentType = "text/html;charset=utf-8";
	private UserManagerImpl userManager;
	private String user_name;
	private String user_password;
	private Student user;
	
	
	
    public String getUser_name() {
		return user_name;
	}


	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}


	public String getUser_password() {
		return user_password;
	}


	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}


	public UserManagerImpl getUserManager() {
		return userManager;
	}


	public void setUserManager(UserManagerImpl userManager) {
		this.userManager = userManager;
	}


	public String execute() throws Exception
    {
		user = new Student();
        ServletActionContext.getResponse().setContentType(contentType);
        user.setStudentName(getUser_name());
        user.setPassword(getUser_password());
        if(userManager.login(user).equals("success")){
        	return SUCCESS;
        }
        else if(userManager.login(user).equals("error"))
        	return ERROR;
        else
        	return NONE;
    }
}
