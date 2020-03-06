package service.client.util;

import java.util.HashSet;
import java.util.Iterator;

import javax.xml.namespace.QName;

import org.apache.axis.EngineConfiguration;
import org.apache.axis.client.Service;

import service.client.ClientSanPhamServiceImple;
import service.client.ClientSanPhamServiceImpleSoapBindingStub;

public abstract class AbstractServiceClientLocator extends Service implements GenericServiceClient {
	// Use to get a proxy class for SanPhamServiceImple
	private String serviceImple_address = "http://localhost:8080/platform_BasicWebServices/services/SanPhamServiceImple";
	// The WSDD service name defaults to the port name.
	private String serviceImpleWSDDServiceName = "SanPhamServiceImple";
	// The namespace URI
	private String nameSpaceURI = "http://serviceImpl.service";

	/**
	 * Example:
	 * http://localhost:8080/platform_BasicWebServices/services/SanPhamServiceImple
	 * 
	 * @return serviceImple_address
	 */
	public abstract String getServiceAddress();

	/**
	 * Example: SanPhamServiceImple
	 * 
	 * @return serviceImpleWSDDServiceName
	 */
	public abstract String getServiceWSDDServiceName();

	/**
	 * Example: http://serviceImpl.service
	 * 
	 * @return nameSpaceURI
	 */
	public abstract String getNameSpaceURI();

	private void setServiceInfo() {
		this.serviceImple_address = getServiceImpleAddress();
		this.serviceImpleWSDDServiceName = getServiceImpleWSDDServiceName();
		this.nameSpaceURI = getNameSpaceURI();
	}

	private HashSet ports = null;

	public AbstractServiceClientLocator() {
		setServiceInfo();
	}

	public AbstractServiceClientLocator(EngineConfiguration config) {
		super(config);
		setServiceInfo();
	}

	public AbstractServiceClientLocator(String wsdlLoc, QName sName) throws javax.xml.rpc.ServiceException {
		super(wsdlLoc, sName);
		setServiceInfo();
	}

	public java.lang.String getServiceImpleAddress() {
		return serviceImple_address;
	}

	public java.lang.String getServiceImpleWSDDServiceName() {
		return serviceImpleWSDDServiceName;
	}

	public void setServiceImpleWSDDServiceName(java.lang.String name) {
		serviceImpleWSDDServiceName = name;
	}

	public GenericServiceClient getSanPhamServiceImple() throws javax.xml.rpc.ServiceException {
		java.net.URL endpoint;
		try {
			endpoint = new java.net.URL(serviceImple_address);
		} catch (java.net.MalformedURLException e) {
			throw new javax.xml.rpc.ServiceException(e);
		}
		return getServiceImple(endpoint);
	}

	public GenericServiceClient getServiceImple(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
		try {
			AbstractServiceImpleSoapBindingStub _stub = new AbstractServiceImpleSoapBindingStub(portAddress, this);
			_stub.setPortName(getServiceImpleWSDDServiceName());
			return _stub;
		} catch (org.apache.axis.AxisFault e) {
			return null;
		}
	}

	public void setSanPhamServiceImpleEndpointAddress(java.lang.String address) {
		serviceImple_address = address;
	}

	/**
	 * For the given interface, get the stub implementation. If this service has no
	 * port for the given interface, then ServiceException is thrown.
	 */
	public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
		try {
			if (GenericServiceClient.class.isAssignableFrom(serviceEndpointInterface)) {
				AbstractServiceImpleSoapBindingStub _stub = new AbstractServiceImpleSoapBindingStub(new java.net.URL(serviceImple_address), this);
				_stub.setPortName(getServiceImpleWSDDServiceName());
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

	public QName getServiceName() {
		return new QName(this.nameSpaceURI, serviceImpleWSDDServiceName + "Service");
	}

	public Iterator getPorts() {
		if (ports == null) {
			ports = new HashSet();
			ports.add(new QName(this.nameSpaceURI, serviceImpleWSDDServiceName));
		}
		return ports.iterator();
	}

	/**
	 * Set the endpoint address for the specified port name.
	 */
	public void setEndpointAddress(java.lang.String portName, java.lang.String address)
			throws javax.xml.rpc.ServiceException {

		if (serviceImpleWSDDServiceName.equals(portName)) {
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
