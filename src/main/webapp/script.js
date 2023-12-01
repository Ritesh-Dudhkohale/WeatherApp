let weatherCond = document.getElementById("weatherCond").innerHTML

console.log(weatherCond)

switch (weatherCond) {
	case 'Clear':
		document.getElementById("weather-img").src = "images/clear.png"
		break;
	case 'Rain':
		document.getElementById("weather-img").src = "images/rain.png"
		break;
	case 'Thunderstorm':
		document.getElementById("weather-img").src = "images/thunderstorm.png"
		break;
	case 'Snow':
		document.getElementById("weather-img").src = "images/snow.png"
		break;
	case 'Haze':
		document.getElementById("weather-img").src = "images/haze.png"
		break;
	case 'Clouds':
		document.getElementById("weather-img").src = "images/clouds.jpg"
		break;
}
