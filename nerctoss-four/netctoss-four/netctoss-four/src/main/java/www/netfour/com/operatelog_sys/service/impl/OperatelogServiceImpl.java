package www.netfour.com.operatelog_sys.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import www.netfour.com.operatelog_sys.beans.OperatelogBean;
import www.netfour.com.operatelog_sys.dao.OperatelogDao;
import www.netfour.com.operatelog_sys.service.OperatelogService;
import www.netfour.com.pojos.Pager;

@Service
public class OperatelogServiceImpl implements OperatelogService {

	@Resource
	private OperatelogDao operatelogDaoImpl;

	@Override
	public Pager getoperateListByMapToPager(Map map) {
		// TODO Auto-generated method stub

		Pager pager = new Pager();
		List<OperatelogBean> datas = operatelogDaoImpl.getoperateListByMapToPager(map);
		System.err.println(datas.size()+"datas");
		
		pager.setRows(datas);
		int page = (int) map.get("page");
		int rows = (int) map.get("rows");
		pager.setPageNumber(page);
		pager.setPageSize(rows);
		System.err.println(rows+"rows");
		int totalRows = operatelogDaoImpl.countoperateListByMapToPager(map);
		pager.setTotal(totalRows);
		
		return pager;
	}

	@Override
	public void add(OperatelogBean ob) {
		// TODO Auto-generated method stub
		
		operatelogDaoImpl.add(ob);
		
		
	}

	
}
