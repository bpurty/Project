package com.capg.uas.service;

import java.util.List;

import com.capg.uas.bean.ProgramScheduled;
import com.capg.uas.exception.UASException;

public interface IApplicantService {

	List<ProgramScheduled> getAllScheduledPrograms() throws UASException;

}
