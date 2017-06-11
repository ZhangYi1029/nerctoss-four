package www.netfour.com.selfservice_sys.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import www.netfour.com.bill_sys.beans.BusinessbillBean;
import www.netfour.com.bill_sys.beans.TotalbillBean;
import www.netfour.com.selfservice_sys.beans.ServiceBean;
import www.netfour.com.selfservice_sys.dao.SelfServiceDao;
import www.netfour.com.selfservice_sys.service.SelfService;

@Service
public class SelfServiceImpl implements SelfService {

	@Resource
	private SelfServiceDao selfServiceDaoImpl;

	@Override
	public TotalbillBean getBillByMonth(Long userId, String month) {
		// TODO Auto-generated method stub
		return selfServiceDaoImpl.getBillByMonth(userId, month);
	}

	@Override
	public List<BusinessbillBean> getBusinessBillBeanbyBillId(Long id) {
		// TODO Auto-generated method stub
		return selfServiceDaoImpl.getBusinessBillBeanbyBillId(id);
	}

	@Override
	public List<ServiceBean> getServerInfo(String month, Long businessId) {
		// TODO Auto-generated method stub
		return selfServiceDaoImpl.getServerInfo(month, businessId);
	}
	
	//注释
	
	
	
}
