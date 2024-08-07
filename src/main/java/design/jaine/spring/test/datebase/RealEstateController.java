package design.jaine.spring.test.datebase;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import design.jaine.spring.test.datebase.domain.RealEstate;
import design.jaine.spring.test.datebase.service.RealEstateService;

@Controller
public class RealEstateController {
	
	@Autowired
	private RealEstateService realEstateService;
	
	@RequestMapping("/db/realestate/list")
	@ResponseBody
	public List<RealEstate> realEstateList() {
		List<RealEstate> realEstateList = realEstateService.getRealEstateList();
		return realEstateList;
	}
	
}
