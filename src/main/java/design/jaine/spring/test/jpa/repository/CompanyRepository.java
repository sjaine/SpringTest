package design.jaine.spring.test.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import design.jaine.spring.test.jpa.domain.Company;

public interface CompanyRepository extends JpaRepository<Company, Integer> {

}
