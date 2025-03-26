-- UNION [ALL], INTERSECT, MINUS 연산자 : http://www.gurubee.net/lecture/1507------
-- scott으로 접속해서 확인하세요 =>주의. 디비버에서는  conn scott/tiger명령어가 적용x
/*UNION과 UNION ALL의 차이는 정렬작업의 수행 여부이다.
UNION은 중복을 제거해야 하기 때문에 정렬작업을 수행하므로 성능이 저하된다.
UNION, MINUS, INTERSECT는 전체범위를 모두 액세스 하는 정렬작업을 수행하기 때문에 
부분범위처리가 불가능하다.


UNION : 합집합
UNION은 두 테이블의 결합을 나타내며, 결합시키는 두 테이블의 중복되지 않은 값들을 반환 한다.

-- 부서번호를 조회하는 UNION 예제.
SELECT deptno FROM emp
 UNION
SELECT deptno FROM dept;
 
 
DEPTNO
--------
      10
      20
      30
      40

UNION ALL : 중복을 포함하는 합집합
UNION과 같으나 두 테이블의 중복되는 값 까지 반환 한다.

-- 부서번호를 조회하는 UNION ALL 예제.
SELECT deptno FROM emp
 UNION ALL
SELECT deptno FROM dept;
 
 
DEPTNO
-------
     20
     30
     30
     20
     30
...
18 개의 행이 선택되었습니다.

INTERSECT : 교집합
INTERSECT는 두 행의 집합중 공통된 행을 반환 한다.

-- 부서번호를 조회하는 INTERSECT 예제.
SELECT deptno FROM emp
INTERSECT
SELECT deptno FROM dept;
 
DEPTNO
---------
       10
       20
       30

MINUS : 차집합
MINUS는 첫 번째 SELECT문에 의해 반환되는 행 중에서 두 번째 SELECT문에 의해 반환되는 행에 존재하지 않는 행들을 반환 한다.

-- 사원이 없는 부서를 조회하는 MINUS 예제.
SELECT deptno FROM dept
 MINUS
SELECT deptno FROM emp;
 
 
DEPTNO
---------
       40  */



-- 7. 서브쿼리(Subquery) ----------------------------------------
-- scott으로 접속해서 확인하세요 =>주의. 디비버에서는  conn scott/tiger명령어가 적용x
/*7.1. Subquery란?  				http://www.gurubee.net/lecture/1501
7.2. Single-Row 				http://www.gurubee.net/lecture/1502
7.3. Multiple-Row Subquery  	http://www.gurubee.net/lecture/1503
7.4. Multiple-Column Subquery  	http://www.gurubee.net/lecture/1504
7.5. Inline View(From절 Subquery)http://www.gurubee.net/lecture/1505
7.6. Scalar Subquery(select절 Subquery)http://www.gurubee.net/lecture/1506*/


-- 7.1. Subquery란?  				http://www.gurubee.net/lecture/1501
/*- Subquery는 다른 하나의 SQL 문장의 절에 NESTEDED된 SELECT 문장 이다.
- SELECT, UPDATE, DELETE, INSERT와 같은 DML문과 
  CREATE TABLE 또는 VIEW의 
  WHERE절이나 HAVING절에서 사용.
- 보통 Subquery는 Main Query 이전에 한 번 실행된다.
- Subquery는 괄호로 묶어야 한다.
- 단일 행 연산자(=, >, >=, <, <=, <>, !=)와 
  다중 행 연산자(IN, NOT IN, ANY, ALL, EXISTS)들이 서브쿼리에 사용 된다.
- Subquery는 연산자의 오른쪽에 위치해야 한다.*/


--- 상관관계 서브 쿼리 : 바깥쪽 쿼리의 컬럼 중의 하나가 안쪽 서브쿼리의 조건에 이용되는 처리 방식
/* 7.2. Single-Row 				http://www.gurubee.net/lecture/1502---------
단일 행(Sing-Row) 서브쿼리 : 
- SELECT 문장으로 부터 오직 하나의 행 만을 검색
- 단일 행 연산자(=,>, >=, <, <=, <>, !=)만 사용
*/
SELECT * FROM emp;

