package www.netfour.com.accountquery_sys.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import www.netfour.com.accountquery_sys.beans.MonthaccountBean;
import www.netfour.com.accountquery_sys.beans.YearaccountBean;
import www.netfour.com.utils.DayMessager;
import www.netfour.com.utils.MonthMessager;

public interface MonthaccountMapper {
	
	/**
	 * 根据业务账号的ID和年份查询满足条件的行数
	 * @param id
	 * @return
	 */
	public int count(@Param("map")Map map);
	
	/**
	 * 根据账务账号的ID和年份查询该账务账号该月的使用的情况
	 * @param id
	 * @return
	 */
	public List<MonthaccountBean> getMonthaccounAlltByIdAndYear(@Param("map")Map map);
	
	
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
	public List<MonthaccountBean> getMonthaccountYearAll(@Param("tzyear")String tzyear);
	
	/**
	 * 每月的1号添加该月的空数据
	 * 并且计算上月的使用情况添加到年份的数据中
	 */
	public void addYearaccount(@Param("lists")List<MonthMessager> lsit);

	
	/**
	 * 查询每年所有月的总和
	 * @return
	 */
	@Select(value="SELECT y.yearacount_id as year, sum(m.month_duration) as sum FROM yearacount as y LEFT JOIN monthaccount as m on m.fk_yearaccount_id = y.yearacount_id LEFT JOIN account as a on y.fk_account_id = a.account_id LEFT JOIN business as b on y.fk_business_id = b.business_id where y.year_duration is  NULL GROUP BY m.fk_yearaccount_id")
	@Results({
		@Result(property="year",column="year",javaType=Long.class),
		@Result(property="sum",column="sum",javaType=Long.class)
	})
	public List<MonthMessager> selectMonthDurationIsSumSetYearDuration();
	
	
	/**
	 * 添加月空的信息
	 */
	
	public void addMonth(@Param("listMonths")List<MonthaccountBean> listMontoh);
	
	/**
	 * 查询最大年的每个服务器的对应的ID
	 * @return
	 */
	
	public List<MonthaccountBean> saveYearID();
	
	/**
	 * 查询每月使用时长的总和
	 * @return
	 */
	@Select(value="SELECT m.monthaccount_id as mId, sum(d.day_duration) as sum FROM dayaccount as d  LEFT JOIN monthaccount as m on d.fk_monthaccount_id = m.monthaccount_id GROUP BY d.fk_monthaccount_id")
	@Results({
		@Result(property="id",column="mId",javaType=Long.class),
		@Result(property="sum",column="sum",javaType=Long.class)
	})
	public List<DayMessager> selectMonth();
	
	/**
	 * 每月结算账务
	 */
	public void updateMonthaccount(@Param("dayMessager")List<DayMessager> list);	
}
