package com.capg.uas.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.capg.uas.bean.Applicant;
import com.capg.uas.bean.ProgramScheduled;
import com.capg.uas.bean.Users;
import com.capg.uas.exception.UASException;
import com.capg.uas.util.ConnectionProvider;

public class MacDaoImpl implements IMacDao {

	
	public static Logger logger=Logger.getRootLogger();
	//PropertyConfigurator.configure("resources/log4j.properties");
 public MacDaoImpl() {
	
	 PropertyConfigurator.configure("resources/log4j.properties");
	}
	
	@Override
	public Users getUserByName(String userName) throws UASException {
		Users user = null;
		try (Connection con = ConnectionProvider.DEFAULT_INSTANCE
				.getConnection();
				PreparedStatement st = con
						.prepareStatement(IQueryMapper.GET_USER)) {

			st.setString(1, userName);

			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				user = new Users();
				user.setLoginId(rs.getString(1));
				user.setPassword(rs.getString(2));
				user.setRole(rs.getString(3));
			}
		} catch (SQLException e) {
			logger.error("Unable To Fetch Records");
			throw new UASException("Unable To Fetch Records");
		}
		return user;
	}

	@Override
	public List<ProgramScheduled> listPrograms() throws UASException {
		List<ProgramScheduled> programsList = null;
		try (Connection con = ConnectionProvider.DEFAULT_INSTANCE
				.getConnection();
				PreparedStatement st = con
						.prepareStatement(IQueryMapper.LIST_SCHEDULED_PROGRAMS);) {

			ResultSet rs = st.executeQuery();

			programsList = new ArrayList<ProgramScheduled>();
			while (rs.next()) {
				ProgramScheduled program = new ProgramScheduled();
				program.setScheduleProgId(rs.getString("Scheduled_program_id"));

				program.setProgName(rs.getString("ProgramName"));

				program.setLocation(rs.getString("Location"));

				program.setStart(rs.getDate("start_date"));

				program.setEnd(rs.getDate("end_date"));

				program.setSessionsPerWeek(rs.getInt("session_per_week"));

				programsList.add(program);
			}

			if (programsList.size() == 0)
				programsList = null;
		} catch (SQLException e) {
			logger.error("Unable To Fetch Programs");
			throw new UASException("Unable To Fetch Programs");
		}
		return programsList;
	}

	@Override
	public List<Applicant> findProgApplicant(String pName) throws UASException {

		List<Applicant> appList = null;
		try (Connection con = ConnectionProvider.DEFAULT_INSTANCE
				.getConnection();
				PreparedStatement st = con
						.prepareStatement(IQueryMapper.FIND_PROG_APPLICANT);) {
			st.setString(1, pName);
			ResultSet rs = st.executeQuery();

			appList = new ArrayList<Applicant>();
			while (rs.next()) {
				Applicant applicant = new Applicant();
				applicant.setAppId(rs.getInt("application_id"));
				applicant.setAppName(rs.getString("full_name"));
				applicant.setAppDOB(rs.getDate("date_of_birth"));
				applicant.setQualification(rs
						.getString("highest_qualification"));
				applicant.setMarks(rs.getInt("marks_obtained"));
				applicant.setGoals(rs.getString("goals"));
				applicant.setEmailId(rs.getString("email_id"));
				applicant.setScheduleProgId(rs
						.getString("Scheduled_program_id"));
				applicant.setStatus(rs.getString("status"));
				applicant.setDateOfInterview(rs.getDate("Date_Of_Interview"));

				appList.add(applicant);
			}

			if (appList.size() == 0)
				appList = null;
		} catch (SQLException e) {
			logger.error("Unable To Fetch Applicants");
			throw new UASException("Unable To Fetch Applicants");
		}
		return appList;
	}

	@Override
	public int updateStatus(int aId) throws UASException {
		int isDone = 0;

		try (Connection con = ConnectionProvider.DEFAULT_INSTANCE
				.getConnection();) {
			try (PreparedStatement stmt = con
					.prepareStatement(IQueryMapper.REJECT_APPLICANT_STATUS);) {

				stmt.setInt(1, aId);

				int count = stmt.executeUpdate();

				if (count > 0) {
					isDone = aId;
					con.commit();
					return isDone;
				}

			} catch (SQLException e) {
				con.rollback();
				logger.error("Unable To Complete Operation");
				throw new UASException("Unable To Complete Operation");
			}
		} catch (SQLException e) {
			logger.error("Unable To Complete Operation");
			throw new UASException("Unable To Complete Operation");
		}

		return isDone;

	}

	@Override
	public int assignInterview(int aId, Date doiSql) throws UASException {
		int isDone = 0;

		try (Connection con = ConnectionProvider.DEFAULT_INSTANCE
				.getConnection();) {
			try (PreparedStatement stmt = con
					.prepareStatement(IQueryMapper.ACCEPT_APPLICANT_STATUS);) {

				stmt.setDate(1, doiSql);
				stmt.setInt(2, aId);

				int count = stmt.executeUpdate();

				if (count > 0) {
					isDone = aId;
					con.commit();
					return isDone;
				}

			} catch (SQLException e) {
				con.rollback();
				logger.error("Unable To Complete Operation");
				throw new UASException("Unable To Complete Operation");
			}
		} catch (SQLException e) {
			logger.error("Unable To Complete Operation");
			throw new UASException("Unable To Complete Operation");
		}

		return isDone;

	}

	@Override
	public List<Applicant> viewInterviewedCandidates() throws UASException {
		List<Applicant> interviewList = null;
		try {
			try (Connection con = ConnectionProvider.DEFAULT_INSTANCE
					.getConnection();
					PreparedStatement st = con
							.prepareStatement(IQueryMapper.LIST_INTERVIEWED_CANDIDATES);) {

				ResultSet rs = st.executeQuery();

				interviewList = new ArrayList<Applicant>();
				while (rs.next()) {
					Applicant applicant = new Applicant();
					applicant.setAppId(rs.getInt("application_id"));
					applicant.setAppName(rs.getString("full_name"));
					applicant.setAppDOB(rs.getDate("date_of_birth"));
					applicant.setQualification(rs
							.getString("highest_qualification"));
					applicant.setMarks(rs.getInt("marks_obtained"));
					applicant.setGoals(rs.getString("goals"));
					applicant.setEmailId(rs.getString("email_id"));
					applicant.setScheduleProgId(rs
							.getString("Scheduled_program_id"));
					applicant.setStatus(rs.getString("status"));
					applicant.setDateOfInterview(rs
							.getDate("Date_Of_Interview"));

					interviewList.add(applicant);
				}

				if (interviewList.size() == 0)
					interviewList = null;
			} catch (SQLException e) {
				logger.error("Unable To Fetch Programs");
				throw new UASException("Unable To Fetch Programs");
			}
		} catch (Exception e) {
			logger.error("Unable To Fetch Programs");
			throw new UASException("Unable To Fetch Programs");
		}
		return interviewList;
	}

	@Override
	public int updateInterviewStatus(int intrwId) throws UASException {
		int isDone = 0;

		try (Connection con = ConnectionProvider.DEFAULT_INSTANCE
				.getConnection();) {
			try (PreparedStatement stmt = con
					.prepareStatement(IQueryMapper.CONFIRM_APPLICANT_STATUS);) {

				stmt.setInt(1, intrwId);

				int count = stmt.executeUpdate();

				if (count > 0) {
					isDone = intrwId;
					con.commit();
					return isDone;
				}

			} catch (SQLException e) {
				con.rollback();
				logger.error("Unable To Complete Operation");
				throw new UASException("Unable To Complete Operation");
			}
		} catch (SQLException e) {
			logger.error("Unable To Complete Operation");
			throw new UASException("Unable To Complete Operation");
		}

		return isDone;
	}

	@Override
	public int addParticipant(int intrwId) throws UASException {
		int isDone = 0;

		try (Connection con = ConnectionProvider.DEFAULT_INSTANCE
				.getConnection();) {
			try (PreparedStatement stmt = con
					.prepareStatement(IQueryMapper.FETCH_PARTICIPANT);) {

				stmt.setInt(1, intrwId);

				List<Applicant> interviewList = null;
				ResultSet rs = stmt.executeQuery();

				interviewList = new ArrayList<Applicant>();
				while (rs.next()) {
					Applicant applicant = new Applicant();
					applicant.setAppId(rs.getInt("application_id"));
					applicant.setAppName(rs.getString("full_name"));
					applicant.setAppDOB(rs.getDate("date_of_birth"));
					applicant.setQualification(rs
							.getString("highest_qualification"));
					applicant.setMarks(rs.getInt("marks_obtained"));
					applicant.setGoals(rs.getString("goals"));
					applicant.setEmailId(rs.getString("email_id"));
					applicant.setScheduleProgId(rs
							.getString("Scheduled_program_id"));
					applicant.setStatus(rs.getString("status"));
					applicant.setDateOfInterview(rs
							.getDate("Date_Of_Interview"));

					interviewList.add(applicant);
				}
				
				Applicant participant =interviewList.get(0);
				PreparedStatement st2 = con
						.prepareStatement(IQueryMapper.ADD_PARTICIPANT);
				st2.setString(1, participant.getEmailId());
				st2.setInt(2, participant.getAppId());
				st2.setString(3, participant.getScheduleProgId());
				int count = st2.executeUpdate();

				
				
				
				if (count > 0) {
					isDone = intrwId;
					con.commit();
					return isDone;
				}

			} catch (SQLException e) {
				con.rollback();
				logger.error("Unable To Complete Operation");
				throw new UASException("Unable To Complete Operation");
			}
		} catch (SQLException e) {
			logger.error("Unable To Complete Operation");
			throw new UASException("Unable To Complete Operation");
		}

		return isDone;
	
	}

}
