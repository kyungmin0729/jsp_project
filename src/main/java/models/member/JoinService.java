package models.member;

import commons.BadRequestException;
import commons.Validator;

public class JoinService {
    private Validator validator; //다형성으로 private Validator 이용
    private MemberDao memberDao;

    public JoinService(Validator validator, MemberDao memberDao) {
        this.validator = validator;
        this.memberDao= memberDao;
    }
    public void join(Member member) {
        //JoinValidator validator = new JoinValidator();
        validator.check(member);

        memberDao.register(member);
    }
}