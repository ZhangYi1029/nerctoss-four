package www.netfour.com.bill_sys.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import www.netfour.com.bill_sys.service.ServersService;
import www.netfour.com.pojos.Pager;

@RequestMapping("/businessbillServersController")
@RestController
public class BusinessbillServerController {
	
	@Resource
	private ServersService serversServiceImpl;
	
	/**
	 * 2.业务账号服务器使用情况
	 * @param page
	 * @param rows
	 * @param tznumber
	 * @return
	 */
	@RequestMapping(value="/businessnumber",method=RequestMethod.GET ,produces={"application/json;charset=utf-8"})
	public Pager getBusinessbillByNumber(String page,String rows,@RequestParam String tznumber){
		
		int pageNumber = Integer.parseInt(page);
		int pageSize = Integer.parseInt(rows);
		int index = (pageNumber - 1)* pageSize;
		
		Map map = new HashMap<>();
		map.put("pageNumber", pageNumber);
		map.put("pageSize", pageSize);
		map.put("index", index);

		map.put("tznumber", tznumber);
		
		Pager pager  = serversServiceImpl.getBusinessByNumber(map);
		
		return pager;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
