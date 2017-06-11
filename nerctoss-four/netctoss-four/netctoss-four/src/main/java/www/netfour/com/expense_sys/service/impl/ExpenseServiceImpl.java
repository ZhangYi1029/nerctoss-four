package www.netfour.com.expense_sys.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import www.netfour.com.expense_sys.beans.ExpenseBean;
import www.netfour.com.expense_sys.dao.ExpenseDao;
import www.netfour.com.expense_sys.service.ExpenseService;
import www.netfour.com.pojos.Pager;

@Service
public class ExpenseServiceImpl implements ExpenseService {

	@Resource
	private ExpenseDao expenseDaoImpl;
	@Override
	public int addExpense(ExpenseBean expenseBean) {
		// TODO Auto-generated method stub
		return expenseDaoImpl.addExpense(expenseBean);
	}

	@Override
	public int deleteExpense(Long expenseId) {
		// TODO Auto-generated method stub
		return expenseDaoImpl.deleteExpense(expenseId);
	}

	@Override
	public int updateExpense(ExpenseBean expenseBean) {
		// TODO Auto-generated method stub
		return expenseDaoImpl.updateExpense(expenseBean);
	}

	@Override
	public Pager showExpenseBeanToPager(Pager pager) {
		// TODO Auto-generated method stub
		pager.setTotal(expenseDaoImpl.selectCountOfExpenses());
		pager.setRows(expenseDaoImpl.selectExpensesToPager(pager));
		return pager;
	}

	@Override
	public int updateExpenseState(String state, Long id) {
		// TODO Auto-generated method stub
		if("开通".equals(state)){
			state="暂停";
		}
		else{
			state="开通";
		}
		return expenseDaoImpl.updateExpenseState(state, id);
	}

	@Override
	public Pager showAvailableExpenseToPager(Pager expensePager) {
		// TODO Auto-generated method stub
		List<ExpenseBean> availableList = new ArrayList<>();
		List<ExpenseBean> expenseList = (List<ExpenseBean>) expenseDaoImpl.selectExpensesToPager(expensePager);
		for (ExpenseBean expense : expenseList) {
			if("开通".equals(expense.getState())){
				availableList.add(expense);
			}
		}
		expensePager.setTotalNumber(availableList.size());
		return expensePager;
	}

	@Override
	public Pager fuzzyQueryExpenseToPager(Pager pager, String name, String type, String state) {
		// TODO Auto-generated method stub
		pager.setTotal(expenseDaoImpl.fuzzyCount(name, type, state));
		pager.setRows(expenseDaoImpl.fuzzySelect(pager, name, type, state));
		return pager;
	}

	@Override
	public int deleteExpenseBatch(List<ExpenseBean> delArr) {
		// TODO Auto-generated method stub
		return expenseDaoImpl.deleteExpenseBatch(delArr);
	}

	@Override
	public int updateDregeExpenseBatch(List<ExpenseBean> dregeArr) {
		// TODO Auto-generated method stub
		return expenseDaoImpl.updateDregeExpenseBatch(dregeArr);
	}

	@Override
	public List<ExpenseBean> selectUsableExpense(String state) {
		// TODO Auto-generated method stub
		return expenseDaoImpl.selectUsableExpense(state);
	}

	@Override
	public boolean selectExpenseNameIsExist(String name) {
		// TODO Auto-generated method stub
		boolean bo = false;
		int i = expenseDaoImpl.selectExpenseNameIsExist(name);
		if(i==0){
			bo = true;
		}
		
		return bo;
	}

}
