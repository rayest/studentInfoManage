# 两个短线分隔符开始
-- -------------------------------
-- --- table structure for t_user
-- -------------------------------
DROP TABLE IF EXISTS t_user;
CREATE TABLE t_user
(
  id       INT NOT NULL AUTO_INCREMENT,
  userName VARCHAR(20),
  password VARCHAR(20),
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
  gradeName VARCHAR(20),
  gradeDesc VARCHAR(20),
  PRIMARY KEY (id)
)
  ENGINE = InnoDb
  DEFAULT CHARSET = utf8;