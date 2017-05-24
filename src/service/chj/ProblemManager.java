package service.chj;

import java.util.List;

import pojo.Problem;

/** 
* @author chj E-mail: 865477704@qq.com
* @version 创建时间：2017年5月15日 下午8:29:18 
* 类说明 
*/

public interface ProblemManager {
	//分页获得题目
	public List<Problem> getProblems(int page);
}
 