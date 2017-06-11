package www.netfour.com.bill_sys.dao;

import java.util.List;
import java.util.Map;

import www.netfour.com.bill_sys.beans.BusinessbillBean;

/**
 * 业务账单---查询Dao
 * 查询2
 * @author yxp
 *
 */
public interface BusinessbillDao {

	/**
	 * 1.根据ID显示：业务账号-月消费表---条数
	 * @param totalbillPager
	 * @return
	 */
	public int count(Map map);
	/**
	 * 1.1根据ID显示：业务账号-月消费表---条数
	 * @param map
	 * @return
	 */
	public List<BusinessbillBean> getBusinessbillById(Map map);

}
