package www.netfour.com.accountquery_sys.dao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import www.netfour.com.accountquery_sys.beans.DayaccountBean;
import www.netfour.com.accountquery_sys.beans.MonthaccountBean;
import www.netfour.com.accountquery_sys.beans.YearaccountBean;
import www.netfour.com.accountquery_sys.dao.DayaccountDao;
import www.netfour.com.accountquery_sys.mapper.DayaccountMapper;

@Repository
public class DayaccountDaoImpl implements DayaccountDao {

	@Resource
	private DayaccountMapper dayaccountMapper;
	
	@Override
	public int count(Map map) {
		// TODO Auto-generated method stub
		return dayaccountMapper.count(map);
	}

	@Override
	public List<DayaccountBean> getDayaccounAlltByIdAndYear(Map map) {
		// TODO Auto-generated method stub
		return dayaccountMapper.getDayaccounAlltByIdAndYear(map);
	}

	

	@Override
	public int addDayaccount(List<DayaccountBean> list) {
		
		return dayaccountMapper.addDayaccount(list);
	}

	@Override
	public List<DayaccountBean> selectDayDuration(Map<String, String> map) {
		// TODO Auto-generated method stub
		return dayaccountMapper.selectDayDuration(map);
	}

	@Override
	public List<YearaccountBean> getYearaccountYearAll() {
		// TODO Auto-generated method stub
		return dayaccountMapper.getYearaccountYearAll();
	}

	@Override
	public List<MonthaccountBean> getMonthaccountYearAll(String tzyear) {
		// TODO Auto-generated method stub
		return dayaccountMapper.getMonthaccountYearAll(tzyear);
	}

	@Override
	public List<DayaccountBean> getdayaccountdayAll(Map<String, String> map) {
		// TODO Auto-generated method stub
		return dayaccountMapper.getdayaccountdayAll(map);
	}

	

}
