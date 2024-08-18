package design.jaine.spring.test.mvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import design.jaine.spring.test.mvc.domain.Realtor;
import design.jaine.spring.test.mvc.repository.RealtorRepository;

@Service
public class RealtorService {
	
	@Autowired
	private RealtorRepository realtorRepository;
	
	public int addRealtor(Realtor realtor) {
		return realtorRepository.insertRealtor(realtor);
	}
}
