package www.netfour.com.logging_sys.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import www.netfour.com.logging_sys.service.LoggingService;
import www.netfour.com.pojos.Pager;

@RequestMapping("/logging")
@RestController
public class loggingController {
	
	
	
	@Resource
	private LoggingService loggingServiceImpl;
	
	@RequestMapping(value="/one", method=RequestMethod.GET ,produces={"application/json;charset=utf-8"})
	public Pager one(String page,String rows ,String time1,String  time2){
		int  page1=Integer.parseInt(page);
		int   rows1=Integer.parseInt(rows);
		int index = (page1 - 1) * rows1;
		Map map = new HashMap();
		map.put("page", page1);
		map.put("index", index);
		map.put("rows", rows1);
	    time1 = (time1== null) ? "1900-01-01 00:00:00" : time1;
		time2= (time2 == null) ? "2020-12-31 00:00:00" : time2;
		
		map.put("logtime", time1);
		map.put("exittime", time2);
		
		Pager pager = loggingServiceImpl.getUserListByMapToPager(map);
		List<?> list = pager.getRows();
		
		
	return  pager;
	}
	
}
