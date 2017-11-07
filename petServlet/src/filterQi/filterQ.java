package filterQi;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.log4j.Logger;



public class filterQ implements Filter{
	private  final Logger log=Logger.getLogger(filterQ.class);
	@Override
	public void destroy() {
		System.out.println("---销毁----");
		
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		log.info("进入filterQ的doFilter()方法");
		arg0.setCharacterEncoding("utf-8");//设置请求内容的字符集
		arg1.setCharacterEncoding("utf-8");//设置响应内容的字符集
		arg2.doFilter(arg0, arg1);  //继续请求处理流程
		log.info("退出filterQ的doFilter()方法");
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("---------初始化---------");
		
	}

}
