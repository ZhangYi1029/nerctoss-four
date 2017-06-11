package www.netfour.com.bill_sys.beans;

import java.io.Serializable;

import www.netfour.com.business_sys.beans.BusinessBean;

/**
 * 月业务账单类 查询2
 * 
 * @author Administrator
 *
 */
public class BusinessbillBean implements Serializable {

	/**
	* 
	*/
	private static final long serialVersionUID = -5334378529865753974L;

	// 主键
	private long businessbillId;

	// 该月该业务账号---使用时长
	private int duration;

	// 该月该业务账号---费用
	private double expense;

	// 月---总账单外键(查：资费套餐)
	private TotalbillBean totalbillBean;

	// 业务表外键(查：业务账号；资费表外键查：资费套餐)
	private BusinessBean businessBean;

	public BusinessbillBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BusinessbillBean(long businessbillId, int duration, double expense, TotalbillBean totalbillBean,
			BusinessBean businessBean) {
		super();
		this.businessbillId = businessbillId;
		this.duration = duration;
		this.expense = expense;
		this.totalbillBean = totalbillBean;
		this.businessBean = businessBean;
	}

	public long getBusinessbillId() {
		return businessbillId;
	}

	public void setBusinessbillId(long businessbillId) {
		this.businessbillId = businessbillId;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public double getExpense() {
		return expense;
	}

	public void setExpense(double expense) {
		this.expense = expense;
	}

	public TotalbillBean getTotalbillBean() {
		return totalbillBean;
	}

	public void setTotalbillBean(TotalbillBean totalbillBean) {
		this.totalbillBean = totalbillBean;
	}

	public BusinessBean getBusinessBean() {
		return businessBean;
	}

	public void setBusinessBean(BusinessBean businessBean) {
		this.businessBean = businessBean;
	}

	@Override
	public String toString() {
		return "BusinessbillBean [businessbillId=" + businessbillId + ", duration=" + duration + ", expense=" + expense
				+ ", totalbillBean=" + totalbillBean + ", businessBean=" + businessBean + "]";
	}

}
