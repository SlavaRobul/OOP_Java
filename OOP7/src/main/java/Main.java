
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import sun.net.www.http.HttpClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import com.fasterxml.jackson.*;

public class Main {

    public static void main(String[] args) throws IOException {
        //Широта и долгота Санкт-Петербурга: 59.939099, 30.315877
        //Но Яндекс пишет, что это Москва
        //API выдает погоду Санкт-Петербурга

        URL url = new URL("https://api.weather.yandex.ru/v2/forecast?lat=59.939099&lon=30.315877&limit=5&hours=false&extra=false");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("X-Yandex-API-Key", "b77a7dd4-21c5-4282-ba93-820c1f9ff42b");

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        final StringBuilder content = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        //System.out.println(content.toString());

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.configure(DeserializationFeature.FAIL_ON_NUMBERS_FOR_ENUMS, false);
        WeatherInfo weatherList = objectMapper.readValue(content.toString(), WeatherInfo.class);

        for (DayInfo item: weatherList.forecasts) {
            System.out.println("В городе " + weatherList.info.tzinfo.name + " на дату " + item.date + " ожидается " + item.parts.day_short.condition + ", температура - " + item.parts.day_short.temp);
        }


    }
}

