package www.netfour.com.bill_sys.dao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import www.netfour.com.bill_sys.beans.ServersBean;
import www.netfour.com.bill_sys.dao.ServersDao;
import www.netfour.com.bill_sys.mapper.ServersMapper;

@Repository
public class ServersDaoImpl implements ServersDao{
	
	
	@Resource
	private ServersMapper serversMapper;
	

	//2.0根据业务number产找：服务器使用情况(条数)
		@Override
		public int serviceIpCount(Map map) {
			// TODO Auto-generated method stub
			return serversMapper.serviceIpCount(map);
		}
		//2.1根据业务number产找：服务器使用情况
		@Override
		public List<ServersBean> getBusinessByNumber(Map map) {
			// TODO Auto-generated method stub
			return serversMapper.getBusinessByNumber(map);
		}
	
}
