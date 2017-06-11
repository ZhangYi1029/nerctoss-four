package www.netfour.com.expense_sys.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import www.netfour.com.expense_sys.beans.ServerBean;
import www.netfour.com.expense_sys.dao.ExpenseDao;
import www.netfour.com.expense_sys.dao.ServerDao;
import www.netfour.com.expense_sys.service.ServerService;

@Service
public class ServerServiceImpl implements ServerService {

	@Resource
	private ServerDao serverDaoImpl;
	@Resource
	private ExpenseDao expenseDaoImpl;
	@Override
	public void updateFee(Long id) {
		ServerBean serverBean = null;
		//根据业务账号id查出该账号下所有的使用服务器的记录
		List<ServerBean> serverList = (List<ServerBean>) serverDaoImpl.getServerBeanById(id);
		//计算每条记录的费用并更新到数据库
		for(int i=0;i<serverList.size();i++){
			//计算使用时间
			Date exitDate = serverList.get(i).getExittime();
			Date LoginDate = serverList.get(i).getLogintime();
			Long durationTime = exitDate.getTime()-LoginDate.getTime();
			Long betweenTime = durationTime/(1000*60);
			double fee = 0;
			double unitPrice=0;
			//获得资费类型
			String type = serverList.get(i).getExpenseAcount().getType();
			//获得单位时间费用:只有计时和套餐有单位时间费用，包月没有
			if("计时".equals(type)||"套餐".equals(type)){
			unitPrice = serverList.get(i).getExpenseAcount().getUnitPrice();
			}
			switch (type) {
			case "计时":
				fee = betweenTime*unitPrice;
				serverBean = serverList.get(i);
				serverBean.setExpense(fee);
				//然后调用update
				serverDaoImpl.updateFDurationFee(serverBean);
				break;
			case "套餐":
				/*套餐情况下，计算该业务账号下当月所有记录的使用时间，如果超过了套餐基本时间，超出的时间按计时算
				如果未超出，只有基本费用
				该方法中只计算出超出的费用，当月结账时，总费用=包月费+超出计时部分费用
				*/
				//duration基本时长
				int duration  = serverList.get(i).getExpenseAcount().getDuration();
				//如果超出基本时长
				if(betweenTime>duration){
					Long overTime = betweenTime-duration;
					fee = overTime*unitPrice;
					
					serverBean = serverList.get(i);
					serverBean.setExpense(fee);
					//然后调用update
					serverDaoImpl.updateFDurationFee(serverBean);
				}
				break;
			default:
				break;
			}
		}
	}
	@Override
	public List<Long> getNeedUpdateId() {
		// TODO Auto-generated method stub
		return serverDaoImpl.getNeedUpdateId();
	}
}
