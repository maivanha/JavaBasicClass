package util;

import java.net.MalformedURLException;
import java.net.URL;  
import javax.xml.namespace.QName;  
import javax.xml.ws.Service;

import service.SanPhamService;  

public class CallWebService {
	public static void main(String[] args) throws MalformedURLException {
		URL url = new URL("http://localhost:8080/WebJava10/services/SanPhamServiceImple?wsdl");

		// 1st argument service URI, refer to wsdl document above
		//2nd argument is service name, refer to wsdl document above  
		QName qname = new QName("http://serviceImpl.service", "SanPhamServiceImpleService");
		Service service = Service.create(url, qname);
		SanPhamService hello = service.getPort(SanPhamService.class);
		System.out.println(hello.getSanPham(1));
	}
}
