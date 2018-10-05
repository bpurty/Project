package com.capg.uas.dao;

import java.sql.Date;
import java.util.List;

import com.capg.uas.bean.Applicant;
import com.capg.uas.bean.ProgramScheduled;
import com.capg.uas.bean.Users;
import com.capg.uas.exception.UASException;

public interface IMacDao {

	Users getUserByName(String userName) throws UASException;

	List<ProgramScheduled> listPrograms() throws UASException;

	List<Applicant> findProgApplicant(String pName) throws UASException;

	int updateStatus(int aId) throws UASException;

	int assignInterview(int aId,Date doiSql) throws UASException;

	List<Applicant> viewInterviewedCandidates() throws UASException;

	int updateInterviewStatus(int intrwId) throws UASException;

	int addParticipant(int intrwId) throws UASException;

}
