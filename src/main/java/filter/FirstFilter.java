package filter;

import jakarta.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

public class FirstFilter implements Filter {//实现Filter接口
	FilterConfig config = null;//定义一个FilterConfig对象为类的实例变量

	public void init(FilterConfig filterConfig) throws ServletException {
		this.config = filterConfig;//获取FilterConfig对象引用
	}

	public void doFilter(ServletRequest request, ServletResponse response,
							 FilterChain chain) throws IOException, ServletException {

		String str = config.getInitParameter("course");//获取过滤器初始参数

		response.setContentType("text/html;charset=gb2312");
		request.setCharacterEncoding("gb2312");
		PrintWriter out = response.getWriter();
		out.println("<font color=blue>前置程序块<br>");
		out.println("过滤器初始参数:course=" + str + "</font><br><br>");


		chain.doFilter(request,response);//调用"过滤器链"方法

		out.println("<br><font color=blue>后置程序块</font><br>");
	}

	public void destroy() {//过滤器"销毁"方法
		config = null;
	}
}