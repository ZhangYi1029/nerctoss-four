package www.netfour.com.business_sys.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import www.netfour.com.account_sys.beans.AccountBean;
import www.netfour.com.account_sys.service.AccountService;
import www.netfour.com.business_sys.beans.BusinessBean;
import www.netfour.com.business_sys.service.BusinessService;
import www.netfour.com.expense_sys.beans.ExpenseBean;
import www.netfour.com.expense_sys.service.ExpenseService;
import www.netfour.com.pojos.Messager;
import www.netfour.com.pojos.Pager;

@RequestMapping("/business")
@RestController
public class BusinessController {
	@Resource
	private BusinessService businessServiceImpl;
	@Resource
	private ExpenseService expenseServiceImpl;
	@Resource
	private AccountService accountServiceImpl;
	/*@RequestMapping(value="/save",method=RequestMethod.POST,produces={"application/json;charset=utf-8"})
	public Messager saveBusiness(@RequestBody BusinessBean business){
		String state="开通";
		business.setState(state);
		Messager messager= new Messager(true, "添加成功");
		try {
			businessServiceImpl.saveBusiness(business);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			messager.setStatus(false);
			messager.setMsg("系统繁忙，请稍后再试");
		}
		
		return messager;
	}*/
	@RequestMapping(value="/all",method=RequestMethod.GET,produces={"application/json;charset=utf-8"})
	public Pager showBusiness(String page,String rows,@RequestParam(value="number",required=false)String number,@RequestParam(value="state",required=false)String state){
		Map map = new HashMap();
		map.put("pageNumber", Integer.parseInt(page));
		map.put("pageSize", Integer.parseInt(rows));
		Pager pag= new Pager();
		pag.setPageNumber(Integer.parseInt(page));
		map.put("index", pag.getIndex());
		map.put("number", number);
		map.put("state", state);
		Pager pager=businessServiceImpl.getBusinessByMapToPager(map);
		
		System.out.println(pager);
		
		return pager;
	}
	
	@RequestMapping(value="/showstate",method=RequestMethod.GET,produces={"application/json;charset=utf-8"})
	public List<AccountBean> showAccountByState(){
		String state="开通";
		List<AccountBean> list=null;
		try {
		list=businessServiceImpl.findAllAccountByState(state);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}
	
	@RequestMapping(value="/showexpense",method=RequestMethod.GET,produces={"application/json;charset=utf-8"})
	public List<ExpenseBean> showExpenseByState(){
		String state="开通";
		List<ExpenseBean> list=null;
		try {
		list=expenseServiceImpl.selectUsableExpense(state);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}
	
	@RequestMapping(value="/save",method=RequestMethod.POST,produces={"application/json;charset=utf-8"})
	public Messager saveBusiness(@RequestBody BusinessBean business){
		String state="开通";
		business.setState(state);
		Messager messager= new Messager(true, "添加成功");
		try {
			businessServiceImpl.saveBusiness(business);
		} catch (Exception e) {
			// TODO: handle exception
			messager.setStatus(false);
			messager.setMsg("系统繁忙，请稍后再试");
		}
		return messager;
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET,produces={"application/json;charset=utf-8"})
	public  BusinessBean getBusinessById(@PathVariable("id") Long id){
		BusinessBean business=null;
		try {
			business=businessServiceImpl.getBusinessById(id);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return business;
	}

	@RequestMapping(value="/update",method=RequestMethod.PUT,produces={"application/json;charset=utf-8"})
	public  Messager updateBusiness(@RequestBody BusinessBean business){
		Messager messager= new Messager(true, "修改成功");
		try {
			AccountBean acc=accountServiceImpl.getAccountStateByBusinessId(business.getId());
			if("暂停".equals(acc.getState())){
				messager.setMsg("您的账务账号还在暂停中，请先去开通账务账号");
				messager.setStatus(false);
			}else{
				businessServiceImpl.updateBusiness(business);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			messager.setMsg("系统繁忙");
			messager.setStatus(false);
		}
		return messager;
	}

	@RequestMapping(value="/del",method=RequestMethod.DELETE,produces={"application/json;charset=utf-8"})
	public  Messager deleteBusiness(@RequestBody List<BusinessBean> rowArr){
		Messager messager= new Messager(true, "删除成功");
		
		try {
			businessServiceImpl.deleteBatchBusiness(rowArr);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			messager.setMsg("系统繁忙");
			messager.setStatus(false);
		}
		return messager;
	}
	@RequestMapping(value="/test",method=RequestMethod.POST,produces={"application/json;charset=utf-8"})
	public  Messager getRepeatBusiness(@RequestBody BusinessBean business){
		System.out.println("number"+business.getNumber());
		Messager messager= null;
		
		try {
			
				BusinessBean bus=businessServiceImpl.getRepeatBusiness(business.getNumber());
				if(bus!=null){
					messager= new Messager(false, "重复");
				}else{
					messager= new Messager(true, "不重复");
				}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			messager= new Messager(false, "系统繁忙");
		}
		return messager;
	}
}
