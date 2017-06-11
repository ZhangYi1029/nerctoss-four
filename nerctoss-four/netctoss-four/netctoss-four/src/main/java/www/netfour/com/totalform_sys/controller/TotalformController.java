package www.netfour.com.totalform_sys.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import www.netfour.com.bill_sys.beans.TotalbillBean;
import www.netfour.com.business_sys.beans.BusinessBean;
import www.netfour.com.totalform_sys.beans.LineBean;
import www.netfour.com.totalform_sys.service.TotalformService;






@RequestMapping("chart")
@RestController
public class TotalformController {

	
	@Resource
	private TotalformService totalformServiceImpl;
	
	
	@RequestMapping(value="/pie",method=RequestMethod.POST,produces = "application/json;charset=utf-8" )
	public List<TotalbillBean> getPieChart(String year,String number){
		System.out.println(year+number);

		
		//"['Firefox', 45.0],['IE', 1000],{ name: 'Chrome', y: 100, sliced: true, selected: true  }, ['Safari', 8.5],['Opera', 6.2],  ['其他',100] "
		System.out.println("测试m");
		List<TotalbillBean> list= totalformServiceImpl.getYearToralbillByYear(year,number);
		
		System.out.println(list);
		
		

		
		return list;
		
		
	}

	@RequestMapping(value="/line",method=RequestMethod.POST,produces = "application/json;charset=utf-8" )
	public List getLineChart(String year,String number){
		
			System.out.println("进来了"+number);
		
		List<BusinessBean> ints=totalformServiceImpl.getAccountTheBusinessAll(number);
		System.out.println(ints);
		
		List li =new ArrayList<>();
		for (BusinessBean b : ints) {
		Long id =	b.getId();
			
		List<LineBean> line =totalformServiceImpl.getBusinessbillListByBusinessId(year,id+"");
		li.add(line);
		}
		
		System.out.println(li);
		List<LineBean> l =(List<LineBean>) li.get(0);
		
		System.out.println(l.get(0).getMonth());
		
	
		
		return  li;
		
		
	}
	
}
