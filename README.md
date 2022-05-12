# Login-API-Service

version '2.4.2'

## 구현 사항
1. 회원가입
2. 비밀번호 암호화 
3. 로그인 회원 토큰 생성
4. h2 db연결

##   실행 전 체크 리스트

1. application.yml 파일 중
hbm2ddl: auto: create로 변경
2. h2 database 
- url링크 jdbc:h2:tcp://localhost/~/test 
- username: sa
- password: 


## postman을 활용한 REST API 적용 

1. 회원가입 POST 
- `http://localhost:8080/v1/signup?id=test&name=testName&password=testPassword&email=test@mail.com&mobile=0100000000`

2. 로그인 POST 
- `http://localhost:8080/v1/signin?id=test&password=testPassword`

3. 회원 수정 PUT
- `http://localhost:8080/v1/user?idx=1&mobile=01022222222&email=ho@naver.com`

4. 회원 조회 GET 
- `http://localhost:8080/v1/users`

5. 회원 삭제 DELETE
- `http://localhost:8080/v1/user/1`

6. 회원 상세 조회 GET 
- `http://localhost:8080/v1/user` 
- Header값을 통한 조회: KEY(X-AUTH-TOKEN) : VALUE(로그인 시 생성되는 jwt)
