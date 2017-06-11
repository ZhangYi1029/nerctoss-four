package www.netfour.com.logging_sys.mapper;

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

import www.netfour.com.logging_sys.beans.LoggingBean;
import www.netfour.com.msys.entity.SysUserEntity;



public interface LoggingMapper {
	
    @Insert(  "insert into logging (logging_logintime, logging_exittime, fk_manager_id) values (#{lb.loggingtime},#{lb.exittingtime}, #{lb.manager.id} )" )  
    @Options(useGeneratedKeys=true,keyProperty="lb.logid")
	public void add(@Param("lb")LoggingBean lb );

    
    
	@Select("select count(logging_id) from logging as l    where  #{map.logtime} <l.logging_logintime && l.logging_exittime < #{map.exittime}    ")
	public int countUserListByMapToPager(@Param("map") Map map);

	
	
	
	@Select("select * from logging  as l   where #{map.logtime} < l.logging_logintime && l.logging_exittime < #{map.exittime}  order by l.logging_id desc limit #{map.index},#{map.rows}")
	@Results({ @Result(id = true, property = "logid", column = "logging_id", javaType = Long.class),
			@Result(property = "content", column = "logging_logintime", javaType = Date.class),
			@Result(property = "operatetime", column = "logging_exittime", javaType = Date.class),
	       @Result(property="manager",javaType=SysUserEntity.class,column="fk_manager_id",one=@One(fetchType=FetchType.EAGER,select="getmangerById"))
	})
	public List<LoggingBean> getUserListByMapToPager(@Param("map") Map map);

	
	
	
	@Select("select username from sys_user where user_id= #{id}")
	@ResultType(SysUserEntity.class)
	public SysUserEntity getmangerById(Long id);

	
	
}
	
	
	
	

