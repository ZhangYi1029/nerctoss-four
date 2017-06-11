package www.netfour.com.bill_sys.beans;

import java.io.Serializable;

import www.netfour.com.account_sys.beans.AccountBean;

/**
 * 月总账务类即账务账单类 查询1
 * 
 * @author Administrator
 *
 */
public class TotalbillBean implements Serializable {

	/**
	* 
	*/
	private static final long serialVersionUID = 6706076674982473125L;

	// 主键
	private Long totalbillId;

	// 总花费
	private double expense;

	// 哪一月
	private String month;

	// 支付方式
	private String paymethod;

	// 支付状态
	private int paystate;

	// 账务账号表---外键(查：身份信息、账务账号)
	private AccountBean accountBean;

	public TotalbillBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TotalbillBean(Long totalbillId, double expense, String month, String paymethod, int paystate,
			AccountBean accountBean) {
		super();
		this.totalbillId = totalbillId;
		this.expense = expense;
		this.month = month;
		this.paymethod = paymethod;
		this.paystate = paystate;
		this.accountBean = accountBean;
	}

	public Long getTotalbillId() {
		return totalbillId;
	}

	public void setTotalbillId(Long totalbillId) {
		this.totalbillId = totalbillId;
	}

	public double getExpense() {
		return expense;
	}

	public void setExpense(double expense) {
		this.expense = expense;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getPaymethod() {
		return paymethod;
	}

	public void setPaymethod(String paymethod) {
		this.paymethod = paymethod;
	}

	public int getPaystate() {
		return paystate;
	}

	public void setPaystate(int paystate) {
		this.paystate = paystate;
	}

	public AccountBean getAccountBean() {
		return accountBean;
	}

	public void setAccountBean(AccountBean accountBean) {
		this.accountBean = accountBean;
	}

	@Override
	public String toString() {
		return "TotalbillBean [totalbillId=" + totalbillId + ", expense=" + expense + ", month=" + month
				+ ", paymethod=" + paymethod + ", paystate=" + paystate + ", accountBean=" + accountBean + "]";
	}

}
