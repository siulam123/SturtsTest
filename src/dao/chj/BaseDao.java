package dao.chj;


import java.io.Serializable;
import java.util.List;
import java.util.Map;

import pojo.PageModel;

/**
 * @author itronys
 */
public interface BaseDao<T> {

	
	public Serializable save(T o);

	public void delete(T o);

	public void update(T o);

	public void saveOrUpdate(T o);

	public T get(String hql);

	public T get(String hql, Map<String, Object> params);

	public List<T> find(String hql);

	public List<T> find(String hql, Map<String, Object> params);

	public List<T> find(String hql, int page, int rows);

	public List<T> find(String hql, Map<String, Object> params, int page, int rows);

	public int totalCount();
	
	public PageModel<T> findByPager(int pageNo, int pageSize);
	
	public Long count(String hql);

	public Long count(String hql, Map<String, Object> params);

	public T get(Class<T> c, Serializable id);

	public int executeHql(String hql);
	

}