package hello.servlet.web.springmvc.v2;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * 스프링 MVC - 컨트롤러 통합
 * 클래스 단위 -> 메서드 단위
 *
 * @RequestMapping 클래스 레벨과 메서드 레벨 조합
 */
@Controller
@RequestMapping("/springmvc/v2/members") //공통적인 부분인 /springmvc/v2/members 를 통합해서 사용하여 중복 제거
//클래스 레벨에 다음과 같이 @RequestMapping 을 두면 메서드 레벨과 조합이 된다. -> 클래스 레벨 + 메서드 레벨
//클래스 레벨 @RequestMapping("/springmvc/v2/members")
// - 메서드 레벨 @RequestMapping("/new-form") -> /springmvc/v2/members/new-form
// - 메서드 레벨 @RequestMapping("/save") -> /springmvc/v2/members/save
// - 메서드 레벨 @RequestMapping -> /springmvc/v2/members
public class SpringMemberControllerV2 {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    @RequestMapping("/new-form") //회원 등록
    public ModelAndView newForm() {
        return new ModelAndView("new-form");
    }

    @RequestMapping("/save") //회원 저장
    public ModelAndView save(HttpServletRequest request, HttpServletResponse response) {

        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));

        Member member = new Member(username, age);
        memberRepository.save(member);

        ModelAndView mav = new ModelAndView("save-result");
        mav.addObject("member", member);
        return mav;
    }

    @RequestMapping //회원 목록
    public ModelAndView members() {

        List<Member> members = memberRepository.findAll();

        ModelAndView mav = new ModelAndView("members");
        mav.addObject("members", members);
        return mav;
    }


}
