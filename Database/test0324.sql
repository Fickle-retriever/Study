SELECT department_id,job_id,count(department_id)
FROM employees2
WHERE department_id IS NOT NULL AND job_id IS NOT NULL
GROUP BY rollup(department_id,job_id)
ORDER BY department_id;

SELECT *
FROM EMPLOYEES2
WHERE employee_id = 100;

SELECT *
FROM employees2
WHERE to_char(employee_id) = '100';

SELECT employee_id,first_name,employee_id||'번 사원명은' ||first_name
--concat(employee_id, '번사원명은' , first_name)
FROM employees2
WHERE employee_id = '100';

SELECT employee_id,first_name,concat(employee_id,'번 사원명은 ') || concat(first_name,' 이다.')
FROM employees2
WHERE employee_id = '100';

SELECT email,initcap(email),lower(email),upper(email)
FROM employees2;

SELECT lpad('oracleclub',16,'*'),rpad('oracleclub',12,'*')
FROM dual;

SELECT REPLACE('oracleclub','oracle','db'), --dbclub
	   REPLACE('OracleClub','oracle','DB'), --OracleClub
	   REPLACE('OracleClub','Oracle','DB')  --DBClub
FROM DUAL;
/*TRANSLATE(char1, str1, str2) - 대소문자구분. 한글자 단위
  'o'를 찾아 'A'로 바꾸기
  'r'->'B'    'a'->'C'    'c'->'D' */

SELECT   REPLACE('oracleclub','oracle','ABCDEF'),--ABCDEFclub
	   TRANSLATE('oracleclub','oracle','ABCDEF') --ABCDEFDEub
FROM DUAL;


SELECT sysdate-(10/(24*60)) 
FROM dual;

SELECT  hire_date, trunc(MONTHS_BETWEEN(sysdate,hire_Date))
FROM employees2;

SELECT sysdate,last_day(sysdate)
FROM dual;

SELECT to_Char(123.45678,'$999,999,999')dollar
FROM dual;

SELECT to_char(123.45678,'000,000,000.00')period
FROM dual;

SELECT to_char(123,'09999')zero
FROM dual;

SELECT department_id, DECODE( department_id,60,'IT' , 
                             70 , '섭외' , 
                             80 ,'sales','그 외 부서') name
FROM departments;

SELECT department_id,CASE department_id
WHEN 60 THEN 'it'
WHEN 70 THEN '섭외'
WHEN 80 THEN '영업'
ELSE '그외 부서'
END 
AS "부서이름"
FROM DEPARTMENTS;


SELECT first_name,salary,
CASE 
	WHEN salary<5000 THEN salary+(salary*0.8)
	WHEN salary BETWEEN 5000 AND 10000 THEN salary+(salary*0.5)
	WHEN salary BETWEEN 10001 AND 20000 THEN salary+(salary*0.3)
	ELSE salary+(salary*0.1)
END "add"
FROM employees2;



-- 사원id 100인 사원정보조회
SELECT *
FROM EMPLOYEES2
WHERE employee_id=100;

SELECT *
FROM EMPLOYEES2
WHERE employee_id='100'; -- 묵시적(형변환)함수

--  to_char(employee_id) : 숫자형인 employee_id컬럼의 값을 문자로 변환
SELECT *
FROM EMPLOYEES2
WHERE to_char(employee_id)='100';   

-- to_number('100') : 문자타입인 '100'을 number타입으로 변환
SELECT *
FROM EMPLOYEES2
WHERE employee_id=to_number('100');


-- Numeric Functions (숫자형 함수) : http://www.gurubee.net/lecture/1024
-- Character Functions (문자형 함수): http://www.gurubee.net/lecture/1025

--CONCAT(char1, char2)
--CONCAT 함수는 Concatenation의 약자로 두 문자를 결합하는 역할
--"||"

-- 100번사원명은 Steven
-- 에러발생 : invalid number of arguments
SELECT employee_id, first_name, 
		CONCAT(employee_id, '번사원명은 '),
		employee_id||'번사원명은 '||first_name,
		-- CONCAT(employee_id, '번사원명은 ',first_name)
		concat(employee_id, '번 사원명은 ') || concat(first_name, ' 이다.'),
		concat(employee_id||'번 사원명은 ', concat(first_name, ' 이다.'))  
FROM EMPLOYEES2;


