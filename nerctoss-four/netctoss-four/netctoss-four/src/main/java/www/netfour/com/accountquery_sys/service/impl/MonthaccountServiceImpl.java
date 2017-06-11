package www.netfour.com.accountquery_sys.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import www.netfour.com.accountquery_sys.beans.MonthaccountBean;
import www.netfour.com.accountquery_sys.beans.YearaccountBean;
import www.netfour.com.accountquery_sys.dao.MonthaccountDao;
import www.netfour.com.accountquery_sys.service.MonthaccountService;
import www.netfour.com.pojos.Pager;
import www.netfour.com.utils.DayMessager;
import www.netfour.com.utils.MonthMessager;

@Service
public class MonthaccountServiceImpl implements MonthaccountService {

	@Resource
	private MonthaccountDao monthaccountDaoImpl;
	
	@Override
	public Pager getMonthaccounAlltByIdAndYear(Map map) {
		// TODO Auto-generated method stub
		Pager p = new Pager();
		
		int totalNumber = monthaccountDaoImpl.count(map);
		List<MonthaccountBean> list = monthaccountDaoImpl.getMonthaccounAlltByIdAndYear(map);
		int pageNumber = (int) map.get("pageNumber");
		int pageSize = (int) map.get("pageSize");
		
		p.setPageNumber(pageNumber);
		p.setPageSize(pageSize);
		p.setTotal(totalNumber);
		p.setRows(list);
		
		return p;
	}

	@Override
	public List<YearaccountBean> getYearaccountYearAll() {
		// TODO Auto-generated method stub
		List<YearaccountBean> lsit = monthaccountDaoImpl.getYearaccountYearAll();
		return monthaccountDaoImpl.getYearaccountYearAll();
	}

	@Override
	public void addMonthaccount() {
		// TODO Auto-generated method stub
		
		List<MonthMessager> mm = monthaccountDaoImpl.selectMonthDurationIsSumSetYearDuration();
		
		monthaccountDaoImpl.addYearaccount(mm);
	}

	@Override
	public void addMonth() {
		
		Date date = new Date();
		Long month = date.getMonth()+1l;
		List<MonthaccountBean> listMontoh = new ArrayList<>();
		
		List<MonthaccountBean> list = monthaccountDaoImpl.saveYearID();
		
		for (int i = 0; i < list.size(); i++) {
			MonthaccountBean m = new MonthaccountBean();
			YearaccountBean y = new YearaccountBean();
			y.setId(list.get(i).getYearaccountBean().getId());
			
			m.setYearaccountBean(y);
			m.setMonth(month);
			listMontoh.add(m);
		}
		
		monthaccountDaoImpl.addMonth(listMontoh);
	}

	@Override
	public void addMonthAccountshichang() {
		// TODO Auto-generated method stub
		List<DayMessager> list = monthaccountDaoImpl.selectMonth();
		
		
		
		monthaccountDaoImpl.updateMonthaccount(list);
	}

	@Override
	public List<MonthaccountBean> getMonthaccountYearAll(String tzyear) {
		// TODO Auto-generated method stub
		return monthaccountDaoImpl.getMonthaccountYearAll(tzyear);
	}
}
