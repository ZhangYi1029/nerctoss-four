package www.netfour.com.accountquery_sys.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import www.netfour.com.accountquery_sys.beans.MonthaccountBean;
import www.netfour.com.accountquery_sys.beans.YearaccountBean;
import www.netfour.com.accountquery_sys.service.MonthaccountService;
import www.netfour.com.pojos.Pager;

@RequestMapping("/monthaccount")
@RestController
public class MonthController {

	@Resource
	private MonthaccountService monthaccountServiceImpl;
	
	@RequestMapping(value="/month",method=RequestMethod.GET ,produces={"application/json;charset=utf-8"})
	public Pager getYear(String page, String rows, String accountNumber,
			@RequestParam String tzyear,@RequestParam String tzaccountBeanNumber ,String year , String month){
		
		int pageNumber = Integer.parseInt(page);
		int pageSize = Integer.parseInt(rows);;
		int index = (pageNumber-1)*pageSize;
		
		accountNumber = (accountNumber == null || accountNumber.equals("") )?tzaccountBeanNumber:accountNumber;
		
		year = (year == null || year.equals("") )? tzyear:year;
		
		if(year.equals("")||year==null){
			year = tzyear;
		}
		
		month = (month == null || month.equals("选择月份:") )? "":month;
		
		Map map = new HashMap<>();
		map.put("pageNumber", pageNumber);
		map.put("pageSize", pageSize);
		map.put("index", index);
		
		map.put("year", year);
		map.put("month", month);
		map.put("accountNumber", accountNumber);
		
		Pager pager = monthaccountServiceImpl.getMonthaccounAlltByIdAndYear(map);
		return pager;
	}
	
	
	@RequestMapping(value="/listYear",method=RequestMethod.GET ,produces={"application/json;charset=utf-8"})
	public @ResponseBody List<HashMap<String, String>>  abcd(){
		
		List<HashMap<String, String>> list = new ArrayList<HashMap<String,String>>();
		
		List<YearaccountBean> lists = monthaccountServiceImpl.getYearaccountYearAll();
		
		
		for(int i = 0 ; i<lists.size() ; i++){
			HashMap<String,String> map = new HashMap<String,String>();
			String year = lists.get(i).getYear()+"";
			map.put("year",year);
			map.put("year",year);
			list.add(map);
		};
		
		return list;
	}
	
	@RequestMapping(value="/listmonth",method=RequestMethod.GET ,produces={"application/json;charset=utf-8"})
	public @ResponseBody List<HashMap<String, String>>  Month(@RequestParam String tzyear){
		
		List<HashMap<String, String>> list = new ArrayList<HashMap<String,String>>();
		
		List<MonthaccountBean> lists = monthaccountServiceImpl.getMonthaccountYearAll(tzyear);
		
		System.err.println( lists.size());
		
		for(int i = 0 ; i<lists.size() ; i++){
			HashMap<String,String> map = new HashMap<String,String>();
			String month = lists.get(i).getMonth()+"";
			map.put("month",month);
			map.put("month",month);
			list.add(map);
		};
		
		return list;
	}
	
}
