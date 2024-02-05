package com.expediteapp;


public class GetIp {
	private static String ip = "192.168.43.155/sms";
	public static String ip(){return "http://"+ip+"/Service.asmx?wsdl";}
	public static String imgStr(){return "http://"+ip+"/Images/";}
	public static String resultStr(){return "http://"+ip+"/results/";}
}


/*public class GetIp {
	private static String ip = "192.168.0.104/WebService";
	public static String ip(){return "http://"+ip+"/WebService.asmx?wsdl";}
	public static String imgStr(){return "http://"+ip+"/Images/";}
	public static String resultStr(){return "http://"+ip+"/results/";}
}*/

/*
public class GetIp {
	private static String ip = "192.168.0.104";	
	public static String ip(){return "http://"+ip+"/Expedite/Service.asmx?wsdl";}
	public static String imgStr(){return "http://"+ip+"/Expedite/Images/";}
	public static String resultStr(){return "http://"+ip+"/Expedite/results/";}
}
*/

/*

public class GetIp {
	
	private static String ip = "testm.vayuna.com";
	public static String ip(){
		return "http://"+ip+"/Service.asmx?wsdl";
	}
	public static String imgStr(){
		return "http://"+ip+"/Images/";
	}
	public static String resultStr(){
		return "http://"+ip+"/results/";
	}
}

*/