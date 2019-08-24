package util;

import java.util.Locale;
import java.util.ResourceBundle;

public class ResourceReader {
	private ResourceBundle rsb = null;
	private String resourceFIle = "message";
	private Locale local = null;

	public ResourceReader(Locale local) {
		if(local != null) {
			this.local = local;
		} else {
			this.local = Locale.US;
		}
		rsb = ResourceBundle.getBundle(resourceFIle, this.local);
	}

	public String getMessage(String key) {
		return rsb.getString(key);
	}
	
	public static void main(String[] args) {
		Locale lc = new Locale("vi", "VN");
		ResourceReader rd = new ResourceReader(lc);
		System.out.println( rd.getMessage("home.manage") );
	}
}
