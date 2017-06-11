package www.netfour.com.bill_sys.service;

import java.util.Map;

import www.netfour.com.bill_sys.beans.TotalbillBean;
import www.netfour.com.pojos.Pager;

public interface TotalbillService {
	
	/**
	 * 显示所有账务账号：月消费
	 * @return
	 */
	public Pager showAll(Map map);
	
	/**
	 * 一、
	 * 1.1
	 * 根据：月份账务账号、用户姓名、身份证----------查询:账务账号
	 * @param number
	 * @param name
	 * @param month
	 * @param idCard
	 * @return
	 */
	public Pager getByManyFees(Map map);	
	
	
	/**
	 * 二、
	 * 根据账务账号id：修改支付状态
	 * @param totalbillBean
	 */
	public int updatebill(TotalbillBean totalbillBean);

}
