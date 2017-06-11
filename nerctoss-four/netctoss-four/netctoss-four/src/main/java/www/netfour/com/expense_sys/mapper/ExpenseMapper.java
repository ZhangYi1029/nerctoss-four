package www.netfour.com.expense_sys.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import www.netfour.com.expense_sys.beans.ExpenseBean;
import www.netfour.com.pojos.Pager;

public interface ExpenseMapper {
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
	public List<ExpenseBean> selectExpensesToPager(@Param("pager")Pager expensePager);
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
	 * 修改资费状态开（开通或暂停）
	 * @param state
	 * @return
	 */
	public int updateExpenseState(@Param("state")String state,@Param("id")Long id);
	
	public int fuzzyCount(@Param("name")String name,@Param("type")String type,@Param("state")String state);
	
	public  List<?> fuzzySelect(@Param("pager")Pager pager,@Param("name")String name,@Param("type")String type,@Param("state")String state);

	/**
	 * 批量删除
	 * @param delArr
	 * @return
	 */
	public int deleteExpenseBatch(@Param("delArr")List<ExpenseBean> delArr);
	
	public int updateDregeExpenseBatch(@Param("dregeArr")List<ExpenseBean> dregeArr);
	
	public List<ExpenseBean> selectUsableExpense(String state);
	public int selectExpenseNameIsExist(@Param("name")String name);
}
