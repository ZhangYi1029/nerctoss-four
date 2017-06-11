package www.netfour.com.operatelog_sys.dao;

import java.util.List;
import java.util.Map;

import www.netfour.com.operatelog_sys.beans.OperatelogBean;

public interface OperatelogDao {
	
	/*
	 * 增加操作信息
	 */
	public void add(OperatelogBean ob);
	/**
	 * 统计满足条件的总条数
	 * 
	 * @param map
	 * @return
	 */
	public int countoperateListByMapToPager(Map map);

	/**
	 * 查询满足条件的所有数据
	 * 
	 * @param map
	 * @return
	 */
	public List<OperatelogBean> getoperateListByMapToPager(Map map);

	/* public Pager search(Pager page); */

}
