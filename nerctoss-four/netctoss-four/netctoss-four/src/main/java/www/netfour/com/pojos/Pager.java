package www.netfour.com.pojos;

/**
 * 分页的帮助类
 * @author Administrator
 *
 */



import java.util.List;
import java.util.Map;


public class Pager {
	private int total;//easyui传递的数据总页数
	private List<?> rows;//easyui传递的数据
	private int pageNumber;//显示页数
	private int pageSize;//显示的条目数
	private int totalNumber;//总的数据条目数
	private int index;
	private Map seekMap;

	public Pager() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Pager(int pageNumber, int pageSize, int totalNumber, int total, int index,
			List<?> rows, Map seekMap) {
		super();
		this.pageNumber = pageNumber;
		this.pageSize = pageSize;
		this.totalNumber = totalNumber;
		this.total = total;
		this.index = index;
		this.rows = rows;
		this.seekMap = seekMap;
	}
	public Pager(List<?> rows, int pageNumber, int pageSize, int totalNumber) {
		super();
		this.rows = rows;
		this.pageNumber = pageNumber;
		this.pageSize = pageSize;
		this.totalNumber = totalNumber;
	}
	
	

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.index = (pageNumber - 1) * this.pageSize;
		this.pageNumber = pageNumber;
	}

	public int getPageSize() {
		
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.index = (this.pageNumber - 1) * pageSize;
		this.pageSize = pageSize;
	}

	public int getTotalNumber() {
		return totalNumber;
	}

	public void setTotalNumber(int totalNumber) {
		this.total = (totalNumber % this.pageSize) == 0 ? (totalNumber / this.pageSize)
				: ((totalNumber / this.pageSize) + 1);
		this.totalNumber = totalNumber;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public List<?> getRows() {
		return rows;
	}

	public void setRows(List<?> rows) {
		this.rows = rows;
	}

	public Map getSeekMap() {
		return seekMap;
	}

	public void setSeekMap(Map seekMap) {
		this.seekMap = seekMap;
	}

	@Override
	public String toString() {
		return "Page [total=" + total + ", rows=" + rows + ", pageNumber=" + pageNumber + ", pageSize=" + pageSize
				+ ", totalNumber=" + totalNumber + ", index=" + index + ", seekMap=" + seekMap + "]";
	}

}	
	
