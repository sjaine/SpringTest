package design.jaine.spring.test.mybatis.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import design.jaine.spring.test.mybatis.domain.REstate;

@Mapper
public interface REstateRepository {
	public REstate selectREstate(@Param("id") int id);
	
	public List<REstate> selectREstateRentPrice(@Param("rentPrice") int rentPrice);
	
	public List<REstate> selectREstateMulti(@Param("area") int area, @Param("price") int price);
	
	// 객체를 insert
	public int insertRealEstate(REstate rEstate);
	
	// parameter를 insert
	public int insertRealEstateByParam(
				@Param("officeId") int officeId
				, @Param("address") String address
				, @Param("area") int area
				, @Param("type") String type
				, @Param("price") int price
				, @Param("rentPrice") int rentPrice
			);
	
	public int updateRealEstate(
			@Param("id") int id
			, @Param("type") String type
			, @Param("price") int price);
	
	public int deleteRealEstate(@Param("id") int id);
}