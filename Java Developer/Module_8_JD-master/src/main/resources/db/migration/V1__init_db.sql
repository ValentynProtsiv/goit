CREATE TABLE worker (
    ID BIGSERIAL PRIMARY KEY,
    NAME VARCHAR(1000) CHECK(LENGTH(NAME) BETWEEN 2 AND 1000) NOT NULL,
    BIRTHDAY DATE CHECK(EXTRACT(YEAR FROM BIRTHDAY) > 1900),
    LEVEL VARCHAR(100) CHECK(LEVEL IN ('TRAINEE', 'JUNIOR', 'MIDDLE', 'SENIOR')) NOT NULL,
    SALARY NUMERIC CHECK(SALARY BETWEEN 100 AND 100000)
);
CREATE TABLE client(
    ID BIGSERIAL PRIMARY KEY,
    NAME VARCHAR(100) CHECK(LENGTH(NAME) BETWEEN 2 AND 1000)
);
CREATE TABLE project(
    ID BIGSERIAL PRIMARY KEY,
    CLIENT_ID BIGINT,
    START_DATE TIMESTAMP,
    FINISH_DATE TIMESTAMP,
    FOREIGN KEY(CLIENT_ID) REFERENCES client(ID)
);
CREATE TABLE project_worker(
    PROJECT_ID BIGINT,
    WORKER_ID BIGINT,
    PRIMARY KEY (PROJECT_ID, WORKER_ID),
    FOREIGN KEY(PROJECT_ID) REFERENCES project(ID),
    FOREIGN KEY (WORKER_ID) REFERENCES worker(ID)
);