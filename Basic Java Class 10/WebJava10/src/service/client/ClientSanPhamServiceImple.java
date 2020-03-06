/**
 * SanPhamServiceImple.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package service.client;

public interface ClientSanPhamServiceImple extends java.rmi.Remote {
	public java.lang.String getAllSanPham() throws java.rmi.RemoteException;

	public model.SanPham getSanPham(int id) throws java.rmi.RemoteException;
}
