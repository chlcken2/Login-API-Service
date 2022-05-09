# Login-API-Service
회사테스트 과제

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
- Header값을 통한 조회: KEY(X-AUTH-TOKEN) : VALUE(?)
