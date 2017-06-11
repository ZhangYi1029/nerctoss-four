package www.netfour.com.bill_sys.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import www.netfour.com.bill_sys.beans.TotalbillBean;
import www.netfour.com.bill_sys.service.TotalbillService;
import www.netfour.com.pojos.Messager;
import www.netfour.com.pojos.Pager;

@RequestMapping("/totalbillController")
@RestController
public class TotalbillController {
	
	@Resource
	private TotalbillService totalbillServiceImpl;
	
	/**
	 * 1.显示：账务账号月消费
	 * 2.查询：账务账号月消费
	 * @param page
	 * @param rows
	 * @param accountBeannumber
	 * @param accountBeanname
	 * @param accountBeanidCard
	 * @param montht
	 * @return
	 */
	@RequestMapping(value="/totalbill",method=RequestMethod.GET,produces={"application/json;charset=utf-8"})
	public Pager showAll(String page,String rows,String accountBeannumber,
			String accountBeanname,String accountBeanidCard,String montht){
		
		//显示页数
		int pageNumber = Integer.parseInt(page);
		//显示条数
		int pageSize = Integer.parseInt(rows);
		int index = (pageNumber - 1)* pageSize;
		
		//查询
		//if(StringUtils.isEmpty(accountBeannumber)) accountBeannumber = "";
		accountBeannumber = (accountBeannumber == null || accountBeannumber.equals(""))?"":accountBeannumber;
		accountBeanname = (accountBeanname == null || accountBeanname.equals(""))?"":accountBeanname;
		accountBeanidCard = (accountBeanidCard == null || accountBeanidCard.equals(""))?"":accountBeanidCard;
		montht = (montht == null || montht.equals(""))?"":montht;
		
		Map map = new HashMap<>();
		map.put("pageNumber", pageNumber);
		map.put("pageSize", pageSize);
		map.put("index", index);

		map.put("accountBeannumber", accountBeannumber);
		map.put("accountBeanname", accountBeanname);
		map.put("accountBeanidCard", accountBeanidCard);
		map.put("montht", montht);

		Pager pager = totalbillServiceImpl.getByManyFees(map);
		
		return pager;
	}
	
	/**
	 * 支付账号账单月消费
	 * @param zfpaystate
	 */
	@RequestMapping(value="/{id}",method=RequestMethod.PUT,produces={"application/json;charset=utf-8"})
	public Messager pay(@RequestBody TotalbillBean totalbillBean,@PathVariable("id")Long id){

			Messager msg = new Messager(true,"支付成功！！！");
			
			totalbillBean.setTotalbillId(id);
			
			totalbillServiceImpl.updatebill(totalbillBean);
			
			return msg;
	}
		
}