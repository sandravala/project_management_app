CREATE TABLE PROJECT (
    PROJECT_ID                 INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    PROJECT_NUMBER     VARCHAR(255),
    NAME               VARCHAR(255)  NOT NULL,
    CLIENT             VARCHAR(255)  NOT NULL,
    COORDINATOR        VARCHAR(255)  NOT NULL,
    ALIAS              VARCHAR(255)  NOT NULL,
    START_DATE         DATE,
    END_DATE           DATE,
    CONTRACT_DATE      DATE,
    ELIGIBLE_COSTS     DOUBLE PRECISION NOT NULL,
    FUNDING_RATE       DOUBLE PRECISION NOT NULL,
    GRANT_AMOUNT       DOUBLE PRECISION NOT NULL,
    INDIRECT_COST_RATE DOUBLE PRECISION NOT NULL
);

create table INVESTMENT (
                            INVESTMENT_ID                 INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
                            PROCUREMENT_TYPE VARCHAR(30),
                            NAME VARCHAR(50),
                            PLANNED_COST_AMOUNT DOUBLE PRECISION NOT NULL,
                            ACTUAL_CONTRACT_COST DOUBLE PRECISION NOT NULL,
                            FUNDING_RATE DOUBLE PRECISION NOT NULL,
                            FUNDING_AMOUNT DOUBLE PRECISION NOT NULL,
                            PROCUREMENT_DEADLINE DATE,
                            PROCUREMENT_STATE VARCHAR(30),
                            PROJECT_ID INT
);