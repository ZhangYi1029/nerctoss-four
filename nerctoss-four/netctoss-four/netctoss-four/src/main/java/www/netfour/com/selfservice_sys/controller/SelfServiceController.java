package www.netfour.com.selfservice_sys.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import www.netfour.com.bill_sys.beans.BusinessbillBean;
import www.netfour.com.bill_sys.beans.TotalbillBean;
import www.netfour.com.msys.utils.ShiroUtils;
import www.netfour.com.pojos.Pager;
import www.netfour.com.selfservice_sys.beans.ServiceBean;
import www.netfour.com.selfservice_sys.service.SelfService;

@RequestMapping("/selfservice")
@RestController
public class SelfServiceController {

	@Resource
	private SelfService selfServiceImpl;

	private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM");

	@RequestMapping(value = "/getBill", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
	public Pager getMonthBill(String userId, String month) {
		Pager pager = new Pager();

		System.out.println(month + ":month");

		String nowMonth = dateFormat.format(new Date());
		Long user = 1L;
		/*if (month != null && month.equals("2017-06")) {

			user = 2L;

		}*/

		month = (month == null || month.equals("")) ? nowMonth : month;

		System.out.println(month);
		System.out.println(Long.valueOf("100"));
		System.out.println(user);
		
		Long id = ShiroUtils.getUserId();
		
		TotalbillBean buill = selfServiceImpl.getBillByMonth(2L, month);
		System.out.println(buill);
		List<TotalbillBean> rows = new ArrayList<>();

		pager.setTotal(0);
		if (buill != null) {

			pager.setTotal(1);
			rows.add(buill);

		}

		pager.setRows(rows);

		System.out.println(pager);

		return pager;

	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
	public List<BusinessbillBean> getBusinessBill(@PathVariable("id") String id) {

		System.out.println(id);
		List<BusinessbillBean> list = selfServiceImpl.getBusinessBillBeanbyBillId(Long.valueOf(id));
		System.out.println(list);

		return list;
	}

	@RequestMapping(value = "/getServerInfo/{month}/{id}", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
	public List<ServiceBean> getServiceInfo(@PathVariable("month") String month, @PathVariable("id") String id) {
		System.out.println(month + "----" + id);

		List<ServiceBean> list = selfServiceImpl.getServerInfo(month, Long.valueOf(id));

		return list;
	}

}
