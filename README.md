# JIB

## Tech

### BackEnd
    - Java 11
    - SpringBoot 2.3.3.RELEASE
    - Lombok
    - JWT
    - JPA
    - Swagger
    - JUnit 5

### FrontEnd
    - React

### DB
    - Postgresql
    - MongoDB

### Infra
    

## Project Stucture
~~~
└─ src
    ├─ main
    │   ├─ java       
    │   │   └─ com   
    │   │        └─ j2kb  
    │   │             └─ jibapi     
    │   │                  ├─ domain
    │   │                  │   ├─ member   
    │   │                  │   │   ├─ api       - RestController 
    │   │                  │   │   ├─ dao       - Repository
    │   │                  │   │   ├─ dto       - Request, Response obj
    │   │                  │   │   ├─ entity    - domain entity, Enum
    │   │                  │   │   └─ service   - bisiness logic
    │   │                  │   ├─ ...   
    │   │                  │   │   ├─ api       - RestController 
    │   │                  │   │   ├─ dao       - Repository
    │   │                  │   │   ├─ dto       - Request, Response obj
    │   │                  │   │   ├─ entity    - domain entity, Enum
    │   │                  │   │   └─ service   - bisiness logic    
    │   │                  └─ global
    │   │                       ├─ common         - 공통사용 obj
    │   │                       ├─ config         - 설정
    │   │                       │   ├─ external  - 외부 lib ( azure client / aws client )
    │   │                       │   ├─ security  - springSecurity config   
    │   │                       │   └─ other        
    │   │                       ├─ error     
    │   │                       │   ├─ exception - exception
    │   │                       │   └─ other
    │   │                       └─ util           - util
    │   └─ resources
    │        ├─ application.properties
    │        ├─ application-local.properties
    │        ├─ application-dev.properties                    
    │        └─ application-prod.properties
~~~

## 진행방향

- 테스트코드 작성
- 클린코드 지향
- [AngularJS Commit Message Conventions](https://gist.github.com/stephenparish/9941e89d80e2bc58a153) 참고 commit log

## Swagger URL
- http://localhost:8080/swagger-ui/index.html

## Return Obj
### SucessResponse
```json
{
  "status": 200,
  "message": "OK",
  "obj": {
    "memberNo": 1,
    "phoneNumber": "01022572652",
    "memberName": "황명권",
    "memberId": "orange2652@gmail.com"
  }
}
```
### ErrorResponse
```json
{
  "message": " Invalid Input Value",
  "status": 400,
  "errors": [
    {
      "field": "memberName",
      "value": "",
      "reason": "널이어서는 안됩니다"
    }
  ],
  "code": "C001"
}
```


