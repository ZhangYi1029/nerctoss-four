package www.netfour.com.bill_sys.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import www.netfour.com.bill_sys.beans.BusinessbillBean;

public interface BusinessbillMapper {
	
	
	/**
	 * 1.根据ID显示：业务账号-月消费表---条数
	 * @param totalbillPager
	 * @return
	 */
	public int count(@Param("map")Map map);
	
	
	
	/**
	 * 1.1根据ID显示：业务账号-月消费表---条数
	 * @param map
	 * @return
	 */
	public List<BusinessbillBean> getBusinessbillById(@Param("map")Map map);
	
	
	
	
	
	
}