--7369사원의 이름,업무,급여,부서번호 조회
SELECT ename,job,sal,deptno
 FROM emp
WHERE empno=7369; 
-- 7369사원과 동일부서에 근무하는 이름,업무,부서번호 조회
SELECT ename,job,deptno
 FROM emp
WHERE deptno=(SELECT deptno
				 FROM emp
				WHERE empno=7369);

--급여가 (7369사원이 받는 급여)보다 많이 받는 사원조회
--급여가 (800)보다 많이 받는 사원조회
--(사원번호가 7369사원이 받는 급여)
SELECT sal
FROM emp
WHERE empno=7369;  --800

SELECT ename,job,sal,deptno
FROM   emp
WHERE sal>( SELECT sal
			FROM emp
			WHERE empno=7369);

-- martin과 같은 해에 입사한 사원정보 조회
-- 1981-09-28 =>1981
-- (입사일이 년도가)1981년도에 입사한 사원정보 조회

SELECT ename,job,sal,deptno,hiredate,to_char(hiredate,'YYYY')
FROM   emp
WHERE  ename=upper('martin');

SELECT ename,job,sal,deptno,hiredate,to_char(hiredate,'YYYY')
FROM   emp
WHERE  to_char(hiredate,'YYYY')='1981';

-- martin과 같은 해에 입사한 사원정보 조회
-- 1981-09-28 =>1981
-- (입사일이 년도가)1981년도에 입사한 사원정보 조회

SELECT ename,job,sal,deptno,hiredate,to_char(hiredate,'YYYY')
FROM   emp
WHERE  ename=upper('martin');

SELECT ename,job,sal,deptno,hiredate,to_char(hiredate,'YYYY')
FROM   emp
WHERE  to_char(hiredate,'YYYY') LIKE '1981%';

SELECT ename,job,sal,deptno,hiredate,to_char(hiredate,'YYYY')
FROM   emp
WHERE  to_char(hiredate,'YYYY')='1981';

SELECT ename,job,sal,deptno,hiredate,to_char(hiredate,'YYYY')
FROM   emp
WHERE  to_char(hiredate,'YYYY')=(SELECT to_char(hiredate,'YYYY')
								 FROM   emp
								 WHERE  ename=upper('martin'));

SELECT * FROM DEPT;
-- CHICAGO에 근무하는 사원조회
-- 부서테이블의 LOC가 CHICAGO/에 근무하는 사원조회
-- 부서번호가 30에 근무하는 사원조회
SELECT * 
FROM DEPT
WHERE LOC='CHICAGO';

SELECT *
FROM EMP
WHERE DEPTNO=(SELECT DEPTNO 
				FROM DEPT
				WHERE LOC='CHICAGO'); 



/*7.3. Multiple-Row Subquery  	http://www.gurubee.net/lecture/1503---------
*Multiple-Row Subquery란?
- 하나 이상의 행을 반환하는 Subquery이다
- SELECT 문장으로부터 하나 이상의 행을 검색
- 단일 행 연산자를 사용하지 못하며, 다중 행 연산자(IN, NOT IN, ANY, ALL, EXISTS)만 사용이 가능

-IN 연산자
- IN 연산자는 하나의 컬럼이 여러개의 '=' 조건을 가지는 경우에 사용
- OR는 IN을 포함한다. IN을 사용해 표현할 수 있는 것은 당연히 OR로 표현할 수 있다.
- 하지만 OR로 표한한 것은 IN으로 표현하지 못할때가 있다. (OR에서 LIKE같은 연산자를 사용한 경우)
- IN은 반드시 하나의 컬럼이 비교되어야 하므로 나중에 인덱스 구성에 대한 전략을 수립할 때 유리하다.
- 그러므로 가능한 OR보다는 IN 을 사용하는 것이 좋다.

- ANY 연산자 :  Subquery의 여러 결과값 중 어느 하나의 값만 만족이 되면 행을 반환
- ALL 연산자 :  Subquery의 여러 결과값 중 모든 결과 값을 만족해야 행을 반환

*EXISTS 연산자
- EXISTS 연산자는 Subquery 데이터가 존재하는가를 체크해 존재 여부(TRUE,FALSE)를 결과로 반환.
- EXISTS절에는 반드시 메인 쿼리와 연결이 되는 조인 조건을 가지고 있어야 한다.
- subquery에서 결과 행을 찾으면, inner query 수행을 중단하고 TRUE를 반환*/

