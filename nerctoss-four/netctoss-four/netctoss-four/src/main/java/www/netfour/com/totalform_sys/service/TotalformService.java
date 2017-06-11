package www.netfour.com.totalform_sys.service;

import java.util.List;

import www.netfour.com.bill_sys.beans.TotalbillBean;
import www.netfour.com.business_sys.beans.BusinessBean;
import www.netfour.com.totalform_sys.beans.LineBean;

public interface TotalformService {

	
	
	public List<TotalbillBean> getYearToralbillByYear(String year,String number);
	
	
	
	public List<BusinessBean> getAccountTheBusinessAll(String number);
	
	
	public List<LineBean>  getBusinessbillListByBusinessId(String year ,String businessId);

	
	
}
