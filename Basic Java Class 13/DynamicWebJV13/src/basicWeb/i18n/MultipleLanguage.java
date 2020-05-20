package basicWeb.i18n;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class MultipleLanguage extends SimpleTagSupport {
	private String readMessage(String input, Locale local) {
		if (local == null)
			local = new Locale("vi", "VN");
		ResourceBundle rb = ResourceBundle.getBundle("message", local);
		String message = null;
		message = rb.getString(input);
		return message;
	}

	@Override
	public void doTag() throws JspException, IOException {
		StringWriter sw = new StringWriter();
		getJspBody().invoke(sw);
		String message = null;
		try {
			Locale locale = (Locale) getJspContext().findAttribute("sesLang");
			message = readMessage(sw.toString(), locale);
		} catch (Exception ex) {
			message = readMessage(sw.toString(), null);
			ex.printStackTrace();
		}
		JspWriter jw = getJspContext().getOut();
		jw.print(message);
	}
}
