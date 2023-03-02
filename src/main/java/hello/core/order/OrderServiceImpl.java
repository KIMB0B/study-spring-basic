package hello.core.order;

import hello.core.annotation.MainDiscountPolicy;
import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository;
    private final @Qualifier("mainDiscountPolicy") DiscountPolicy discountPolicy;

    // @Autowired는 생성자가 하나면 생략 가능함
    public OrderServiceImpl(
            MemberRepository memberRepository,
            /* @Qualifier("mainDiscountPolicy") 추가 시 해당 Qualifier를 지정한 FixDiscountPolicy로 지정됨
            * 추가하지 않을 시 @Primary를 지정한 RateDiscountPolicy로 지정됨 */

            /* Annotation을 추가하면서 MainDiscountPolicy를 RateDiscountPolicy로 변경함
            * Qualifier 내의 빈 이름은 string이라 오류가 생겨도 찾기 힘들어 Annotation으로 따로 만듦
            * @MainDiscountPolicy를 추가하면 RateDiscountPolicy가 적용되고 자세한 내용은 annotation/MainDiscountPolicy */
            @MainDiscountPolicy
            DiscountPolicy discountPolicy
    ) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {

        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    // 스프링의 @Configuration 싱글톤 테스트를 위한 Getter
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}