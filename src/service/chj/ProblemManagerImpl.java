package service.chj;

import java.util.List;

import org.springframework.stereotype.Service;

import daoImpl.chj.ProblemDaoImpl;
import pojo.Problem;

/** 
* @author chj E-mail: 865477704@qq.com
* @version 创建时间：2017年5月15日 下午8:32:01 
* 类说明 
*/
@Service
public class ProblemManagerImpl implements ProblemManager{

	private ProblemDaoImpl problemDaoImpl;
	
	

	public void setProblemDaoImpl(ProblemDaoImpl problemDaoImpl) {
		this.problemDaoImpl = problemDaoImpl;
	}



	@Override
	public List<Problem> getProblems(int page) {
		return problemDaoImpl.findByPager(page, 10).getDatas();
	}
	
	public ProblemManagerImpl() {
		System.out.println("ProblemManagerImpl IN");
	}

	
	
	public ProblemDaoImpl getProblemDaoImpl() {
		return problemDaoImpl;
	}
	

}
 