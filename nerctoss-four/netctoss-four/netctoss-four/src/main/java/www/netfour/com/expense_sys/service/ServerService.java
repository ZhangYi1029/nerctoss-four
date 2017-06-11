package www.netfour.com.expense_sys.service;

import java.util.List;

public interface ServerService {
	/**
	 * 根据业务账号id，计算费用并添加到记录中
	 * @param id
	 *
	 */
	public void updateFee(Long id);
	
	/**
	 * 获得需要在定时器中算账的业务账号id，在定时器中调用
	 */
	public List<Long> getNeedUpdateId();
}
