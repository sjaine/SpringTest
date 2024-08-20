package design.jaine.spring.test.thymeleaf.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import design.jaine.spring.test.thymeleaf.domain.Weather;
import design.jaine.spring.test.thymeleaf.repository.WeatherRepository;

@Service
public class WeatherService {
	@Autowired
	private WeatherRepository weatherRepository;
	
	public List<Weather> getWeather() {
		List<Weather> weatherList = weatherRepository.selectWeather();
		return weatherList;
	}
	
	public int addWeather(
				LocalDate date
				, String weather
				, String microDust
				, double temperatures
				, double precipitation
				, double windSpeed
			) {
		int count = weatherRepository.insertWeather(date, weather, microDust, temperatures, precipitation, windSpeed);
		return count;
	}
}
