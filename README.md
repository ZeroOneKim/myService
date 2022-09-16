# 제목 - Animal Love
버려지는 반려동물들을 입양할 수 있게 도와주는 사이트<br>
서비스 DNS - (오픈기간:미정)  <br>
시연영상 - https://www.youtube.com/watch?v=2i9dDRvADAo

## DB
![myservice database](https://user-images.githubusercontent.com/83469080/183641328-f0eec91e-42c2-4d13-8c5c-5d666a9109ac.PNG)

## 환경 (SpringBoot)
* Spring Boot 2.7.0
* Intellij
* JDK 11 /Gradle
* MariaDataBase

## Skill stack
* HTML/CSS/JavaScript (BootStrap)
* SpringBoot JPA
* SpringBoot Security
* SpringBoot Validation

## About Error
* css가 적용이 안되던 현상 - Spring Security 적용시 css 파일 경로에 대한 접근 권한을 주어져야 한다.
* https://www.baeldung.com/spring-security-jdbc-authentication 의 오픈소스를 사용했으나, 에러가 남 -> 기존 코드에서 접근제어자를 추가하여 해결 <br>
* PortForwading 으로 접근이 안되던 현상 - 공유기가 2대로, 2번의 PortForwarding 거침
* Entity - Repository - Controller 의 형식으로 Controller에서 한 메서드에 모든 코드를 작성하려다. 결합도가 높아져 오류가나던 현상 -> Service를 활용하여 기존보다 코드의 클린화
* (홈)페이지 이동시 URL이 /docs/** 형태로 들어가지는 오류 -> 그럴경우 홈으로 Redirect로 이동
