## SW활용 현황 통계 API 구축을 위한 SQL 작성!

1. 월별 접속자 수

```sql
select count(*) as totalCnt
from statistics.requestinfo ri 
where left(ri.createDate, 4) = (년월) and ri.requestCode = (요청코드)

ex) (년월) 2003, 2012 // (요청코드) O: 접속, L: 로그인
```

---

2. 일자별 접속자 수

```sql
select count(*) as totalCnt
from statistics.requestinfo ri 
where left(ri.createDate, 6) = (년월일) and ri.requestCode = (요청코드)

ex) (년월일) 200312, 201215 // (요청코드) O: 접속, L: 로그인
```

---

3. 평균 하루 로그인 수

```sql
select avg(countTable.totalCnt) as avgCnt
from (
   select count(*) as totalCnt
   from statistics.requestinfo ri
   where ri.requestCode = (요청코드"L")
   group by left(ri.createDate, 6)
) as countTable;
```

---

4. 휴일을 제외한 로그인 수

> 휴일(HOLIDAY) 테이블을 따로 구성했다고 가정
> 

| PK | INT | NOTNULL |
| --- | --- | --- |
| HOLIDAY_DATE | VARCHAR(10) | NOTNULL |

```sql
select count(*) as totalCnt
from statistics.requestinfo as r
left outer join statistics.holiday as h
on left(r.createDate, 6) = h.holiday_date
where [h.id](http://h.id/) is null and left(r.createDate, 4) = (년월);

ex) (년월) 2003, 2012
```

---

5. 부서별 월별 로그인 수

```sql
select count(*) as totalCnt
from statistics.user as u
join statistics.requestinfo as r on u.userID=r.userID
where u.HR_ORGAN = (부서번호) and left(r.createDate, 4) = (년월);

ex) (부서번호) 1, 2, 3... // (년월) 2003, 2012
```
