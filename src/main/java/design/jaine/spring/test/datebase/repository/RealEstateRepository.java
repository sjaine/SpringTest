package design.jaine.spring.test.datebase.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import design.jaine.spring.test.datebase.domain.RealEstate;

@Mapper
public interface RealEstateRepository {
	public List<RealEstate> selectRealEstateList();
}
