package www.netfour.com.totalform_sys.beans;

import java.io.Serializable;

public class LineBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3550318474097035359L;

	private String number;
	private Double expense;
	private String month;

	public LineBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LineBean(String number, Double expense, String month) {
		super();
		this.number = number;
		this.expense = expense;
		this.month = month;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Double getExpense() {
		return expense;
	}

	public void setExpense(Double expense) {
		this.expense = expense;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	@Override
	public String toString() {
		return "LineBean [number=" + number + ", expense=" + expense + ", month=" + month + "]";
	}

}
