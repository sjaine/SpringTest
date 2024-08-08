package design.jaine.spring.test.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import design.jaine.spring.test.mybatis.domain.REstate;
import design.jaine.spring.test.mybatis.service.REstateService;

@Controller
public class REstateController {

	@Autowired
	private REstateService rEstateService;
	
	@RequestMapping("/mybatis/real-estate/1")
	@ResponseBody
	public REstate rEstate(@RequestParam("id") int id) {
		REstate rEstate = rEstateService.getREstate(id);
		return rEstate;
	}
	
	@RequestMapping("/mybatis/real-estate/2")
	@ResponseBody
	public List<REstate> rEstateRentPrice(@RequestParam("rentPrice") int rentPrice) {
		List<REstate> rEstateList = rEstateService.getREstateRentPrice(rentPrice);
		return rEstateList;
	}
	
	@RequestMapping("/mybatis/real-estate/3")
	@ResponseBody
	public List<REstate> rEstateMulti(@RequestParam("area") int area, @RequestParam("price") int price) {
		List<REstate> rEstateList = rEstateService.getREstateMulti(area, price);
		return rEstateList;
	}
}
