package com.chameleonlauncher.service;

import android.content.Intent;

public class ChameleonWidgetServiceIntent extends Intent {

	/*
	 Handshake Process:
	 	1: Service generates key
	 		- Sends key and component identity to Chameleon
	 	2: Chameleon generates key and sends it to identified service explictly
	 	3: Service finalizes handshake by sending both keys back to Chameleon.
	 */
	
	
	
	/* Chameleon Remote Service Contract Actions*/
	
	//STEP 1: Request that a contract be established or refreshed
	static public final String ACTION_REQUEST_CONTRACT = "com.chameleonlauncher.registerservice.ACTION_REQUEST_CONTRACT";
	
	//STEP 2:Service generates request token and sends to Chameleon for a response token
	static public final String ACTION_SERVICE_REQUEST_REGISTER = "com.chameleonlauncher.registerservice.ACTION_SERVICE_REQUEST_REGISTER";
	
	//STEP 3: Chameleon contacts Service and sends response token and request token
	static public final String ACTION_SERVICE_REQUEST_REGISTER_CONFIRMATION = "com.chameleonlauncher.registerservice.ACTION_SERVICE_REQUEST_REGISTER_CONFIRMATION";
	
	//STEP 4: Service pass both tokens back to Chameleon to verify contract.
	static public final String ACTION_SERVICE_CONFIRM_REGISTER = "com.chameleonlauncher.registerservice.ACTION_SERVICE_CONFIRM_REGISTER";
	
	//Internal broadcast action used by RemoteServiceRegistrar tell Chameleon service has been registered and delivering credentials.
	static public final String ACTION_ADD_REGISTERED_SERVICE = "com.chameleonlauncher.registerservice.ACTION_ADD_REGISTERED_SERVICE";
	
	

	
	//Generic action for a Service sending a response to a widget
	static public final String ACTION_WIDGET_RESPONSE = "com.chameleonlauncher.ACTION_WIDGET_RESPONSE";
	
	
	
	static public final String EXTRA_RESEND_INTENTS = "com.chameleonlauncher.registerservice.EXTRA_RESEND_INTENTS";
	
	//Contract keys used to sign requests from Chameleon to a service.
	static public final String EXTRA_REQUEST_TOKEN = "com.chameleonlauncher.registerservice.EXTRA_REQUEST_TOKEN";
	static public final String EXTRA_RESPONSE_TOKEN = "com.chameleonlauncher.registerservice.EXTRA_RESPONSE_TOKEN";
	
	//Identifies the component sending the intent in contract negotiations.
	static public final String EXTRA_COMPONENT_NAME = "com.chameleonlauncher.registerservice.EXTRA_SERVICE_NAME";
	static public final String EXTRA_COMPONENT_PACKAGE_NAME = "com.chameleonlauncher.registerservice.EXTRA_SERVICE_PACKAGE_NAME";
	
	//When widget contacts a Service, this identifies the baseurl the widget was downloaded from.
	static public final String EXTRA_WIDGET_BASEURL = "com.chameleonlauncher.EXTRA_WIDGET_BASEURL";
	
	//Identifies the GUID for the widget as specified in it's manifest.
	static public final String EXTRA_WIDGET_GUID = "com.chameleonlauncher.EXTRA_WIDGET_GUID";
	
	//The Chameleon instance id of the widget that sent this intent.
	static public final String EXTRA_WIDGET_ID = "com.chameleonlauncher.EXTRA_WIDGET_ID";
	
	//A Chameleon unique id for this intent sent.
	static public final String EXTRA_WIDGET_REQUEST_ID = "com.chameleonlauncher.EXTRA_WIDGET_REQUEST_ID";
	
	//JSON data sent by the widget to the service or vice-versa.
	static public final String EXTRA_JSON_DATA = "com.chameleonlauncher.EXTRA_JSON_DATA";
	
	
	
	
	
	
	
	
	
	
	
}
