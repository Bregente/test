package tutorial.global.common.util;

import javax.servlet.ServletContext;

import org.springframework.web.context.support.WebApplicationContextUtils;

public class AppCtxUtil {
    
    public static Object getBean(ServletContext servletContext, String beanName){
        return WebApplicationContextUtils.getWebApplicationContext(servletContext).getBean(beanName);
    }
}
