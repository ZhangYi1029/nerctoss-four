package www.netfour.com.accountquery_sys.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import www.netfour.com.accountquery_sys.beans.MonthaccountBean;
import www.netfour.com.accountquery_sys.beans.YearaccountBean;
import www.netfour.com.utils.DayMessager;
import www.netfour.com.utils.MonthMessager;

public interface MonthaccountDao {

	
	/**
	 * 根据业务账号的ID和年份查询满足条件的行数
	 * @param id
	 * @return
	 */
	public int count(Map map);
	
	/**
	 * 根据账务账号的ID和年份查询该账务账号该月的使用的情况
	 * @param id
	 * @return
	 */
	public List<MonthaccountBean> getMonthaccounAlltByIdAndYear(Map map);
	
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
	public void addYearaccount(List<MonthMessager> lsit);
	
	/**
	 * 查询每年所有月的总和
	 * @return
	 */
	public List<MonthMessager> selectMonthDurationIsSumSetYearDuration();
	
	/**
	 * 添加月空的信息
	 */
	public void addMonth(List<MonthaccountBean> listMontoh);
	
	/**
	 * 查询最大年的每个服务器的对应的ID
	 * @return
	 */
	public List<MonthaccountBean> saveYearID();
	
	/**
	 * 每月结算账务
	 * @return
	 */
	public List<DayMessager> selectMonth();
	
	/**
	 * 每月结算账务
	 */
	public void updateMonthaccount(@Param("dayMessager")List<DayMessager> list);
}
