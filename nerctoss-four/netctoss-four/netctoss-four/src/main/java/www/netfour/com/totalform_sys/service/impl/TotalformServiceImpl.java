package www.netfour.com.totalform_sys.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import www.netfour.com.bill_sys.beans.TotalbillBean;
import www.netfour.com.business_sys.beans.BusinessBean;
import www.netfour.com.totalform_sys.beans.LineBean;
import www.netfour.com.totalform_sys.dao.TotalformDao;
import www.netfour.com.totalform_sys.service.TotalformService;


@Service
public class TotalformServiceImpl implements TotalformService {

	@Resource
	private TotalformDao totalformDaoImpl;
	
	@Override
	public List<TotalbillBean> getYearToralbillByYear(String year, String number) {
		// TODO Auto-generated method stub
		
		
		return totalformDaoImpl.getYearToralbillByYear(year, number);
	}

	@Override
	public List<BusinessBean> getAccountTheBusinessAll(String number) {
		// TODO Auto-generated method stub
		return totalformDaoImpl.getAccountTheBusinessAll(number);
	}

	@Override
	public List<LineBean> getBusinessbillListByBusinessId(String year, String businessId) {
		// TODO Auto-generated method stub
		return totalformDaoImpl.getBusinessbillListByBusinessId(year, businessId);
	}

}