SELECT * FROM EMP;
-- KING이나 CLARK와 동일한 업무를 하는 사원 조회
-- KING이 하는 업무 조회
SELECT JOB FROM EMP WHERE ENAME='KING';  --PRESIDENT
-- CLARK이 하는 업무 조회
SELECT JOB FROM EMP WHERE ENAME='CLARK'; --MANAGER
-- KING이나 CLARK가 하는 업무 조회
SELECT JOB FROM EMP WHERE ENAME='KING' OR  ENAME='CLARK';
SELECT JOB FROM EMP WHERE ENAME IN('KING','CLARK');
SELECT JOB,ENAME FROM EMP WHERE ENAME IN('KING','CLARK');

SELECT *
FROM   EMP
WHERE  JOB=(
			SELECT JOB 
			FROM EMP 
			WHERE ENAME IN('KING','CLARK')
		   ); --single-row subquery returns more than one ROW => 원인)  =연산자 사용불가
		   -- 해결방법>다중 행 연산자(IN, NOT IN, ANY, ALL, EXISTS) 사용

-- 단일 행 연산자를 사용하지 못하며, 다중 행 연산자(IN, NOT IN, ANY, ALL, EXISTS)만 사용이 가능
SELECT *
FROM   EMP
WHERE  JOB IN(
				SELECT JOB 
				FROM EMP 
				WHERE ENAME IN('KING','CLARK')
			 ); 

-- KING이나 CLARK의 업무와 다른 업무를 하는 사원 조회
SELECT *
FROM   EMP
WHERE  JOB NOT IN(
					SELECT JOB 
					FROM EMP 
					WHERE ENAME IN('KING','CLARK')
			 	); 


/*- ANY 연산자 :  Subquery의 여러 결과값 중 어느 하나의 값만 만족이 되면 행을 반환
- ALL 연산자 :  Subquery의 여러 결과값 중 모든 결과 값을 만족해야 행을 반환*/
-- 10번 부서에서 근무하는 사원급여보다 많이 받는 사원 조회
-- 급여가 (10번 부서에서 근무하는 사원급여)보다 많이 받는 사원 조회
-- 10번 부서에서 근무하는 사원급여
SELECT SAL
FROM  EMP 
WHERE deptno=10; --1300, 2450, 5000

-- 급여가 (1300, 2450, 5000)보다 많이 받는 사원 조회
SELECT *
FROM  EMP 
WHERE sal>(1300, 2450, 5000); -- this operator must be followed by ANY or ALL

SELECT *
FROM  EMP 
WHERE sal>ANY(1300, 2450, 5000);

SELECT *
FROM  EMP 
WHERE sal>ALL(1300, 2450, 5000);

SELECT *
FROM  EMP 
WHERE sal>ANY(SELECT SAL
				FROM  EMP 
				WHERE deptno=10);

SELECT *
FROM  EMP 
WHERE sal>ALL(SELECT SAL
				FROM  EMP 
				WHERE deptno=10);


SELECT *
FROM  EMP 
WHERE sal>ALL(SELECT SAL
				FROM  EMP 
				WHERE deptno=10000);

SELECT SAL
				FROM  EMP 
				WHERE deptno=10000;  -- NO ROWS SELECTED

/*EXISTS 연산자
- EXISTS 연산자는 Subquery 데이터가 존재하는가를 체크해 존재 여부(TRUE,FALSE)를 결과로 반환한다.
- EXISTS절에는 반드시 메인 쿼리와 연결이 되는 조인 조건을 가지고 있어야 한다.
- subquery에서 결과 행을 찾으면, inner query 수행을 중단하고 TRUE를 반환*/				
-- 서브쿼리의 실행결과가 없으면 MAIN쿼리의 실행결과도 없다	
-- 현재 데이터를 기준으로 deptno가 10000인 사원의 급여는 없다=>-- NO ROWS SELECTED
SELECT *
FROM  EMP 
WHERE EXISTS(SELECT SAL
			 FROM  EMP 
			 WHERE deptno=10000);

