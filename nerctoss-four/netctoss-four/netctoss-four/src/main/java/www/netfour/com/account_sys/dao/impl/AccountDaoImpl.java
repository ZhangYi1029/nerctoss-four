package www.netfour.com.account_sys.dao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import www.netfour.com.account_sys.beans.AccountBean;
import www.netfour.com.account_sys.dao.AccountDao;
import www.netfour.com.account_sys.mapper.AccountMapper;
@Repository
public class AccountDaoImpl implements AccountDao {
	
	@Resource
	private AccountMapper accountMapper;

	@Override
	public int saveAccount(AccountBean account) {
		// TODO Auto-generated method stub
		return accountMapper.saveAccount(account);
	}

	@Override
	public int saveBatchAccount(List<AccountBean> account) {
		// TODO Auto-generated method stub
		return accountMapper.saveBatchAccount(account);
	}
	@Override
	public int updateAccount(AccountBean account) {
		// TODO Auto-generated method stub
		return accountMapper.updateAccount(account);
	}

	@Override
	public int deleteAccountById(Long id) {
		// TODO Auto-generated method stub
		return accountMapper.deleteAccountById(id);
	}

	@Override
	public List<AccountBean> findAllAccount(String state) {
		// TODO Auto-generated method stub
		return accountMapper.findAllAccount(state);
	}

	@Override
	public AccountBean findAccountById(Long id) {
		// TODO Auto-generated method stub
		return accountMapper.findAccountById(id);
	}

	@Override
	public int countAccountByMapToPager(Map map) {
		// TODO Auto-generated method stub
		return accountMapper.countAccountByMapToPager(map);
	}

	@Override
	public List<AccountBean> getAccountByMapToPager(Map map) {
		// TODO Auto-generated method stub
		return accountMapper.getAccountByMapToPager(map);
	}

	@Override
	public AccountBean getAccountIdByNumber(String number) {
		// TODO Auto-generated method stub
		return accountMapper.getAccountIdByNumber(number);
	}

	@Override
	public AccountBean findRepeatAccount(AccountBean account) {
		// TODO Auto-generated method stub
		return accountMapper.findRepeatAccount(account);
	}

	@Override
	public int deleteBatchAccount(List<AccountBean> account){
		// TODO Auto-generated method stub
		return accountMapper.deleteBatchAccount(account);
	}

	@Override
	public AccountBean getAccountStateByBusinessId(Long id) {
		// TODO Auto-generated method stub
		return accountMapper.getAccountStateByBusinessId(id);
	}

	@Override
	public List<String> queryAllPerms(Long accountId) {
		// TODO Auto-generated method stub
		return accountMapper.queryAllPerms(accountId);
	}

	@Override
	public AccountBean queryByAccountName(String accountName) {
		// TODO Auto-generated method stub
		return accountMapper.queryByAccountName(accountName);
	}

	

}
