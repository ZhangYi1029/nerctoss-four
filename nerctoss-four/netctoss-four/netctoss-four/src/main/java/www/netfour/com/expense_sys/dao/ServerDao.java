package www.netfour.com.expense_sys.dao;

import java.util.List;

import www.netfour.com.expense_sys.beans.ServerBean;

public interface ServerDao {
	
	public List<ServerBean> getServerBeanById(Long id); 


	public int updateFDurationFee(ServerBean serverBean);
	
	public List<Long> getNeedUpdateId();
}
