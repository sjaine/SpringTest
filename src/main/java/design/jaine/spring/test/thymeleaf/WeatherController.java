package design.jaine.spring.test.thymeleaf;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import design.jaine.spring.test.thymeleaf.domain.Weather;
import design.jaine.spring.test.thymeleaf.service.WeatherService;

@Controller
@RequestMapping("/thymeleaf/weather")
public class WeatherController {
	@Autowired
	private WeatherService weatherService;
	
	@GetMapping("/info")
	public String weatherInfo(Model model) {
		List<Weather> weatherList = weatherService.getWeather();
		
		model.addAttribute("weatherList", weatherList);
		
		return "thymeleaf/weatherInfo";
	}
	
	@GetMapping("/input")
	public String weatherInput(Model model) {
		return "thymeleaf/weatherInput";
	}
	
	@GetMapping("/create")
	public String weatherCreate(
				@RequestParam("date") @DateTimeFormat(pattern="yyyy년 MM월 dd일") LocalDate date
				, @RequestParam("weather") String weather
				, @RequestParam("microDust") String microDust
				, @RequestParam("temperatures") double temperatures
				, @RequestParam("precipitation") double precipitation
				, @RequestParam("windSpeed") double windSpeed
			) {
		
		weatherService.addWeather(date, weather, microDust, temperatures, precipitation, windSpeed);
		
		return "redirect:/thymeleaf/weather/info";
	}
}
