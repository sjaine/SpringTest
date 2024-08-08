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
}
