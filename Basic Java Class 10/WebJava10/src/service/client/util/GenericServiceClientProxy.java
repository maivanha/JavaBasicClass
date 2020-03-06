package service.client.util;

public class GenericServiceClientProxy {
	private String _endpoint = null;
	private GenericServiceClient gServiceClient = null;
	
	public GenericServiceClientProxy() {
		_initSanPhamServiceImpleProxy();
	}

	public GenericServiceClientProxy(String endpoint) {
		_endpoint = endpoint;
		_initSanPhamServiceImpleProxy();
	}

	private void _initSanPhamServiceImpleProxy() {
		try {
			gServiceClient = (new AbstractServiceClientLocator()).getSanPhamServiceImple();
			if (gServiceClient != null) {
				if (_endpoint != null)
					((javax.xml.rpc.Stub) gServiceClient)._setProperty("javax.xml.rpc.service.endpoint.address",
							_endpoint);
				else
					_endpoint = (String) ((javax.xml.rpc.Stub) gServiceClient)
							._getProperty("javax.xml.rpc.service.endpoint.address");
			}

		} catch (javax.xml.rpc.ServiceException serviceException) {
		}
	}

	public String getEndpoint() {
		return _endpoint;
	}

	public void setEndpoint(String endpoint) {
		_endpoint = endpoint;
		if (gServiceClient != null)
			((javax.xml.rpc.Stub) gServiceClient)._setProperty("javax.xml.rpc.service.endpoint.address",
					_endpoint);

	}

	public GenericServiceClient getSanPhamServiceImple() {
		if (gServiceClient == null)
			_initSanPhamServiceImpleProxy();
		return gServiceClient;
	}

	/*
	 * public java.lang.String getAllSanPham() throws java.rmi.RemoteException { if
	 * (gServiceClient == null) _initSanPhamServiceImpleProxy(); return
	 * gServiceClient.getAllSanPham(); }
	 * 
	 * public model.SanPham getSanPham(int id) throws java.rmi.RemoteException { if
	 * (gServiceClient == null) _initSanPhamServiceImpleProxy(); return
	 * gServiceClient.getSanPham(id); }
	 */
}
