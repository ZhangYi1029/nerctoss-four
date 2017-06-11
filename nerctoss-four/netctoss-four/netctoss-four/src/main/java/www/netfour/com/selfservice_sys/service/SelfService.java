package www.netfour.com.selfservice_sys.service;

import java.util.List;

import www.netfour.com.bill_sys.beans.BusinessbillBean;
import www.netfour.com.bill_sys.beans.TotalbillBean;
import www.netfour.com.selfservice_sys.beans.ServiceBean;

public interface SelfService {

	public TotalbillBean getBillByMonth(Long userId,String month);
	
	public List<BusinessbillBean> getBusinessBillBeanbyBillId( Long id);
	
	
	public List<ServiceBean> getServerInfo(String month,Long businessId);

}
