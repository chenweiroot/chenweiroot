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
		System.out.println("---����----");
		
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		log.info("����filterQ��doFilter()����");
		arg0.setCharacterEncoding("utf-8");//�����������ݵ��ַ���
		arg1.setCharacterEncoding("utf-8");//������Ӧ���ݵ��ַ���
		arg2.doFilter(arg0, arg1);  //��������������
		log.info("�˳�filterQ��doFilter()����");
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("---------��ʼ��---------");
		
	}

}
