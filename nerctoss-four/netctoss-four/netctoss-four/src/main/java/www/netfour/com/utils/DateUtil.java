package www.netfour.com.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateUtil {


	public static java.sql.Date getSqlDate(java.util.Date utilDate) {

		return new java.sql.Date(utilDate.getTime());
	}

	public static java.sql.Date getSqlDate(String dateStr) {

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		java.sql.Date date = null;
		try {
			java.util.Date utilDate = dateFormat.parse(dateStr);
			date = new java.sql.Date(utilDate.getTime());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		return date;
	}

	public static java.util.Date getUtilDate(java.sql.Date sqlDate) {

		return new java.util.Date(sqlDate.getTime());
	}

	public static java.util.Date getUtilDate(String dateStr) {

		java.util.Date date = null;
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			date = dateFormat.parse(dateStr);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return date;
	}

	public static String getUtilDateString(java.util.Date date) {

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		return dateFormat.format(date);
	}

	public static String getSqlDateString(java.sql.Date date) {

		return date.toString();
	}

}
