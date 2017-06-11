package www.netfour.com.accountquery_sys.beans;

/**
 * 日账务类
 * @author Administrator
 *
 */
public class DayaccountBean {

	private Long id;//主键 ID
	private Long day;//哪一天
	private Long dayDuration;//这一天的使用时长
	
	private MonthaccountBean monthaccountBean;//月账务表
	private YearaccountBean yearaccountBean;//年账务表

	public DayaccountBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public DayaccountBean(Long id, Long day, Long dayDuration, MonthaccountBean monthaccountBean,
			YearaccountBean yearaccountBean) {
		super();
		this.id = id;
		this.day = day;
		this.dayDuration = dayDuration;
		this.monthaccountBean = monthaccountBean;
		this.yearaccountBean = yearaccountBean;
	}

	

	public YearaccountBean getYearaccountBean() {
		return yearaccountBean;
	}



	public void setYearaccountBean(YearaccountBean yearaccountBean) {
		this.yearaccountBean = yearaccountBean;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getDay() {
		return day;
	}

	public void setDay(Long day) {
		this.day = day;
	}

	public Long getDayDuration() {
		return dayDuration;
	}

	public void setDayDuration(Long dayDuration) {
		this.dayDuration = dayDuration;
	}

	public MonthaccountBean getMonthaccountBean() {
		return monthaccountBean;
	}

	public void setMonthaccountBean(MonthaccountBean monthaccountBean) {
		this.monthaccountBean = monthaccountBean;
	}

	@Override
	public String toString() {
		return "DayaccountBean [id=" + id + ", day=" + day + ", dayDuration=" + dayDuration + ", monthaccountBean="
				+ monthaccountBean + "]";
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((day == null) ? 0 : day.hashCode());
		result = prime * result + ((dayDuration == null) ? 0 : dayDuration.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((monthaccountBean == null) ? 0 : monthaccountBean.hashCode());
		result = prime * result + ((yearaccountBean == null) ? 0 : yearaccountBean.hashCode());
		return result;
	}
	
	
}
