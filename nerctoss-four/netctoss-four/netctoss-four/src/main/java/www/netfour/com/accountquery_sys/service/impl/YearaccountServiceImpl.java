package www.netfour.com.accountquery_sys.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import www.netfour.com.accountquery_sys.beans.YearaccountBean;
import www.netfour.com.accountquery_sys.dao.YearaccountDao;
import www.netfour.com.accountquery_sys.service.YearaccountService;
import www.netfour.com.business_sys.beans.BusinessBean;
import www.netfour.com.pojos.Pager;

@Service
public class YearaccountServiceImpl implements YearaccountService {

	@Resource
	private YearaccountDao yearaccountDaoImpl;
	
	@Override
	public Pager getYearaccounAlltById(Map map) {
		// TODO Auto-generated method stub
		Pager p = new Pager();
		int total= yearaccountDaoImpl.count(map);
		List<YearaccountBean> list = yearaccountDaoImpl.getYearaccounAlltById(map);
		int pageNumber = (int) map.get("pageNumber");
		int pageSize = (int) map.get("pageSize");
		
		p.setPageNumber(pageNumber);
		p.setPageSize(pageSize);
		
		p.setTotal(total);
		p.setRows(list);
		return p;
	}

	@Override
	public Pager getYearaccountAll(Map map) {
		// TODO Auto-generated method stub
		Pager p = new Pager();
		
		int total= yearaccountDaoImpl.count(map);
		List<YearaccountBean> list = yearaccountDaoImpl.getYearaccountAll(map);
		int pageNumber = (int) map.get("pageNumber");
		int pageSize = (int) map.get("pageSize");
		
		p.setPageNumber(pageNumber);
		p.setPageSize(pageSize);
		
		p.setTotal(total);
		p.setRows(list);
		return p;
	}

	@Override
	public List<YearaccountBean> getYearaccountIsYearAll() {
		// TODO Auto-generated method stub
		return yearaccountDaoImpl.getYearaccountIsYearAll();
	}

	@Override
	public void addYearaccount() {
		List<YearaccountBean> list = new ArrayList<>();
		
		List<BusinessBean> list2 = yearaccountDaoImpl.getAllBusinessBean();
		System.err.println(list2.size());
		YearaccountBean yB = yearaccountDaoImpl.getYearaccountBeanIsYear();
		
		
		for (int i = 0; i < list2.size(); i++) {
			YearaccountBean yBean = new YearaccountBean();
			yBean.setBusinessBean(list2.get(i));
			yBean.setYear(yB.getYear()+1);
			list.add(yBean);
		}
		
		yearaccountDaoImpl.addYearaccount(list);
	}

	
	
}