/*INITCAP(char), LOWER(char), UPPER(char)
INITCAP : 주어진 문자열의 첫 번째 문자를 대문자로 변환시켜 준다.
LOWER : 주어진 문자열을 소문자로 변환시켜 준다.
UPPER : 주어진 문자열을 대문자*/

select email, INITCAP(email), 
	   LOWER(email), 
	   FIRST_NAME, UPPER(FIRST_NAME)
FROM EMPLOYEES2;

/*LPAD(char1, n [,char2]), RPAD(char1, n [,char2])
LPAD : 왼쪽에 문자열을 끼어 놓는 역할.
RPAD : 오른쪽에 문자열을 끼어 놓는 역할.
n은 반환되는 문자열의 전체 길이를 나타내며, 
char1의 문자열이 n보다 클 경우 char1을 n개 문자열 만큼 반환)*/

SELECT LPAD('oracleclub', 12, '*'), RPAD('oracleclub', 12, '*')
FROM DUAL;

SELECT LPAD(FIRST_NAME, 15, ' '), RPAD(FIRST_NAME, 15, ' ')
FROM EMPLOYEES2;

/*TRIM(char1[,char2]), LTRIM(char1[,char2]), RTRIM(char1[,char2])
TRIM : 특정한 문자를 제거. 제거할 문자를 입력하지 않으면 기본적으로 공백이 제거 된다.
LTRIM : 왼쪽부터 문자를 제거. 제거할 문자를 입력하지 않으면 기본적으로 왼쪽 공백이 제거 된다.
RTRIM : 오른쪽부터 문자를 제거. 제거할 문자를 입력하지 않으면 기본적으로 오른쪽 공백이 제거*/
SELECT TRIM('o' FROM 'oracleclub'), TRIM(' oracleclub ') FROM DUAL;
SELECT LTRIM('과학수사과','과'), RTRIM('과학수사과','과') FROM DUAL;

/*LENGTH(char), LENGTHB(char)
문자열의 길이, 공백도 길이를 가짐*/
SELECT LENGTH('oracleclub'), LENGTH(' oracleclub ') FROM DUAL;
	   --      6                 3               5  		
SELECT LENGTH('oracle'), LENGTH('오라클'), LENGTH('123 @') FROM DUAL;
	   --      6                 9               5 
SELECT LENGTHB('oracle'), LENGTHB('오라클'), LENGTHB('123 @') FROM DUAL;

/*INSTR (char1, str1, [m], [n])
문자열이 포함되어 있는지를 조사하여 문자열의 위치를 반환. 
지정한 문자열이 발견되지 않으면 0이 반환. 대소문자구분.
문자열의 첫 번째 위치는 1(주의:0 아님)
char1 : 대상문자열, str1 : 검색문자,-1이면 맨뒷(오른쪽)글자부터 앞방향(왼쪽), m:시작위치, n:검색순위
-- 지정한 문자 OK가 발견되지 않아 0을 반환.*/
SELECT INSTR('CORPORATE FLOOR','OK') idx FROM DUAL; --0
		    --1                             0
SELECT INSTR('CORPORATE FLOOR','C'), INSTR('CORPORATE FLOOR','c') 
FROM DUAL; 
		    --2                     --2
SELECT INSTR('CORPORATE FLOOR','O'),INSTR('CORPORATE FLOOR','O',1,1),
		    --5                            --13      
       INSTR('CORPORATE FLOOR','O',3,1),INSTR('CORPORATE FLOOR','O',3,2)
FROM DUAL; 

-- 왼쪽에서 세 번째부터 시작을 해서 검색된 OR의 위치를 반환 한다.
SELECT INSTR('CORPORATE FLOOR','OR', 3) idx FROM DUAL; --5

-- 왼쪽에서 세 번째부터 시작을 해서 비교를 하여 OR이 두 번째 검색되는 지점의 위치를 반환 한다.
SELECT INSTR('CORPORATE FLOOR','OR', 3, 2) idx FROM DUAL; --14

SELECT INSTR('CORPORATE FLOOR','O', 3,-1) idx FROM DUAL; --argument '-1' is out of range
SELECT INSTR('CORPORATE FLOOR','O', -1,1) idx FROM DUAL; --14
SELECT INSTR('CORPORATE FLOOR','O', -5,1) idx FROM DUAL; --5

