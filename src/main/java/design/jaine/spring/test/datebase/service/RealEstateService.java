package design.jaine.spring.test.datebase.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import design.jaine.spring.test.datebase.domain.RealEstate;
import design.jaine.spring.test.datebase.repository.RealEstateRepository;

@Service
public class RealEstateService {
	
	@Autowired
	private RealEstateRepository realEstateRepository;
	
	public List<RealEstate> getRealEstateList() {
		List<RealEstate> realEstateList = realEstateRepository.selectRealEstateList();
		return realEstateList;
	}
}
