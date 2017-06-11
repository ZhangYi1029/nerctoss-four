package www.netfour.com.accountquery_sys.dao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import www.netfour.com.accountquery_sys.beans.MonthaccountBean;
import www.netfour.com.accountquery_sys.beans.YearaccountBean;
import www.netfour.com.accountquery_sys.dao.MonthaccountDao;
import www.netfour.com.accountquery_sys.mapper.MonthaccountMapper;
import www.netfour.com.utils.DayMessager;
import www.netfour.com.utils.MonthMessager;

@Repository
public class MonthaccountDaoImpl implements MonthaccountDao {

	@Resource
	private MonthaccountMapper monthaccountMapper;
	
	@Override
	public int count(Map map) {
		// TODO Auto-generated method stub
		return monthaccountMapper.count(map);
	}

	@Override
	public List<MonthaccountBean> getMonthaccounAlltByIdAndYear(Map map) {
		// TODO Auto-generated method stub
		
		return monthaccountMapper.getMonthaccounAlltByIdAndYear(map);
	}

	@Override
	public List<YearaccountBean> getYearaccountYearAll() {
		// TODO Auto-generated method stub
		return monthaccountMapper.getYearaccountYearAll();
	}

	@Override
	public void addYearaccount(List<MonthMessager> lsit) {
		// TODO Auto-generated method stub
		monthaccountMapper.addYearaccount(lsit);
	}

	@Override
	public List<MonthMessager> selectMonthDurationIsSumSetYearDuration() {
		// TODO Auto-generated method stub
		return monthaccountMapper.selectMonthDurationIsSumSetYearDuration();
	}

	@Override
	public void addMonth(List<MonthaccountBean> listMontoh) {
		// TODO Auto-generated method stub
		monthaccountMapper.addMonth(listMontoh);
	}

	@Override
	public List<MonthaccountBean> saveYearID() {
		// TODO Auto-generated method stub
		return monthaccountMapper.saveYearID();
	}

	@Override
	public List<DayMessager> selectMonth() {
		// TODO Auto-generated method stub
		return monthaccountMapper.selectMonth();
	}

	@Override
	public void updateMonthaccount(List<DayMessager> list) {
		// TODO Auto-generated method stub
		monthaccountMapper.updateMonthaccount(list);
	}

	@Override
	public List<MonthaccountBean> getMonthaccountYearAll(String tzyear) {
		// TODO Auto-generated method stub
		return monthaccountMapper.getMonthaccountYearAll(tzyear);
	}


}