-- 문자치환함수
/*REPLACE(char1, str1, str2) - 대소문자구분
REPLACE는 문자열의 특정 문자를 다른 문자로 변환 */
SELECT REPLACE('oracleclub','oracle','db'), --dbclub
	   REPLACE('OracleClub','oracle','DB'), --OracleClub
	   REPLACE('OracleClub','Oracle','DB')  --DBClub
FROM DUAL;
/*TRANSLATE(char1, str1, str2) - 대소문자구분. 한글자 단위
  'o'를 찾아 'A'로 바꾸기
  'r'->'B'    'a'->'C'    'c'->'D' */
SELECT   REPLACE('oracleclub','oracle','ABCDEF'),--ABCDEFclub
	   TRANSLATE('oracleclub','oracle','ABCDEF') --ABCDEFDEub
FROM DUAL;

/*★문자열추출    801123-1234567
SUBSTR(char, m ,[n]), SUBSTRB(char, m ,[n])
SUBSTR 함수는 m 번째 자리부터 길이가 n개인 문자열을 반환
n은 글자수.(주의. 위치가 아님!) n이 생략되면 문자열의 끝까지 반환
m이 음수일 경우에는 뒤에서 m 번째 문자부터 n개의 문자를 반환*/

-- 세번째 이후 문자열 반환.
SELECT SUBSTR('oracleclub', 3)FROM DUAL; --acleclub
  
-- 세번째 이후 네개의 문자열(->4글자 추출) 반환.
SELECT SUBSTR('oracleclub', 3, 4)FROM DUAL; --acle
 
-- 뒤에서 세번째(->l)이후 두개의 문자열 반환.(->2글자 추출) 
SELECT SUBSTR('oracleclub', -3, 2) FROM DUAL; --lu


-- Datetime Functions(날짜 함수) : http://www.gurubee.net/lecture/1026 ---
-- 날짜 함수는 NUMBER형 값 또는 DATE형의 값을 RETURN

-- SYSDATE: 현재 일자와 시간(시스템기준).최소단위 = 1초 
-- 2025-03-24 12:42:47
-- 25/03/24
-- 날짜+-숫자 => DATE형의 값을 RETURN
SELECT SYSDATE-1, SYSDATE, SYSDATE+1
FROM   DUAL;

SELECT SYSDATE-(24/24), SYSDATE, SYSDATE+(24/24)
FROM   DUAL;

-- 10시간 전, 10시간 뒤
SELECT SYSDATE-(10/24), SYSDATE, SYSDATE+(10/24)
FROM   DUAL;

-- 10분 전, 10분 뒤
SELECT SYSDATE-(10/(24*60)), SYSDATE, SYSDATE+(10/(24*60))
FROM   DUAL;

SELECT TO_CHAR(SYSDATE,'RRRR-MM-DD HH24:MI:SS') "지금시간"
FROM   DUAL;
 
SELECT TO_CHAR(SYSDATE-1,'RRRR-MM-DD HH24:MI:SS') "하루전지금시간"
FROM   DUAL;
 
SELECT TO_CHAR(SYSDATE-1/24,'RRRR-MM-DD HH24:MI:SS') "1시간전시간"
FROM   DUAL;
 
SELECT TO_CHAR(SYSDATE-1/24/60,'RRRR-MM-DD HH24:MI:SS') "1분전시간"
FROM   DUAL;
 
SELECT TO_CHAR(SYSDATE-1/24/60/10,'RRRR-MM-DD HH24:MI:SS') "6초전시간"
FROM DUAL;
 
SELECT TO_CHAR(SYSDATE-(5/24 + 30/24/60 + 10/24/60/60),'RRRR-MM-DD HH24:MI:SS') "5시간 30분 10초전"
FROM DUAL;


-- ADD_MONTHS(a, b) : ADD_MONTHS 함수는 a의 날짜에 b의 달을 더한 값을 반환
SELECT TO_CHAR(ADD_MONTHS(SYSDATE,3),'RRRR-MM-DD'),
               ADD_MONTHS(SYSDATE,-3)
FROM DUAL;

-- MONTHS_BETWEEN(a1, a2) : a1과 a2 사이의 달의 수를 NUMBER형 타입으로 반환
SELECT MONTHS_BETWEEN(TO_DATE('2010-06-05','RRRR-MM-DD'), 
                      TO_DATE('2010-05-01','RRRR-MM-DD'))  "month"  
FROM DUAL;

