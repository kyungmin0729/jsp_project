# 의존성 추가(pom.xml)
- junit5
- mockito
- maven-sure-fire plugin
- servlet-api
- servlet.jsp-api
- jstl api
- jstl implementation
- lombok
- BCrypt (https://central.sonatype.com/artifact/org.mindrot/jbcrypt)
- 톰캣11 서버 설정

# 회원 가입 기능 설계(JoinService)
## models/member/JoinService.java
- 시작하는 구간과 끝나는 구간을 나눈다. (Start S, End E)
- 필수 항목 검증(아이디, 비밀번호, 비밀번호 확인, 회원명, 이메일, 회원가입약관 동의)
- 아이디 중복 여부 체크 - 중복된 경우 가입 불가
- 아이디 자리수(6자리 이상), 비밀번호 자리수(8자리 이상) 체크
- 비밀번호, 비밀번호 확인 입력 데이터 일치여부 체크
######
- 회원 정보를 저장 
  1) 암호화 
    - 양방향 암호화 
      - 암호화 <--> 복호화 
      - AES256... 
      - Aria
    - 단방향 암호화 - 해시, 복호화x (원 데이터로 복구x)
      - 고정값 해시 : 값은 값에 대해서 같은 해시 - md5, sha1, sha245, sha516 
      - 유동 해시 : 같은 값에 대해서 해시를 만들때 마다 다른 해시 -> 예측 불가능성 - BCrypt

# 기능통합
- 회원가입 
    - Controller : /member/join
    - controllers/member/JoinController.java
    - GET : 회원가입 양식 
    - POST : 회원가입 처리 
    - View : /WEB-INF/templates/member/join.jsp
- 로그인
  - Controller : /member/login
  - controllers/member/LoginController.java
  - GET : 로그인 양식
  - POST : 로그인 처리
  - View : /WEB-INF/templates/member/login.jsp
- 메인페이지
 - 로그인한 경우
   - 사용자명(아이디)님 로그인 메세지 출력
   - 로그아웃(/member/logout), 마이페이지(/mypage) 링크
 - 미로그인 상태
   - 회원가잆(/member/join), 로그인(/member/login) 링크
- 로그아웃
  - /member/logout 
  - Controller
    - controllers/member/LogoutController.java
  - GET, POST 메서드 상관 없이 기능 할 수 있도록 처리

## 완성 화면
### 회원가입
![회원가입](https://github.com/kyungmin0729/jsp_project/blob/Descripton/images/join.png?raw=true)
### 로그인
![로그인](https://github.com/kyungmin0729/jsp_project/blob/Descripton/images/login.png?raw=true)
### 메인페이지
![메인페이지](https://github.com/kyungmin0729/jsp_project/blob/Descripton/images/main.png?raw=true)