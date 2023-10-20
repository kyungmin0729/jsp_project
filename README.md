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
######
양방향 암호화 
- 암호화 <--> 복호화 
- AES256... 
- Aria
######
단방향 암호화 - 해시, 복호화x (원 데이터로 복구x)
######
1) 고정값 해시 : 값은 값에 대해서 같은 해시 - md5, sha1, sha245, sha516
######
2) 유동 해시 : 같은 값에 대해서 해시를 만들때 마다 다른 해시 -> 예측 불가능성 - BCrypt
# 로그인 기능 설계(LoginService)
## models/member/LoginService.java
- 필수 항목 검증(아이디, 비밀번호)
- 아이디에 해당하는 회원 정보가 있는지 체크
- 로그인 처리(세션에 회원 정보를 저장)