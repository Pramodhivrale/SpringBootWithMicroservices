package com.service;

import java.util.List;
import com.req.*;

import jakarta.servlet.http.HttpServletResponse;
import com.entity.*;
public interface ServiceInterface {
	public List<String> getPlanNames();

	public List<String> getPlanStatus();

	public List<EntityClass> getAllData(SearchReqData searchReqData);

	boolean getExcel(HttpServletResponse response) throws Exception;

	boolean getPdf(HttpServletResponse response) throws Exception;

}
