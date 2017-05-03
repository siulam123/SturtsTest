/**
 * 
 */
package service;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.BaseDao;
import pojo.Solution;

/**
 * @author chj
 *
 */
@Transactional
@Service
public class SolutionManagerImpl implements SolutionManager {
	//默认安装名称装配
	@Resource
	private BaseDao<Solution> baseDao;
	

	@Override
	public Serializable saveSolution(Solution solution) throws HibernateException {
		return baseDao.save(solution);
	}


}
