package www.netfour.com.bill_sys.dao;

import java.util.List;
import java.util.Map;

import www.netfour.com.bill_sys.beans.ServersBean;

public interface ServersDao {

	/**
	 * 2.0根据业务number产找：服务器使用情况(条数)
	 * @return
	 */
	public int serviceIpCount(Map map); 
	/**
	 * 2.1根据业务number产找：服务器使用情况
	 * @return
	 */
	public List<ServersBean> getBusinessByNumber(Map map);
	
	
}
