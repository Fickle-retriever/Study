--  한 줄 주석문(ctrl+/)
-- hr계정의 모든 테이블 조회
SELECT *
FROM tab;

-- employees 테이블 모든 컬럼 조회
SELECT *
FROM  employees;

-- 윈도우>환경설정>편집기>데이터편집기>데이터포맷

/* 다중라인 주석문
 */

/* 조회문법
select * | 컬럼명
from  테이블명;
*/

/* employees : 사원
 employee_id	사원id(pk:primary key.기본키)
 first_name		사원명
 last_name		성(가문)
 email
 phone_numbeer
 hire_date		입사일자
 job_id			업무id(job id)
 salary			급여
 commission_pct	커미션퍼센트
 manager_id		상사의 사원id
 department_id	부서id

 *departments : 부서
 department_id	부서id(pk:primary key.기본키)
 department_name부서명
 manager_id		사원id(부서를 관리하는 사원이 가진 사원id)
 location_id	위치id
 
 * locations  : 위치(장소)
 location_id	위치id
 street_address	도로명주소
 postal_code	우편번호
 city			도시명
 state_province 주명
 coundtry_id	국가id
 
 *countries	국가
 coundtry_id	국가id
 coundtry_name	국가명
 region_id		지역id
 
 *regions 		지역(대륙)
 region_id		지역id
 region_name	지역명
 
 */

-- employees 테이블 모든 컬럼 조회
SELECT *
FROM  employees;

-- employees 테이블에서 사원id,사원명,입사일,급여,커미션퍼센트 컬럼 조회
SELECT employee_id,first_name, hire_date, salary, commission_pct
FROM  employees;

-- alias(별칭) : 이해도향상, 간단, 의미부여, 보안
-- " " : 대소문자, 특수문자, 공백, (한글:있어도 되고, 없어도무관)
SELECT employee_id empid,
		first_name "FirstName", 
		hire_date  입사일, 
		salary	   "$급여", 
		commission_pct as "커미션 비율"
FROM  employees;

-- 표현식 : 컬럼명, 산술식, 별칭...
-- 컬럼간의 계산 => 컬럼값에 null이 있으면 결과는 null
SELECT employee_id,
		salary,
		salary+99,
		commission_pct,
		salary*13+salary*commission_pct, AS 커미션적용
FROM  employees;

SELECT 1+1, sysdate
FROM dual;

-- sysdate : 오라클서버의 현재 날짜,시간
SELECT * FROM dual; --더미테이블
-- 아래코드는 에러발생
--SELECT empid
--FROM  employees;
-- "EMPID": invalid identifier

-- employees 테이블에서 사원id,사원명,입사일,급여,커미션퍼센트 컬럼 조회
-- 사원명 abc순으로 출력
SELECT employee_id,first_name, hire_date, salary, commission_pct
FROM  employees
order by first_name;

-- 사원명 내림차순으로 출력
SELECT employee_id,
		first_name 사원명, hire_date, salary, commission_pct
FROM  employees
order by 사원명 desc;

-- 사원명 내림차순으로 출력
SELECT employee_id,
		first_name 사원명, hire_date, salary, commission_pct
FROM  employees
order by 2 desc;

-- 급여를 많이 받는 사원부터 출력
SELECT employee_id,
		first_name 사원명, hire_date, salary, commission_pct
FROM  employees
order by salary desc;

-- (hire_date을 기준으로) 고참부터 출력
SELECT employee_id,
		first_name 사원명, hire_date, salary, commission_pct
FROM  employees
order by hire_date asc;

-- (hire_date을 기준으로) 고참부터 출력하되, 입사동기라면 고액급여자부터 출력
SELECT employee_id,
		first_name 사원명, hire_date, salary, commission_pct
FROM  employees
order by hire_date ASC, salary DESC;

-- commission_pct 적은 사원부터
-- 사원id,사원명,입사일,급여,커미션퍼센트 컬럼 조회
SELECT employee_id,first_name, hire_date, salary, commission_pct
FROM  employees
order by commission_pct ASC;

