package hello.core.member;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService{
    private final MemberRepository memberRepository;

//    @Autowired // rombok으로 생략 가능(@RequiredArgsConstructor: final 객체를 생성자로 자동으로 만듦)
//    public MemberServiceImpl(MemberRepository memberRepository) {
//        this.memberRepository = memberRepository;
//    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

    // 스프링의 @Configuration 싱글톤 테스트를 위한 Getter
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
