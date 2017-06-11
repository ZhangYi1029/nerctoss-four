package www.netfour.com.msys.shiro;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import www.netfour.com.account_sys.beans.AccountBean;
import www.netfour.com.account_sys.service.AccountService;

public class AccountRealm extends AuthorizingRealm {
	
	@Autowired
    private AccountService accountService;
	

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		// TODO Auto-generated method stub
		AccountBean account = (AccountBean)principals.getPrimaryPrincipal();
		Long accountId = account.getId();
		
		List<String> permsList = null;
		
		permsList = accountService.queryAllPerms(accountId);

		//用户权限列表
		Set<String> permsSet = new HashSet<String>();
		for(String perms : permsList){
			if(StringUtils.isBlank(perms)){
				continue;
			}
			permsSet.addAll(Arrays.asList(perms.trim().split(",")));
		}
		
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		info.setStringPermissions(permsSet);
		return info;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token)
			throws AuthenticationException {
		// TODO Auto-generated method stub
		String accountName = (String) token.getPrincipal();
        String password = new String((char[]) token.getCredentials());
        
        System.out.println(accountName);
        
        System.out.println(password);
        
        //查询用户信息
        AccountBean account = accountService.queryByAccountName(accountName);
        System.out.println(account);
        //账号不存在
        if(account == null) {
            throw new UnknownAccountException("账号或密码不正确");
        }
        
        //密码错误
        if(!password.equals(account.getPassword())) {
            throw new IncorrectCredentialsException("账号或密码不正确");
        }
        
        //账号锁定
        if(!"开通".equals(account.getState())){
        	throw new LockedAccountException("账号已被锁定,请联系管理员");
        }
        
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(account, password, getName());
        return info;
	}

}
