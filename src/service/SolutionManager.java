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
	
	//����Solution,�ύ����
	public Serializable saveSolution(Solution solution) throws HibernateException;
}
