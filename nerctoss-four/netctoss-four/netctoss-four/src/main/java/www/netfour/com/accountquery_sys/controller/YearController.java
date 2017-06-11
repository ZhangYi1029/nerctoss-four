package www.netfour.com.accountquery_sys.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import www.netfour.com.accountquery_sys.beans.YearaccountBean;
import www.netfour.com.accountquery_sys.service.YearaccountService;
import www.netfour.com.pojos.Pager;

@RequestMapping("/yearaccount")
@RestController
public class YearController {

	@Resource
	private YearaccountService yearaccountServiceImpl;
	
	@RequestMapping(value="/year",method=RequestMethod.GET ,produces={"application/json;charset=utf-8"})
	public Pager getYear(String page, String rows, String accountNumber,String year){
		
		
		
		int pageNumber = Integer.parseInt(page);
		int pageSize = Integer.parseInt(rows);;
		int index = (pageNumber-1)*pageSize;
		
		
		accountNumber = (accountNumber == null )?"":accountNumber;
		year = (year == null )? "":year;
		
		Map map = new HashMap<>();
		map.put("pageNumber", pageNumber);
		map.put("pageSize", pageSize);
		map.put("index", index);
		
		
		map.put("year", year);
		map.put("accountNumber", accountNumber);
		
		
		Pager pager = yearaccountServiceImpl.getYearaccounAlltById(map);
		
		
		
		return pager;
	}
	
	
	@RequestMapping(value="/list",method=RequestMethod.GET ,produces={"application/json;charset=utf-8"})
	public @ResponseBody List<HashMap<String, String>>  abcd(){
		
		List<HashMap<String, String>> list = new ArrayList<HashMap<String,String>>();
		
		List<YearaccountBean> lists = yearaccountServiceImpl.getYearaccountIsYearAll();
		
		for(int i = 0 ; i<lists.size() ; i++){
			HashMap<String,String> map = new HashMap<String,String>();
			String year = lists.get(i).getYear()+"";
			map.put("year",year);
			map.put("year",year);
			list.add(map);
		};
		
		return list;
	}
	
	@RequestMapping(value="/tiaozhuan",method=RequestMethod.GET)
	public String ttttt(){
		
		System.out.println("呵呵哒");
		
		return "/telecomlease_system/html/yearAccount.html?year="+5;
		
		
	}
}