-- EXISTS연산자는 서브쿼리의 결과가 존재하기만 하면 메인쿼리가 실행된다
SELECT *
FROM  EMP 
WHERE EXISTS(SELECT SAL
			 FROM  EMP 
			 WHERE deptno=10);


-- 7.4. Multiple-Column Subquery  	http://www.gurubee.net/lecture/1504---------
/*Multiple-Column Subquery란?
결과 값이 두 개 이상의 컬럼을 반환하는 Subquery*/

-- 부서별 최대급여를 받는 사원명,업무job,급여조회
-- (부서별 최대급여를 받는 사원의 ??) 사원명,업무job,급여조회
SELECT ename,job,sal
FROM EMP 
WHERE ;

-- 전체사원 중 최대급여
SELECT max(sal)
FROM emp;  --99990.9

-- 부서별 최대급여
SELECT deptno, max(sal)
FROM emp
GROUP BY deptno;  

-- 부서번호=30 and 급여=2850인    사원 ename,job,sal조회
-- 부서번호=20 and 급여=99990.9인 사원 ename,job,sal조회
-- 부서번호=10 and 급여=5000인    사원 ename,job,sal조회
SELECT ename,job,sal
FROM EMP 
WHERE deptno=10 and sal=5000;  --king PRESIDENT  5000
SELECT ename,job,sal
FROM EMP 
WHERE deptno=20 and sal=99990.9; -- 이순신   99990.9
SELECT ename,job,sal
FROM EMP 
WHERE deptno=30 and sal=2850; -- BLAKE  MANAGER  2850

SELECT ename,job,sal
FROM EMP 
WHERE deptno=(SELECT deptno
			  FROM emp
			  GROUP BY deptno)  --single-row subquery returns more than one row
	  and 
      sal = (SELECT max(sal)
			  FROM emp
			  GROUP BY deptno); --single-row subquery returns more than one row

SELECT ename,job,sal
FROM EMP 
WHERE (deptno,sal) IN(SELECT  deptno, max(sal)
						FROM  emp
						GROUP BY deptno);			  
									  
			  
-- 'MANAGER'일을 하는 사원 중에서 급여를 제일 많이 받는 사원의 사원명,업무job,급여조회
-- ( 'MANAGER'일을 하는 사원 중에서 급여를 제일 많이 받는??)
SELECT 'MANAGER',max(sal)
FROM emp
WHERE job='MANAGER';    -- MANAGER 2975

SELECT ename,job,sal
FROM EMP 
WHERE (job,sal) IN(SELECT 'MANAGER',max(sal)
					FROM emp
					WHERE job='MANAGER');




-- 7.5. Inline View(From절 Subquery)http://www.gurubee.net/lecture/1505---------
SELECT * 
FROM  (select 	deptno, count(empno) cnt, 
				sum(sal) sumSAL,
				round(avg(sal),0) AS avgSAL,
				max(sal) maxSAL,
				min(sal) minSAL
	   from  emp
	   group by deptno
	   order by count(empno) desc, avgSAL DESC);

SELECT * 
FROM  ( SELECT empno, ename, sal, hiredate, deptno
		FROM  EMP  
		WHERE deptno=20
		order by hiredate desc);

-- Inline View(From절 Subquery)의 테이블별칭을 emp20
-- emp20.empno : emp20의 empno컬럼을 의미
SELECT emp20.empno, emp20.ename, emp20.sal
FROM  ( SELECT empno, ename, sal, hiredate, deptno
		FROM  EMP  
		WHERE deptno=20
		order by hiredate desc) emp20;



-- 7.6. Scalar Subquery(select절 Subquery)http://www.gurubee.net/lecture/1506
/*Scalar Subquery란? SELECT 절에서 사용하는 Subquery 이다.

*Scalar Subquery의 특징
- 한 개의 로우만 반환 한다.
- 메인 쿼리에서 추출되는 데이터 건 수 만큼 수행되기 때문에 
  조인으로 수행 될 때보다 수행회수가 적을 수 있다.
- 일치하는 값이 없는 경우 NULL을 반환 한다.
- 코드성 테이블에서 코드값을 조회 할 때, 불필요한 조인을 하지 않기 위해 많이 사용*/


