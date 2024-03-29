# Spring-Review

감을 잃지 않기 위한 스프링 복습2 - 회원 주문

! 모르는 것 뿐만 아니라 아는 것도 적었습니다.

## 비즈니스 요구사항과 설계
- 회원
  - 회원을 가입하고 조회할 수 있다.
  - 회원은 일반과 VIP 두 가지 등급이 있다. 
  - 회원 데이터는 자체 DB를 구축할 수 있고, 외부 시스템과 연동할 수 있다. (미확정)
  - 회원 도메인 협력 관계
    ![image](https://user-images.githubusercontent.com/77595685/271834977-365bc39a-88a8-4377-9864-c122d8c6cdcf.png)
  - 회원 클래스 다이어그램
    ![image](https://user-images.githubusercontent.com/77595685/271835010-524786f7-c396-455e-b8e8-f6a96764ab43.png)
  - 회원 객체 다이어그램
    ![image](https://user-images.githubusercontent.com/77595685/271835037-da562a15-f8ca-41cd-af4f-f84daf363ed9.png)
    - 회원 서비스: MemberServiceImpl

- 주문과 할인 정책 
  - 회원은 상품을 주문할 수 있다.
  - 회원 등급에 따라 할인 정책을 적용할 수 있다.
  - 할인 정책은 모든 VIP는 1000원을 할인해주는 고정 금액 할인을 적용해달라. (나중에 변경 될 수 있다.)
  - 할인 정책은 변경 가능성이 높다. 회사의 기본 할인 정책을 아직 정하지 못했고, 오픈 직전까지 고민을 미루고 싶다. 최악의 경우 할인을 적용하지 않을 수 도 있다. (미확정)
  - 주문 도메인 전체
    ![image](https://user-images.githubusercontent.com/77595685/271836442-b89f9f02-e4dd-4276-a458-96b76a4e71df.png)
  - 주문 도메인 클래스 다이어그램
    ![image](https://user-images.githubusercontent.com/77595685/271836458-47a22939-42c1-494e-b2c8-62d34e335dce.png)
  - 주문 도메인 객체 다이어그램
    ![image](https://user-images.githubusercontent.com/77595685/271836551-448fa0fd-0195-42bd-9757-a8a113c656e8.png)
    ![image](https://user-images.githubusercontent.com/77595685/271836556-02ef88b9-023c-4cfa-b15f-401de80c807e.png)


