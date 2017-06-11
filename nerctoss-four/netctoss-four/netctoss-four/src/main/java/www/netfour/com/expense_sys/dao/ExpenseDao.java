package www.netfour.com.expense_sys.dao;

import java.util.List;

import www.netfour.com.expense_sys.beans.ExpenseBean;
import www.netfour.com.pojos.Pager;

public interface ExpenseDao {
	/**
	 * 查询开通状态的
	 * @return
	 */
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
	 * @param expensePager
	 * @return
	 */
	public List<?> selectExpensesToPager(Pager expensePager);
	/**
	 * 查询记录条数
	 * @return
	 */
	public int selectCountOfExpenses();
	/**
	 * 获取expenseBean用于判断其类型，单位费用等
	 * @param id
	 * @return
	 */
	public ExpenseBean getExpenseBeanById(Long id);
	/**
	 * 修改状态
	 * @param state
	 * @param id
	 * @return
	 */
	public int updateExpenseState(String state,Long id);
	/**
	 * 模糊查询总记录条数
	 * @return
	 */
	public int fuzzyCount(String name,String type,String state);
	
	public  List<?> fuzzySelect(Pager pager,String name,String type,String state);

	/**
	 * 批量删除
	 * @param delArr
	 * @return
	 */
	public int deleteExpenseBatch(List<ExpenseBean> delArr);
	/**
	 * 批量开通
	 * @param dregeArr
	 * @return
	 */
	public int updateDregeExpenseBatch(List<ExpenseBean> dregeArr);
	public int selectExpenseNameIsExist(String name);
}