------------------------------------------------------------------------------------------
--VIEW : http://www.gurubee.net/lecture/1036 ----------------------------------------------
/*VIEW : 가상테이블
- 뷰는 실제 데이터가 저장 되는 것은 아니지만 뷰를 통해 데이터를 관리 할수 있다.
- 뷰는 복잡한 Query를 통해 얻을 수 있는 결과를 간단한 Query로 얻을 수 있게 한다.
- 한 개의 뷰로 여러 테이블에 대한 데이터를 검색 할 수 있다.
- 특정 평가 기준에 따른 사용자 별로 다른 데이터를 액세스할 수 있도록 한다.


뷰의 제한 조건.
- 테이블에 NOT NULL로 만든 컬럼들이 뷰에 다 포함이 되 있어야 한다.
- ROWID, ROWNUM, NEXTVAL, CURRVAL등과 같은 가상컬럼에 대한 참조를 포함하고 있는 뷰에는 어떤 데이터도 INSERT 할 수 없다
- WITH READ ONLY 옵션을 설정한 뷰도 데이터를 갱신 할 수 없다.
- WITH CHECK OPTION을 설정한 뷰는 뷰의 조건에 해당되는 데이터만 삽입, 삭제,수정을 할 수 있다*/


/*VIEW생성
CREATE [OR REPLACE] VIEW 뷰명
AS
SELECT 
FROM   테이블
[WHERE 조건]
[order by 1차정렬기준 정렬방식, N차정렬기준 정렬방식];
 */

-- 20번부서에 근무하는 사번, 사원명, 급여, 입사일, 부서번호 출력하는 
-- VIEW dept20_view 생성
CREATE OR REPLACE VIEW dept20_view
AS
SELECT empno, ename, sal, hiredate, deptno
FROM  EMP  
WHERE deptno=20
order by sal desc;

-- (dept20_view대상) 급여 800받는 사원조회
SELECT *
FROM dept20_view
WHERE sal = 800
order by empno ASC;

VIEW: SELECT, INSERT, UPDATE, delete

SELECT * FROM EMP;
SELECT * FROM dept20_view;

-- (dept20_view대상) 9001, 이순신, 99990, 1990/03/25, 20 입사 
INSERT INTO dept20_view(empno, ename, sal, hiredate, deptno)
values(9001, '이순신', 99990, to_date('1990/03/25','YYYY/MM/DD'), 20);

-- (dept20_view대상) 9002, 홍, 1234, 오늘, 20 입사 
INSERT INTO dept20_view(empno, ename, sal, hiredate, deptno)
values(9002, '홍', 1234, sysdate, 20);

-- (dept20_view대상) 9001사원의 급여는 기존급여에 0.9를 더하고, 입사일은 1991/03/25 수정
update dept20_view
SET sal=sal+0.9, hiredate='1991/03/25'
WHERE empno=9001;

-- (dept20_view대상) 9001사원의 입사일을 오늘, 10번 부서 수정
update dept20_view
SET hiredate=sysdate, deptno=10
WHERE empno=9001;

-- (emp) 9001사원의 20번 부서 수정
update emp
SET deptno=20
WHERE empno=9001;

-- (dept20_view대상) 9002인 홍 삭제
DELETE FROM dept20_view
WHERE empno=9002 AND  ename='홍';


-- VIEW dept20_view를 생성하시오
-- 원칙적으로 하나의 동일계정내에서  객체obejct명은 중복할 수 없다
-- CREATE OR REPLACE는  dept20_view라는 이름의 view가 존재하지 않으면 생성create
-- dept20_view라는 이름의 view가 존재하면 REPLACE하겠다는 뜻임
CREATE OR REPLACE VIEW dept20_view
AS
SELECT empno, ename, sal, hiredate, deptno
FROM  EMP  
WHERE deptno=20
order by hiredate desc;

SELECT * FROM dept20_view;


