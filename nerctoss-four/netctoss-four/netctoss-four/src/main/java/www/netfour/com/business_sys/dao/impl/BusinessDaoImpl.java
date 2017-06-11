package www.netfour.com.business_sys.dao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import www.netfour.com.business_sys.beans.BusinessBean;
import www.netfour.com.business_sys.dao.BusinessDao;
import www.netfour.com.business_sys.mapper.BusinessMapper;
@Repository
public class BusinessDaoImpl implements BusinessDao {
	@Resource
	private BusinessMapper businessMapper;

	@Override
	public int saveBusiness(BusinessBean business) {
		// TODO Auto-generated method stub
		return businessMapper.saveBusiness(business);
	}

	@Override
	public int updateBusiness(BusinessBean business) {
		// TODO Auto-generated method stub
		return businessMapper.updateBusiness(business);
	}

	@Override
	public int deleteBusinessById(Long id) {
		// TODO Auto-generated method stub
		return businessMapper.deleteBusinessById(id);
	}
	
	@Override
	public int countBusinessByMapToPager(Map map) {
		// TODO Auto-generated method stub
		return businessMapper.countBusinessByMapToPager(map);
	}
	
	@Override
	public List<BusinessBean> getBusinessByMapToPager(Map map) {
		// TODO Auto-generated method stub
		return businessMapper.getBusinessByMapToPager(map);
	}

	@Override
	public BusinessBean getBusinessById(Long id) {
		// TODO Auto-generated method stub
		return businessMapper.getBusinessById(id);
	}

	@Override
	public BusinessBean getRepeatBusiness(String number) {
		// TODO Auto-generated method stub
		return businessMapper.getRepeatBusiness(number);
	}

	@Override
	public int deleteBatchBusiness(List<BusinessBean> business) {
		// TODO Auto-generated method stub
		return businessMapper.deleteBatchBusiness(business);
	}

	@Override
	public int updateBusinessStateByAccountId(Long id) {
		// TODO Auto-generated method stub
		return businessMapper.updateBusinessStateByAccountId(id);
	}

	

}
