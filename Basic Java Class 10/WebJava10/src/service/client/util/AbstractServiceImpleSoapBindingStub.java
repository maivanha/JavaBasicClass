package service.client.util;

import java.util.Vector;

import javax.xml.namespace.QName;

import org.apache.axis.client.Stub;

public class AbstractServiceImpleSoapBindingStub extends Stub implements GenericServiceClient{
	private Vector cachedSerClasses = new java.util.Vector();
	private Vector cachedSerQNames = new java.util.Vector();
	private Vector cachedSerFactories = new java.util.Vector();
	private Vector cachedDeserFactories = new java.util.Vector();

	static org.apache.axis.description.OperationDesc[] _operations;

	static {
		_operations = new org.apache.axis.description.OperationDesc[2];
		_initOperationDesc1();
	}

	private static void _initOperationDesc1() {
		org.apache.axis.description.OperationDesc oper;
		org.apache.axis.description.ParameterDesc param;
		oper = new org.apache.axis.description.OperationDesc();
		oper.setName("getAllSanPham");
		oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
		oper.setReturnClass(java.lang.String.class);
		oper.setReturnQName(new javax.xml.namespace.QName("http://serviceImpl.service", "getAllSanPhamReturn"));
		oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
		oper.setUse(org.apache.axis.constants.Use.LITERAL);
		_operations[0] = oper;

		oper = new org.apache.axis.description.OperationDesc();
		oper.setName("getSanPham");
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName("http://serviceImpl.service", "id"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
		oper.addParameter(param);
		oper.setReturnType(new javax.xml.namespace.QName("http://model", "SanPham"));
		oper.setReturnClass(model.SanPham.class);
		oper.setReturnQName(new javax.xml.namespace.QName("http://serviceImpl.service", "getSanPhamReturn"));
		oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
		oper.setUse(org.apache.axis.constants.Use.LITERAL);
		_operations[1] = oper;

	}

	public AbstractServiceImpleSoapBindingStub() throws org.apache.axis.AxisFault {
		this(null);
	}

	public AbstractServiceImpleSoapBindingStub(java.net.URL endpointURL, javax.xml.rpc.Service service)
			throws org.apache.axis.AxisFault {
		this(service);
		super.cachedEndpoint = endpointURL;
	}

	public AbstractServiceImpleSoapBindingStub(javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
		if (service == null) {
			super.service = new org.apache.axis.client.Service();
		} else {
			super.service = service;
		}
		((org.apache.axis.client.Service) super.service).setTypeMappingVersion("1.2");
		Class cls;
		QName qName;
		QName qName2;
		Class beansf = org.apache.axis.encoding.ser.BeanSerializerFactory.class;
		Class beandf = org.apache.axis.encoding.ser.BeanDeserializerFactory.class;
		Class enumsf = org.apache.axis.encoding.ser.EnumSerializerFactory.class;
		Class enumdf = org.apache.axis.encoding.ser.EnumDeserializerFactory.class;
		Class arraysf = org.apache.axis.encoding.ser.ArraySerializerFactory.class;
		Class arraydf = org.apache.axis.encoding.ser.ArrayDeserializerFactory.class;
		Class simplesf = org.apache.axis.encoding.ser.SimpleSerializerFactory.class;
		Class simpledf = org.apache.axis.encoding.ser.SimpleDeserializerFactory.class;
		Class simplelistsf = org.apache.axis.encoding.ser.SimpleListSerializerFactory.class;
		Class simplelistdf = org.apache.axis.encoding.ser.SimpleListDeserializerFactory.class;
		qName = new javax.xml.namespace.QName("http://model", "SanPham");
		cachedSerQNames.add(qName);
		cls = model.SanPham.class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(beansf);
		cachedDeserFactories.add(beandf);

	}

	protected org.apache.axis.client.Call createCall() throws java.rmi.RemoteException {
		try {
			org.apache.axis.client.Call _call = super._createCall();
			if (super.maintainSessionSet) {
				_call.setMaintainSession(super.maintainSession);
			}
			if (super.cachedUsername != null) {
				_call.setUsername(super.cachedUsername);
			}
			if (super.cachedPassword != null) {
				_call.setPassword(super.cachedPassword);
			}
			if (super.cachedEndpoint != null) {
				_call.setTargetEndpointAddress(super.cachedEndpoint);
			}
			if (super.cachedTimeout != null) {
				_call.setTimeout(super.cachedTimeout);
			}
			if (super.cachedPortName != null) {
				_call.setPortName(super.cachedPortName);
			}
			java.util.Enumeration keys = super.cachedProperties.keys();
			while (keys.hasMoreElements()) {
				java.lang.String key = (java.lang.String) keys.nextElement();
				_call.setProperty(key, super.cachedProperties.get(key));
			}
			// All the type mapping information is registered
			// when the first call is made.
			// The type mapping information is actually registered in
			// the TypeMappingRegistry of the service, which
			// is the reason why registration is only needed for the first call.
			synchronized (this) {
				if (firstCall()) {
					// must set encoding style before registering serializers
					_call.setEncodingStyle(null);
					for (int i = 0; i < cachedSerFactories.size(); ++i) {
						Class cls = (Class) cachedSerClasses.get(i);
						javax.xml.namespace.QName qName = (javax.xml.namespace.QName) cachedSerQNames.get(i);
						java.lang.Object x = cachedSerFactories.get(i);
						if (x instanceof Class) {
							Class sf = (Class) cachedSerFactories.get(i);
							Class df = (Class) cachedDeserFactories.get(i);
							_call.registerTypeMapping(cls, qName, sf, df, false);
						} else if (x instanceof javax.xml.rpc.encoding.SerializerFactory) {
							org.apache.axis.encoding.SerializerFactory sf = (org.apache.axis.encoding.SerializerFactory) cachedSerFactories
									.get(i);
							org.apache.axis.encoding.DeserializerFactory df = (org.apache.axis.encoding.DeserializerFactory) cachedDeserFactories
									.get(i);
							_call.registerTypeMapping(cls, qName, sf, df, false);
						}
					}
				}
			}
			return _call;
		} catch (java.lang.Throwable _t) {
			throw new org.apache.axis.AxisFault("Failure trying to get the Call object", _t);
		}
	}
}
