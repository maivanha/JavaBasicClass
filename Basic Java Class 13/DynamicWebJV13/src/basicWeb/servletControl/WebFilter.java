package basicWeb.servletControl;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class WebFilter
 */
@javax.servlet.annotation.WebFilter("/*")
public class WebFilter implements Filter {

    /**
     * Default constructor. 
     */
    public WebFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest servLetRequest = ((HttpServletRequest)request);
		if(servLetRequest.getSession().getAttribute("seletedLang") == null) 
			servLetRequest.getSession().setAttribute("seletedLang", "vi_VN");
		
		System.out.println("\n\n\n\n>>>> Change langauge");
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
