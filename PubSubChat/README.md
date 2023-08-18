# Pub/Sub 기반 채팅 기능 프로젝트

## TECH STACK
- Java 8
- JDK 1.8 (Amazon Corretto Version 1.8.0_352)
- Spring Boot 2.7.14
- Spring Data Redis
- Gradle
- IntelliJ IDEA Ultimate

## INSTALLATION
- Docker 를 이용한 Redis 기동 가이드
    - Docker Registry 에서 Redis 이미지 불러오기
        - `docker pull redis`
    - Redis 실행(-d 옵션을 주지 않는 경우 Command + C로 종료해야 함)
        - `docker run --name my-redis -p 6379:6379 redis`
        - `docker run -d --name my-redis -p 6379:6379 redis`
    - Redis 중지
        - `docker stop my-redis`
    - Redis 삭제
        - `docker rm my-redis`
    - Docker Container 안에서 쉘 실행
        - ` docker exec -it my-redis /bin/sh`
    - Container 내부의 쉘에서 Redis-cli 실행(호스트와 포트를 지정하지 않으면 127.0.0.1:6379 사용)
        - `redis-cli`

## REFERENCE
- Pub/Sub 패턴
  - 메시징 모델 중의 하나로 발행(Publish) 과 구독 (Subscribe) 역할로 개념화 한 형태
  - 발행자와 구독자는 서로에 대한 정보 없이 특정 주제 (토픽 or 채널) 를 매개로 송수신
  - 메시징 미들웨어 사용의 장점
    - 비동기 : 통신의 비동기 처리
    - 낮은 결합도 : 송수신자와 수신자가 직접 서로 의존하지 않고 공통 미들웨어에 의존
    - 탄력성 : 구성원들 간에 느슨한 연결로 인해 일부 장애가 생겨도 영향이 최소화 됨
  - Redis 의 Pub/Sub 특징
    - 메시지가 큐에 저장되지 않음
    - Kafka 의 컨슈머 그룹같은 분산처리 개념이 없음
    - 메시지 발행 시 push 방식으로 subscriber 들에게 전송
    - subscriber 가 늘어날 수록 성능 저하
  - Redis 의 Pub/Sub 의 유즈케이스
    - 실시간으로 빠르게 전송되어야 하는 메시지
    - 메시지 유실을 감내할 수 있는 케이스
    - 최대 1회 전송(at-most-once) 패턴이 적합한 경우
    - Subscriber 들이 다양한 채널을 유동적으로 바꾸면서 한시적으로 구독하는 경우

## REQUIREMENT
- 채팅 기능의 요구사항
  - 채팅 클라이언트와 채팅 서버가 존재하고 통신 방식을 정해야 함 (프로토콜)
  - 채팅 서버는 채팅방 관리 로직을 작성해야 함
  - 채팅 기능을 Publish/Subscribe 구조를 이용해 쉽게 구현
    - Client
      - 채팅방 입장 -> 채널 Subscribe
      - 메시지 전송 -> 채널에 Publish
      - 메시지 수신 -> 채널 구독에 따른 Listener 구현
    - Redis
      - 채팅방 생성 -> 채널 사용으로 대체
      - 채팅방 접속자 관리 -> 필요없음
      - 채팅방 메시지 수신/전송 -> 필요없음

## RESULT