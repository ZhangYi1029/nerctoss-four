package www.netfour.com.bill_sys.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import www.netfour.com.bill_sys.service.BusinessbillService;
import www.netfour.com.pojos.Pager;

@RequestMapping("/businessbillInquireController")
@RestController
public class BusinessbillInquireController {

	@Resource
	private BusinessbillService businessbillServiceImpl;
	
	/**
	 * 3.查询：业务月消费
	 *   显示：业务月消费
	 * @ResponseBody:使传递数据在路径中不改变
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping(value="/bynumber",method=RequestMethod.GET ,produces={"application/json;charset=utf-8"})
	public Pager getBusinessbillById(String page,String rows,@RequestParam String cdnumber){
		
		int pageNumber = Integer.parseInt(page);
		int pageSize = Integer.parseInt(rows);
		int index = (pageNumber - 1)* pageSize;
		
		Map map = new HashMap<>();
		map.put("pageNumber", pageNumber);
		map.put("pageSize", pageSize);
		map.put("index", index);

		map.put("cdnumber", cdnumber);
		
		Pager pager  = businessbillServiceImpl.getBusinessbillById(map);
		
		
		return pager;
	}
	
	
	
	
	
	
}
