/**
 * 
 */
package service;

import java.io.Serializable;

import org.hibernate.HibernateException;

import pojo.Solution;


/**
 * @author chj
 *
 */
public interface SolutionManager {
	
	//保存Solution,提交答题
	public Serializable saveSolution(Solution solution) throws HibernateException;
}
