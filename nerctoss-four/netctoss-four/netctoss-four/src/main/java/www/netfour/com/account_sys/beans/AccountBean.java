package www.netfour.com.account_sys.beans;

import java.io.Serializable;
import java.util.List;

import www.netfour.com.business_sys.beans.BusinessBean;

/**
 * 账务账号类
 * @author Administrator
 *
 */
public class AccountBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1206834637017336685L;
	private Long id;
	private String name;   //真实性别
	private String idCard;//身份证号
	private int gender;    //性别
	private String genders;
	private String number;  //账务账号
	private String password; //密码
	private String phone;   //电话号码
	private String address;//地址
	private String qq;     //QQ
	private String postcode;//邮编
	private String paymethod;//支付方式
	private String state;//状态
	
	private List<BusinessBean> business;
	public AccountBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public AccountBean(Long id, String name, String idCard, int gender, String number, String password, String phone,
			String address, String qq, String postcode, String paymethod, String state, List<BusinessBean> business) {
		super();
		this.id = id;
		this.name = name;
		this.idCard = idCard;
		this.gender = gender;
		this.number = number;
		this.password = password;
		this.phone = phone;
		this.address = address;
		this.qq = qq;
		this.postcode = postcode;
		this.paymethod = paymethod;
		this.state = state;
		this.business = business;
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
	public String getIdCard() {
		return idCard;
	}
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		 genders=(gender==0)?"女":"男";
		this.gender = gender;
	}
	
	public String getGenders() {
		return genders;
	}

	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	public String getPaymethod() {
		return paymethod;
	}
	public void setPaymethod(String paymethod) {
		this.paymethod = paymethod;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	public List<BusinessBean> getBusiness() {
		return business;
	}

	public void setBusiness(List<BusinessBean> business) {
		this.business = business;
	}

	@Override
	public String toString() {
		return "AccountBean [id=" + id + ", name=" + name + ", idCard=" + idCard + ", gender=" + gender + ",genders=" + genders + ", number="
				+ number + ", password=" + password + ", phone=" + phone + ", address=" + address + ", qq=" + qq
				+ ", postcode=" + postcode + ", paymethod=" + paymethod + ", state=" + state + "]";
	}

	
}
