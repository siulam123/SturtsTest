/**
 * 
 */
package service;

import java.io.Serializable;

import org.hibernate.HibernateException;

import pojo.Source_code;

/**
 * @author chj
 *
 */
public interface Source_codeManager {
	//保存Solution,提交答题
		public Serializable saveSource_code(Source_code Source_code) throws HibernateException;
}
