코멘토 2주차 API문서 초안
---

## 계정이력

| 버전 | 변경일 | 변경사유 | 변경내역 |
| --- | --- | --- | --- |
| 1.0 | 2023-01-20 | 최초작성 | 최초작성 |
|  |  |  |  |
|  |  |  |  |

---

## 접속자 수API

일자별 접속자 수 제공

### 요청url

http://localhost8080/statistics?{params(key=value)}

ex) http://localhost8080/statistics?date=2022-01-20

### Request Parameters

| name | desc | type | mandatory |
| --- | --- | --- | --- |
| date | 날짜 | string | O |

### Response Body

```jsx
{
	"count" : 100
}
```

## 부서별 접속자 수API

부서별 접속자 수 API

### 요청url

http://localhost8080/statistics/department?{params(key=value)}

ex) http://localhost8080/statistics/department?date=2022-01-20&id=2

### Request Parameters

| name | desc | type | mandatory |
| --- | --- | --- | --- |
| date | 날짜 | string | O |
| id | 부서 ID | number | O |

### Response Body

```jsx
{
	"count" : 100
}
```

## 로그인 요청 수API

일자별 로그인 요청 수 API

### 요청url

http://localhost8080/statistics/login?{params(key=value)}

ex) http://localhost8080/statistics/login?date=2022-01-20

### Request Parameters

| name | desc | type | mandatory |
| --- | --- | --- | --- |
| date | 날짜 | string | O |

### Response Body

```jsx
{
	"count" : 100
}
```

## 게시글 작성 수API

일자별 게시글 작성 수 API

### 요청url

http://localhost8080/statistics/article?{params(key=value)}

ex) http://localhost8080/statistics/article?date=2022-01-20

### Request Parameters

| name | desc | type | mandatory |
| --- | --- | --- | --- |
| date | 날짜 | string | O |

### Response Body

```jsx
{
	"count" : 100
}
```
