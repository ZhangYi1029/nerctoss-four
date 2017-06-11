package www.netfour.com.bill_sys.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import www.netfour.com.bill_sys.beans.BusinessbillBean;
import www.netfour.com.bill_sys.dao.BusinessbillDao;
import www.netfour.com.bill_sys.service.BusinessbillService;
import www.netfour.com.pojos.Pager;

/**
 * 2.查询服务器使用情况
 * @author yxp
 *
 */
@Service
public class BusinessbillServiceImpl implements BusinessbillService {
	
	@Resource
	private BusinessbillDao businessbillDaoImpl;
	
	/**
	 * 一、
	 * 分页显示：业务账号-月消费
	 */
	@Override
	public Pager getBusinessbillById(Map map){
		
		Pager p = new Pager();
		int totalNumber = businessbillDaoImpl.count(map);
		List<BusinessbillBean> list = businessbillDaoImpl.getBusinessbillById(map);
		int pageNumber = (int) map.get("pageNumber");
		int pageSize = (int) map.get("pageSize");

		p.setPageNumber(pageNumber);
		p.setPageSize(pageSize);
		p.setTotal(totalNumber);
		
		
		p.setRows(list);
		
		return p;
	}

	

}
