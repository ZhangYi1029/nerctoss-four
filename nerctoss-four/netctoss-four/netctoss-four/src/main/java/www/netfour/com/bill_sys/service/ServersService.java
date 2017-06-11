package www.netfour.com.bill_sys.service;

import java.util.Map;

import www.netfour.com.pojos.Pager;

public interface ServersService {

	/**
	 * 2.根据业务id产找：服务器使用情况
	 * @return
	 */
	public Pager getBusinessByNumber(Map map);
	
}
