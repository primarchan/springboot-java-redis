# Redis 기반 Game Leader Board 프로젝트

## TECH STACK

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

## RESULT