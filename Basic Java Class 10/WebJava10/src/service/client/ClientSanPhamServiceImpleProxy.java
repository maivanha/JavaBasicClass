package service.client;

public class ClientSanPhamServiceImpleProxy implements ClientSanPhamServiceImple {
	private String _endpoint = null;
	private ClientSanPhamServiceImple sanPhamServiceImple = null;

	public ClientSanPhamServiceImpleProxy() {
		_initSanPhamServiceImpleProxy();
	}

	public ClientSanPhamServiceImpleProxy(String endpoint) {
		_endpoint = endpoint;
		_initSanPhamServiceImpleProxy();
	}

	private void _initSanPhamServiceImpleProxy() {
		try {
			sanPhamServiceImple = (new ClientSanPhamServiceImpleServiceLocator())
					.getSanPhamServiceImple();
			if (sanPhamServiceImple != null) {
				if (_endpoint != null)
					((javax.xml.rpc.Stub) sanPhamServiceImple)._setProperty("javax.xml.rpc.service.endpoint.address",
							_endpoint);
				else
					_endpoint = (String) ((javax.xml.rpc.Stub) sanPhamServiceImple)
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
		if (sanPhamServiceImple != null)
			((javax.xml.rpc.Stub) sanPhamServiceImple)._setProperty("javax.xml.rpc.service.endpoint.address",
					_endpoint);

	}

	public ClientSanPhamServiceImple getSanPhamServiceImple() {
		if (sanPhamServiceImple == null)
			_initSanPhamServiceImpleProxy();
		return sanPhamServiceImple;
	}

	public java.lang.String getAllSanPham() throws java.rmi.RemoteException {
		if (sanPhamServiceImple == null)
			_initSanPhamServiceImpleProxy();
		return sanPhamServiceImple.getAllSanPham();
	}

	public model.SanPham getSanPham(int id) throws java.rmi.RemoteException {
		if (sanPhamServiceImple == null)
			_initSanPhamServiceImpleProxy();
		return sanPhamServiceImple.getSanPham(id);
	}

}