-- null : 알 수 없는 값. 확정되지 않은 값. 공백(' '), 0과 다르다
-- 		  (오라클에서는) 무한대=> 오름차순정렬시 마지막

-- 사원id가 100인 사원조회
SELECT employee_id,first_name, hire_date, salary, commission_pct
FROM  employees
where employee_id=100;

-- 사원id가 100외의 모든 사원조회 =>사원id가 100이 아니다
SELECT employee_id,first_name, hire_date, salary, commission_pct
FROM  employees
where employee_id!=100;
-- 사원id가 100외의 모든 사원조회 =>사원id가 100이 아니다
SELECT employee_id,first_name, hire_date, salary, commission_pct
FROM  employees
where employee_id<>100;

--(first_name사원명이)렉스사원조회 
--first_name의 컬럼값의 데이터타입이 VARCHAR2(->문자)
--문자열검색은 영문스펠링일치, 공백일치, 대소문자일치
SELECT employee_id,first_name, hire_date, salary, commission_pct
FROM  employees
where first_name='Lex';

-- (입사일이)2001-01-13 사원조회
SELECT employee_id,first_name, hire_date, salary, commission_pct
FROM  employees
where hire_date='2001-01-13';

-- (입사일이)2001-01-13 사원조회
SELECT employee_id,first_name, hire_date, salary, commission_pct
FROM  employees
where hire_date=to_date('2001-01-13','yyyy-mm-dd');

-- (입사일이)2001-01-13 사원조회=> to_date()변환함수를 사용하여 문자데이터를 날짜DATE타입으로 형변환
SELECT employee_id,first_name, hire_date, salary, commission_pct
FROM  employees
where hire_date=to_date('01.01/13','yy.mm/dd');

-- 'RR'방식으로 date 조회
SELECT employee_id,first_name, hire_date, 
		TO_CHAR(hire_date,'yyyy/mm/dd'), 
		salary, commission_pct
FROM  employees
where hire_date=to_date('01/01/13','rr/mm/dd');

/* 조회문법
select { * | 컬럼명 [as 별칭] }
from  테이블명
[where 조건]
[order by 1차정렬기준 정렬방식, N차정렬기준 정렬방식];

*'' : 문자, 날짜

*연산자
-비교연산자 : >초과  >=이상 <미만 <=이하  =같다(일치.동일), != <>일치x.동일x

*정렬기준 : 컬럼명, 컬럼별칭, select절의 순서
*정렬방식
-오름차순(asc. 기본) - 숫자 작->큰, a->z, ㄱ->ㅎ, 예전날짜->최근
-내림차순(desc)     - 숫자 큰->작, z->a, ㅎ->ㄱ, 최근->예전날짜
*/


/*'YY' 방식  vs.  'RR' 방식
1) YY 
입력 년도를 오라클 서버의 현재 날짜와 동시대로 계산
ex. YY 형식에서 '19'를 입력한다면 2019년으로, '
55'을 입력한다면 2055년으로, 
'81'을 입력한다면 2081년으로 인식

2) RR 
현재 년도(뒤의 두 자리) / 입력하는 년도(뒤의 두 자리) / 결  과
 00 ~ 49			/ 00 ~ 49				/ 현재 세기
 00 ~ 49			/ 50 ~ 99				/ 이전 세기
 50 ~ 99			/ 00 ~ 49				/ 다음 세기
 50 ~ 99			/ 50 ~ 99				/ 현재 세기

 현재는 2025년이기 때문에 현재 년도의 뒤의 두 자리는 00~49 사이에 있다. 
 이 때 내가 '81'을 입력한다면 입력하는 년도의 두의 두 자리는 50~99에 해당한다. 
 표에 따르면 현재 년도가 00~49, 입력 년도가 50~99일 경우 전 세기로 계산한다
 즉 1900년대로 계산하여 오라클은 81을 1981년으로 인식하는 것이다.
*/




