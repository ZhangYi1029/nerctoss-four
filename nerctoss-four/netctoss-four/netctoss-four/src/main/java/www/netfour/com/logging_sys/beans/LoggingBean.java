
package www.netfour.com.logging_sys.beans;

import java.io.Serializable;
import java.util.Date;

import www.netfour.com.msys.entity.SysUserEntity;
import www.netfour.com.utils.DateUtil;

public class LoggingBean implements Serializable {
	private long logid;
	private Date content;
	private Date operatetime;
	private String loggingtime;
	private String exittingtime;
	private SysUserEntity manager;
	public LoggingBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
	

	public LoggingBean(String loggingtime, String exittingtime, SysUserEntity manager) {
		super();
		this.loggingtime = loggingtime;
		this.exittingtime = exittingtime;
		this.manager = manager;
	}






	public LoggingBean(long logid, Date content, Date operatetime, String loggingtime, String exittingtime,
			SysUserEntity manager) {
		super();
		this.logid = logid;
		this.content = content;
		this.operatetime = operatetime;
		this.loggingtime = loggingtime;
		this.exittingtime = exittingtime;
		this.manager = manager;
	}






	public String getLoggingtime() {
		
		
		
		return loggingtime;
	}

	public void setLoggingtime(String loggingtime) {
		this.loggingtime = loggingtime;
	}

	public String getExittingtime() {
		return exittingtime;
	}

	public void setExittingtime(String exittingtime) {
		this.exittingtime = exittingtime;
	}

	public long getLogid() {
		return logid;
	}

	public void setLogid(long logid) {
		this.logid = logid;
	}

	public Date getContent() {
		return content;
	}

	public void setContent(Date content) {
		
		loggingtime=DateUtil.getUtilDateString(content);
		this.content = content;
	}

	public Date getOperatetime() {
		return operatetime;
	}

	public void setOperatetime(Date operatetime) {
		exittingtime=DateUtil.getUtilDateString(operatetime);
		this.operatetime = operatetime;
	}


	@Override
	public String toString() {
		return "LoggingBean [logid=" + logid + ", content=" + content + ", operatetime=" + operatetime
				+ ", loggingtime=" + loggingtime + ", exittingtime=" + exittingtime + ", manager=" + manager + "]";
	}

	/**
	 * @return the manager
	 */
	public SysUserEntity getManager() {
		return manager;
	}

	/**
	 * @param manager the manager to set
	 */
	public void setManager(SysUserEntity manager) {
		this.manager = manager;
	}

}
