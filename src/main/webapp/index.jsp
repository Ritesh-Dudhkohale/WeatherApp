<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Weather-App</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
	<div class="container">
		<div class="cards">
			<p id="heading">Weather Forecast</p>
			<div class="inputbox">
				<form action="/WeatherApp/GetInput" method="post">
					<input type="text" name="city_name" autofocus="autofocus"
						placeholder="Enter city name">
					<button type="submit">
						<img src="images/icon-search.png">
					</button>
				</form>
			</div>

			<div class="display-weather">
				<p id="city">${city}</p>
				<p id="date">${date}</p>
				<div>
					<img alt="" src="images/clear.png" id="weather-img">
				</div>
				<p id="weatherCond">${weatherCond}</p>
				<p id="temp">${temp}
					<span style="font-weight: 100">°C</span>
				</p>
				<div class="footer">
					<div class="footer-cards">
						<div>
							<img src="images/icon-humidity.png">
						</div>
						<div>
							<p style="font-weight: bold">Humidity</p>
							<p>${humidity}%</p>
						</div>
					</div>
					<div class="footer-cards">
						<div>
							<img src="images/icon-windspeed.png">
						</div>
						<div>
							<p style="font-weight: bold">Wind Speed</p>
							<p>${windSpeed}km/hr</p>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript" src="script.js"></script>
</body>
</html>
