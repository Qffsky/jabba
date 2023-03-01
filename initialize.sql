DROP TABLE IF EXISTS ProjectAndRolesHistory, EIDToSalaryHistory, EIDToSalaryPolicy, EIDToProjectRoles, PIDToProjectRoles;

DROP TABLE IF EXISTS EmployeeInfo, PayPolicy, Projects;

DROP TYPE IF EXISTS policyType;

CREATE TYPE policyType  AS ENUM ('title', 'role', 'experience', 'additional');

CREATE TABLE EmployeeInfo (
	EmployeeID int PRIMARY KEY,
	FullName varchar(100),
	HomeAddress varchar(100),
	Education varchar(100),
	WorkExperience interval DAY,
	JobTitle varchar(50),
	Salary integer
);

CREATE TABLE Projects (
	ProjectID int PRIMARY KEY,
	ProjectName varchar(50),
	ProjectStart timestamp NOT NULL,
	ProjectEnd timestamp
);

CREATE TABLE PayPolicy (
	PolicyID int PRIMARY KEY,
	PolicyType policyType,
	PolicyDescription jsonb
);

CREATE TABLE ProjectAndRolesHistory (
	EmployeeID int REFERENCES EmployeeInfo(EmployeeID),
	PARHistory jsonb[]
);

CREATE TABLE EIDToSalaryHistory (
	EmployeeID int REFERENCES EmployeeInfo(EmployeeID),
	SalaryHistory jsonb[]
);

CREATE TABLE EIDToSalaryPolicy (
	EmployeeID int REFERENCES EmployeeInfo(EmployeeID),
	PolicyID int[]
);

CREATE TABLE EIDToProjectRoles (
	EmployeeID int REFERENCES EmployeeInfo(EmployeeID),
	ProjectID int REFERENCES Projects(ProjectID),
	ProjectRole varchar(50),
	PRIMARY KEY(EmployeeID, ProjectID)
);

CREATE TABLE PIDToProjecTRoles (
	ProjectID int REFERENCES Projects(ProjectID),
	ProjectRoles varchar(50)[]
);







