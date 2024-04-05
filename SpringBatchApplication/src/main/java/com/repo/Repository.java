package com.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.entity.EntityClass;
@org.springframework.stereotype.Repository
@EnableJpaRepositories
public interface Repository extends JpaRepository<EntityClass, Integer>
{
	

}
