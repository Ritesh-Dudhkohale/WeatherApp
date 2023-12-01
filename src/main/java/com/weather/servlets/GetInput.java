package com.weather.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.StringReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Date;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;

@WebServlet("/GetInput")
public class GetInput extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("index.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String city = request.getParameter("city_name");

		if (city.isEmpty())  city = "India";

		String apiKey = "048b83c20de4cc1801590c1fd780ed02";

		String weatherApi = "https://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + apiKey;

		HttpRequest myRequest = HttpRequest.newBuilder().GET().uri(URI.create(weatherApi)).build();
		HttpClient client = HttpClient.newBuilder().build();

		HttpResponse<String> res = null;
		try {
			res = client.send(myRequest, HttpResponse.BodyHandlers.ofString());

		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
		String stringData = res.body();

		// converting in json
		JsonReader jsonReader = Json.createReader(new StringReader(stringData));
		JsonObject jsonData = jsonReader.readObject();

		// getting date and converting it into readable
		long timeStamp = jsonData.getJsonNumber("dt").longValue() * 1000;
		Date date = new Date(timeStamp);

		// Temparature
		double tempKn = jsonData.getJsonObject("main").getJsonNumber("temp").doubleValue();
		String tempC = String.format("%.2f", (tempKn - 273.15));

		// humidity
		int humidity = jsonData.getJsonObject("main").getJsonNumber("humidity").intValue();

		// Wind Speed
		double windSpeed = jsonData.getJsonObject("wind").getJsonNumber("speed").doubleValue();

		// weather condition
		String weatherCond = jsonData.getJsonArray("weather").get(0).asJsonObject().getString("main").toString();

		request.setAttribute("date", date);
		request.setAttribute("city", city);
		request.setAttribute("temp", tempC);
		request.setAttribute("humidity", humidity);
		request.setAttribute("windSpeed", windSpeed);
		request.setAttribute("weatherCond", weatherCond);

		request.getRequestDispatcher("index.jsp").forward(request, response);

	}
}
