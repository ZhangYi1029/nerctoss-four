package www.netfour.com.bill_sys.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import www.netfour.com.bill_sys.beans.ServersBean;

public interface ServersMapper {

	/**
	 * 2.2根据业务number产找：服务器使用情况(条数)
	 * @return
	 */
	public int serviceIpCount(@Param("map")Map map); 
	/**
	 * 2.2根据业务number产找：服务器使用情况
	 * @return
	 */
	public List<ServersBean> getBusinessByNumber(@Param("map")Map map);
	
	
}
