package www.netfour.com.operatelog_sys.service;

import java.util.Map;

import www.netfour.com.operatelog_sys.beans.OperatelogBean;
import www.netfour.com.pojos.Pager;

public interface OperatelogService {

	/* public Pager search(Pager page); */

	public Pager getoperateListByMapToPager(Map map);
	
	
	
	/*
	 * 增加操作信息
	 */
	public void add(OperatelogBean ob);
}
