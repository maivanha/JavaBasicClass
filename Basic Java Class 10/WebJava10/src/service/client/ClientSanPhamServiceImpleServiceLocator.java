/**
 * SanPhamServiceImpleServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package service.client;

public class ClientSanPhamServiceImpleServiceLocator extends org.apache.axis.client.Service
		implements ClientSanPhamServiceImple {

	public ClientSanPhamServiceImpleServiceLocator() {
	}

	public ClientSanPhamServiceImpleServiceLocator(org.apache.axis.EngineConfiguration config) {
		super(config);
	}

	public ClientSanPhamServiceImpleServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName)
			throws javax.xml.rpc.ServiceException {
		super(wsdlLoc, sName);
	}

	// Use to get a proxy class for SanPhamServiceImple
	private java.lang.String SanPhamServiceImple_address = "http://localhost:8080/platform_BasicWebServices/services/SanPhamServiceImple";

	public java.lang.String getSanPhamServiceImpleAddress() {
		return SanPhamServiceImple_address;
	}

	// The WSDD service name defaults to the port name.
	private java.lang.String SanPhamServiceImpleWSDDServiceName = "SanPhamServiceImple";

	public java.lang.String getSanPhamServiceImpleWSDDServiceName() {
		return SanPhamServiceImpleWSDDServiceName;
	}

	public void setSanPhamServiceImpleWSDDServiceName(java.lang.String name) {
		SanPhamServiceImpleWSDDServiceName = name;
	}

	public ClientSanPhamServiceImple getSanPhamServiceImple() throws javax.xml.rpc.ServiceException {
		java.net.URL endpoint;
		try {
			endpoint = new java.net.URL(SanPhamServiceImple_address);
		} catch (java.net.MalformedURLException e) {
			throw new javax.xml.rpc.ServiceException(e);
		}
		return getSanPhamServiceImple(endpoint);
	}

	public ClientSanPhamServiceImple getSanPhamServiceImple(java.net.URL portAddress)
			throws javax.xml.rpc.ServiceException {
		try {
			ClientSanPhamServiceImpleSoapBindingStub _stub = new ClientSanPhamServiceImpleSoapBindingStub(
					portAddress, this);
			_stub.setPortName(getSanPhamServiceImpleWSDDServiceName());
			return _stub;
		} catch (org.apache.axis.AxisFault e) {
			return null;
		}
	}

	public void setSanPhamServiceImpleEndpointAddress(java.lang.String address) {
		SanPhamServiceImple_address = address;
	}

	/**
	 * For the given interface, get the stub implementation. If this service has no
	 * port for the given interface, then ServiceException is thrown.
	 */
	public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
		try {
			if (ClientSanPhamServiceImple.class.isAssignableFrom(serviceEndpointInterface)) {
				ClientSanPhamServiceImpleSoapBindingStub _stub = new ClientSanPhamServiceImpleSoapBindingStub(
						new java.net.URL(SanPhamServiceImple_address), this);
				_stub.setPortName(getSanPhamServiceImpleWSDDServiceName());
				return _stub;
			}
		} catch (java.lang.Throwable t) {
			throw new javax.xml.rpc.ServiceException(t);
		}
		throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  "
				+ (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
	}

	/**
	 * For the given interface, get the stub implementation. If this service has no
	 * port for the given interface, then ServiceException is thrown.
	 */
	public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface)
			throws javax.xml.rpc.ServiceException {
		if (portName == null) {
			return getPort(serviceEndpointInterface);
		}
		java.lang.String inputPortName = portName.getLocalPart();
		if ("SanPhamServiceImple".equals(inputPortName)) {
			return getSanPhamServiceImple();
		} else {
			java.rmi.Remote _stub = getPort(serviceEndpointInterface);
			((org.apache.axis.client.Stub) _stub).setPortName(portName);
			return _stub;
		}
	}

	public javax.xml.namespace.QName getServiceName() {
		return new javax.xml.namespace.QName("http://serviceImpl.service", "SanPhamServiceImpleService");
	}

	private java.util.HashSet ports = null;

	public java.util.Iterator getPorts() {
		if (ports == null) {
			ports = new java.util.HashSet();
			ports.add(new javax.xml.namespace.QName("http://serviceImpl.service", "SanPhamServiceImple"));
		}
		return ports.iterator();
	}

	/**
	 * Set the endpoint address for the specified port name.
	 */
	public void setEndpointAddress(java.lang.String portName, java.lang.String address)
			throws javax.xml.rpc.ServiceException {

		if ("SanPhamServiceImple".equals(portName)) {
			setSanPhamServiceImpleEndpointAddress(address);
		} else { // Unknown Port Name
			throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
		}
	}

	/**
	 * Set the endpoint address for the specified port name.
	 */
	public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address)
			throws javax.xml.rpc.ServiceException {
		setEndpointAddress(portName.getLocalPart(), address);
	}

}
