package www.netfour.com.operatelog_sys.mapper;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import www.netfour.com.msys.entity.SysUserEntity;
import www.netfour.com.operatelog_sys.beans.OperatelogBean;

public interface OperatelogMapper {

	@Select("select count(operateIog_id) from operateiog as  o  where    #{map.starttime}  <o.operateIog_time&&o.operateIog_time< #{map.stoptime}  ")
	public int countoperateListByMapToPager(@Param("map") Map map);

	
	
	@Select("select * from operateiog  as  o  where    #{map.starttime}  <o.operateIog_time&&o.operateIog_time< #{map.stoptime}    order by   operateIog_id   desc limit #{map.index},#{map.rows}")
	@Results({ @Result(id = true, property = "operateid", column = "operateIog_id", javaType = Long.class),
			@Result(property = "operatecontent", column = "operateIog_Content", javaType = String.class),
			@Result(property = "operatetime", column = "operateIog_time", javaType = Date.class),
	        @Result(property="mb",javaType=SysUserEntity.class,column="fk_manager_id",one=@One(fetchType=FetchType.EAGER,select="getmById"))
	})
	public List<OperatelogBean> getoperateListByMapToPager(@Param("map") Map map);

	@Select("select username from sys_user where user_id= #{id}")
	@ResultType(SysUserEntity.class)
	public SysUserEntity getmById(Long id);
	
	
	
	 @Insert("insert into operateiog (operateIog_Content, operateIog_time, fk_manager_id) values (#{ob.operatecontent},#{ob.operatetime2}, #{ob.mb.id} )" )  
	 @Options(useGeneratedKeys=true,keyProperty="ob.operateid")
	public void add(@Param("ob")OperatelogBean ob);
	
}
