package www.netfour.com.business_sys.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import www.netfour.com.account_sys.beans.AccountBean;
import www.netfour.com.account_sys.dao.AccountDao;
import www.netfour.com.business_sys.beans.BusinessBean;
import www.netfour.com.business_sys.dao.BusinessDao;
import www.netfour.com.business_sys.service.BusinessService;
import www.netfour.com.pojos.Pager;


@Service
public class BusinessServiceImpl implements BusinessService {
	@Resource
	private BusinessDao businessDaoImpl;
	@Resource
	private AccountDao accountDaoImpl;

	@Override
	public int saveBusiness(BusinessBean business) {
		// TODO Auto-generated method stub
		return businessDaoImpl.saveBusiness(business);
	}

	@Override
	public int updateBusiness(BusinessBean business) {
		// TODO Auto-generated method stub
		return businessDaoImpl.updateBusiness(business);
	}

	@Override
	public int deleteBusinessById(Long id) {
		// TODO Auto-generated method stub
		return businessDaoImpl.deleteBusinessById(id);
	}

	@Override
	public Pager getBusinessByMapToPager(Map map) {
		// TODO Auto-generated method stub
		Pager pager=new Pager();
		int totalNumber=businessDaoImpl.countBusinessByMapToPager(map);
		pager.setTotal(totalNumber);
		List<?> list=businessDaoImpl.getBusinessByMapToPager(map);
		int pageNumber = (int) map.get("pageNumber");
		int pageSize = (int) map.get("pageSize");
		pager.setPageNumber(pageNumber);
		pager.setPageSize(pageSize);
		pager.setRows(list);
		return pager;
	}

	@Override
	public BusinessBean getBusinessById(Long id) {
		// TODO Auto-generated method stub
		return businessDaoImpl.getBusinessById(id);
	}

	@Override
	public BusinessBean getRepeatBusiness(String number) {
		// TODO Auto-generated method stub
		return businessDaoImpl.getRepeatBusiness(number);
	}
	@Override
	public List<AccountBean> findAllAccountByState(String state){
		
		return accountDaoImpl.findAllAccount(state);
	}

	@Override
	public int deleteBatchBusiness(List<BusinessBean> business) {
		// TODO Auto-generated method stub
		return businessDaoImpl.deleteBatchBusiness(business);
	}

	
}
