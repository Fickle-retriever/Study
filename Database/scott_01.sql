-- system계정접속
CONN system/1234

/*만약  scott계정이 없다면 생성하자
-- scott계정삭제
-- 주의 및 참고 : 계정이 삭제 되면 그 계정에 있는 객체(table,view,sequence등)이 삭제됨
drop user scott cascade;

-- scott계정삭제
create user  scott
identified by tiger;
*/


-- SCOTT계정에 role부여 및 비번을 tiger변경
GRANT CONNECT,RESOURCE,UNLIMITED TABLESPACE TO scott IDENTIFIED BY tiger;


-- SCOTT계정의 DEFAULT TABLESPACE와 TEMPORARY TABLESPACE설정
ALTER USER SCOTT DEFAULT TABLESPACE USERS;
ALTER USER SCOTT TEMPORARY TABLESPACE TEMP;


-- SCOTT계정접속
CONNECT scott/tiger

-- DEPT테이블 삭제
DROP TABLE DEPT;

-- DEPT테이블생성 : 부서정보
CREATE TABLE DEPT(
        DEPTNO NUMBER(2) CONSTRAINT PK_DEPT PRIMARY KEY,  --부서번호
	DNAME VARCHAR2(14) ,  --부서명
	LOC VARCHAR2(13)  --위치
 ) ;

-- EMP테이블 삭제
DROP TABLE EMP;

-- EMP테이블생성 : 사원정보
CREATE TABLE EMP(
	EMPNO NUMBER(4) CONSTRAINT PK_EMP PRIMARY KEY, --사원번호
	ENAME VARCHAR2(10),  --사원명
	JOB VARCHAR2(9), --업무
	MGR NUMBER(4), --상사의 사원번호	
	HIREDATE DATE, --입사일자
	SAL NUMBER(7,2), --급여
	COMM NUMBER(7,2), --커미션
	DEPTNO NUMBER(2) CONSTRAINT FK_DEPTNO REFERENCES DEPT --부서번호
);

-- DEPT테이블에  부서정보입력
INSERT INTO DEPT VALUES(10,'ACCOUNTING','NEW YORK');
INSERT INTO DEPT VALUES(20,'RESEARCH','DALLAS');
INSERT INTO DEPT VALUES(30,'SALES','CHICAGO');
INSERT INTO DEPT VALUES(40,'OPERATIONS','BOSTON');

-- EMP테이에 사원정보입력
INSERT INTO EMP VALUES(7369,'SMITH','CLERK',7902,to_date('17-12-1980','dd-mm-yyyy'),800,NULL,20);
INSERT INTO EMP VALUES(7499,'ALLEN','SALESMAN',7698,to_date('20-2-1981','dd-mm-yyyy'),1600,300,30);
INSERT INTO EMP VALUES(7521,'WARD','SALESMAN',7698,to_date('22-2-1981','dd-mm-yyyy'),1250,500,30);
INSERT INTO EMP VALUES(7566,'JONES','MANAGER',7839,to_date('2-4-1981','dd-mm-yyyy'),2975,NULL,20);
INSERT INTO EMP VALUES(7654,'MARTIN','SALESMAN',7698,to_date('28-9-1981','dd-mm-yyyy'),1250,1400,30);
INSERT INTO EMP VALUES(7698,'BLAKE','MANAGER',7839,to_date('1-5-1981','dd-mm-yyyy'),2850,NULL,30);
INSERT INTO EMP VALUES(7782,'CLARK','MANAGER',7839,to_date('9-6-1981','dd-mm-yyyy'),2450,NULL,10);
INSERT INTO EMP VALUES(7788,'SCOTT','ANALYST',7566,to_date('13-JUL-87')-85,3000,NULL,20);
INSERT INTO EMP VALUES(7839,'KING','PRESIDENT',NULL,to_date('17-11-1981','dd-mm-yyyy'),5000,NULL,10);
INSERT INTO EMP VALUES(7844,'TURNER','SALESMAN',7698,to_date('8-9-1981','dd-mm-yyyy'),1500,0,30);
INSERT INTO EMP VALUES(7876,'ADAMS','CLERK',7788,to_date('13-JUL-87')-51,1100,NULL,20);
INSERT INTO EMP VALUES(7900,'JAMES','CLERK',7698,to_date('3-12-1981','dd-mm-yyyy'),950,NULL,30);
INSERT INTO EMP VALUES(7902,'FORD','ANALYST',7566,to_date('3-12-1981','dd-mm-yyyy'),3000,NULL,20);
INSERT INTO EMP VALUES(7934,'MILLER','CLERK',7782, to_date('23-1-1982','dd-mm-yyyy'), 1300,NULL,10);

-- BONUS테이블 삭제
DROP TABLE BONUS;

-- BONUS테이블 생성
CREATE TABLE BONUS
	(
	ENAME VARCHAR2(10), --사원명
	JOB      VARCHAR2(9), --업무
	SAL      NUMBER, --급여
	COMM NUMBER --커미션
	) ;

-- SALGRADE테이블 삭제
DROP TABLE SALGRADE;

-- SALGRADE테이블생성 : 급여등급
CREATE TABLE SALGRADE( 
	GRADE NUMBER, --등급
	 LOSAL NUMBER, -최저급여
	 HISAL NUMBER  --최고급여
);

-- SALGRADE테이블에 데이터입력
INSERT INTO SALGRADE VALUES (1,700,1200);
INSERT INTO SALGRADE VALUES (2,1201,1400);
INSERT INTO SALGRADE VALUES (3,1401,2000);
INSERT INTO SALGRADE VALUES (4,2001,3000);
INSERT INTO SALGRADE VALUES (5,3001,9999);

-- 커밋
COMMIT;






