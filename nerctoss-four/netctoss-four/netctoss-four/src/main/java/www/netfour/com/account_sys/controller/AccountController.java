package www.netfour.com.account_sys.controller;

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
import www.netfour.com.pojos.Messager;
import www.netfour.com.pojos.Pager;




@RequestMapping("/account")
@RestController
public class AccountController {
	
	@Resource
	private AccountService accountServiceImpl;
	
	@RequestMapping(value="/test",method=RequestMethod.POST,produces={"application/json;charset=utf-8"})
	public Messager testRepeatAccount(@RequestBody AccountBean account){
		Messager messager=null;
		try {
			AccountBean existAccount = accountServiceImpl.findRepeatAccount(account);
			if(existAccount!=null){
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
	@RequestMapping(value="/save",method=RequestMethod.POST,produces={"application/json;charset=utf-8"})
	public Messager saveAccount(@RequestBody AccountBean account){
		String state="开通";
		account.setState(state);
		System.out.println(account);
		Messager messager= new Messager(true, "添加成功");
		try {
			accountServiceImpl.saveAccount(account);
		} catch (Exception e) {
			// TODO: handle exception
			messager.setStatus(false);
			messager.setMsg("系统繁忙，请稍后再试");
		}
		return messager;
	}
	
//	@RequestMapping(value="/save",method=RequestMethod.POST,produces={"application/json;charset=utf-8"})
//	public Messager saveBatchAccount(@RequestBody List<AccountBean> account){
//		String state="开通";
//		for (int i = 0; i < account.size(); i++) {
//			
//		}
//		Messager messager= new Messager(true, "添加成功");
//		try {
//			accountServiceImpl.saveBatchAccount(account);
//		} catch (Exception e) {
//			// TODO: handle exception
//			messager.setStatus(false);
//			messager.setMsg("系统繁忙，请稍后再试");
//		}
//		return messager;
//	}
	
	/*@RequestMapping(value="/save",method=RequestMethod.PUT,produces={"application/json;charset=utf-8"})
	public Messager updateAccount(@RequestBody AccountBean account){
		
		
		
		return null;
	}*/
	
	@RequestMapping(value="/all",method=RequestMethod.GET,produces={"application/json;charset=utf-8"})
	public  Pager showAccount(String page,String rows,@RequestParam(value="number",required=false)String number,@RequestParam(value="phone",required=false)String phone,@RequestParam(value="state",required=false)String state){
		Map map = new HashMap();
		
		map.put("pageNumber", Integer.parseInt(page));
		map.put("pageSize", Integer.parseInt(rows));
		Pager pag= new Pager();
		pag.setPageNumber(Integer.parseInt(page));
		map.put("index", pag.getIndex());
		map.put("number", number);
		map.put("phone", phone);
		map.put("state", state);
		Pager pager=accountServiceImpl.getAccountByMapToPager(map);
		
		return pager;
	}


@RequestMapping(value="/{id}",method=RequestMethod.GET,produces={"application/json;charset=utf-8"})
public  AccountBean getAccountById(@PathVariable("id") Long id){
	AccountBean account=null;

	try {
		account=accountServiceImpl.findAccountById(id);
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}

	return account;
}

@RequestMapping(value="/update",method=RequestMethod.PUT,produces={"application/json;charset=utf-8"})
public  Messager updateAccount(@RequestBody AccountBean account){
	Messager messager= new Messager(true, "修改成功");
	try {
		accountServiceImpl.updateAccount(account);
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
		messager.setMsg("系统繁忙");
		messager.setStatus(false);
	}
	return messager;
}

@RequestMapping(value="/del",method=RequestMethod.DELETE,produces={"application/json;charset=utf-8"})
public  Messager deleteAccount(@RequestBody List<AccountBean> rowArr){
	Messager messager= new Messager(true, "删除成功");
	
	try {
		accountServiceImpl.deleteBatchAccount(rowArr);
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
		messager.setMsg("系统繁忙");
		messager.setStatus(false);
	}
	return messager;
}
}
