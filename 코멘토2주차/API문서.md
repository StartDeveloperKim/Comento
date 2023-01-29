코멘토 2주차 API문서 초안
---

---

## 계정이력

| 버전 | 변경일 | 변경사유 | 변경내역 |
| --- | --- | --- | --- |
| 1.0 | 2023-01-20 | 최초작성 | 최초작성 |
|  |  |  |  |
|  |  |  |  |

---

## 월별 접속자 수 API

- 월별 접속자 수 제공
- HTTP Method : GET

### 요청url

/statistic/{month}?date=value

ex) /statistic/month?date=20230120

### Request Parameters

| name | desc | type | mandatory | Note |
| --- | --- | --- | --- | --- |
| requestName | 검색기준 | String | O | month |
| date | 날짜 | String | O | 20230120 |

### Response Body

```jsx
{
	"count" : 100
}
```

## 일자별 접속자 수 API

- 일자별 접속자 수 제공
- HTTP Method : GET

### 요청url

/statistic/{day}?date=value

ex) /statistic/day?date=20230120

### Request Parameters

| name | desc | type | mandatory | Note |
| --- | --- | --- | --- | --- |
| requestName | 검색기준 | String | O | day |
| date | 날짜 | String | O | 20230120 |

### Response Body

```jsx
{
	"count" : 100
}
```

## 평균 하루 로그인 수 API

- 평균 하루 로그인 수 제공
- HTTP Method : GET

### 요청url

/statistic/login?criteria=value

ex) /statistic/login?criteria=avg

### Request Parameters

| name | desc | type | mandatory | Note |
| --- | --- | --- | --- | --- |
| criteria | 검색기준 | String | O | avg(평균) |

### Response Body

```java
{
	"count" : 100
}
```

## 휴일을 제외한 로그인 수 API

- 휴일을 제외한 로그인 수 제공
- HTTP Method : GET

### 요청url

/statistic/login?criteria=value&date=value

ex) /statistic/login?criteria=except-holiday&date=month

### Request Parameters

| name | desc | type | mandatory | Note |
| --- | --- | --- | --- | --- |
| criteria | 기준 | string | O | except-holiday(휴일 제외) |
| date | 년, 또는 월 | string | O | month(월), year(년) |

### Response Body

```java
{
	"count" : 100
}
```

## 부서별 월별 로그인 수 API

- 부서별 월별 로그인 수 제공
- HTTP Method : GET

### 요청url

/statistic/department?id=value&criteria=value&date=value

ex) /statistic/department?id=2&criteria=month&date=202206

### Request Parameters

| name | desc | type | mandatory | Note |
| --- | --- | --- | --- | --- |
| id | 부서ID | Long | O | 부서ID |
| criteria | 기준 | string | O | month(월) |
| date | 날짜 | string | O | 20230120 |

### Response Body

```java
{
	"count" : 100
}
```
