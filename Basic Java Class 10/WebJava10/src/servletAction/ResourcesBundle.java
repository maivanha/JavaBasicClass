package servletAction;

import java.util.Locale;
import java.util.ResourceBundle;

public class ResourcesBundle {
	private ResourceBundle rsb = null;
	private String rsFile = "ApplicationResources";
	private Locale local = null;
	
	public ResourcesBundle(Locale local) {
		if(local != null) {
			this.local = local;
		}else {
			
		}
	}
}
