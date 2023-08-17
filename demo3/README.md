# 서비스의 속도를 높이는 캐시 레이어 실습 프로젝트

## TECH STACK
- Java 8
- Spring Boot 2.7.14
- Spring Data Redis
- Gradle
- IntelliJ IDEA Ultimate

## INSTALLATION

## REFERENCE
- `Spring` 의 `Caching` 기능 활용
  - `Spring` 의 `Cache` 추상화
    - `CacheManager` 를 통해 일반적인 `Cache Interface` 구현 (다양한 구현체가 존재)
    - 메서드에 `Cache` 를 손쉽게 적용

| Annotation  | 설명                                         |
|:-----------:|:--------------------------------------------|
| @Cacheable  | 메서드에 캐시를 적용한다. (Cache-Aside 패턴 수행)    |  
|  @CachePut  | 메서드의 리턴값을 캐시에 설정한다.                   |  
| @CacheEvict | 메서드의 키값을 기반으로 캐시를 삭제한다.              |  

## RESULT