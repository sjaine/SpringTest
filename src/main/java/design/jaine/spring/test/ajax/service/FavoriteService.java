package design.jaine.spring.test.ajax.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import design.jaine.spring.test.ajax.domain.Favorite;
import design.jaine.spring.test.ajax.repository.FavoriteRepository;

@Service
public class FavoriteService {
	@Autowired
	private FavoriteRepository favoriteRepository;
	
	public List<Favorite> getFavorite() {
		List<Favorite> favoriteList = favoriteRepository.selectFavorite();
		return favoriteList;
	}
	
	public int addFavorite(String name, String url) {
		
		int count = favoriteRepository.insertFavorite(name, url);
		return count;
		
	}
	
	// 여부 체크
	public boolean isDuplicateUrl(String url) {
		int count = favoriteRepository.checkDuplicate(url);
		
		return count != 0;
	}
	
	public int deleteFavoriteById(int id) {
		int count = favoriteRepository.deleteFavorite(id);
		return count;
	}
}
