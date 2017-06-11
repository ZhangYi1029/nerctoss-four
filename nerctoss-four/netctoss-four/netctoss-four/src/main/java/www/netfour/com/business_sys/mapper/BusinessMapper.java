package www.netfour.com.business_sys.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import www.netfour.com.business_sys.beans.BusinessBean;


public interface BusinessMapper {

	/**
	 * 增加业务账号
	 * @param business
	 * @return
	 */
	public int saveBusiness(@Param("business")BusinessBean business);
	/**
	 * 修改业务账号
	 * @param business
	 * @return
	 */
	public int updateBusiness(@Param("business")BusinessBean business);
	/**
	 * 删除业务账号
	 * @param id
	 * @return
	 */
	public int deleteBusinessById(Long id);
	/**
	 * 查询符合条件的业务账号的总数据
	 * @param map
	 * @return
	 */
	public int countBusinessByMapToPager(@Param("map")Map map);
	/**
	 * 查询符合条件的所有的业务账号
	 * @param map
	 * @return
	 */
	public List<BusinessBean> getBusinessByMapToPager(@Param("map")Map map);
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
	 * 批量删除
	 * @param ids
	 * @return
	 */
	public int deleteBatchBusiness(@Param("business")List<BusinessBean> business);
	/**
	 * 根据账户账号的状态的更改来改动业务账号的状态
	 * @param id
	 * @return
	 */
	public int updateBusinessStateByAccountId(Long id);
}
