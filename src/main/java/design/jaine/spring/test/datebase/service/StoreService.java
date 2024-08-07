package design.jaine.spring.test.datebase.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import design.jaine.spring.test.datebase.domain.Store;
import design.jaine.spring.test.datebase.repository.StoreRepository;

@Service
public class StoreService {
	
	@Autowired
	private StoreRepository storeRepository;
	
	public List<Store> getStoreList() {
		List<Store> storeList = storeRepository.selectStoreList();
		return storeList;
	}
}
