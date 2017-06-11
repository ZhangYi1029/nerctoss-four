package www.netfour.com.msys.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import www.netfour.com.msys.entity.SysUserEntity;
import www.netfour.com.msys.utils.ShiroUtils;

/**
 * Controller公共组件
 * 
 */
public abstract class AbstractController {
	protected Logger logger = LoggerFactory.getLogger(getClass());
	
	protected SysUserEntity getUser() {
		return ShiroUtils.getUserEntity();
	}

	protected Long getUserId() {
		return getUser().getUserId();
	}
}