-- 사원의 근무개월수 출력
SELECT employee_id, first_name, hire_date, SYSDATE, MONTHS_BETWEEN(SYSDATE, hire_date)
FROM  EMPLOYEES2
ORDER BY hire_date DESC;


-- 두 일자 사이에 일짜 수를 조회하는 예제
SELECT TO_DATE('2010-06-05','RRRR-MM-DD') - 
       TO_DATE('2010-05-01','RRRR-MM-DD')  "Day"  
FROM DUAL;

-- LAST_DAY(d) : LAST_DAY 함수는 달의 마지막 날의 날짜
SELECT SYSDATE, LAST_DAY(SYSDATE) FROM DUAL;
SELECT employee_id, first_name, hire_date, LAST_DAY(hire_date),
											LAST_DAY(hire_date)-hire_date
FROM  EMPLOYEES2
ORDER BY hire_date DESC;


-- NEXT_DAY(d, c1) : NEXT_DAY는 돌아오는 명시된 요일의 일자를 반환한다.
-- 요일은 1(일) 2(월) 3(화) 4(수)~ 7(토)로 입력
SELECT NEXT_DAY(SYSDATE, 4) "Next Wednesday"
FROM DUAL;

-- Conversion Functions(변환 함수) : http://www.gurubee.net/lecture/1027 ---------
-- TO_CHAR :날짜 또는 숫자->문자 타입으로 변환
-- 예)TO_CHAR(number), TO_CHAR(number, format), TO_CHAR(date, format) 형식으로 사용할 수 있다.

-- 콤마
SELECT TO_CHAR(12345678,'999,999,999') comma FROM DUAL;
 
-- 소숫점 예제  
SELECT TO_CHAR(123.45678,'999,999,999.99999999') period,
	   TO_CHAR(123.45678,'000,000,000.00000000') 
FROM DUAL; 
 
-- $ 표시 예제
SELECT TO_CHAR(12345678,'$999,999,999') dollar  FROM DUAL;
 
-- Local 화폐 표시 예제 (한국의 경우 ￦로 자동 변환 됨)
SELECT TO_CHAR(12345678,'L999,999,999') local  FROM DUAL;
 
-- 왼쪽에 0을 삽입
SELECT TO_CHAR(123,'09999') zero FROM DUAL;


-- Date Format의 변환:DATE타입의 데이터를 아래와 같이 특정 형식의 문자 타입으로 변환 할 수 있다.
-- 년,월,일,시,분,초 예제
SELECT TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS') "sysdate"
FROM DUAL;
 
-- 365일 중 몇 일째인지 조회
SELECT TO_CHAR(SYSDATE, 'DDD') "Day of year" FROM DUAL;
SELECT hire_date,TO_CHAR(hire_date,'YYYY'),
			     TO_CHAR(hire_date, 'DDD') "Day of year" 
FROM EMPLOYEES2;
 
-- 53주 중 몇 주차 인지 조회
SELECT TO_CHAR(SYSDATE, 'IW') "Week of year" FROM DUAL;
 
-- 해당 월의 이름 조회
SELECT TO_CHAR(SYSDATE, 'MONTH') "Name of month" FROM DUAL;

/*--TO_DATE
TO_DATE 함수는 문자(CHAR, VARCHAR2)형을 DATE타입으로 변환
TO_DATE(char, format) 형식으로 사용 할 수 있다.
[표 2] 주요 Date Format Elements 에서 'W', 'WW' Format을 제외한 나머지는 
        TO_DATE 함수의 format으로 사용 할 수 있다. */

-- DATE 타입으로 변환하는 예제
SELECT TO_DATE('2011-01-01','RRRR-MM-DD') FROM DUAL;

/*TO_NUMBER
- TO_NUMBER 함수는 문자(CHAR, VARCHAR2)의 데이터 타입을 숫자형식으로 변환 한다.
- TO_NUMBER(char) 형식으로 사용 할 수 있다.*/

-- 문자를 숫자로 변환
SELECT TO_NUMBER('01210616'),
       TO_CHAR(TO_NUMBER('01210616')*10000,'999,999,999,999,999.99') 
FROM DUAL; 

-- 기타함수: http://www.gurubee.net/lecture/1029------------
--UID, USER
--UID는 현재 사용자의 유일한 ID 번호를 반환하고, 
-- USER는 현재 오라클 사용자를 VARCHAR2형식으로 반환 한다.

SELECT USER, UID FROM DUAL;  -- HR 43


