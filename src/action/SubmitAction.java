/**
 * 
 */
package action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.Action;

import daoImpl.SolutionDaoImpl;
import daoImpl.Source_codeDaoImpl;
import pojo.Solution;
import pojo.Source_code;

/**
 * @author chj
 *
 */
@Controller
public class SubmitAction implements Action {

	private String contentType = "text/html;charset=utf-8";
	@Autowired
	private Solution solution;
	@Autowired
	private Source_code source_code;
	@Autowired
	private SolutionDaoImpl solutionDao;
	@Autowired
	private Source_codeDaoImpl source_codeDao;
	@Autowired
	private int problem_id;
	@Autowired
	private int language;
	@Autowired
	private String source;
	
	
	
	@Override
	public String execute() throws Exception {
		//保存提交代码信息
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date = df.format(new Date());
		Solution solution = new Solution();
		solution.setSolution_id(110);
		solution.setProblem_id(problem_id);
		solution.setUser_id("qwerasdf");
		solution.setIn_date(date);
		solution.setLanguage(language);
		solution.setIp("::1");
		solution.setCode_length(source.length());

		//保存提交代码
		Source_code source_code = new Source_code();
		source_code.setSolution_id(solution.getSolution_id());
		source_code.setSource(source);
		
		solutionDao.save(solution);
		source_codeDao.save(source_code);
		ServletActionContext.getRequest().getSession().setAttribute("Solution_id",solution.getSolution_id());
		return INPUT;
		
	}


}
