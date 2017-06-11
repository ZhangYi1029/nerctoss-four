package www.netfour.com.accountquery_sys.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import www.netfour.com.accountquery_sys.beans.DayaccountBean;
import www.netfour.com.accountquery_sys.beans.MonthaccountBean;
import www.netfour.com.accountquery_sys.beans.YearaccountBean;

public interface DayaccountMapper {

	/**
	 * 根据业务账号的ID和年份还有月份查询满足条件的行数
	 * @param id
	 * @return
	 */
	public int count(@Param("map")Map map);
	
	/**
	 * 根据账务账号的ID和年份还有月份查询该账务账号该年的使用的情况
	 * @param id
	 * @return
	 */
	public List<DayaccountBean> getDayaccounAlltByIdAndYear(@Param("map")Map map);
	
	
	/**
	 * 查询所有已存在的年份
	 * @return
	 */
	@Select(value="select distinct year from yearacount ORDER BY year ASC")
	@Results({
		@Result(property="year",column="year",javaType=Long.class)
	})
	public List<YearaccountBean> getYearaccountYearAll();
	
	
	/**
	 * 按照年查询该年所有的月份
	 * 
	 * @return
	 */
	@Select(value="select distinct m.month as month from yearacount as y  left join monthaccount as m on m.fk_yearaccount_id = y.yearacount_id WHERE y.`year` = #{tzyear} ORDER BY m.month ASC")
	@Results({
		@Result(property="month",column="month",javaType=Long.class)
	})
	public List<MonthaccountBean> getMonthaccountYearAll(@Param("tzyear")String tzyear);
	
	/**
	 * 按照年和月查询该年的某月所有的日子
	 * 
	 * @return
	 */
	@Select(value="select distinct d.`day` from yearacount as y  left join monthaccount as m on m.fk_yearaccount_id = y.yearacount_id LEFT JOIN dayaccount as d on d.fk_monthaccount_id = m.monthaccount_id WHERE y.`year` = #{map.tzyear} AND m.`month` = #{map.tzmonth} ORDER BY m.month ASC")
	@Results({
		@Result(property="day",column="day",javaType=Long.class)
	})
	public List<DayaccountBean> getdayaccountdayAll(@Param("map")Map<String, String> map);
	/**
	 * 添加每天使用时长
	 */
	public int addDayaccount(@Param("days")List<DayaccountBean> list);
	
	/**
	 * 查询每天使用的时长信息
	 * @param map
	 * @return
	 */
	public List<DayaccountBean> selectDayDuration(@Param("map")Map<String, String> map);
}
