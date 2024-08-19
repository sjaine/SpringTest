package design.jaine.spring.test.thymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WeatherController {
	@GetMapping("/weather/info")
	public String weatherInfo() {
		return "thymeleaf/weatherInfo";
	}
}
