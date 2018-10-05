package com.capg.uas.service;

import java.util.List;

import com.capg.uas.bean.ProgramScheduled;
import com.capg.uas.dao.ApplicantDaoImpl;
import com.capg.uas.dao.IApplicantDao;
import com.capg.uas.exception.UASException;

public class ApplicantServiceImpl implements IApplicantService {
	
	private IApplicantDao applicantDao;
	public ApplicantServiceImpl() {
		applicantDao = new ApplicantDaoImpl();
	}
	
	
	@Override
	public List<ProgramScheduled> getAllScheduledPrograms() throws UASException {
		return applicantDao.getAllScheduledPrograms();
	}
	
	
	
	

}
