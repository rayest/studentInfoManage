# 两个短线分隔符开始
-- -------------------------------
-- --- table structure for t_user
-- -------------------------------
DROP TABLE IF EXISTS t_user;
CREATE TABLE t_user
(
  id       INT NOT NULL AUTO_INCREMENT,
  userName VARCHAR(50),
  password VARCHAR(50),
  PRIMARY KEY (id)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

-- --------------------------------
-- --- table structure for t_grade
-- --------------------------------
DROP TABLE IF EXISTS t_grade;
CREATE TABLE t_grade
(
  id        INT NOT NULL AUTO_INCREMENT,
  gradeName VARCHAR(50),
  gradeDesc VARCHAR(1000),
  PRIMARY KEY (id)
)
  ENGINE = InnoDb
  DEFAULT CHARSET = utf8;

-- -------------------------------------
-- ----- table structure for t_student
-- -------------------------------------
DROP TABLE IF EXISTS t_student;
CREATE TABLE t_student
(
  id       INT NOT NULL AUTO_INCREMENT,
  stuNo    VARCHAR(20),
  stuName  VARCHAR(50),
  sex      VARCHAR(10),
  birthday DATE,
  gradeId  INT,
  email    VARCHAR(50),
  stuDesc  VARCHAR(1000),
  PRIMARY KEY (id),
  FOREIGN KEY (gradeId) REFERENCES t_grade (id)
)
  ENGINE = InnoDb
  DEFAULT CHARSET = utf8;