package www.netfour.com.accountquery_sys.beans;

import java.util.List;

/**
 * 月账务类
 * @author Administrator
 *
 */
public class MonthaccountBean {

	private Long id;//主键id
	private Long month;//哪一月
	private Long monthDuration;//该月使用时长
	
	private YearaccountBean yearaccountBean;//年账务表
	
	private List<DayaccountBean> dayaccountBean;//日账务表

	public MonthaccountBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MonthaccountBean(Long id, Long month, Long monthDuration, YearaccountBean yearaccountBean,
			List<DayaccountBean> dayaccountBean) {
		super();
		this.id = id;
		this.month = month;
		this.monthDuration = monthDuration;
		this.yearaccountBean = yearaccountBean;
		this.dayaccountBean = dayaccountBean;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getMonth() {
		return month;
	}

	public void setMonth(Long month) {
		this.month = month;
	}

	public Long getMonthDuration() {
		return monthDuration;
	}

	public void setMonthDuration(Long monthDuration) {
		this.monthDuration = monthDuration;
	}

	public YearaccountBean getYearaccountBean() {
		return yearaccountBean;
	}

	public void setYearaccountBean(YearaccountBean yearaccountBean) {
		this.yearaccountBean = yearaccountBean;
	}

	public List<DayaccountBean> getDayaccountBean() {
		return dayaccountBean;
	}

	public void setDayaccountBean(List<DayaccountBean> dayaccountBean) {
		this.dayaccountBean = dayaccountBean;
	}

	@Override
	public String toString() {
		return "MonthaccountBean [id=" + id + ", month=" + month + ", monthDuration=" + monthDuration
				+ ", yearaccountBean=" + yearaccountBean + ", dayaccountBean=" + dayaccountBean + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dayaccountBean == null) ? 0 : dayaccountBean.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((month == null) ? 0 : month.hashCode());
		result = prime * result + ((monthDuration == null) ? 0 : monthDuration.hashCode());
		result = prime * result + ((yearaccountBean == null) ? 0 : yearaccountBean.hashCode());
		return result;
	}
	
}
