package www.netfour.com.expense_sys.service;

import java.util.List;

import www.netfour.com.expense_sys.beans.ExpenseBean;
import www.netfour.com.pojos.Pager;

public interface ExpenseService {
	
	public List<ExpenseBean> selectUsableExpense(String state);
	/**
	 * 添加资费
	 * @param expenseBean
	 * @return
	 */
	public int addExpense(ExpenseBean expenseBean);
	/**
	 * 删除资费
	 * @param expenseId
	 * @return
	 */
	public int deleteExpense(Long expenseId);
	/**
	 * 修改资费
	 * @param expenseBean
	 * @return
	 */
	public int updateExpense(ExpenseBean expenseBean);
	/**
	 * 分页显示资费表
	 * @return
	 */
	public Pager showExpenseBeanToPager(Pager expensePager);
	/**
	 * 开通暂停资费状态
	 * @param state
	 * @param id
	 * @return
	 */
	public int updateExpenseState(String state,Long id);
	/**
	 * 分页查询所有开通状态的资费
	 * @param expensePager
	 * @return
	 */
	public Pager showAvailableExpenseToPager(Pager expensePager);
	/**
	 * 分页模糊查询
	 * @param expensePager
	 * @param name
	 * @param type
	 * @param state
	 * @return
	 */
	public Pager fuzzyQueryExpenseToPager(Pager pager,String name,String type,String state);
	/**
	 * 批量删除
	 * @param delArr
	 * @return
	 */
	public int deleteExpenseBatch(List<ExpenseBean> delArr);
	/**
	 * 批量开通
	 */
	public int updateDregeExpenseBatch(List<ExpenseBean> dregeArr);
	/**
	 * 查数据库资费名称是否已存在
	 * @param name
	 * @return
	 */
	public boolean selectExpenseNameIsExist(String name);
	
}
