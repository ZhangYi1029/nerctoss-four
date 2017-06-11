package www.netfour.com.selfservice_sys.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import www.netfour.com.bill_sys.beans.BusinessbillBean;
import www.netfour.com.bill_sys.beans.TotalbillBean;
import www.netfour.com.selfservice_sys.beans.ServiceBean;
import www.netfour.com.selfservice_sys.dao.SelfServiceDao;
import www.netfour.com.selfservice_sys.mapper.SelfServiceMapper;


@Repository
public class SelfServiceDaoImpl implements SelfServiceDao {

	@Resource
	private SelfServiceMapper selfServiceMapper;
	
	
	@Override
	public TotalbillBean getBillByMonth(Long userId, String month) {
		// TODO Auto-generated method stub
		
		return selfServiceMapper.getBillByMonth(userId, month);
	}


	@Override
	public List<BusinessbillBean> getBusinessBillBeanbyBillId(Long id) {
		// TODO Auto-generated method stub
		return selfServiceMapper.getBusinessBillBeanbyBillId(id);
	}


	@Override
	public List<ServiceBean> getServerInfo(String month, Long businessId) {
		// TODO Auto-generated method stub
		return selfServiceMapper.getServerInfo(month, businessId);
	}

}
