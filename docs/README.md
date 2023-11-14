# 크리스마스 프로모션


### 프로그램 목적

고객에게 날짜와 주문을 입력 받으면 이벤트 플래너가 주문 메뉴, 할인 전 총주문 금액, 증정 메뉴, 혜택 내역, 총혜택 금액, 할인 후 예상 결제 금액, 12월 이벤트 배지 내용을 보여주는 프로그램을 개발합니다.

### 기능 목록

어떤 클래스에서 어떤 기능을 수행하는지 정리했습니다.

### EventPlanner

Controller 역할 수행, model과 view를 이어주는 역할을 하며 전체 흐름을 설정합니다.

- [X]  start() : 프로그램을 시작
- [X]  print() : 결과 출력 
- [X]  readDate() : 검증 과정을 거친 날짜 입력
- [X]  readOrder() : 검증 과정을 거친 메뉴 입력 

### InputView

고객에게 날짜와 주문을 입력 받습니다.

- [X]  readDate() : 날짜 입력
- [X]  readMenu() : 메뉴 입력

### Validate

검증 작업을 수행합니다.

- [X]  validateNumber() : 숫자인지 검증
- [X]  validateDateNumberRange() : 1~31 사이인지 검증
- [X]  validateMenu() : 메뉴가 있는지 검증
- [X]  validateMenuNumberRange() : 1 이상 20 이하 숫자인지 검증
- [X]  validateMenuDuplicated() : 메뉴가 중복인지 검증
- [X]  validateMenuHaveNumber() : 메뉴의 개수가 입력되었는지 검증
- [X]  validateMenuOnlyBeverage() : 음료만 있는지 확인
- [X]  validateMenuMaximum() : 메뉴 갯수가 20 이내인지 검증

### InputConverter

입력값을 변환하는 작업을 수행합니다.

- [X]  convertDate() : 날짜 입력값을 숫자로 변환
- [X]  convertOrder() : 주문 입력값을 Map으로 변환 
- [X]  convertMenu() : 주문의 메뉴 검증 후 변환
- [X]  convertNumber() : 주문의 메뉴 개수 검증 후 반환

### Order

날짜와 주문을 저장하며 각 종 작업을 수행합니다. 

- [X]  convertOrder() : String을 Menu로 변환 
- [X]  orderMenu() : 메뉴 목록 반환
- [X]  countDessertMenu() : 디저트 메뉴 개수 집계 
- [X]  countMainMenu() : 메인 메뉴 개수 집계
- [X]  calculateOrderMoney() : 총 주문 금액 계산
- [X]  christmasDdayDiscount() : 크리스마스 디데일 할인 금액 계산
- [X]  dayDiscount() : 날짜 할인 금액 계산
- [X]  weekdayDiscount() : 평일 할인 금액 계산
- [X]  weekendDiscount() : 주말 할인 금액 계산
- [X]  specialDiscount() : 특별 할인 금액 계산
- [X]  giveawayEvent() : 증정 이벤트 계산

 
### Event

Model 역할 수행, 날짜와 메뉴를 입력 받아 할인과 증정, 이벤트 배지 부여 여부를 계산합니다.

- [X]  benefitTotal() : 혜택 내역 집계
- [X]  benefit() : 유효한 혜택 내역 집계
- [X]  benefitMoney() : 총 혜택 금액 계산
- [X]  discountMoney() : 총 할인 금액 계산
- [X]  badgeEvent() : 배지 부여

### EventService

출력에 쓰일 비즈니스 로직을 처리합니다. 

- [X] getDate() : 날짜 
- [X] orderMenu() : 주문 메뉴 
- [X] orderMoney() : 할인 전 총 주문 금액
- [X] giveaway() : 증정 메뉴 
- [X] benefit() : 혜택 내역 
- [X] benefitMoney() : 총혜택 금액
- [X] orderMoneyAfterBenefit() : 할인 후 예상 결제 금액
- [X] badgeEvent() : 12월 이벤트 배지

### OutputView

혜택 정보와 결과 화면을 제공합니다.

- [X]  printIntro() : 인트로 문구 출력
- [X]  printMenu() : 주문한 메뉴와 개수 출력
- [X]  printOrderMoney() : 할인 전 총주문 금액 출력
- [X]  printGiveaway() : 증정 메뉴 출력
- [X]  printBenefit() : 혜택 내역 출력
- [X]  printBenefitMoney() : 총혜택 금액 출력
- [X]  printOrderMoneyAfterDiscount() : 할인 후 예상 결제 금액 출력
- [X]  printEventBadge() : 12월 이벤트 배지 출력


### enum 클래스

- [X]  InputMessage : 입력 안내 메세지 상수 모임
- [X]  OutputMessage : 출력 메세지 상수 모임
- [X]  BenefitMessage : 혜택 내역 매세지 상수 모임
- [X]  ErrorMessage : 에러 메세지 상수 모임
- [X]  Menu : 메뉴 상수 모임
- [X]  Number : 숫자 상수 모임
- [X]  SpecialDay : 특별한 날짜 상수 모임
- [X]  MenuCategory : 메뉴 카테고리 상수 모임
- [X]  EventBadge : 이벤트 뱃지 상수 모임
