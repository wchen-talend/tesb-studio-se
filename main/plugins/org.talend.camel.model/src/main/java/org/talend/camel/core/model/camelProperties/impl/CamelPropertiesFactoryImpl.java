/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.talend.camel.core.model.camelProperties.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.talend.camel.core.model.camelProperties.*;
import org.talend.camel.core.model.camelProperties.BeanItem;
import org.talend.camel.core.model.camelProperties.CamelProcessItem;
import org.talend.camel.core.model.camelProperties.CamelPropertiesFactory;
import org.talend.camel.core.model.camelProperties.CamelPropertiesPackage;
import org.talend.camel.core.model.camelProperties.RouteResourceItem;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class CamelPropertiesFactoryImpl extends EFactoryImpl implements CamelPropertiesFactory {
    /**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public static CamelPropertiesFactory init() {
		try {
			CamelPropertiesFactory theCamelPropertiesFactory = (CamelPropertiesFactory)EPackage.Registry.INSTANCE.getEFactory(CamelPropertiesPackage.eNS_URI);
			if (theCamelPropertiesFactory != null) {
				return theCamelPropertiesFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new CamelPropertiesFactoryImpl();
	}

    /**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public CamelPropertiesFactoryImpl() {
		super();
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case CamelPropertiesPackage.BEAN_ITEM: return createBeanItem();
			case CamelPropertiesPackage.CAMEL_PROCESS_ITEM: return createCamelProcessItem();
			case CamelPropertiesPackage.ROUTE_RESOURCE_ITEM: return createRouteResourceItem();
			case CamelPropertiesPackage.ROUTE_DOCUMENT_ITEM: return createRouteDocumentItem();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public BeanItem createBeanItem() {
		BeanItemImpl beanItem = new BeanItemImpl();
		return beanItem;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public CamelProcessItem createCamelProcessItem() {
		CamelProcessItemImpl camelProcessItem = new CamelProcessItemImpl();
		return camelProcessItem;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public RouteResourceItem createRouteResourceItem() {
		RouteResourceItemImpl routeResourceItem = new RouteResourceItemImpl();
		return routeResourceItem;
	}

    /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RouteDocumentItem createRouteDocumentItem() {
		RouteDocumentItemImpl routeDocumentItem = new RouteDocumentItemImpl();
		return routeDocumentItem;
	}

				/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public CamelPropertiesPackage getCamelPropertiesPackage() {
		return (CamelPropertiesPackage)getEPackage();
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
    @Deprecated
    public static CamelPropertiesPackage getPackage() {
		return CamelPropertiesPackage.eINSTANCE;
	}

} //CamelPropertiesFactoryImpl
