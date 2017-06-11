package www.netfour.com.utils;

public class MonthMessager {

	private Long year;
	private Long sum;
	public MonthMessager() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MonthMessager(Long year, Long sum) {
		super();
		this.year = year;
		this.sum = sum;
	}
	public Long getYear() {
		return year;
	}
	public void setYear(Long year) {
		this.year = year;
	}
	public Long getSum() {
		return sum;
	}
	public void setSum(Long sum) {
		this.sum = sum;
	}
	@Override
	public String toString() {
		return "MonthMessager [year=" + year + ", sum=" + sum + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((sum == null) ? 0 : sum.hashCode());
		result = prime * result + ((year == null) ? 0 : year.hashCode());
		return result;
	}
	
}
