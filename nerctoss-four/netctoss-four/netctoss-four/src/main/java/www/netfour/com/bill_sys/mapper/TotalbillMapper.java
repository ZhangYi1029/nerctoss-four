package www.netfour.com.bill_sys.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import www.netfour.com.bill_sys.beans.TotalbillBean;

public interface TotalbillMapper {
	
	
	/**
	 * 分页显示：账务账号-月消费表
	 * @param totalbillPager
	 * @return
	 */
	public List<TotalbillBean> showAll(@Param("map")Map map);
	/**
	 * 查询记录：账务账号-月消费表-条数
	 * @return
	 */
	public int count(@Param("map")Map map);
	
	
	/**
	 * 一、1.0
	 * 根据：月份、账务账号外键----------查询:账务账号
	 * @param number
	 * @param name
	 * @param month
	 * @param idCard
	 * @return
	 */
	public List<TotalbillBean> getByManyFees(@Param("map")Map map);
	
	/**
	 * 二、
	 * 根据账务账号id：修改支付状态
	 * @param totalbillId
	 */
	public int updatebill(@Param("totalbillBean")TotalbillBean totalbillBean);;

	
}