-- 부서별 사원수, 총급여,평균급여,최고급여,최저급여를 조회
-- 평균급여는 소수점1번째 자리에서 반올림
-- 부서별 근무사원수가 많은 부서부터 조회하되, 근무자수가 동일하면 평균급여가 높은 부서부터 출력
-- 위의 내용을 가진 VIEW생성
CREATE VIEW dept_aggregation_view
AS
select deptno, count(empno) cnt, 
		sum(sal) sumSAL,
		round(avg(sal),0) AS avgSAL,
		max(sal) maxSAL,
		min(sal) minSAL
from  emp
group by deptno
order by count(empno) desc, avgSAL desc;

SELECT * FROM  dept_aggregation_view;

-- 7.5. Inline View(From절 Subquery)http://www.gurubee.net/lecture/1505---------
SELECT * 
FROM  (select deptno, count(empno) cnt, 
		sum(sal) sumSAL,
		round(avg(sal),0) AS avgSAL,
		max(sal) maxSAL,
		min(sal) minSAL
	   from  emp
	   group by deptno
	   order by count(empno) desc, avgSAL DESC);
-- must name this expression with a column alias 
-- 원인)함수를 사용한 컬럼은 반드시 ALIAS를 지정해야 한다.
-- 해결방법) 컬럼별칭 추가하여 문제 해결

/* insufficient privileges : 원인)불충분 권한
해결방법) system으로 CREATE VIEW권한을 scott은 부여받아야 한다
conn system/1234
GRANT CREATE VIEW
TO scott;
*/
--  name is already used by an existing object

-- view조회
SELECT view_name 뷰명, text 내용
FROM user_views;

-- view삭제
-- DROP VIEW 뷰명;
DROP VIEW dept_aggregation_view;

select deptno, count(empno) cnt, 
		sum(sal) sumSAL,
		round(avg(sal),0) AS avgSAL,
		max(sal) maxSAL,
		min(sal) minSAL
from  emp
group by deptno
order by count(empno) desc, avgSAL desc


----------------------------------------------------------
--join http://www.gurubee.net/lecture/1020----------------
/*조인(Join)

Join 이란?
- 둘 이상의 테이블을 연결하여 데이터를 검색하는 방법 이다.
- 보통 둘 이상의 행들의 공통된 값 Primary Key 및 Foreign Key 값을 사용하여 조인 한다.
- 두 개의 테이블을 SELECT문장 안에서 조인 하려면 적어도 하나의 컬럼이 그 두 테이블 사이에서 공유 되어야 한다.

Join 방법과 방식
- 조인의 방법 : Equi Join (등가 조인, 내부조인) , Non-Equi Join , Self Join , Outer JOIN*/

SELECT empno, ename,deptno
FROM emp
ORDER BY deptno ASC;   -- 10여러3, 20여러4, 30여러6, 40없다 =>13명

SELECT deptno,dname,loc
FROM dept;   -- 10(ACCOUNTING), 20(RESEARCH), 30, 40

SELECT empno, ename,deptno, deptno,dname,loc
FROM emp, dept; --column ambiguously DEFINED   모호하게 정의된 열

-- CARTESIAN PRODUCT
-- 오라클에서 카티션 곱(Cartesian Product)은 CROSS JOIN이라고도 불리며, 
-- 조인할 때 WHERE절을 적지 않거나 잘못 기술했을 때 발생
SELECT emp.empno, emp.ename,emp.deptno 사원T부서번호,      dept.deptno 부서T부서번호, dept.dname,dept.loc
FROM emp, dept; 

-- CROSS JOIN
SELECT emp.empno, emp.ename,emp.deptno 사원T부서번호,      dept.deptno 부서T부서번호, dept.dname,dept.loc
FROM emp  CROSS JOIN  dept; 

/*--Equi Join
- 가장 일반적으로 사용하는 Equality Condition(=)에 의한 조인이다
- Equi join의 성능을 높이기 위해서는 Index 기능을 사용하는 것이 좋다.
  SELECT 컬럼명
  FROM   테이블명1, 테이블명2
  WHERE  조인조건 */
SELECT emp.empno, emp.ename,  dept.deptno 부서번호, dept.dname,dept.loc
FROM emp, dept
WHERE emp.deptno=dept.deptno;


