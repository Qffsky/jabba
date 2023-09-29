DROP TABLE IF EXISTS EIDToSalaryHistory, EIDToSalaryPolicy, EIDToProjectRoles;

DROP TABLE IF EXISTS EmployeeInfo, PayPolicy, Projects;

DROP TYPE IF EXISTS policyType, projectRole;

CREATE TYPE policyType  AS ENUM ('title', 'projectRole', 'experience', 'additional');
CREATE TYPE projectRole AS ENUM ('supervisor', 'analyst', 'secretary', 'expert');

CREATE TABLE EmployeeInfo (
	EmployeeID integer PRIMARY KEY,
	FullName varchar(100),
	HomeAddress varchar(100),
	Education varchar(100),
	WorkExperience interval YEAR,
	JobTitle projectRole,
	Salary integer
);

CREATE TABLE Projects (
	ProjectID integer PRIMARY KEY,
	ProjectName varchar(50),
	ProjectStart timestamp NOT NULL,
	ProjectEnd timestamp
);

CREATE TABLE PayPolicy (
	PolicyID integer PRIMARY KEY,
	PolicyType policyType,
	PolicyDescription varchar(100),
	PolicyAmount integer
);


CREATE TABLE EIDToSalaryHistory (
	EmployeeID integer REFERENCES EmployeeInfo(EmployeeID),
	SalaryHistory jsonb[]
);

CREATE TABLE EIDToSalaryPolicy (
	EmployeeID integer REFERENCES EmployeeInfo(EmployeeID),
	PolicyID integer REFERENCES PayPolicy(PolicyID)
);

CREATE TABLE EIDToProjectRoles (
	EmployeeID integer REFERENCES EmployeeInfo(EmployeeID),
	ProjectID integer REFERENCES Projects(ProjectID),
	ProjectRole projectRole,
	PRIMARY KEY(EmployeeID, ProjectID)
);





