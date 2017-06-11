package www.netfour.com.account_sys.service;

import java.util.List;
import java.util.Map;

import www.netfour.com.account_sys.beans.AccountBean;
import www.netfour.com.msys.entity.SysUserEntity;
import www.netfour.com.pojos.Pager;

public interface AccountService {

	List<String> queryAllPerms(Long accountId);
	
	AccountBean queryByAccountName(String accountName);
	/**
	 * 单个新增账务账号
	 * @param account
	 * @return
	 */
	public int saveAccount(AccountBean account);
 
	/**
	 * 批量增加账务账号
	 * @param account
	 * @return
	 */
	
	public int saveBatchAccount(List<AccountBean> account);
	
	/**
	 * 修改账务账号
	 * @param account
	 * @return
	 */
	public int updateAccount(AccountBean account);
	/**
	 * 删除账务账号
	 * @param id
	 * @return
	 */
	public int deleteAccountById(Long id);
	
	/**
	 * 根据id来查询账务详细信息
	 * @param id
	 * @return
	 */
	public AccountBean findAccountById(Long id);
	/**
	 * 查询符合条件的所有账户账号
	 * @param map
	 * @return
	 */
	public Pager getAccountByMapToPager(Map map);
	/**
	 * 身份证、电话 查询是否有重复
	 * @param account
	 * @return
	 */
	public AccountBean findRepeatAccount(AccountBean account);
	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */
	public int deleteBatchAccount(List<AccountBean> account);
	/**
	 * 根据业务账号来查询账务账号的状态
	 * @param id
	 * @return
	 */
	public AccountBean getAccountStateByBusinessId(Long id);
}
