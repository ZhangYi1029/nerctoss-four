package www.netfour.com.accountquery_sys.service;

import java.util.List;
import java.util.Map;

import www.netfour.com.accountquery_sys.beans.MonthaccountBean;
import www.netfour.com.accountquery_sys.beans.YearaccountBean;
import www.netfour.com.pojos.Pager;


public interface MonthaccountService {

	/**
	 * 根据账务账号的ID和年份查询该账务账号该月的使用的情况
	 * @param id
	 * @return
	 */
	public Pager getMonthaccounAlltByIdAndYear(Map map);
	
	/**
	 * 查询所有已存在的年份
	 * @return
	 */
	public List<YearaccountBean> getYearaccountYearAll();
	
	/**
	 * 按照年查询该年所有的月份
	 * 
	 * @return
	 */
	public List<MonthaccountBean> getMonthaccountYearAll(String tzyear);
	
	/**
	 * 每月的1号添加该月的空数据
	 * 并且计算上月的使用情况添加到年份的数据中
	 */
	public void addMonthaccount();
	
	/**
	 * 添加月空的信息
	 */
	public void addMonth();
	
	/**
	 * 添加每月的账务信息（使用时长）
	 */
	public void addMonthAccountshichang();
}
