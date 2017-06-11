package www.netfour.com.bill_sys.dao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import www.netfour.com.bill_sys.beans.TotalbillBean;
import www.netfour.com.bill_sys.dao.TotalbillDao;
import www.netfour.com.bill_sys.mapper.TotalbillMapper;

/**
 * 账务账单---查询DaoImpl
 * 查询1
 * @author yxp
 *
 */
@Repository
public class TotalbillDaoImpl implements TotalbillDao{

	@Resource
	private TotalbillMapper totalbillMapper;
	
	/**
	 * 1.0查询:账务账号-消费
	 */
	@Override
	public List<TotalbillBean> getByManyFees(Map map) {
		// TODO Auto-generated method stub
		return (List<TotalbillBean>) totalbillMapper.getByManyFees(map);
	}
	
	/**
	 * 2.修改支付状态
	 */
	@Override
	public int updatebill(TotalbillBean totalbillBean){
		// TODO Auto-generated method stub
		return totalbillMapper.updatebill(totalbillBean);		
	}


	/**
	 * 分页显示
	 */
	@Override
	public List<TotalbillBean> showAll(Map map){
		// TODO Auto-generated method stub
		return totalbillMapper.showAll(map);
	}


	/**
	 * 分页显示：有多少条
	 */
	@Override
	public int count(Map map) {
		return totalbillMapper.count(map);
	}


}
