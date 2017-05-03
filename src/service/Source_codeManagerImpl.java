/**
 * 
 */
package service;

import java.io.Serializable;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.BaseDao;
import pojo.Source_code;

/**
 * @author chj
 *
 */
@Transactional
@Service
public class Source_codeManagerImpl implements Source_codeManager {
	@Resource
	private BaseDao<Source_code> baseDao;
	/* (non-Javadoc)
	 * @see service.Source_codeManager#saveSource_code(pojo.Source_code)
	 */
	@Override
	public Serializable saveSource_code(Source_code Source_code) throws HibernateException {
		return baseDao.save(Source_code);
	}

}
