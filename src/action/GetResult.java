/**
 * 
 */
package action;

import java.io.PrintWriter;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.Action;

import daoImpl.SolutionDaoImpl;
import pojo.Solution;

/**
 * @author chj
 *
 */
@Controller
public class GetResult implements Action {

	@Autowired
	private SolutionDaoImpl solutionDao;
	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.Action#execute()
	 */
	@Override
	public String execute() throws Exception {
		Integer solutionid = (Integer)ServletActionContext.getRequest().getSession().getAttribute("Solution_id");
		Solution s = solutionDao.get(Solution.class, solutionid );
		System.out.println(s.getResult());
		PrintWriter out = ServletActionContext.getResponse().getWriter();
		out.println("½á¹ûÎª: " + s.getResult());
		return null;
	}

}
