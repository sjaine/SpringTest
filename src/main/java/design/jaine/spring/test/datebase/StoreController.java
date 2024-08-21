package design.jaine.spring.test.datebase;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import design.jaine.spring.test.datebase.domain.Review;
import design.jaine.spring.test.datebase.domain.Store;
import design.jaine.spring.test.datebase.service.StoreService;

@Controller
public class StoreController {
	
	@Autowired
	private StoreService storeService;
	
	@RequestMapping("/db/store/list")
	@ResponseBody
	public List<Store> storeList() {
		List<Store> storeList = storeService.getStoreList();
		return storeList;
	}
	
	@GetMapping("/thymeleaf/store/info")
	public String getStoreList(Model model) {
		List<Store> storeList = storeService.getStoreList();
		
		model.addAttribute("storeList", storeList);
		
		return "thymeleaf/storeInfo";
	}
	
	@GetMapping("/thymeleaf/store/review")
	public String getStoreReview(Model model) {
		List<Review> storeReview = storeService.getStoreReview();
		
		model.addAttribute("storeReview", storeReview);
		
		return "thymeleaf/storeReview";
	}
}
