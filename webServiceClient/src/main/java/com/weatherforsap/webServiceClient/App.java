package com.weatherforsap.webServiceClient;


/**
 * Gets the weather from World Weather Online
 */
public class App
{
	public final static void main(String[] args) {
        computeWeather("LaRochelle", "fr");
        computeWeather("Capri", "it");
        computeWeather("Dublin", "ie");
        computeWeather("St.Johnsbury", "us");
    }
	
	public static void computeWeather(String city, String country){
		try {
			String xmlData = DataGetter.getXmlData(city, country);
			DataExtracter.Data data = DataExtracter.getLocalWeatherDataFromXml(xmlData);
			System.out.println("City : "+city);
			System.out.println("current temperature (celsius) : "+data.current_condition.temp_C);
			System.out.println("sky condition : "+data.current_condition.weatherDesc);
			System.out.println("humidity : "+data.current_condition.humidity);
		} catch (Exception e) {
			System.out.println("Can't get "+city+","+country+" weather informations.");
			e.printStackTrace();
		}
		System.out.println("---------------");
	}
}
