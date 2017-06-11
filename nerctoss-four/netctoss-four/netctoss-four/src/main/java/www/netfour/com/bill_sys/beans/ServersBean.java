package www.netfour.com.bill_sys.beans;

import java.io.Serializable;
import java.util.Date;

import www.netfour.com.business_sys.beans.BusinessBean;
import www.netfour.com.expense_sys.beans.ExpenseBean;
import www.netfour.com.utils.DateUtil;

/**
 * 服务器使用情况类
 * @author Administrator
 *
 */
public class ServersBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7118650056371300264L;
	private Long id;
	private double expense;//该次花费费用
	private String ip;//服务器ip地址
	
	private String logintimes;//登录时间
	private String exittimes;//退出时间
	private Long durations;//时长
	
	public Long getDurations() {
		return durations;
	}
	public void setDurations(Long durations) {
		this.durations = durations;
	}
	public String getLogintimes() {
		return logintimes;
	}
	public void setLogintimes(String logintimes) {
		this.logintimes = logintimes;
	}
	public String getExittimes() {
		return exittimes;
	}
	public void setExittimes(String exittimes) {
		this.exittimes = exittimes;
	}
	private Date logintime;//登录时间
	private Date exittime;//退出时间
	private ExpenseBean expenseAcount;//资费表外键
	private BusinessBean business;//业务表外键
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public double getExpense() {
		return expense;
	}
	public void setExpense(double expense) {
		this.expense = expense;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public Date getLogintime() {
		return logintime;
	}
	
	
	public void setLogintime(Date logintime) {
		
		logintimes=DateUtil.getUtilDateString(logintime);
		
		this.logintime = logintime;
		
		
	}
	public Date getExittime() {
		return exittime;
	}
	
	
	public void setExittime(Date exittime) {
		
		exittimes=DateUtil.getUtilDateString(exittime);
		
		this.exittime = exittime;
	}
	
	
	public ExpenseBean getExpenseAcount() {
		return expenseAcount;
	}
	public void setExpenseAcount(ExpenseBean expenseAcount) {
		this.expenseAcount = expenseAcount;
	}
	public BusinessBean getBusiness() {
		return business;
	}
	public void setBusiness(BusinessBean business) {
		this.business = business;
	}
	@Override
	public String toString() {
		return "ServerBean [id=" + id + ", expense=" + expense + ", ip=" + ip + ", logintime=" + logintime
				+ ", exittime=" + exittime + ", expenseAcount=" + expenseAcount + ", business=" + business + "]";
	}
	public ServersBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ServersBean(Long id, double expense, String ip, Date logintime, Date exittime, ExpenseBean expenseAcount,
			BusinessBean business) {
		super();
		this.id = id;
		this.expense = expense;
		this.ip = ip;
		this.logintime = logintime;
		this.exittime = exittime;
		this.expenseAcount = expenseAcount;
		this.business = business;
	}
	
	
}
