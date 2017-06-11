package www.netfour.com.logging_sys.dao;

import java.util.List;
import java.util.Map;

import www.netfour.com.logging_sys.beans.LoggingBean;

public interface LoggingDao {

	/**
	 * 统计满足条件的总条数
	 * 
	 * @param map
	 * @return
	 */
	public int countUserListByMapToPager(Map map);

	/**
	 * 查询满足条件的所有数据
	 * 
	 * @param map
	 * @return
	 */
	public List<LoggingBean> getUserListByMapToPager(Map map);

	/**
	 * 查询满足条件的数据
	 * 
	 * @param
	 * @return
	 */

	public void add(LoggingBean lb);

}
