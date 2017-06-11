package www.netfour.com.selfservice_sys.mapper;

import java.util.List;

import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;
import org.apache.ibatis.type.JdbcType;

import www.netfour.com.account_sys.beans.AccountBean;
import www.netfour.com.bill_sys.beans.BusinessbillBean;
import www.netfour.com.bill_sys.beans.TotalbillBean;
import www.netfour.com.business_sys.beans.BusinessBean;
import www.netfour.com.selfservice_sys.beans.ServiceBean;

public interface SelfServiceMapper {

	
	
	@Select(value="select *  from totalbill  where #{mont}=totalbill_month  and #{userId}=fk_account_id " )
	@Results({
			@Result(id=true,property="totalbillId",jdbcType=JdbcType.BIGINT,column="totalbill_id",javaType=Long.class),
			@Result(property="expense",column="totalbill_expense",javaType=Double.class),
			@Result(property="month",column="totalbill_month",javaType=String.class),
			@Result(property="paymethod",column="totalbill_paymethod",javaType=String.class),
			@Result(property="paystate",column="totalbill_paystate",javaType=Integer.class),
			@Result(property="accountBean",column="fk_account_id",one=@One(fetchType=FetchType.EAGER,select="getBillAccountBean") )
	})
	public TotalbillBean getBillByMonth(@Param("userId")Long userId,@Param("mont")String mont);
	
	
	@Select(value="select account_name as name ,account_number as number from  account where account_id =#{id}")
	@ResultType(AccountBean.class)
	public AccountBean getBillAccountBean(@Param("id") Long id );
	
	@Select(value="select businessbill_id as businessbillId,businessbill_duration as duration ,businessbill_expense as expense ,fk_business_id  from businessbill  where  #{id} =fk_totalbill_id ")
	@Results({
			@Result(id=true,property="businessbillId",column="businessbill_id",javaType=Long.class),
			@Result(property="duration",column="businessbill_duration",javaType=Integer.class),
			@Result(property="expense",column="businessbill_expense",javaType=Double.class),
			@Result(property="businessBean",column="fk_business_id",one=@One(fetchType=FetchType.EAGER,select="getBusinessByBusinessId"))
	})
	public List<BusinessbillBean> getBusinessBillBeanbyBillId(@Param("id") Long id);
	

	@Select(value="select  business_id as id ,business_number as  number from business where business_id =#{id}")
	@ResultType(BusinessBean.class)
	public BusinessBean getBusinessByBusinessId(@Param("id") Long id);
	
	
	
	@Select(value="select s.server_ip as serviceIp , s.server_logintime as loginTime ,s.server_exittime as  exitTime , s.server_expense as servcieExpense from `server` as s  where  s.server_exittime  like CONCAT(#{month},'%') and s.fk_business_id =#{businessId}")
	@ResultType(ServiceBean.class)
	public List<ServiceBean> getServerInfo(@Param("month") String month,@Param("businessId")Long businessId);
	
}
