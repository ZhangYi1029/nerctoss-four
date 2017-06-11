package www.netfour.com.business_sys.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import www.netfour.com.account_sys.beans.AccountBean;
import www.netfour.com.business_sys.beans.BusinessBean;
import www.netfour.com.pojos.Pager;

public interface BusinessService {
	/**
	 * 增加业务账号
	 * @param business
	 * @return
	 */
	public int saveBusiness(BusinessBean business);
	/**
	 * 修改业务账号
	 * @param business
	 * @return
	 */
	public int updateBusiness(BusinessBean business);
	/**
	 * 删除业务账号
	 * @param id
	 * @return
	 */
	public int deleteBusinessById(Long id);
	/**
	 * 查询符合条件的业务账号
	 * @param map
	 * @return
	 */
	public Pager getBusinessByMapToPager(Map map);
	/**
	 * 根据id查询业务账号的详细信息
	 * @param id
	 * @return
	 */
	public BusinessBean getBusinessById(Long id);
	
	/**
	 * 查询业务账号是否重复
	 * @param number
	 * @return
	 */
	public BusinessBean getRepeatBusiness(String number);
	/**
	 * 根据账务账号的状态查询数据
	 * @param state
	 * @return
	 */
	public List<AccountBean> findAllAccountByState(String state);
	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */
	public int deleteBatchBusiness(@Param("business")List<BusinessBean> business);
}
