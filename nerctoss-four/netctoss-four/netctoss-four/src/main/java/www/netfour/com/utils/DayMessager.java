package www.netfour.com.utils;

public class DayMessager {

	private Long id;
	private Long sum;
	public DayMessager() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DayMessager(Long id, Long sum) {
		super();
		this.id = id;
		this.sum = sum;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getSum() {
		return sum;
	}
	public void setSum(Long sum) {
		this.sum = sum;
	}
	@Override
	public String toString() {
		return "DayMessager [id=" + id + ", sum=" + sum + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((sum == null) ? 0 : sum.hashCode());
		return result;
	}
}