-- 10번 부서에 근무하는 사원번호,이름,부서번호,부서명,소재지 출력
SELECT emp.empno, emp.ename,  dept.deptno 부서번호, dept.dname,dept.loc
FROM emp, dept
WHERE emp.deptno=dept.deptno
	  AND
	  emp.deptno=10;

SELECT e.empno, e.ename,  d.deptno 부서번호, d.dname,d.loc
FROM emp e, dept d
WHERE e.deptno=d.deptno
	  AND
	  e.deptno=10;

-- 아래는 에러발생 : select절에 조인조건에 사용되는 컬럼에는 테이블명(테이블별칭)을 명시해야 한다
SELECT e.empno, e.ename, deptno, d.dname,d.loc
FROM emp e, dept d
WHERE e.deptno=d.deptno
	  AND
	  e.deptno=10; --에러발생
-- column ambiguously defined


	  
/* INNER JOIN ON: 
 - 콤마(,) 대신 INNER JOIN을 사용 할 수 있으며, 
 - INNER는 생략 가능하다. 
 - Join 조건은 ON 절에 온다.
 SELECT 컬럼명
 FROM   테이블명1 [INNER] JOIN 테이블명
 						  ON 조인조건 */
SELECT emp.empno, emp.ename,  dept.deptno 부서번호, dept.dname,dept.loc
FROM emp INNER JOIN dept
		         ON emp.deptno=dept.deptno;

SELECT emp.empno, emp.ename,  dept.deptno 부서번호, dept.dname,dept.loc
FROM emp JOIN dept
		   ON emp.deptno=dept.deptno;

SELECT emp.empno, emp.ename,  dept.deptno 부서번호, dept.dname,dept.loc
FROM   emp JOIN dept
		     ON emp.deptno=dept.deptno
WHERE  emp.deptno=10;

SELECT e.empno, e.ename,  d.deptno 부서번호, d.dname,d.loc
FROM   emp e JOIN dept d
		       ON e.deptno=d.deptno
WHERE  e.deptno=10;

-- 아래는 에러발생 : select절에 조인조건에 사용되는 컬럼에는 테이블명(테이블별칭)을 명시해야 한다
SELECT e.empno, e.ename, deptno 부서번호, d.dname,d.loc
FROM   emp e JOIN dept d
		       ON e.deptno=d.deptno
WHERE  e.deptno=10;--에러발생
-- column ambiguously defined



/*NATURAL JOIN :
- 동일한 컬럼을 내부적으로 모두조인 하므로, ON절이 생략 가능
- Equi Join과 동일 하다고 보면 된다.
- 두 테이블의 동일한 이름을 가지는 칼럼은 모두 조인이 된다.
- 동일한 컬럼을 내부적으로 찾게 되므로 테이블 Alias를 주면 오류가 발생 한다.
- 동일한 컬럼이 두개 이상일 경우 JOIN~USING 문장으로 조인되는 컬럼을 제어 할 수 있다.
 SELECT 컬럼명
 FROM   테이블명1 NATURAL JOIN 테이블명 */
SELECT e.empno, e.ename,  deptno 부서번호, d.dname,d.loc
FROM   emp e NATURAL JOIN dept d;

-- 아래는 에러발생 : NATURAL join에 사용되는 컬럼에는 테이블명(테이블별칭)을 명시x
SELECT e.empno, e.ename,  d.deptno 부서번호, d.dname,d.loc
FROM   emp e NATURAL JOIN dept d;--에러발생
-- column used in NATURAL join cannot have qualifier



/*JOIN~USING절:
- NATURAL JOIN의 단점은 동일한 이름을 가지는 칼럼은 모두 조인이 되는데, USING 문을 사용하면 컬럼을 선택해서 조인을 할 수가 있다.
- USING절 안에 포함되는 컬럼에 Alias를 지정하면 오류가 발생
SELECT 컬럼명
 FROM   테이블명1 JOIN 테이블명
 				USING(조인조건컬럼) */
SELECT emp.empno, emp.ename,  dept.deptno 부서번호, dept.dname,dept.loc
FROM   emp JOIN dept
 		  USING(deptno);-- 에러발생
