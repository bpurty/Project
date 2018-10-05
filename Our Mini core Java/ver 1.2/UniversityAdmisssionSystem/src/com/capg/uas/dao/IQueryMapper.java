package com.capg.uas.dao;

public interface IQueryMapper {
	
	public static final String LIST_SCHEDULED_PROGRAMS = "SELECT * FROM Programs_Scheduled";

	public static final String GET_USER="SELECT * FROM Users WHERE login_id=?";
	
	public static final String FIND_PROG_APPLICANT="SELECT * FROM Application WHERE Scheduled_program_id IN( Select Scheduled_program_id from Programs_Scheduled where ProgramName=?) ";
	
	public static final String REJECT_APPLICANT_STATUS="UPDATE Application SET status='REJECTED' WHERE application_id=?";
	
	public static final String LIST_INTERVIEWED_CANDIDATES = "SELECT * FROM Application WHERE status='ACCEPTED'";
	
	public static final String FETCH_PARTICIPANT="SELECT * FROM Application where application_id=? ";
	
	public static final String ADD_PARTICIPANT ="INSERT INTO PARTICIPANT VALUES (PARTICIPANT_ID.NEXTVAL,?,?,?)";
	
	public static final String CONFIRM_APPLICANT_STATUS="UPDATE Application SET status='CONFIRMED' WHERE application_id=?";
	
	public static final String ACCEPT_APPLICANT_STATUS="UPDATE Application SET status='ACCEPTED',Date_Of_Interview=? WHERE application_id=?";
	/*public static final String ADD_BOOK="INSERT INTO lmsBooks VALUES(?,?,?)";
	public static final String LIST_BOOKS="SELECT * FROM lmsBooks";
	public static final String FIND_BOOK="SELECT * FROM lmsBooks WHERE bcode=?";

	public static final String LIST_RESERVED_BOOKS="SELECT logid,lmsBooks.bcode,studid,title,resvdt FROM lmsRegister INNER JOIN lmsBooks ON lmsRegister.bcode=lmsBooks.bcode WHERE isudt IS NULL";
	public static final String LIST_ISSUED_BOOKS="SELECT logid,lmsBooks.bcode,studid,title,isudt FROM lmsRegister INNER JOIN lmsBooks ON lmsRegister.bcode=lmsBooks.bcode WHERE isudt IS NOT NULL AND rtndt IS NULL";
	public static final String FIND_ENTRY="SELECT * FROM lmsRegister WHERE logid=?";
	
	public static final String UPDATE_BOOK_STATUS="UPDATE lmsBooks SET status=? WHERE bcode=?";
	public static final String LOG_RESERVE_BOOK="INSERT INTO lmsRegister(logid,bcode,studid,resvdt) VALUES(logid_seq.nextval,?,?,?)";
	public static final String LOG_ISSUE_BOOK="UPDATE lmsRegister SET isudt=? WHERE logid=?";
	public static final String LOG_RETURN_BOOK="UPDATE lmsRegister SET rtndt=? WHERE logid=?";	*/
}
