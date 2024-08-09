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
@RequestMapping("/mybatis/real-estate")
public class REstateController {

	@Autowired
	private REstateService rEstateService;
	
	@RequestMapping("select/1")
	@ResponseBody
	public REstate rEstate(@RequestParam("id") int id) {
		REstate rEstate = rEstateService.getREstate(id);
		return rEstate;
	}
	
	@RequestMapping("select/2")
	@ResponseBody
	public List<REstate> rEstateRentPrice(@RequestParam("rentPrice") int rentPrice) {
		List<REstate> rEstateList = rEstateService.getREstateRentPrice(rentPrice);
		return rEstateList;
	}
	
	@RequestMapping("select/3")
	@ResponseBody
	public List<REstate> rEstateMulti(@RequestParam("area") int area, @RequestParam("price") int price) {
		List<REstate> rEstateList = rEstateService.getREstateMulti(area, price);
		return rEstateList;
	}
	
	@RequestMapping("/create")
	@ResponseBody
	public String createRealEstate() {
		REstate rEstate = new REstate();
		rEstate.setOfficeId(3);
		rEstate.setAddress("푸르지용 리버 303동 1104호");
		rEstate.setArea(89);
		rEstate.setType("매매");
		rEstate.setPrice(100000);
		
		int count = rEstateService.addRealEstate(rEstate);
		
		return "입력 개수: " + count;
	}
	
	@RequestMapping("/createParam")
	@ResponseBody
	public String createByParameter(@RequestParam("officeId") int officeId) {
		int count = rEstateService.addRealEstateByObject(officeId, "썅떼빌리버 오피스텔 814호", 45, "월세", 100000, 120);
		return "입력 개수: " + count;
	}
	
	@RequestMapping("/update")
	@ResponseBody
	public String updateRealEstate(@RequestParam("id") int id, @RequestParam("type") String type, @RequestParam("price") int price) {
		int count = rEstateService.updateRealEstate(id, type, price);
		return "수정 성공: " + count;
	}
	
	@RequestMapping("/delete")
	@ResponseBody
	public String deleteRealEstate(@RequestParam("id") int id) {
		int count = rEstateService.deleteRealEstate(id);
		return "삭제 성공: " + count;
	}
	
}
