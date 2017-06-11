package www.netfour.com.expense_sys.beans;

import java.io.Serializable;

/**
 * 资费类
 * @author Administrator
 *
 */
public class ExpenseBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3037407325267086782L;
	private Long id;
	private String name;//资费名字
	private int duration;//基本时长
	private double price;//基本花费
	private String introduce;//资费介绍
	private String type;//资费种类
	private double unitPrice;//单位花费
	private String state;//资费状态（开通或暂停）

	public ExpenseBean(Long id, String name, int duration, double price, String introduce, String type,
			double unitPrice, String state) {
		super();
		this.id = id;
		this.name = name;
		this.duration = duration;
		this.price = price;
		this.introduce = introduce;
		this.type = type;
		this.unitPrice = unitPrice;
		this.state = state;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "ExpenseBean [id=" + id + ", name=" + name + ", duration=" + duration + ", price=" + price
				+ ", introduce=" + introduce + ", type=" + type + ", unitPrice=" + unitPrice + ", state=" + state + "]";
	}
	public ExpenseBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ExpenseBean(Long id, String name, int duration, double price, String introduce, String type,
			double unitPrice) {
		super();
		this.id = id;
		this.name = name;
		this.duration = duration;
		this.price = price;
		this.introduce = introduce;
		this.type = type;
		this.unitPrice = unitPrice;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
	
	
}
