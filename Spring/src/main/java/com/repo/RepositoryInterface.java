package com.repo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import com.entity.EntityClass;

@Repository
public interface RepositoryInterface extends JpaRepository<EntityClass, Integer>
{
	@Query(value = "select distinct(plan_name) from `citizen-data`;",nativeQuery = true)
	public List<String> getPlanNames();
	
	@Query(value = "select distinct(plan_status) from `citizen-data`;",nativeQuery = true)
	public List<String> getPlanStatus();

}
