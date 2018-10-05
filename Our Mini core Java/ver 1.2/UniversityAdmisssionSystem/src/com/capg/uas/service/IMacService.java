package com.capg.uas.service;

import java.sql.Date;
import java.util.List;

import com.capg.uas.bean.Applicant;
import com.capg.uas.bean.ProgramScheduled;
import com.capg.uas.exception.UASException;

public interface IMacService {
	
	public boolean validateMac(String userName, String password) throws UASException;

	public List<ProgramScheduled> listPrograms() throws UASException;

	public List<Applicant> findProgApplicant(String pName) throws UASException;

	public int updateStatus(int aId) throws UASException;

	public int assignInterview(int aId,Date doiSql) throws UASException;

	public List<Applicant> viewInterviewedCandidates() throws UASException;

	public int updateInterviewStatus(int intrwId) throws UASException;

	public int addParticipant(int intrwId) throws UASException;

	
	 public boolean isValidDoi(String doi);
}
