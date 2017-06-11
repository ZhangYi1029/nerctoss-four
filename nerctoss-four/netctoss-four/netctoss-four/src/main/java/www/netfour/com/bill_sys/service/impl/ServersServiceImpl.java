package www.netfour.com.bill_sys.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import www.netfour.com.bill_sys.beans.ServersBean;
import www.netfour.com.bill_sys.dao.ServersDao;
import www.netfour.com.bill_sys.service.ServersService;
import www.netfour.com.pojos.Pager;

@Service
public class ServersServiceImpl implements ServersService{

	@Resource
	private ServersDao serversDaoImpl;
	
	/**
	 * 2.业务账号：服务器使用情况
	 */
	@Override
	public Pager getBusinessByNumber(Map map) {
		// TODO Auto-generated method stub
				
		Pager p = new Pager();
		int totalNumber = serversDaoImpl.serviceIpCount(map);
		List<ServersBean> list = serversDaoImpl.getBusinessByNumber(map);
		int pageNumber = (int) map.get("pageNumber");
		int pageSize = (int) map.get("pageSize");
		
		
		Long totaltime = 0l;

		
		
		//计算使用时间
		for(int i = 0;i<list.size();i ++){
		Date exitDates = list.get(i).getExittime();
		Date LoginDates = list.get(i).getLogintime();
		Long durationTime = exitDates.getTime()-LoginDates.getTime();
		Long durations = durationTime/(1000*60);
		
		//将计算的时间---放入到Bean中
		list.get(i).setDurations(durations);
		
		//System.err.println(durations+"分钟");
		
		totaltime += durations; 

		}

		
		p.setPageNumber(pageNumber);
		p.setPageSize(pageSize);
		p.setTotal(totalNumber);
		p.setRows(list);
		
		return p;
	}
}
