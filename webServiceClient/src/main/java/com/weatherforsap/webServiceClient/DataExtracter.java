package com.weatherforsap.webServiceClient;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

public class DataExtracter {
	public static Data getLocalWeatherDataFromXml(String xml) throws Exception {
		Data location = null;
		InputStream is = new ByteArrayInputStream(xml.getBytes());
		JAXBContext jaxbContext = JAXBContext.newInstance(Data.class);
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		location = (Data) jaxbUnmarshaller.unmarshal(is);
		return location;
	}
	
	///////////////////////////////////////////////////////////////////
	// Here is some classes I got from WorldWeatherOnline examples.
	///////////////////////////////////////////////////////////////////
	@XmlRootElement(namespace = "com.example.javawwo.LocalWeather.Data")
	@XmlAccessorType( XmlAccessType.FIELD )
	static class Weather {
	    String date;
	    String tempMaxC;
	    String tempMaxF;
	    String tempMinC;
	    String tempMinF;
	    String windspeedMiles;
	    String windspeedKmph;
	    String winddirection;
	    String weatherCode;
	    String weatherIconUrl;
	    String weatherDesc;
	    String precipMM;
	    Weather() {}
	}
	
	@XmlRootElement(namespace = "com.example.javawwo.LocalWeather.Data")
	@XmlAccessorType( XmlAccessType.FIELD )
	static class CurrentCondition {
	    String observation_time;
	    String temp_C;
	    String weatherCode;
	    String weatherIconUrl;
	    String weatherDesc;
	    String windspeedMiles;
	    String windspeedKmph;
	    String winddirDegree;
	    String winddir16Point;
	    String precipMM;
	    String humidity;
	    String visibility;
	    String pressure;
	    String cloudcover;
	    CurrentCondition() {}
	}
	
	@XmlRootElement(namespace = "com.example.javawwo.LocalWeather.Data")
	@XmlAccessorType( XmlAccessType.FIELD )
	static class Request {
		String type;
		String query;
		Request() {};
	}
	
	@XmlRootElement
	@XmlAccessorType( XmlAccessType.FIELD )
	static class Data {
		Request request;
		CurrentCondition current_condition;
		Weather weather;
		Data() {}
	}
}
