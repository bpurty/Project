package com.capg.uas.service;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.capg.uas.bean.Applicant;
import com.capg.uas.bean.ProgramScheduled;
import com.capg.uas.bean.Users;
import com.capg.uas.dao.IMacDao;
import com.capg.uas.dao.MacDaoImpl;
import com.capg.uas.exception.UASException;

public class MacServiceImpl implements IMacService {

	IMacDao dao = new MacDaoImpl();

	@Override
	public boolean validateMac(String userName, String password)
			throws UASException {
		boolean validity = false;
		String role = "MAC";
		Users user = dao.getUserByName(userName);
		if (user == null)
			throw new UASException("No Such Login Id");
		else if (!password.equals(user.getPassword()))
			throw new UASException("Password Mismatch");
		else if (!role.matches(user.getRole()))
			throw new UASException("Role Mismatch");

		else
			validity = true;

		return validity;
	}

	@Override
	public List<ProgramScheduled> listPrograms() throws UASException {
		// TODO Auto-generated method stub
		return dao.listPrograms();
	}

	@Override
	public List<Applicant> findProgApplicant(String pName) throws UASException {
		return dao.findProgApplicant(pName);
	}

	@Override
	public int updateStatus(int aId) throws UASException {
		return dao.updateStatus(aId);
	}

	@Override
	public int assignInterview(int aId, Date doiSql) throws UASException {

		return dao.assignInterview(aId, doiSql);
	}

	@Override
	public List<Applicant> viewInterviewedCandidates() throws UASException {
		// TODO Auto-generated method stub
		return dao.viewInterviewedCandidates();
	}

	@Override
	public int updateInterviewStatus(int intrwId) throws UASException {
		// TODO Auto-generated method stub
		return dao.updateInterviewStatus(intrwId);
	}

	@Override
	public int addParticipant(int intrwId) throws UASException {

		return dao.addParticipant(intrwId);
	}

	@Override
	public boolean isValidDoi(String doi) {
		/*
		 * DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy"); Date date
		 * = doi; String strDate = dateFormat.format(date);
		 */
		Pattern namePattern = Pattern
				.compile("^(3[01]|[12][0-9]|0[1-9])/(1[0-2]|0[1-9])/[0-9]{4}$");
		Matcher nameMatcher = namePattern.matcher(doi);
		return nameMatcher.matches();
	}

}
