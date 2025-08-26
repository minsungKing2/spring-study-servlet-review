package hello.servlet.domain.member;


import lombok.Getter;
import lombok.Setter;

@Getter @Setter
//회원 도메인 모델
public class Member {

    private Long id; //id는 Member 를 회원 저장소에 저장하면 회원 저장소가 할당한다.
    private String username;
    private int age;

    public Member() {}

    public Member(String username, int age) {
        this.username = username;
        this.age = age;
    }
}
