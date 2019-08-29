package util;

import java.io.IOException;
import java.io.StringWriter;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class MultipleLanguageTag extends SimpleTagSupport {
	ResourceReader rr = new ResourceReader(null);
	StringWriter sw = new StringWriter();
	
	public void doTag() throws JspException, IOException {
		// Thay the key bang value cua file properties
		getJspBody().invoke(sw);
		
		String key = sw.toString();
		String value = rr.getMessage(key); 
		
		JspWriter jw = getJspContext().getOut();
		jw.print(value);
	}
}
