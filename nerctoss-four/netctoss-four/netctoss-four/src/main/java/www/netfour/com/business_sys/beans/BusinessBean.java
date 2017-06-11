package www.netfour.com.business_sys.beans;

import java.io.Serializable;

import www.netfour.com.account_sys.beans.AccountBean;
import www.netfour.com.expense_sys.beans.ExpenseBean;

/**
 * 业务账号类
 * @author Administrator
 *
 */
public class BusinessBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5004460103322479001L;
	private Long id;
	private String number; //业务账号
	private String password;  //密码
	private String serviceIp;  //实验室ip
	private String state;      //状态
	private ExpenseBean expense;  //资费类型
	private AccountBean account;  //账务账号
	public BusinessBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BusinessBean(Long id, String number, String password, String serviceIp, String state, ExpenseBean expense,
			AccountBean account) {
		super();
		this.id = id;
		this.number = number;
		this.password = password;
		this.serviceIp = serviceIp;
		this.state = state;
		this.expense = expense;
		this.account = account;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getServiceIp() {
		return serviceIp;
	}
	public void setServiceIp(String serviceIp) {
		this.serviceIp = serviceIp;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public ExpenseBean getExpense() {
		return expense;
	}
	public void setExpense(ExpenseBean expense) {
		this.expense = expense;
	}
	public AccountBean getAccount() {
		return account;
	}
	public void setAccount(AccountBean account) {
		this.account = account;
	}
	@Override
	public String toString() {
		return "BusinessBean [id=" + id + ", number=" + number + ", password=" + password + ", serviceIp=" + serviceIp
				+ ", state=" + state + ", expense=" + expense + ", account=" + account + "]";
	}
	
	
	
}
