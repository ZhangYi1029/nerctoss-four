package www.netfour.com.bill_sys.dao;

import java.util.List;
import java.util.Map;

import www.netfour.com.bill_sys.beans.TotalbillBean;

/**
 * 账务账单---查询Dao
 * 查询1
 * @author yxp
 *
 */
public interface TotalbillDao {
	
	
	/**
	 * 1.1分页显示：账务账号-月消费表
	 * @param totalbillPager
	 * @return
	 */
	public List<TotalbillBean> showAll(Map map);
	/**
	 * 1.2查询记录：账务账号-月消费表-条数
	 * @return
	 */
	public int count(Map map);

	
	/**
	 * 2.0根据：月份、账务账号、用户姓名、身份证----------查询:账务账号
	 * @param number
	 * @param name
	 * @param month
	 * @param idCard
	 * @return
	 */
	public List<TotalbillBean> getByManyFees(Map map);
	

	
	/**
	 * 3.0根据账务账号id：修改支付状态paystate
	 * @param totalbillId
	 */
	public int updatebill(TotalbillBean totalbillBean);
	
}
