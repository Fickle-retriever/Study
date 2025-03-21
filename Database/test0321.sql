/* 조회문법
select { * | 컬럼명 [as 별칭] }
from  테이블명
[where 조건]
[group by 그룹기준]
[having 그룹조건]
[order by 1차정렬기준 정렬방식, N차정렬기준 정렬방식];

*'' : 문자, 날짜

*연산자
-비교연산자 : >초과  >=이상 <미만 <=이하  =같다(일치.동일), != <>일치x.동일x

*정렬기준 : 컬럼명, 컬럼별칭, select절의 순서
*정렬방식
-오름차순(asc. 기본) - 숫자 작->큰, a->z, ㄱ->ㅎ, 예전날짜->최근
-내림차순(desc)     - 숫자 큰->작, z->a, ㅎ->ㄱ, 최근->예전날짜
*/


SELECT * FROM employees;

CREATE TABLE employees2
as
SELECT *
FROM employees;

SELECT * FROM EMPLOYEES2;

SELECT count(employee_id),count(first_name),count(hire_date),
count(commission_pct),count(manager_id),count(*)
FROM EMPLOYEES2;

SELECT max(salary), min(salary),sum(salary),avg(salary),stddev(salary)
FROM employees2
ORDER BY salary ASC;

SELECT abs(190.534),ceil(190.534),floor(190.534),
round(190.534,-2),round(190.534,0),round(190.534,1),round(190.534,2)
FROM dual;

SELECT ROUND(avg(salary),5)
FROM employees2;

SELECT first_name
FROM employees2
ORDER BY first_name ASC;

SELECT min(first_name),max(first_name)
FROM employees2;

SELECT DISTINCT department_id
FROM employees2
WHERE department_id IS NOT null
ORDER BY DEPARTMENT_ID ASC;

SELECT department_id "부서 번호",count(employee_id) AS "직원수",min(salary) "최저급여",max(salary) "최대급여",
sum(salary) "급여합산",trunc(avg(salary))"급여평균",trunc(stddev(salary)) "급여 표준편차",
MAX(salary)-min(salary) AS "차이"
FROM EMPLOYEES2
WHERE department_id IS NOT NULL
GROUP BY department_id
HAVING max(salary) - min(salary) >= 5000
ORDER BY "차이" asc;

SELECT DISTINCT department_id
FROM employees2
WHERE department_id IS NOT null;

SELECT department_id,job_id,count(department_id)
FROM employees2
WHERE department_id IS NOT NULL AND job_id IS NOT NULL
GROUP BY rollup(department_id,job_id)
ORDER BY department_id;




