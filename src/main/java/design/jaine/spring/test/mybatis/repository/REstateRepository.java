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
}