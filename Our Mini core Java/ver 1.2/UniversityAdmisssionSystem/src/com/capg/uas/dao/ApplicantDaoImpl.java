package com.capg.uas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.capg.uas.bean.ProgramScheduled;
import com.capg.uas.dao.IQueryMapper;
import com.capg.uas.exception.UASException;
import  com.capg.uas.util.ConnectionProvider;

public class ApplicantDaoImpl implements IApplicantDao {

	@Override
	public List<ProgramScheduled> getAllScheduledPrograms() throws UASException {
		List<ProgramScheduled> programScheduledList = null;
		
		try (Connection con = ConnectionProvider.DEFAULT_INSTANCE.getConnection();
				PreparedStatement st = con
						.prepareStatement(IQueryMapper.LIST_SCHEDULED_PROGRAMS);) {
			/*st.setString(1, book.getBcode());
			st.setString(2, book.getTitle());
			st.setString(3, book.getStatus().toString());
			int count = st.executeUpdate();

			if (count > 0)
				bcode = book.getBcode();*/

		} catch (SQLException e) {
			//log.error(e);
			throw new UASException("Error in process");
		}
			
			
		return programScheduledList;
	}
	
}
