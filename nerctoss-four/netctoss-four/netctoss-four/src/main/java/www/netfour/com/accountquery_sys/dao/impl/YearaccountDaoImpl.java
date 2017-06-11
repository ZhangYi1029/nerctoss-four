package www.netfour.com.accountquery_sys.dao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import www.netfour.com.accountquery_sys.beans.YearaccountBean;
import www.netfour.com.accountquery_sys.dao.YearaccountDao;
import www.netfour.com.accountquery_sys.mapper.YearaccountMapper;
import www.netfour.com.business_sys.beans.BusinessBean;

@Repository
public class YearaccountDaoImpl implements YearaccountDao {

	@Resource
	private YearaccountMapper yearaccountMapper;
	
	@Override
	public int count(Map map) {
		// TODO Auto-generated method stub
		return yearaccountMapper.count(map);
	}

	@Override
	public List<YearaccountBean> getYearaccounAlltById(Map map) {
		// TODO Auto-generated method stub
		return yearaccountMapper.getYearaccounAlltById(map);
	}

	@Override
	public List<YearaccountBean> getYearaccountAll(Map map) {
		// TODO Auto-generated method stub
		return yearaccountMapper.getYearaccountAll(map);
	}

	@Override
	public List<YearaccountBean> getYearaccountIsYearAll() {
		// TODO Auto-generated method stub
		return yearaccountMapper.getYearaccountIsYearAll();
	}

	@Override
	public void addYearaccount(List<YearaccountBean> list) {
		// TODO Auto-generated method stub
		yearaccountMapper.addYearaccount(list);
	}

	@Override
	public List<BusinessBean> getAllBusinessBean() {
		// TODO Auto-generated method stub
		return yearaccountMapper.getAllBusinessBean();
	}

	@Override
	public YearaccountBean getYearaccountBeanIsYear() {
		// TODO Auto-generated method stub
		return yearaccountMapper.getYearaccountBeanIsYear();
	}

	

}
