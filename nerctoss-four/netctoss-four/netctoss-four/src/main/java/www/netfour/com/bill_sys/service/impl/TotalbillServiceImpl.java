package www.netfour.com.bill_sys.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import www.netfour.com.bill_sys.beans.TotalbillBean;
import www.netfour.com.bill_sys.dao.TotalbillDao;
import www.netfour.com.bill_sys.service.TotalbillService;
import www.netfour.com.pojos.Pager;

/**
 * 1.账号查业务费用
 * @author yxp
 *
 */
@Service
public class TotalbillServiceImpl implements TotalbillService{
	
	@Resource
	private TotalbillDao totalbillDaoImpl;
	
	/**
	 * 分页显示：账务账号-月费用
	 */
	@Override
	public Pager showAll(Map map){
		// TODO Auto-generated method stub
		Pager p = new Pager();
		int total=totalbillDaoImpl.count(map);
		List<TotalbillBean> list = totalbillDaoImpl.showAll(map);
		int pageNumber = (int) map.get("pageNumber");
		int pageSize = (int) map.get("pageSize");
		
		p.setPageNumber(pageNumber);
		p.setPageSize(pageSize);
		p.setTotal(total);
		p.setRows(list);

		return p;
	}
	
	
	
	/**
	 * 一、1.1
	 * 根据：月份、账务账号外键----------查询:账务账号
	 * @param number
	 * @param name
	 * @param month
	 * @param idCard
	 * @return
	 */
	@Override
	public Pager getByManyFees(Map map){
		// TODO Auto-generated method stub
		
		Pager p = new Pager();
		int total=totalbillDaoImpl.count(map);
		List<TotalbillBean> list = totalbillDaoImpl.getByManyFees(map);
		int pageNumber = (int) map.get("pageNumber");
		int pageSize = (int) map.get("pageSize");
		
		p.setPageNumber(pageNumber);
		p.setPageSize(pageSize);
		p.setTotal(total);
		p.setRows(list);
		
		return p;
		
	}


	/**
	 * 二、
	 * 根据账务账号id：修改支付状态
	 * @param totalbillId
	 */
	@Override
	public int updatebill(TotalbillBean totalbillBean) {
		// TODO Auto-generated method stub
		return totalbillDaoImpl.updatebill(totalbillBean);		
	}
}
