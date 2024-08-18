package design.jaine.spring.test.mvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import design.jaine.spring.test.mvc.domain.Seller;
import design.jaine.spring.test.mvc.repository.SellerRepository;

@Service
public class SellerService {
	@Autowired
	private SellerRepository sellerRepository;
	
	// 닉네임, 매너온도, 프로필 이미지 경로 전달 받고 판매자 정보 저장
	public int addSeller(String nickname
			, double temperature
			, String profileImage) {
		
		int count = sellerRepository.insertSeller(nickname, temperature, profileImage);
		
		return count;
		
	}
	
	public Seller getSeller() {
		Seller seller = sellerRepository.selectSeller();
		return seller;
	}
	
	public Seller getSellerById(int id) {
		Seller seller = sellerRepository.selectSellerById(id);
		return seller;
	}
}
