package www.netfour.com.accountquery_sys.dao;

import java.util.List;
import java.util.Map;

import www.netfour.com.accountquery_sys.beans.YearaccountBean;
import www.netfour.com.business_sys.beans.BusinessBean;

public interface YearaccountDao {

	
	/**
	 * 根据业务账号的ID查询满足条件的行数
	 * @param id
	 * @return
	 */
	public int count(Map map);
	
	
	/**
	 * 根据账务账号的ID查询该账务账号所有的使用的情况
	 * @param id
	 * @return
	 */
	public List<YearaccountBean> getYearaccounAlltById(Map map);
	
	/**
	 * 查询全部账务情况
	 * @return
	 */
	public List<YearaccountBean> getYearaccountAll(Map map);
	
	/**
	 * 查询所有已存在的年份
	 * @return
	 */
	public List<YearaccountBean> getYearaccountIsYearAll();
	
	/**
	 * 添加年账务表信息
	 * @param list
	 */
	public void addYearaccount(List<YearaccountBean> list);
	
	/**
	 * 查询取出所有的账务账号
	 * @return
	 */
	public List<BusinessBean> getAllBusinessBean();
	
	/**
	 * 取出当前表的最大年份
	 * @return
	 */
	public YearaccountBean getYearaccountBeanIsYear();
}
