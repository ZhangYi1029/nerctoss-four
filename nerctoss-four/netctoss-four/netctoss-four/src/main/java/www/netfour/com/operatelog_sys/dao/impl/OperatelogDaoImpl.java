package www.netfour.com.operatelog_sys.dao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import www.netfour.com.operatelog_sys.beans.OperatelogBean;
import www.netfour.com.operatelog_sys.dao.OperatelogDao;
import www.netfour.com.operatelog_sys.mapper.OperatelogMapper;

@Repository
public class OperatelogDaoImpl implements OperatelogDao {

	@Resource
	private OperatelogMapper operatelogMapper;

	/*
	 * @Override public Pager search(Pager page) { // TODO Auto-generated method
	 * stub return lm.search(page); }
	 */

	@Override
	public int countoperateListByMapToPager(Map map) {
		// TODO Auto-generated method stub
		
		
		
		return operatelogMapper.countoperateListByMapToPager(map);
	}

	@Override
	public List<OperatelogBean> getoperateListByMapToPager(Map map) {
		// TODO Auto-generated method stub
		return operatelogMapper.getoperateListByMapToPager(map);
	}

	@Override
	public void add(OperatelogBean ob) {
		// TODO Auto-generated method stub
		
		
		operatelogMapper.add(ob);
	}

}
