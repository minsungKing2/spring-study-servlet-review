package hello.servlet.web.springmvc.v3;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 실무에서 주로 사용하는 방식
 * v3
 * Model 도입 -> Model 파라미터: save(), members() 를 보면 Model 을 파라미터로 받는 것을 확인할 수 있다. 스프링 MVC 도 이런 편의 기능을 제공한다.
 * ViewName 직접 반환 -> 뷰의 논리 이름을 반환할 수 있다.
 * @RequestParam 사용 -> 스프링은 HTTP 요청 파라미터를 @RequestParam 으로 받을 수 있다.
 *  - @RequestParam("username")은 request.getParameter("username")와 거의 같은 코드라고 생각하면 된다. 물론 GET 쿼리 파라미터, POST Form 방식을 모두 지원한다.
 * @RequestMapping -> @GetMapping, @PostMapping: @RequestMapping 은 URL 만 매칭하는 것이 아니라, HTTP Method 도 함께 구분할 수 있다.
 *  - 예를 들어서 URL 이 /new-form 이고, HTTP Method 가 GET 인 경우를 모두 만족하는 매핑을 하려면 다음과 같이 처리하면 된다.
 *  -> @RequestMapping(value = "/new-form", method = RequestMethod.GET)
 *  이것을 @GetMapping, @PostMapping 으로 더 편리하게 사용할 수 있다. 참고로 Get, Post, Put, Delete, Patch 모두 애노테이션이 준비되어 있다.
 */
@Controller
@RequestMapping("/springmvc/v3/members")
public class SpringMemberControllerV3 {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    //회원 등록 폼
    @GetMapping("/new-form")
    public String newForm() {
        return "new-form";
    }

    //회원 저장
    @PostMapping("/save")
    public String save(
            @RequestParam("username") String username,
            @RequestParam("age") int age,
            Model model) {
        Member member = new Member(username, age);
        memberRepository.save(member);

        model.addAttribute("member", member);
        return "save-result";
    }

    //회원 목록 조회
    @GetMapping
    public String members(Model model) {
        List<Member> members = memberRepository.findAll();
        model.addAttribute("members", members);
        return "members";
    }
}
