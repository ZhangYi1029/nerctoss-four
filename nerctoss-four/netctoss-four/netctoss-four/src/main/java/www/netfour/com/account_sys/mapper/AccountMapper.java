package www.netfour.com.account_sys.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import www.netfour.com.account_sys.beans.AccountBean;

public interface AccountMapper {
	
	List<String> queryAllPerms(@Param("accountId")Long accountId);
	
	AccountBean queryByAccountName(@Param("accountName")String accountName);
	
	/**
	 * 单个新增账务账号
	 * @param account
	 * @return
	 */
	public int saveAccount(@Param("account")AccountBean account);
 
	/**
	 * 批量增加账务账号
	 * @param account
	 * @return
	 */
	
	public int saveBatchAccount(@Param("account")List<AccountBean> account);
	
	/**
	 * 修改账务账号
	 * @param account
	 * @return
	 */
	public int updateAccount(@Param("account")AccountBean account);
	/**
	 * 根据id删除账务账号
	 * @param id
	 * @return
	 */
	public int deleteAccountById(Long id);
	/**
	 * 根据状态查询所有账务账号
	 * @return
	 */
	public List<AccountBean> findAllAccount(String state);
	/**
	 * 根据id来查询账务详细信息
	 * @param id
	 * @return
	 */
	public AccountBean findAccountById(Long id);
	/**
	 * 查询符合条件的总条数
	 * @param map
	 * @return
	 */
	public int countAccountByMapToPager(@Param("map")Map map); 
	/**
	 * 查询符合条件的所有账务账号
	 * @param map
	 * @return
	 */
	public List<AccountBean> getAccountByMapToPager(@Param("map")Map map);
	/**
	 * 根据账务账号查找id
	 * @param number
	 * @return
	 */
	public AccountBean getAccountIdByNumber(String number);
	/**
	 * 根据用户的真实姓名模糊查询账户账号
	 * @param name
	 * @return
	 */
	public List<AccountBean> getAccountByLikeName(String name);
	/**
	 * 身份证、电话 查询是否有重复
	 * @param account
	 * @return
	 */
	public AccountBean findRepeatAccount(@Param("account")AccountBean account);
	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */
	public int deleteBatchAccount(@Param("accounts")List<AccountBean> account);
	/**
	 * 根据业务账号来查询账务账号的状态
	 * @param id
	 * @return
	 */
	public AccountBean getAccountStateByBusinessId(Long id);
}
