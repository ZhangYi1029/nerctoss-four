package www.netfour.com.operatelog_sys.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import www.netfour.com.operatelog_sys.service.OperatelogService;
import www.netfour.com.pojos.Pager;

@RequestMapping("/operate")
@RestController
public class OperateController {
	
	
	
	@Resource
	private OperatelogService  operatelogServiceImpl   ;
	
	@RequestMapping(value="/one", method=RequestMethod.GET ,produces={"application/json;charset=utf-8"})
	public Pager opeone(String page,String rows ,String time3,String  time4){
		int  page1=Integer.parseInt(page);
		int   rows1=Integer.parseInt(rows);
		
		int index = (page1 - 1) * rows1;
		Map map = new HashMap();
		map.put("page", page1);
		map.put("index", index);
		map.put("rows", rows1);
		time3 = (time3== null) ? "1900-01-01" : time3;
		time4= (time4 == null) ? "2020-12-31" : time4;
		
		
		map.put("starttime",time3+" 00:00:00");
		map.put("stoptime",time4+" 00:00:00");
	
	
		
		Pager pager = operatelogServiceImpl.getoperateListByMapToPager(map);
		
		System.out.println(pager);
		
	return  pager;
	}
	
}
