package models.member;

import org.mindrot.jbcrypt.BCrypt;

import java.util.HashMap;
import java.util.Map;

public class MemberDao {
    //데이터를 접근하는 객체
    private  static Map<String, Member> members = new HashMap<>();

    //가입하기
    public void register(Member member) {
        String userPw = BCrypt.hashpw(member.getUserPw(), BCrypt.gensalt(12));
        member.setUserPw(userPw);
        members.put(member.getUserId(), member);
    }


    //중복체크
    public Member get(String userId) {
        return members.get(userId);
    }
    public boolean exists(String userId) {
      return members.containsKey(userId);
    }

    public static void clearData() {
        members.clear();
    }
}
