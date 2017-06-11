package www.netfour.com.accountquery_sys.service;

import java.util.List;
import java.util.Map;

import www.netfour.com.accountquery_sys.beans.YearaccountBean;
import www.netfour.com.pojos.Pager;

public interface YearaccountService {

	
	/**
	 * 根据账务账号的ID查询该账务账号所有的使用的情况
	 * @param id
	 * @return
	 */
	public Pager getYearaccounAlltById(Map map);
	
	/**
	 * 查询全部账务情况
	 * @return
	 */
	public Pager getYearaccountAll(Map map);
	
	/**
	 * 查询所有已存在的年份
	 * @return
	 */
	public List<YearaccountBean> getYearaccountIsYearAll();
	
	/**
	 * 添加年账务表信息
	 * @param list
	 */
	public void addYearaccount();
}
