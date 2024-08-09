package design.jaine.spring.test.mybatis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import design.jaine.spring.test.mybatis.domain.REstate;
import design.jaine.spring.test.mybatis.repository.REstateRepository;

@Service
public class REstateService {
	@Autowired
	private REstateRepository rEstateRepository;
	
	public REstate getREstate(int id) {
		REstate rEstate = rEstateRepository.selectREstate(id);
		return rEstate;
	}
	
	public List<REstate> getREstateRentPrice(int rentPrice) {
		List<REstate> rEstateList = rEstateRepository.selectREstateRentPrice(rentPrice);
		return rEstateList;
	}
	
	public List<REstate> getREstateMulti(int area, int price) {
		List<REstate> rEstateList = rEstateRepository.selectREstateMulti(area, price);
		return rEstateList;
	}
	
	// 객체 insert 저장 기능
	public int addRealEstate(REstate rEstate) {
		int count = rEstateRepository.insertRealEstate(rEstate);
		return count;
	}
	
	// parameter insert 저장 기능
	public int addRealEstateByObject(
				int officeId
				,String adress
				, int area
				, String type
				, int price
				, int rentPrice
			) {
		int count = rEstateRepository.insertRealEstateByParam(officeId, adress, area, type, price, rentPrice);
		return count;
	}
	
	// 업데이트 기능
	public int updateRealEstate(int id, String type, int price) {
		int count = rEstateRepository.updateRealEstate(id, type, price);
		return count;
	}
	
	// 삭제 기능
	public int deleteRealEstate(int id) {
		int count = rEstateRepository.deleteRealEstate(id);
		return count; 
	}
}
