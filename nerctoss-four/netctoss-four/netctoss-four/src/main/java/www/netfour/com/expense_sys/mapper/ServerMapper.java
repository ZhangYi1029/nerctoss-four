package www.netfour.com.expense_sys.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import www.netfour.com.expense_sys.beans.ServerBean;

public interface ServerMapper {


	public List<ServerBean> getServerBeanById(Long id); 
	public int updateFDurationFee(@Param("serverBean")ServerBean serverBean);
	public List<Long> getNeedUpdateId();
}
