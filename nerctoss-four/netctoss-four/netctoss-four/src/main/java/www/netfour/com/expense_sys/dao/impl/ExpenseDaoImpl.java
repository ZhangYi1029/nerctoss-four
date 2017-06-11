package www.netfour.com.expense_sys.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import www.netfour.com.expense_sys.beans.ExpenseBean;
import www.netfour.com.expense_sys.dao.ExpenseDao;
import www.netfour.com.expense_sys.mapper.ExpenseMapper;
import www.netfour.com.pojos.Pager;

@Repository
public class ExpenseDaoImpl implements ExpenseDao {

	@Resource
	private ExpenseMapper expenseMapper;
	
	
	
	@Override
	public int addExpense(ExpenseBean expenseBean) {
		// TODO Auto-generated method stub
		return expenseMapper.addExpense(expenseBean);
	}

	@Override
	public int deleteExpense(Long expenseId) {
		// TODO Auto-generated method stub
		return expenseMapper.deleteExpense(expenseId);
	}

	@Override
	public int updateExpense(ExpenseBean expenseBean) {
		// TODO Auto-generated method stub
		return expenseMapper.updateExpense(expenseBean);
	}

	@Override
	public  List<ExpenseBean> selectExpensesToPager(Pager pager) {
		// TODO Auto-generated method stub
		return expenseMapper.selectExpensesToPager(pager);
	}

	@Override
	public int selectCountOfExpenses() {
		// TODO Auto-generated method stub
		return expenseMapper.selectCountOfExpenses();
	}

	@Override
	public ExpenseBean getExpenseBeanById(Long id) {
		// TODO Auto-generated method stub
		return expenseMapper.getExpenseBeanById(id);
	}

	@Override
	public int updateExpenseState(String state,Long id) {
		// TODO Auto-generated method stub
		return expenseMapper.updateExpenseState(state,id);
	}

	@Override
	public int fuzzyCount(String name, String type, String state) {
		// TODO Auto-generated method stub
		return expenseMapper.fuzzyCount(name, type, state);
	}

	@Override
	public List<?> fuzzySelect(Pager pager, String name, String type, String state) {
		// TODO Auto-generated method stub
		return expenseMapper.fuzzySelect(pager, name, type, state);
	}

	@Override
	public int deleteExpenseBatch(List<ExpenseBean> delArr) {
		// TODO Auto-generated method stub
		System.err.println(delArr.get(0).getId());
		return expenseMapper.deleteExpenseBatch(delArr);
	}

	@Override
	public int updateDregeExpenseBatch(List<ExpenseBean> dregeArr) {
		// TODO Auto-generated method stub
		return expenseMapper.updateDregeExpenseBatch(dregeArr);
	}

	@Override
	public List<ExpenseBean> selectUsableExpense(@Param("state")String state) {
		// TODO Auto-generated method stub
		
		
		return expenseMapper.selectUsableExpense(state);
	}

	@Override
	public int selectExpenseNameIsExist(String name) {
		// TODO Auto-generated method stub
		return expenseMapper.selectExpenseNameIsExist(name);
	}

}