-- column part of USING clause cannot have qualifier
-- USING절에 사용되는 컬럼명이  select절에 포함될 때는 테이블명(테이블별칭)을 명시하지x 	
 		  
 		  
SELECT emp.empno, emp.ename,  deptno 부서번호, dept.dname,dept.loc
FROM   emp JOIN dept
 		   USING(deptno);

SELECT e.empno, e.ename,  deptno 부서번호, d.dname,d.loc
FROM   emp e JOIN dept d
 		     USING(deptno);

-- 아래는 에러발생 : USING절의 조인조건에 사용되는 컬럼에는 테이블명(테이블별칭)을 명시하지x 
SELECT emp.empno, emp.ename,  deptno 부서번호, dept.dname,dept.loc
FROM   emp JOIN dept
 		  USING(dept.deptno);-- 에러발생
-- only simple column names allowed here
-- USING절의 조인조건에 사용되는 컬럼에는 테이블명(테이블별칭)을 명시하지x 		  



 		  
 		  
/*-- Non-Equi Join : http://www.gurubee.net/lecture/1020 -----------------------
- 테이블의 어떤 column도 Join할 테이블의 column에 일치하지 않을 때 사용하고, 
  조인조건은 동등( = )이외의 연산자를 갖는다.
- BETWEEN AND, IS NULL, IS NOT NULL, IN, NOT IN
- 거의 사용하지 않는다*/
 		  
-- emp 테이블과 salgrade 테이블의 Non-Equi Join 예제
SELECT e.ename,e.sal,s.grade
FROM   emp e, salgrade s
WHERE  e.sal 
BETWEEN s.losal    AND s.hisal;
 		




 		  
/*-- Self Join : http://www.gurubee.net/lecture/1020 -----------------------
- Equi Join과 같으나 
  하나의 테이블에서 조인이 일어나는 것이 다르다.
- 같은 테이블에 대해 두 개의 alias를 사용하여 
  FROM절에 두 개의 테이블을 사용하는 것 처럼 조인*/
 		  
-- 사원의 매니저명을 조회하는 Self Join 예제
SELECT e.ename, a.ename "Manager"
  FROM emp e, emp a
 WHERE e.empno = a.mgr;




/*Outer Join 이란? : http://www.gurubee.net/lecture/1021 --------------------------
- Equi Join은 조인을 생성하려는 두 개의 테이블의 한쪽 컬럼에서 값이 없다면 테이터를 반환하지 못한다.
- 동일 조건에서 조인 조건을 만족하는 값이 없는 행들을 조회하기 위해 Outer Join을 사용 한다.
- Outer Join 연산자는 "(+)" 이다.
- 조인시 값이 없는 조인측에 "(+)"를 위치 시킨다.
- Outer Join 연산자는 표현식의 한 편에만 올 수 있다. */
 		  



/*LEFT, RIGHT, FULL Outer Join  : http://www.gurubee.net/lecture/1021 --------------------------
Oracle9i 부터는 ANSI/ISO SQL 표준인 LEFT OUTER JOIN , RIGHT OUTER JOIN, FULL OUTER JOIN를 지원

*LEFT OUTER JOIN
-- 오른쪽 테이블(아래 예제에서 emp테이블)에 조인시킬 컬럼의 값이 없는 경우 사용 */

-- LEFT OUTER JOIN 조인 예제
SELECT e.deptno, d.deptno
FROM   dept d LEFT OUTER JOIN emp e
                           ON d.deptno = e.deptno; 


-- RIGHT OUTER JOIN
-- 아래 예제에서 emp테이블에 조인시킬 컬럼의 값이 없는 경우 사용
SELECT e.deptno, d.deptno
FROM   dept d RIGHT OUTER JOIN 
                           ON d.deptno = e.deptno; 



-- FULL OUTER JOIN
-- FULL OUTERL JOIN은 양쪽 테이블 모두 Outer Join걸어야 하는 경우 사용
-- 아래 예제에서 emp테이블과 dept테이블의 값이 없는 경우 사용
SELECT e.deptno, d.deptno
FROM   dept d RIGHT OUTER JOIN emp e
                           ON d.deptno = e.deptno;  
