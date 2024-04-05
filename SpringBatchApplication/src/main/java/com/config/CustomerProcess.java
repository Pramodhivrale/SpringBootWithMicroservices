package com.config;

import org.springframework.batch.item.ItemProcessor;

import com.entity.EntityClass;

public class CustomerProcess implements ItemProcessor<EntityClass, EntityClass>
{

	@Override
	public EntityClass process(EntityClass item) throws Exception {
		
//		if (item.getGender().equals("male"))
//		{
//			return item;
//			
//		}
		
		return item;
	}
	

}
