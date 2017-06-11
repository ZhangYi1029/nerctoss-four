package www.netfour.com.totalform_sys.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import www.netfour.com.bill_sys.beans.TotalbillBean;
import www.netfour.com.business_sys.beans.BusinessBean;
import www.netfour.com.totalform_sys.beans.LineBean;
import www.netfour.com.totalform_sys.dao.TotalformDao;
import www.netfour.com.totalform_sys.mapper.TotalformMapper;

@Repository
public class TotalformDaoImpl implements TotalformDao {

	@Resource
	private TotalformMapper totalformMapper;
	
	
	@Override
	public List<TotalbillBean> getYearToralbillByYear(String year, String number) {
		// TODO Auto-generated method stub
	
		
		
		return totalformMapper.getYearToralbillByYear(year, number);
	}


	@Override
	public List<BusinessBean> getAccountTheBusinessAll(String number) {
		// TODO Auto-generated method stub
		return totalformMapper.getAccountTheBusinessAll(number);
	}


	@Override
	public List<LineBean> getBusinessbillListByBusinessId(String year, String businessId) {
		// TODO Auto-generated method stub
		return totalformMapper.getBusinessbillListByBusinessId(year, businessId);
	}

}
