package design.jaine.spring.test.mvc.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import design.jaine.spring.test.mvc.domain.Seller;

@Mapper
public interface SellerRepository {
	public Seller selectSeller();
	
	public int insertSeller(
			@Param("nickname") String nickname
			, @Param("temperature") double temperature
			, @Param("profileImage") String profileImage
			);
	
	public Seller selectSellerById(@Param("id") int id);
}
