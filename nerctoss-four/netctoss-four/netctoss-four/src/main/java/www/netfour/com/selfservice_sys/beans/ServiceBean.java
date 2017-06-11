package www.netfour.com.selfservice_sys.beans;

import java.io.Serializable;
import java.util.Date;

import www.netfour.com.utils.DateUtil;

public class ServiceBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6274223839404612520L;

	private String serviceIp;
	private Date loginTime;
	private Date exitTime;
	private String loginTimeStr;
	private String exitTimeStr;
	private double servcieExpense;

	public ServiceBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ServiceBean(String serviceIp, Date loginTime, Date exitTime, double servcieExpense) {
		super();
		this.serviceIp = serviceIp;
		this.loginTime = loginTime;
		this.exitTime = exitTime;
		this.servcieExpense = servcieExpense;
	}

	public String getServiceIp() {
		return serviceIp;
	}

	public void setServiceIp(String serviceIp) {
		this.serviceIp = serviceIp;
	}

	public Date getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(Date loginTime) {
		this.loginTimeStr = DateUtil.getUtilDateString(loginTime);

		this.loginTime = loginTime;
	}

	public Date getExitTime() {
		return exitTime;
	}

	public void setExitTime(Date exitTime) {
		this.exitTimeStr = DateUtil.getUtilDateString(exitTime);

		this.exitTime = exitTime;
	}

	public double getServcieExpense() {
		return servcieExpense;
	}

	public void setServcieExpense(double servcieExpense) {
		this.servcieExpense = servcieExpense;
	}

	public String getLoginTimeStr() {
		return loginTimeStr;
	}

	public void setLoginTimeStr(String loginTimeStr) {
		this.loginTimeStr = loginTimeStr;
	}

	public String getExitTimeStr() {
		return exitTimeStr;
	}

	public void setExitTimeStr(String exitTimeStr) {
		this.exitTimeStr = exitTimeStr;
	}

	@Override
	public String toString() {
		return "ServiceBean [serviceIp=" + serviceIp + ", loginTime=" + loginTime + ", exitTime=" + exitTime
				+ ", loginTimeStr=" + loginTimeStr + ", exitTimeStr=" + exitTimeStr + ", servcieExpense="
				+ servcieExpense + "]";
	}

}
