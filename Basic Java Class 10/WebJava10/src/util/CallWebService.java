package util;

import java.rmi.RemoteException;

import model.SanPham;
import service.client.ClientSanPhamServiceImpleProxy;

public class CallWebService {
	public static void main(String[] args) throws RemoteException {
		ClientSanPhamServiceImpleProxy spServiceProxy = new ClientSanPhamServiceImpleProxy();
		spServiceProxy.setEndpoint("http://localhost:8080/WebJava10/services/SanPhamServiceImple");
		SanPham sp = spServiceProxy.getSanPham(3);
		System.out.println(sp.getId() + "\t" + sp.getTen());
	}
}
