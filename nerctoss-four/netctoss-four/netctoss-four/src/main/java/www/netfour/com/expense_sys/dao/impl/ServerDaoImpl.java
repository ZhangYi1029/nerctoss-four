package www.netfour.com.expense_sys.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import www.netfour.com.expense_sys.beans.ServerBean;
import www.netfour.com.expense_sys.dao.ServerDao;
import www.netfour.com.expense_sys.mapper.ServerMapper;

@Repository
public class ServerDaoImpl implements ServerDao {

	@Resource
	private ServerMapper serverMapper;

	@Override
	public int updateFDurationFee(ServerBean serverBean) {
		// TODO Auto-generated method stub
		return serverMapper.updateFDurationFee(serverBean);
	}

	@Override
	public List<ServerBean> getServerBeanById(Long id) {
		// TODO Auto-generated method stub
		return serverMapper.getServerBeanById(id);
	}

	@Override
	public List<Long> getNeedUpdateId() {
		// TODO Auto-generated method stub
		return serverMapper.getNeedUpdateId();
	}

}
