package com.capg.uas.dao;

import java.util.List;

import com.capg.uas.bean.ProgramScheduled;
import com.capg.uas.exception.UASException;

public interface IApplicantDao {

	List<ProgramScheduled> getAllScheduledPrograms() throws UASException;

}
