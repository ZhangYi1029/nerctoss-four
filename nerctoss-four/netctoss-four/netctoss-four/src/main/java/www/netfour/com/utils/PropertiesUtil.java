package www.netfour.com.utils;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 设置配置文件读取方法的类
 * @author Administrator
 *
 */
public class PropertiesUtil {
	public Properties getProperties(){
		Properties props = null;
		InputStream in = null;
		
		try {
			String path = this.getClass().getResource("/converters.properties").getPath();
			//空格在JAVA文件路径获取中，会变成%20
			if(path.contains("%20")){
				path = path.replace("%20", " ");
			}
			File file = new File(path);
			in = new BufferedInputStream(new FileInputStream(file));
			props = new Properties();
			props.load(in);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				in.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return props;
	}
}
