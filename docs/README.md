# 크리스마스 프로모션

---

### 프로그램 목적

고객에게 날짜와 주문을 입력 받으면 이벤트 플래너가 주문 메뉴, 할인 전 총주문 금액, 증정 메뉴, 혜택 내역, 총혜택 금액, 할인 후 예상 결제 금액, 12월 이벤트 배지 내용을 보여주는 프로그램을 개발합니다.

### 기능 목록

---

어떤 클래스에서 어떤 기능을 수행하는지 정리했습니다.

### EventPlanner

Controller 역할 수행, model과 view를 이어주는 역할을 하며 전체 흐름을 설정합니다.

- [ ]  start() : 프로그램을 시작

### InputView

고객에게 날짜와 주문을 입력 받습니다.

- [ ]  readDate() : 날짜 입력
- [ ]  readMenu() : 메뉴 입력

### Validate

검증 작업을 수행합니다.

- [ ]  validateNumber() : 숫자인지 검증
- [ ]  validateDateNumberRange() : 1~31 사이인지 검증
- [ ]  validateMenuForm() : 예시의 형태인지 검증
- [ ]  validateMenu() : 메뉴가 있는지 검증
- [ ]  validateMenuNumberRange() : 1 이상의 숫자인지 검증
- [ ]  validateMenuDuplicated() : 메뉴가 중복인지 검증
- [ ]  validateMenuOnlyBeverage() : 음료만 있는지 확인
- [ ]  validateMenuMaximum() : 메뉴 갯수가 20 이내인지 검증

### Event

Model 역할 수행, 날짜와 메뉴를 입력 받아 할인과 증정, 이벤트 배지 부여 여부를 계산합니다.

- [ ]  calculateOrderMoney() : 주문 금액을 계산
- [ ]  benefit() : 혜택 내역 집계
- [ ]  christmasDdayDiscount() : 크리스마스 디데일 할인 금액 계산
- [ ]  weekdayDiscount() : 평일 할인 금액 계산
- [ ]  weekendDiscount() : 주말 할인 금액 계산
- [ ]  specialDiscount() : 특별 할인 금액
- [ ]  giveawayEvent() : 증정 이벤트 계산
- [ ]  badgeEvent() : 배지 부여
- [ ]  menuCount() : 입력 받은 주문에 메뉴 개수 계산

### OutputView

혜택 정보와 결과 화면을 제공합니다.

- [ ]  printMenu() : 주문한 메뉴와 개수 출력
- [ ]  printOrderMoney() : 할인 전 총주문 금액 출력
- [ ]  printGiveaway() : 증정 메뉴 출력
- [ ]  printBenefit() : 혜택 내역 출력
- [ ]  printBenefitMoney() : 총혜택 금액 출력
- [ ]  printOrderMoneyAfterDiscount() : 할인 후 예상 결제 금액 출력
- [ ]  printEventBadge() : 12월 이벤트 배지 출력
- [ ]  printErrorMessage() : 상황에 맞는 에러 메세지 출력

### enum 클래스

- [X]  InputMessage : 입력 안내 메세지 상수 모임
- [X]  OutputMessage : 출력 메세지 상수 모임
- [X]  BenefitMessage : 혜택 내역 매세지 상수 모임
- [X]  ErrorMessage : 에러 메세지 상수 모임
- [X]  Menu : 메뉴 상수 모임
- [X]  MenuCategory : 메뉴 카테고리 상수 모임
- [X]  EventBadge : 이벤트 뱃지 상수 모임
