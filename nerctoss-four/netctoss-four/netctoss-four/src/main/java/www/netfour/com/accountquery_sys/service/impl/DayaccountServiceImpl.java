package www.netfour.com.accountquery_sys.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import www.netfour.com.accountquery_sys.beans.DayaccountBean;
import www.netfour.com.accountquery_sys.beans.MonthaccountBean;
import www.netfour.com.accountquery_sys.beans.YearaccountBean;
import www.netfour.com.accountquery_sys.dao.DayaccountDao;
import www.netfour.com.accountquery_sys.service.DayaccountService;
import www.netfour.com.pojos.Pager;

@Service
public class DayaccountServiceImpl implements DayaccountService {

	@Resource
	private DayaccountDao dayaccountDaoImpl;
	
	@Override
	public Pager getDayaccounAlltByIdAndYear(Map map) {
		// TODO Auto-generated method stub
		
		Pager p = new Pager();
		int total = dayaccountDaoImpl.count(map);
		List<DayaccountBean> list = dayaccountDaoImpl.getDayaccounAlltByIdAndYear(map);
		int pageNumber = (int) map.get("pageNumber");
		int pageSize = (int) map.get("pageSize");
		
		
		p.setPageNumber(pageNumber);
		p.setPageSize(pageSize);
		p.setTotal(total);
		p.setRows(list);
		
		
		return p;
	}



	@Override
	public void addDayaccount() {
		//获取昨天日期
		List<DayaccountBean> list = new ArrayList<>();
		Calendar   cal   =   Calendar.getInstance();
		cal.add(Calendar.DATE,-1);
		String date = new SimpleDateFormat( "yyyy-MM-dd").format(cal.getTime());
		
		 String year = cal.get(Calendar.YEAR)+"";//得到年
		 String month = (cal.get(Calendar.MONTH)+1)+"";//由于月份是从0开始的所以加1
		
		 
		  Map<String, String> map = new HashMap<>();
		  map.put("year", year);
		  map.put("month", month);
		  map.put("date", date);
		  
		 List<DayaccountBean> list2= dayaccountDaoImpl.selectDayDuration(map);
		
		 
		 for (int i = 0; i < list2.size(); i++) {
			DayaccountBean d = new DayaccountBean();
			d.setDayDuration(list2.get(i).getDayDuration());
			d.setMonthaccountBean(list2.get(i).getMonthaccountBean());
			d.setDay(cal.get(Calendar.DATE)+1l);
			list.add(d);
		}
		 dayaccountDaoImpl.addDayaccount(list);
	}

	@Override
	public List<YearaccountBean> getYearaccountYearAll() {
		// TODO Auto-generated method stub
		return dayaccountDaoImpl.getYearaccountYearAll();
	}

	@Override
	public List<MonthaccountBean> getMonthaccountYearAll(String tzyear) {
		// TODO Auto-generated method stub
		return dayaccountDaoImpl.getMonthaccountYearAll(tzyear);
	}



	@Override
	public List<DayaccountBean> getdayaccountdayAll(Map<String, String> map) {
		// TODO Auto-generated method stub
		return dayaccountDaoImpl.getdayaccountdayAll(map);
	}

	

}
