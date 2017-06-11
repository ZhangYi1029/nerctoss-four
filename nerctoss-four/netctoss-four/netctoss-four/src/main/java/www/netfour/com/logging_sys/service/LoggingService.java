package www.netfour.com.logging_sys.service;

import java.util.Map;

import www.netfour.com.logging_sys.beans.LoggingBean;
import www.netfour.com.pojos.Pager;

public interface LoggingService {

	public void add(LoggingBean lb );

	public Pager getUserListByMapToPager(Map map);
}
