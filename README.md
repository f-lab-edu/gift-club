# gift-club
선물 공유 서비스

# 프로젝트 목표
* 카카오톡의 선물하기 서비스 같은 선물하기 백엔드 API 서버를 구축하는것이 목표입니다.
* 객체지향 설계에 입각하여 기능구현 및 대용량 트래픽 처리를 목표로 구현하는것이 목표입니다.
* Redis를 활용하여 데이터 정합성 문제를 해결하는것이 목표입니다.
* JenkinsPipeline을 설계하여 CI/CD를 통한 자동화하여 쉽게 협업이 가능한 프로젝트를 만드는것이 목표입니다.

# 기술적 issue 해결 과정
* [#1] 대규모 트래픽에 대응가능한 서버 확장의 종류 Scale Up vs Scale Out

  https://velog.io/@rudus1012/%EC%B4%88%EB%B3%B4-%EA%B0%9C%EB%B0%9C%EC%9E%90%EA%B0%80-%EB%8C%80%EA%B7%9C%EB%AA%A8%ED%8A%B8%EB%9E%98%ED%94%BD%EC%97%90-%EB%8C%80%EC%9D%91%ED%95%98%EB%8A%94-%EA%B3%BC%EC%A0%95Scale-Up-vs-Scale-Out
  
* [#2] 서버를 확장했을 때 사용자 로그인 정보는 어디에 저장할까? -Sticky Session, Session Clustring, Session Storage

  https://velog.io/@rudus1012/%EC%B4%88%EB%B3%B4-%EA%B0%9C%EB%B0%9C%EC%9E%90%EA%B0%80-%EB%8C%80%EA%B7%9C%EB%AA%A8%ED%8A%B8%EB%9E%98%ED%94%BD%EC%97%90-%EB%8C%80%EC%9D%91%ED%95%98%EB%8A%94-%EA%B3%BC%EC%A0%95Session-%EB%B6%88%EC%9D%BC%EC%B9%98
  
* [#3] In-Memory-DB 중 Redis를 선택한 이유

  https://velog.io/@rudus1012/%EC%B4%88%EB%B3%B4-%EA%B0%9C%EB%B0%9C%EC%9E%90%EA%B0%80-%EB%8C%80%EA%B7%9C%EB%AA%A8%ED%8A%B8%EB%9E%98%ED%94%BD%EC%97%90-%EB%8C%80%EC%9D%91%ED%95%98%EB%8A%94-%EA%B3%BC%EC%A0%95Redis-vs-Memcached
  
# 프로젝트 중점사항
* 버전관리
* 문서화
* Spring Transaction을 활용하여 선물하기 기능 구현
* 로그인 부가기능 Spring AOP로 분리
* Redis Cache를 사용하여 데이터 정합성 문제 해결
  
# DB ERD

![image](https://user-images.githubusercontent.com/43171179/119863651-bfbe2600-bf54-11eb-9460-5b05e366fc69.png)
