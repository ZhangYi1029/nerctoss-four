package www.netfour.com.logging_sys.dao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import www.netfour.com.logging_sys.beans.LoggingBean;
import www.netfour.com.logging_sys.dao.LoggingDao;
import www.netfour.com.logging_sys.mapper.LoggingMapper;

@Repository
public class LoggingDaoImpl implements LoggingDao {
	@Resource
	private LoggingMapper loggingMapper;

	@Override
	public List<LoggingBean> getUserListByMapToPager(Map map) {
		// TODO Auto-generated method stub
		return loggingMapper.getUserListByMapToPager(map);
	}

	

	@Override
	public int countUserListByMapToPager(Map map) {
		// TODO Auto-generated method stub
		return loggingMapper.countUserListByMapToPager(map);
	}

	@Override
	public void add(LoggingBean lb) {
		// TODO Auto-generated method stub
		
		loggingMapper.add(lb);
	}

}
