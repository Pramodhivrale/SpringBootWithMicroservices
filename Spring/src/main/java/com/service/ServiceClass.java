package com.service;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.entity.EntityClass;
import com.repo.RepositoryInterface;
import com.req.SearchReqData;
import com.utility.EmailSender;
import com.utility.ExcelUtility;
import com.utility.PdfUtility;

import jakarta.servlet.http.HttpServletResponse;


@Service
public class ServiceClass implements ServiceInterface {

	
	
	@Autowired
	private RepositoryInterface repo;


	@Autowired
	private ExcelUtility email;

	@Autowired
	private PdfUtility pdfUtility;

	@Autowired
	private EmailSender sender;

	@Override
	public List<String> getPlanNames() {
		List<String> planNames = repo.getPlanNames();
		return planNames;
	}

	@Override
	public List<String> getPlanStatus() {
		List<String> planStatus = repo.getPlanStatus();
		return planStatus;
	}

	@Override
	public List<EntityClass> getAllData(SearchReqData searchReqData) {

		EntityClass entity = new EntityClass();

		if (null != searchReqData.getPlanName() && !"".equals(searchReqData.getPlanName())) {

			entity.setPlanName(searchReqData.getPlanName());
		}
		if (null != searchReqData.getPlanStatus() && !"".equals(searchReqData.getPlanStatus())) {
			entity.setPlanStatus(searchReqData.getPlanStatus());
		}
		if (null != searchReqData.getGender() && !"".equals(searchReqData.getGender())) {
			entity.setGender(searchReqData.getGender());
		}
		if (null != searchReqData.getPlanStartDate() && !"".equals(searchReqData.getPlanStartDate())) {
			entity.setPlanStartDate(searchReqData.getPlanStartDate());
		}
		if (null != searchReqData.getPlanEndDate() && !"".equals(searchReqData.getPlanEndDate())) {
			entity.setPlanEndDate(searchReqData.getPlanEndDate());
		}
		return repo.findAll(Example.of(entity));
	}

	@Override
	public boolean getPdf(HttpServletResponse response) throws Exception {

		List<EntityClass> all = repo.findAll();
		pdfUtility.getPdf(response, all);

		return true;

	}

	@Override
	public boolean getExcel(HttpServletResponse response) throws Exception {
		File f=new File("plans.xls");
		List<EntityClass> all = repo.findAll();
		email.genreateExcel(response, all,f);

		String subject = "test mail subject";
		String body = "<h2>Data</h2>";
		String to = "hivralepramod4@gmail.com";
		
		sender.sendMail(subject, body, to,f);
		f.delete();

	

		return true;

	}

}
