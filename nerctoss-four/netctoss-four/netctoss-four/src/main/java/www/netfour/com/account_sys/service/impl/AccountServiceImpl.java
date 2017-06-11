package www.netfour.com.account_sys.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import www.netfour.com.account_sys.beans.AccountBean;
import www.netfour.com.account_sys.dao.AccountDao;
import www.netfour.com.account_sys.service.AccountService;
import www.netfour.com.business_sys.dao.BusinessDao;
import www.netfour.com.pojos.Pager;
@Service
public class AccountServiceImpl implements AccountService {
	@Resource
	private AccountDao accountDaoImpl;
	@Resource
	private BusinessDao businessDaoImpl;

	@Override
	public int saveAccount(AccountBean account) {
		// TODO Auto-generated method stub
		return accountDaoImpl.saveAccount(account);
	}

	@Override
	public int saveBatchAccount(List<AccountBean> account) {
		// TODO Auto-generated method stub
		return accountDaoImpl.saveBatchAccount(account);
	}
	@Override
	public int updateAccount(AccountBean account) {
		// TODO Auto-generated method stub
		if(account.getState().equals("暂停")){
			businessDaoImpl.updateBusinessStateByAccountId(account.getId());
		}
		return accountDaoImpl.updateAccount(account);
	}

	@Override
	public int deleteAccountById(Long id) {
		// TODO Auto-generated method stub
		return accountDaoImpl.deleteAccountById(id);
	}

	
	@Override
	public AccountBean findAccountById(Long id) {
		// TODO Auto-generated method stub
		return accountDaoImpl.findAccountById(id);
	}

	@Override
	public Pager getAccountByMapToPager(Map map) {
		// TODO Auto-generated method stub
		Pager pager=new Pager();
		int totalNumber=accountDaoImpl.countAccountByMapToPager(map);
		
		pager.setTotal(totalNumber);
		List<?> list=accountDaoImpl.getAccountByMapToPager(map);
		
		int pageSize = (int) map.get("pageSize");
		
		int pageNumber = (int) map.get("pageNumber");
		
		pager.setPageSize(pageSize);
		pager.setPageNumber(pageNumber);
		
		pager.setRows(list);
		return pager;
	}

	@Override
	public AccountBean findRepeatAccount(AccountBean account) {
		// TODO Auto-generated method stub
		return accountDaoImpl.findRepeatAccount(account);
	}

	@Override
	public int deleteBatchAccount(List<AccountBean> account) {
		// TODO Auto-generated method stub
		return accountDaoImpl.deleteBatchAccount(account);
	}

	@Override
	public AccountBean getAccountStateByBusinessId(Long id) {
		// TODO Auto-generated method stub
		return accountDaoImpl.getAccountStateByBusinessId(id);
	}

	@Override
	public List<String> queryAllPerms(Long accountId) {
		// TODO Auto-generated method stub
		return accountDaoImpl.queryAllPerms(accountId);
	}

	@Override
	public AccountBean queryByAccountName(String accountName) {
		// TODO Auto-generated method stub
		return accountDaoImpl.queryByAccountName(accountName);
	}

	

}
