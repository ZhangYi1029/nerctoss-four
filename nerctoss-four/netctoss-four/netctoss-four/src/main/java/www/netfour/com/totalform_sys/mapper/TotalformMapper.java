package www.netfour.com.totalform_sys.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;

import www.netfour.com.bill_sys.beans.TotalbillBean;
import www.netfour.com.business_sys.beans.BusinessBean;
import www.netfour.com.totalform_sys.beans.LineBean;

public interface TotalformMapper {

	@Select(value = "select t.totalbill_expense as expense,t.totalbill_month  as `month`  from totalbill as t  LEFT JOIN  account as a  on t.fk_account_id=a.account_id  where  t.totalbill_month  like CONCAT(#{year},'%') and a.account_number = #{number} ")
	@ResultType(TotalbillBean.class)
	public List<TotalbillBean> getYearToralbillByYear(@Param("year") String year, @Param("number") String number);

	
	@Select(value="select b.business_id  as id  from business as b LEFT JOIN  account as a  on b.fk_accort_id=a.account_id where a.account_number=#{number}")
	@ResultType(BusinessBean.class)
	public List<BusinessBean> getAccountTheBusinessAll(@Param("number") String number);



	@Select(value="select bu.business_number as number,b.businessbill_expense as expense,t.totalbill_month as month  from businessbill as b LEFT JOIN totalbill as t  on b.fk_totalbill_id =t.totalbill_id  LEFT JOIN business as bu on b.fk_business_id=bu.business_id   where b.fk_business_id=#{businessId} and t.totalbill_month like CONCAT(#{year},'%')   ORDER BY t.totalbill_month")
	@ResultType(LineBean.class)
	public List<LineBean>  getBusinessbillListByBusinessId(@Param("year")String year ,@Param("businessId")String businessId);

	
}
