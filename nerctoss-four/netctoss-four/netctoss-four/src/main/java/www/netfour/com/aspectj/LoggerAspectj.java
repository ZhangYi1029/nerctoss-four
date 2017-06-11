package www.netfour.com.aspectj;

import java.util.Arrays;
import java.util.Date;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import www.netfour.com.logging_sys.beans.LoggingBean;
import www.netfour.com.logging_sys.service.LoggingService;
import www.netfour.com.logging_sys.service.impl.LoggingServiceImpl;
import www.netfour.com.msys.entity.SysUserEntity;
import www.netfour.com.msys.utils.ShiroUtils;
import www.netfour.com.operatelog_sys.beans.OperatelogBean;
import www.netfour.com.operatelog_sys.service.OperatelogService;
import www.netfour.com.operatelog_sys.service.impl.OperatelogServiceImpl;
import www.netfour.com.utils.DateUtil;



@Component
@Aspect
public class LoggerAspectj {
	
	private Logger logger = Logger.getLogger(this.getClass());
	
	
	private LoggingService loggingService = new LoggingServiceImpl();
	
	
	private OperatelogService operatelogService = new OperatelogServiceImpl();
	
	@Before(value="execution(* www.netfour.com.*sys.controller.*.*(..))")
	public void before(JoinPoint jp){
		if(true){
			
			Long userId = ShiroUtils.getUserId();
			
			SysUserEntity sue = new SysUserEntity();
			sue.setUserId(userId);
			
			Object[] objts = jp.getArgs();
			
			loggingService.add(new LoggingBean(DateUtil.getUtilDateString(new Date()), null, sue));
			
			operatelogService.add(new OperatelogBean(Arrays.toString(objts), new Date(), sue));
			
			
		}
		
		
	}
	
//	@AfterReturning(returning="rvt",pointcut="execution(* org.pan.springMybatis.*mag.controller.*.*(..))")
//	public void afterReturning(JoinPoint jp,Object rvt){
//		logger.info(rvt);
//		
//	}
	
//	@AfterThrowing(throwing="exe",value="execution(* org.pan.springMybatis.*mag.controller.*.*(..))")
//	public void afterThrowing(JoinPoint jp,Object exe){
//		
//	}
	
	/*@Around(value="execution(* org.pan.springMybatis.*mag.controller.*.*(..))")
	public Object aroundAdvice(ProceedingJoinPoint jp){
		
		Object obj = jp.getTarget();//目标对象
		String method = jp.getSignature().getName();//目标方法
		
		Object rvt = null;
		Object[] objts = jp.getArgs();
		try {
			rvt = jp.proceed(objts);
		} catch (Throwable e) {
			
			logger.error(obj.getClass()+"----------"+method,e);
		}
		return rvt;
		
	}*/
}
