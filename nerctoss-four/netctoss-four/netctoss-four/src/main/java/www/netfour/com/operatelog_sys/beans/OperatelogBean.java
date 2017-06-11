package www.netfour.com.operatelog_sys.beans;

import java.io.Serializable;
import java.util.Date;

import www.netfour.com.msys.entity.SysUserEntity;
import www.netfour.com.utils.DateUtil;

public class OperatelogBean implements Serializable {
	private long operateid;
	private String operatecontent;
	private Date operatetime;
	private String operatetime2;
    private SysUserEntity  mb;
	public long getOperateid() {
		return operateid;
	}

	public void setOperateid(long operateid) {
		this.operateid = operateid;
	}

	public String getOperatecontent() {
		return operatecontent;
	}

	public void setOperatecontent(String operatecontent) {
		this.operatecontent = operatecontent;
	}

	public Date getOperatetime() {
		return operatetime;
	}

	public void setOperatetime(Date operatetime) {
		
		operatetime2=DateUtil.getUtilDateString(operatetime);
		this.operatetime = operatetime;
	}

	public OperatelogBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	

	@Override
	public String toString() {
		return "OperatelogBean [operateid=" + operateid + ", operatecontent=" + operatecontent + ", operatetime="
				+ operatetime + ", mb=" + mb + "]";
	}

	

	public OperatelogBean(long operateid, String operatecontent, Date operatetime, SysUserEntity mb) {
		super();
		this.operateid = operateid;
		this.operatecontent = operatecontent;
		this.operatetime = operatetime;
		this.mb = mb;
	}
	
	

	public OperatelogBean(String operatecontent, Date operatetime, SysUserEntity mb) {
		super();
		this.operatecontent = operatecontent;
		this.operatetime = operatetime;
		this.mb = mb;
	}

	/**
	 * @return the mb
	 */
	public SysUserEntity getMb() {
		return mb;
	}

	/**
	 * @param mb the mb to set
	 */
	public void setMb(SysUserEntity mb) {
		this.mb = mb;
	}

	/**
	 * @return the operatetime2
	 */
	public String getOperatetime2() {
		return operatetime2;
	}

	/**
	 * @param operatetime2 the operatetime2 to set
	 */
	public void setOperatetime2(String operatetime2) {
		
		
		this.operatetime2 = operatetime2;
	}

}
