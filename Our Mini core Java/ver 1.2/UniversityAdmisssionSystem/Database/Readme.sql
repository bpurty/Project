 CREATE TABLE Programs_Offered(
 ProgramName VARCHAR2(5) PRIMARY KEY,
 description VARCHAR2(20),
 applicant_eligibility VARCHAR2(40),
 duration NUMBER,
 degree_certificate_offered VARCHAR2(10));
 
 CREATE TABLE Programs_Scheduled(
 Scheduled_program_id VARCHAR2(5) PRIMARY KEY,
 ProgramName VARCHAR2(5) REFERENCES Programs_Offered(ProgramName),
 Location VARCHAR2(10),
 start_date DATE,
 end_date DATE,
 session_per_week NUMBER); 
 
 CREATE TABLE Application(
 application_id NUMBER PRIMARY KEY,
 full_name VARCHAR2(20),
 date_of_birth DATE,
 highest_qualification VARCHAR2(10),
 marks_obtained NUMBER,
 goals VARCHAR2(20),
 email_id VARCHAR2(20),
 Scheduled_program_id VARCHAR2(5) REFERENCES Programs_Scheduled(Scheduled_program_id),
 status VARCHAR2(10) DEFAULT 'APPLIED',
 Date_Of_Interview DATE);
 
 CREATE TABLE Users(
 login_id VARCHAR2(5),
 password VARCHAR2(10),
 role VARCHAR2(5));

 CREATE TABLE Participant(
 Roll_no VARCHAR2(5) PRIMARY KEY,
 email_id VARCHAR2(20),
 application_id NUMBER REFERENCES Application(application_id),
 Scheduled_program_id VARCHAR2(5));
 
 CREATE SEQUENCE PARTICIPANT_ID START WITH 1000 ;
 
INSERT INTO Programs_Offered VALUES('MATHS','Mathematics','Graduate',2,'Masters');

INSERT INTO Programs_Scheduled VALUES('Mat','MATHS','Arizona',TO_DATE('06-11-2018',
'mm-dd-yyyy'),TO_DATE('08-11-2020','mm-dd-yyyy'),5);

INSERT INTO Application VALUES(1,'Ace',TO_DATE('06-11-1996','mm-dd-yyyy'),'Graduate'
,95,'Scientist','ace@gmail.com','Mat','Applied',NULL);
 
 
INSERT INTO Participant VALUES('1','face@gmail.com',1,'Math');

INSERT INTO Users VALUES('123','123','MAC');

INSERT INTO Users VALUES('12345','12345','Admin');



commit;