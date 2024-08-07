package design.jaine.spring.test.datebase;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
}
