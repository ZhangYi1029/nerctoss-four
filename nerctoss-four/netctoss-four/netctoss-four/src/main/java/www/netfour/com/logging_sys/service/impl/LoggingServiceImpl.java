package www.netfour.com.logging_sys.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import www.netfour.com.logging_sys.beans.LoggingBean;
import www.netfour.com.logging_sys.dao.LoggingDao;
import www.netfour.com.logging_sys.service.LoggingService;
import www.netfour.com.pojos.Pager;

@Service
public class LoggingServiceImpl implements LoggingService {
	@Resource
	private LoggingDao loggingDaoImpl;

	

	@Override
	public Pager getUserListByMapToPager(Map map) {
		// TODO Auto-generated method stub

		Pager pager = new Pager();
		
		List<LoggingBean> datas = loggingDaoImpl.getUserListByMapToPager(map);
		System.err.println(datas);
		int page = (int) map.get("page");
		int rows = (int) map.get("rows");
		pager.setPageNumber(page);
		pager.setPageSize(rows);
		int totalRows = loggingDaoImpl.countUserListByMapToPager(map);
		pager.setTotal(totalRows);
		pager.setRows(datas);

		return pager;
	}

	@Override
	public void add(LoggingBean lb ) {
		// TODO Auto-generated method stub
		
		loggingDaoImpl.add(lb);
		
		
	}

}
