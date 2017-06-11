package www.netfour.com.accountquery_sys.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import www.netfour.com.accountquery_sys.beans.YearaccountBean;
import www.netfour.com.business_sys.beans.BusinessBean;

public interface YearaccountMapper {


	/**
	 * 查询满足条件的行数
	 * @param id
	 * @return
	 */
	public int count(@Param("map")Map map);
	
	
	/**
	 * 根据账务账号的ID查询该账务账号所有的使用的情况
	 * @param id
	 * @return
	 */
	public List<YearaccountBean> getYearaccounAlltById(@Param("map")Map map);
	
	/**
	 * 查询全部账务情况
	 * @return
	 */
	public List<YearaccountBean> getYearaccountAll(@Param("map")Map map);
	
	/**
	 * 查询所有已存在的年份
	 * @return
	 */
	public List<YearaccountBean> getYearaccountIsYearAll();
	
	/**
	 * 添加年账务表信息
	 * @param list
	 */
	public void addYearaccount(@Param("years")List<YearaccountBean> list);
	
	/**
	 * 查询取出所有的账务账号
	 * @return
	 */
	@Select(value="SELECT business_id,business_password,business_number,business_serviceIp ,fk_accort_id from business")
	@Results({
		@Result(id=true,property="id",column="business_id",javaType=Long.class),
		@Result(property="password",column="business_password",javaType=String.class),
		@Result(property="number",column="business_number",javaType=String.class),
		@Result(property="serviceIp",column="business_serviceIp",javaType=String.class),
		@Result(property="account.id",column="fk_accort_id",javaType=Long.class)
	})
	public List<BusinessBean> getAllBusinessBean();
	
	/**
	 * 取出当前表的最大年份
	 * @return
	 */
	@Select(value="SELECT MAX(year) as max from yearacount")
	@Results({
		@Result(property="year",column="max",javaType=Long.class)
	})
	public YearaccountBean getYearaccountBeanIsYear();
}
