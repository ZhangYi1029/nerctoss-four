package www.netfour.com.accountquery_sys.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import www.netfour.com.accountquery_sys.beans.DayaccountBean;
import www.netfour.com.accountquery_sys.beans.MonthaccountBean;
import www.netfour.com.accountquery_sys.beans.YearaccountBean;

public interface DayaccountDao {

	
	/**
	 * 根据业务账号的ID查询满足条件的行数
	 * @param id
	 * @return
	 */
	public int count(Map map);
	
	/**
	 * 根据账务账号的ID和年份查询该账务账号该年的使用的情况
	 * @param id
	 * @return
	 */
	public List<DayaccountBean> getDayaccounAlltByIdAndYear(Map map);
	
	
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
	 * 按照年和月查询该年的某月所有的日子
	 * 
	 * @return
	 */
	public List<DayaccountBean> getdayaccountdayAll(Map<String, String> map);
	
	
	/**
	 * 添加每天使用时长
	 */
	public int addDayaccount(List<DayaccountBean> list);
	
	/**
	 * 查询每天使用的时长信息
	 * @param map
	 * @return
	 */
	public List<DayaccountBean> selectDayDuration(@Param("map")Map<String, String> map);
	
	
	
}
