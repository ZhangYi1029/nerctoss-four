package www.netfour.com.bill_sys.service;

import java.util.Map;

import www.netfour.com.pojos.Pager;

public interface BusinessbillService {
	
	/**
	 * 1.根据ID分页显示：业务账号-月消费表
	 * @return
	 */
	public Pager getBusinessbillById(Map map);

	
	
}
