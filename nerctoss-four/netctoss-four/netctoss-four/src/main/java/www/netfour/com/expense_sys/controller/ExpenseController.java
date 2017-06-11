package www.netfour.com.expense_sys.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import www.netfour.com.expense_sys.beans.ExpenseBean;
import www.netfour.com.expense_sys.service.ExpenseService;
import www.netfour.com.pojos.Messager;
import www.netfour.com.pojos.Pager;

@RequestMapping("/expense")
@RestController
public class ExpenseController {
	@Resource
	private ExpenseService expenseServiceImpl;
	
	@RequestMapping(value="/addExpense",method=RequestMethod.POST,produces={"application/json;charset=utf-8"})
	public Messager addExpense(@RequestBody ExpenseBean expenseBean){
		Messager msg = new Messager(true,"操作成功");
		try {
			System.out.println("dddd");
			expenseServiceImpl.addExpense(expenseBean);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			msg.setStatus(false);
			msg.setMsg("系统繁忙，请稍后重试");
		}
		//
		return msg;
	}
	
	@RequestMapping(value="/show",method=RequestMethod.GET,produces={"application/json;charset=utf-8"})
	public Pager showExpenseToPager(String page,String rows,@RequestParam(value="name",required=false)String name,@RequestParam(value="type",required=false)String type,@RequestParam(value="state",required=false)String state){
		Pager pager = new Pager();
		pager.setPageNumber(Integer.parseInt(page));
		pager.setPageSize(Integer.parseInt(rows));
		pager = expenseServiceImpl.fuzzyQueryExpenseToPager(pager, name, type, state);
		System.out.println(pager.getRows());
		return pager;
	}
	
	
	//删除
	@RequestMapping(value="/delExpense",method=RequestMethod.DELETE,produces={"application/json;charset=utf-8"})
	public Messager delExpense(@RequestBody List<ExpenseBean> delArr){

		Messager msg = new Messager(true,"操作成功");
		try {
			expenseServiceImpl.deleteExpenseBatch(delArr);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			msg.setMsg("系统繁忙，请稍后重试");
			msg.setStatus(false);
		}
		return msg;
	}
	//修改
	@RequestMapping(value="/updateExpense",method=RequestMethod.PUT,produces={"application/json;charset=utf-8"})
	public Messager updateExpense(@RequestBody ExpenseBean expenseBean){
		Messager msg = new Messager(true,"操作成功");
		try {
			expenseServiceImpl.updateExpense(expenseBean);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			msg.setMsg("系统繁忙，请稍后重试");
			msg.setStatus(false);
		}
		return msg;
	}
	//开通
	@RequestMapping(value="/dregeExpense",produces={"application/json;charset=utf-8"})
	public Messager updateExpense(@RequestBody List<ExpenseBean> dregeArr){

		Messager msg = new Messager(true,"操作成功");
		try {
			expenseServiceImpl.updateDregeExpenseBatch(dregeArr);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			msg.setMsg("系统繁忙，请稍后重试");
			msg.setStatus(false);
		}
		return msg;
		
	}
	//验证
	@RequestMapping(value="/validate",produces={"application/json;charset=utf-8"})
	public Messager updateExpense(@RequestBody String name){
		Messager msg = new Messager();
		try {
			boolean bo = expenseServiceImpl.selectExpenseNameIsExist(name);
			msg.setStatus(true);
			if(bo){
				msg.setMsg("名称合法");
			}
			else{
				msg.setMsg("资费名称不能重复");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			msg.setMsg("系统繁忙，请稍后重试");
			msg.setStatus(false);
		}
		return msg;
		
	}

}
