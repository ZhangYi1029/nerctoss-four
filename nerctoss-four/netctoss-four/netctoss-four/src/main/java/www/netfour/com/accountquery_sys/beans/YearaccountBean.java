package www.netfour.com.accountquery_sys.beans;

import java.util.List;

import www.netfour.com.account_sys.beans.AccountBean;
import www.netfour.com.business_sys.beans.BusinessBean;

/**
 * 年账务类
 * @author Administrator
 *
 */
public class YearaccountBean {

	
	private Long id;//主键ID
	private Long year;//那一年
	private Long yearDuration;//该年使用的时长
	
	private AccountBean accountBean;//账务账号类
	private BusinessBean businessBean;//业务账号类

	private List<MonthaccountBean> monthaccountBean;//月账务表

	public YearaccountBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public YearaccountBean(Long id, Long year, Long yearDuration, AccountBean accountBean, BusinessBean businessBean,
			List<MonthaccountBean> monthaccountBean) {
		super();
		this.id = id;
		this.year = year;
		this.yearDuration = yearDuration;
		this.accountBean = accountBean;
		this.businessBean = businessBean;
		this.monthaccountBean = monthaccountBean;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getYear() {
		return year;
	}

	public void setYear(Long year) {
		this.year = year;
	}

	public Long getYearDuration() {
		return yearDuration;
	}

	public void setYearDuration(Long yearDuration) {
		this.yearDuration = yearDuration;
	}

	public AccountBean getAccountBean() {
		return accountBean;
	}

	public void setAccountBean(AccountBean accountBean) {
		this.accountBean = accountBean;
	}

	public BusinessBean getBusinessBean() {
		return businessBean;
	}

	public void setBusinessBean(BusinessBean businessBean) {
		this.businessBean = businessBean;
	}

	public List<MonthaccountBean> getMonthaccountBean() {
		return monthaccountBean;
	}

	public void setMonthaccountBean(List<MonthaccountBean> monthaccountBean) {
		this.monthaccountBean = monthaccountBean;
	}

	@Override
	public String toString() {
		return "YearaccountBean [id=" + id + ", year=" + year + ", yearDuration=" + yearDuration + ", accountBean="
				+ accountBean + ", businessBean=" + businessBean + ", monthaccountBean=" + monthaccountBean + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accountBean == null) ? 0 : accountBean.hashCode());
		result = prime * result + ((businessBean == null) ? 0 : businessBean.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((monthaccountBean == null) ? 0 : monthaccountBean.hashCode());
		result = prime * result + ((year == null) ? 0 : year.hashCode());
		result = prime * result + ((yearDuration == null) ? 0 : yearDuration.hashCode());
		return result;
	}

	
}
