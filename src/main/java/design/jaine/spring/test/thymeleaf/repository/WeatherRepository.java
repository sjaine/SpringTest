package design.jaine.spring.test.thymeleaf.repository;

import java.time.LocalDate;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import design.jaine.spring.test.thymeleaf.domain.Weather;

@Mapper
public interface WeatherRepository {
	public List<Weather> selectWeather();
	
	public int insertWeather(
				@Param("date") LocalDate date
				, @Param("weather") String weather
				, @Param("microDust") String microDust
				, @Param("temperatures") double temperatures
				, @Param("precipitation") double precipitation
				, @Param("windSpeed") double windSpeed
			);
}