-- DECODE와 CASE: http://www.gurubee.net/lecture/1028 -------------
/*DECODE
- DECODE 함수는 조건에 따라 데이터를 다른 값이나 컬럼값으로 추출 할 수 있다.
- DECODE(VALUE, IF1, THEN1, IF2, THEN2...) 형태로 사용 할 수 있다.
- VALUE 값이 IF1일 경우에 THEN1 값을 반환하고, VALUE 값이 IF2일 경우에는 THEN2 값을 반환한다.
- DECODE 함수 안에 DECODE함수를 중첩으로 사용 할 수 있다.*/

-- 부서번호가 60이면 '최강IT', 70이면 '섭외', 80이면 '영업'
-- 나머지는 '그 외 부서'를 출력하는 예제
SELECT department_id, 
DECODE(department_id, 60, '최강IT',
                      70, '섭외',
                      80, '영업', 
                      '그 외 부서') name
FROM DEPARTMENTS;


/*CASE
- CASE 함수는 DECODE함수가 제공하지 못하는 비교연산의 단점을 해결할 수 있는 함수이다.
- DECODE함수에서 비교연산을 수행하기 위해서는 
  GREATEST, LEAST등의 함수를 사용해야 하지만, 
  CASE함수에서는 조건 연산자를 모두 사용 할 수 있다.
- CASE함수는 IF.. THEN .. ELSE 구문과 비슷 하다. 
   WHEN절 다음에 여러 조건이 올 수 있다.*/

-- 부서번호가 60이면 '최강IT', 70이면 '섭외', 80이면 '영업'
-- 나머지는 '그 외 부서'를 출력하는 예제
SELECT department_id, 
CASE department_id
		WHEN 60 THEN '최강IT'
        WHEN 70 THEN '섭외'
        WHEN 80 THEN '영업'
        ELSE '그 외 부서'
        END
        AS  "DEPT_NAME"
FROM DEPARTME NTS;

--급여별로 인상율을 다르게 계산
SELECT first_name, salary,
       CASE
          WHEN salary < 5000  THEN salary+(salary*0.8)
          WHEN salary BETWEEN 5000  AND 10000 THEN salary+(salary*0.5)
          WHEN salary BETWEEN 10001 AND 20000 THEN salary+(salary*0.3)
          ELSE salary+(salary*0.1)
       END sal
  FROM employees2; 


-- NVL, NVL2, NULLIF, COALESCE : http://www.gurubee.net/lecture/1880

-- NVL : NULL 값을 다른 값으로 바꿀 때 사용하며, 모든 데이터 타입에 적용이 가능하다.
-- 매니저가 없는 값을 0으로 바꾸어서 출력하는 예제.
SELECT employee_id, manager_id , NVL(manager_id, 0) mgr
  FROM employees2;

SELECT department_id, employee_id,manager_id FROM employees2;

SELECT employee_id, salary,
	   commission_pct, NVL(commission_pct, 0),
	   salary*commission_pct,
	   salary*NVL(commission_pct, 0)
  FROM employees2
ORDER BY commission_pct asc;

/*NVL2
- NVL2라는 함수는 NVL함수의 DECODE 함수의 개념을 합쳤다고 생각하면 쉽습니다.
- NVL2(expr, expr1, expr2)
- expr의 값이 NULL이 아닐 경우에는 expr1의 값을 반환 하고, NULL일 경우에는 expr2의 값을 반환 한다.*/
SELECT employee_id, salary,
	   commission_pct, 
	   NVL(commission_pct, 0),
	   NVL2(commission_pct,1111,0)
  FROM employees2
ORDER BY commission_pct asc;

/*NULLIF
- NULLIF(exp1, exp2)
- exp1값과 exp2값이 동일하면 NULL을 그렇지 않으면 exp1을 반환
- CASE WHEN expr1 = expr2 THEN NULL ELSE expr1 END*/

SELECT commission_pct, 
	   NULLIF(commission_pct, 0.1),
	   NULLIF(commission_pct, 0.3),
	   NULLIF(commission_pct, 0),
	   NULLIF(commission_pct, null)
  FROM employees2
ORDER BY commission_pct asc;

/*COALESCE
- COALESCE(expr1,expr2,expr3,…) : null이 아닌 첫번째 값을 리턴
- expr1이 NULL이 아니면 expr1값을 그렇지 않으면 COALESCE(expr2,expr3,…)값을 반환.
- NVL 함수와 비슷하다.*/

