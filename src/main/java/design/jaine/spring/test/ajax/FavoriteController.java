package design.jaine.spring.test.ajax;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import design.jaine.spring.test.ajax.domain.Favorite;
import design.jaine.spring.test.ajax.service.FavoriteService;

@Controller
@RequestMapping("/ajax/favorite")
public class FavoriteController {
	@Autowired
	private FavoriteService favoriteService;
	
	@GetMapping("/info")
	public String favoriteInfo(Model model) {
		List<Favorite> favoriteList = favoriteService.getFavorite();
		
		model.addAttribute("favoriteList", favoriteList);
		
		return "ajax/favoriteInfo";
	}
	
	@GetMapping("/input")
	public String favoriteInput() {
		return "ajax/favoriteInput";
	}
	
	@PostMapping("/create")
	@ResponseBody
	public Map<String, String> createFavorite(
				@RequestParam("name") String name
				, @RequestParam("url") String url
			) {
		
		int count = favoriteService.addFavorite(name, url);
		
		Map<String, String> resultMap = new HashMap<>();
		
		if(count == 1) {
			resultMap.put("result", "success");
		} else {
			resultMap.put("result", "fail");
		}
		
		return resultMap;
	}
	
	@PostMapping("/duplicateCheck")
	@ResponseBody
	public Map<String, Boolean> isDuplicate(@RequestParam("url") String url) {
		boolean isDuplicate = favoriteService.isDuplicateUrl(url);
		
		Map<String, Boolean> duplicateMap = new HashMap<>();
		
		duplicateMap.put("isDuplicate", isDuplicate);
		
		return duplicateMap;
	}
	
	@GetMapping("/delete")
	@ResponseBody
	public Map<String, String> deleteFavorite(@RequestParam("id") int id) {
		int count = favoriteService.deleteFavoriteById(id);
		
		Map<String, String> deleteMap = new HashMap<>();
		
		if(count == 1) {
			deleteMap.put("deleteResult", "success");
		} else {
			deleteMap.put("deleteResult", "fail");
		}
		
		return deleteMap;
		
	}
}
