package models.member;

public class ServiceManager {
    //객체조립기 - 의존성 ,싱글톤 사용

    private static ServiceManager instance;
    private ServiceManager() {};

    public static ServiceManager getInstance() {
        if (instance == null ) {
            instance = new ServiceManager();
        }

        return instance;
    }


    public MemberDao memberDao() {
        return new MemberDao();
    }
    public JoinValidator joinValidator() {
        JoinValidator validator = new JoinValidator();
        validator.setMemberDao(memberDao());

        return validator;
    }

    public JoinService joinService() {
        return new JoinService(joinValidator(), memberDao());
    }

    public LoginValidator loginValidator() {
        return new LoginValidator();
    }

    public LoginService loginService() {
        return new LoginService(loginValidator());
    }

}