SELECT commission_pct, 
	   manager_id,
	   COALESCE(commission_pct,manager_id,1)
  FROM employees2;

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
단일 행(Sing-Row) 서브쿼리 : SELECT 문장으로 부터 오직 하나의 행 만을 검색*/

/*7.3. Multiple-Row Subquery  	http://www.gurubee.net/lecture/1503---------
SELECT 문장으로부터 하나 이상의 행을 검색 */

-- 7.4. Multiple-Column Subquery  	http://www.gurubee.net/lecture/1504---------
/*SELECT 문장으로부터 하나 이상의 컬럼을 검색*/

-- 7.5. Inline View(From절 Subquery)http://www.gurubee.net/lecture/1505---------

-- 7.6. Scalar Subquery(select절 Subquery)http://www.gurubee.net/lecture/1506

SELECT empno, ename,sal,hiredate,deptno
FROM emp
WHERE deptno = 20;

CREATE VIEW dept_aggregation_view
as
SELECT deptno,count(ename) cnt,sum(sal) sumsal,round(avg(sal),0) avgsal ,max(sal) maxsal ,min(sal) minsal
FROM emp
WHERE deptno IS NOT null
GROUP BY deptno
ORDER BY count(ename) DESC ,round(avg(sal),0) desc ;

SELECT * FROM dept_aggregation_view;

SELECT *
FROM (SELECT deptno,count(ename) cnt,sum(sal) sumsal,round(avg(sal),0) avgsal ,max(sal) maxsal ,min(sal) minsal
FROM emp
WHERE deptno IS NOT null
GROUP BY deptno
ORDER BY count(ename) DESC ,round(avg(sal),0) DESC) ;

CREATE OR REPLACE VIEW dept20_view
AS
SELECT empno, ename,sal,hiredate,deptno
FROM emp
WHERE deptno = 20
ORDER BY sal DESC;

SELECT * FROM dept20_view
WHERE sal = 800;

INSERT INTO dept20_view(empno,ename,sal,hiredate,deptno)
values(9001,'이순신', 9999,'1990/03/25',20);

INSERT INTO dept20_view(empno,ename,sal,hiredate,deptno)
values(9002,'홍', 1234,'2025/03/25',20);

UPDATE dept20_view
SET sal = sal+(sal*0.9),hiredate = '1991/03/25'
WHERE empno = 9001;

DELETE dept20_view
WHERE empno = 9002;

UPDATE dept20_view
SET hiredate = sysdate,deptno = 10
WHERE empno = 9001;

SELECT * FROM dept20_view; 
SELECT * FROM emp;

SELECT ename,job,deptno 
FROM emp
WHERE empno = 7369;

SELECT *
FROM emp
WHERE to_char(hiredate,'YYYY') = 
(SELECT to_char(hiredate,'YYYY') FROM emp WHERE ename = upper('martin'));

SELECT *
FROM emp
WHERE deptno  = 
(SELECT deptno FROM dept WHERE loc = 'CHICAGO');

SELECT * FROM EMP
WHERE ename = 'KING' OR ename = 'CLARK';

SELECT *
FROM emp
WHERE job NOT in
(SELECT job FROM emp WHERE ename = 'KING' OR ename = 'CLARK' );

SELECT *
FROM emp
WHERE sal >any 
(SELECT sal FROM emp WHERE deptno = 10);


SELECT deptno,2000
FROM emp
GROUP BY deptno;

SELECT ename,job,sal
FROM emp
where(deptno,sal) IN (SELECT deptno,2000 FROM emp GROUP BY deptno );

SELECT job,max(sal)
FROM EMP
WHERE job = 'MANAGER';

SELECT ename,job,sal
FROM emp
where(job,sal) in(SELECT 'MANAGER',max(sal) FROM emp WHERE job = 'MANAGER');


SELECT empno,ename,deptno
FROM emp
ORDER BY deptno ASC;ALTER 

select e.deptno,d.deptno
FROM emp e JOIN dept d
ON e.deptno = d.deptno
WHERE e.DEPTNO = d.deptno;

SELECT deptno
FROM emp e JOIN dept d
USING (deptno);
-- using 절에 사용되는 컬럼명이 select 절에 포함될때는 테이블명을 명시하지 말기

select deptno
FROM emp natural JOIN dept;



