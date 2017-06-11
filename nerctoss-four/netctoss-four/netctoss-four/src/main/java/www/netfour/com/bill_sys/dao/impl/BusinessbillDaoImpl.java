package www.netfour.com.bill_sys.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import www.netfour.com.bill_sys.beans.BusinessbillBean;
import www.netfour.com.bill_sys.dao.BusinessbillDao;
import www.netfour.com.bill_sys.mapper.BusinessbillMapper;

/**
 * 业务账单---查询DaoImpl
 * 查询2
 * @author yxp
 *
 */
@Repository
public class BusinessbillDaoImpl implements BusinessbillDao {

	
	@Resource
	private BusinessbillMapper businessbillMapper;
	
	
	//1.1符合条件业务账号条数(根据账务账号)
	@Override
	public int count(Map map) {
		// TODO Auto-generated method stub
		return businessbillMapper.count(map);
	}

	//1.2符合条件业务账号
	@Override
	public List<BusinessbillBean> getBusinessbillById(Map map) {
		// TODO Auto-generated method stub
		
		
		return businessbillMapper.getBusinessbillById(map);
	}

	
	
	
}
