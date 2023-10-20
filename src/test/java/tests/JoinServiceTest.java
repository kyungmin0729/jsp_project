package tests;

import commons.BadRequestException;
import models.member.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("회원가입 기능 단위테스트")
public class JoinServiceTest {
    private JoinService joinService;

    @BeforeEach
    void init() {
        //joinService = new JoinService(new JoinValidator(), new MemberDao()); // 관리하기 편한 객체조립기 필요함
        joinService = ServiceManager.getInstance().joinService();
    }

    private Member getMember() {
        return Member.builder()
                .userId("user" + System.currentTimeMillis())
                .userPw("12345678")
                .confirmUserPw("12345678")
                .userNm("사용자")
                .email("user@test.org")
                .agree(true)
                .build();

    }
    @Test
    @DisplayName("회원가입 성공시 예외발생하지 않음")
    void joinSuccess() {
        assertDoesNotThrow(() -> {
            joinService.join(getMember());
        });

    }

    @Test
    @DisplayName("필수 항목 검증(아이디, 비밀번호, 비밀번호 확인, 회원명, 이메일, 회원가입약관 동의)")
    void requiredFieldCheck() {
        //아이디(userId가 null 또는 빈값("")
        assertThrows(BadRequestException.class, () -> {
            Member member = getMember();

            member.setUserId(null);
            joinService.join(member);

            member.setUserId("    ");
            joinService.join(member);
        });
    }
}