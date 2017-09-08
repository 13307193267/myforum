package forums.bsth.mcj.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Listener implements HttpSessionListener, ServletContextListener, ServletRequestListener {
	
	private static Logger logger = LoggerFactory.getLogger(Listener.class); // 日志记录器
	// 创建sesion的时候被调用

	public void sessionCreated(HttpSessionEvent se) {
		HttpSession session = se.getSession();
		
		logger.info("新建的session的ID为：" + session.getId());

	}

	public void sessionDestroyed(HttpSessionEvent se) {
		HttpSession session = se.getSession();
		logger.info("销毁的session的ID为：" + session.getId());

	}

	// 加载servlet上下文的时候被调用
	public void contextDestroyed(ServletContextEvent sce) {
		ServletContext context = sce.getServletContext();
		logger.info("即将关闭：" + context.getContextPath());
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ServletContext context = sce.getServletContext();
		logger.info("项目启动 ： 添加基本静态数据到ServletContext");
		logger.info("------即将开启：" + context.getContextPath());
		context.setAttribute("base", context.getContextPath());
//		context.setAttribute("path", ConfigProperties.getProperty("path"));
	}

	// 创建request的时候被调用
	public void requestInitialized(ServletRequestEvent sre) {
		HttpServletRequest httpServletRequest = (HttpServletRequest) sre.getServletRequest();
		String url = httpServletRequest.getRequestURI();// 访问的路径
		url = httpServletRequest.getQueryString() == null ? url : (url + "?" + httpServletRequest.getQueryString());
		httpServletRequest.setAttribute("dateCreate", System.currentTimeMillis());
		logger.info("IP地址为：" + httpServletRequest.getRemoteAddr() + "请求" + url);
	}

	public void requestDestroyed(ServletRequestEvent sre) {
		HttpServletRequest httpServletRequest = (HttpServletRequest) sre.getServletRequest();
		Long time = System.currentTimeMillis() - (Long) httpServletRequest.getAttribute("dateCreate");
		logger.info(httpServletRequest.getRemoteAddr() + "请求结束，耗时：" + time + "毫秒");
	}

}