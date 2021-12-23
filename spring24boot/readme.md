# Spring Boot

Spring 에서 만든 기존의 Spring 구조를 간소화한 방식의 프로젝트

한 번에 모든 설정을 완료하는 것을 목표로 만들어진 프로젝트

## Legacy 프로젝트와의 차이점

- `web.xml`이 `ServletInitializer.java`로 대체됨
- `root-context.xml`과 `servlet-context.xml`이 `application.properties`와 `자바 Configuration`으로 대체됨
- 기타 의존성들이 통합되어 boot 의존성으로 관리됨

## spring boot 프로젝트의 실행방법

1. WAS(ex : tomcat)를 이용하여 실행하는 경우
	- legacy와 동일하게 실행됨
	- was의 기본 설정을 따라간다(포트 등)
2. 독립 실행
	- boot 프로젝트에는 반드시 `main메소드`가 존재한다 (프로젝트명 + Application.java)
	- 해당 프로젝트를 Spring Boot Application 모드로 실행하면 프로젝트가 설정에 의해 서비스가 가능
	- 별도의 WAS가 없어도 내장 WAS에 의해서 실행된다(embeded tomcat이 내장되어 있음)

## 주의해야할 점
1. 컴포넌트 스캔은 최초 생성할 때 지정한 패키지에 적용된다
2. 기존 STS에서 spring explorer 등을 활용하기 까다롭다
3. 독립 실행을 할 때에는 갱신사항이 있으면 반드시 애플리케이션을 재시작 해야 반영된다
	- spring-devtools 를 설치하면 이런 문제점들이 개선된다
	
## Spring Boot 의존성 관리

Spring boot에서는 이른바 "자주 사용하는 의존성"을 직접 버전 관리해준다

- 확인주소 : [https://docs.spring.io/spring-boot/docs/current/reference/html/dependency-versions.html](https://docs.spring.io/spring-boot/docs/current/reference/html/dependency-versions.html)

버전을 자동으로 최적화 및 최신화 시켜서 관리하므로 해당 버전을 쓰면 안되는 경우 버전을 명시하여 사용

`spring-boot`로 시작하는 의존성들은 기존 `spring-legacy`와 필요한 추가 `dependency`들을 자동으로 가져오도록 계층 구조로 설계되어 있기 때문에
최소한의 의존성 등록으로 최대한 많은 의존성들을 가져올 수 있도록 설계되어 있다

## Spring boot에서 JSP 사용하기

### pom.xml

```xml
<dependency>
	<groupId>javax.servlet</groupId>
	<artifactId>jstl</artifactId>
</dependency>
<dependency>
	<groupId>org.apache.tomcat.embed</groupId>
	<artifactId>tomcat-embed-jasper</artifactId>
</dependency>
```

### application.properties

```properties
# view resolver setting
spring.mvc.view.prefix=/WEB-INF/views/
spring.mvc.view.suffix=.jsp
```

### jsp가 위치할 폴더를 생성

spring boot에는 webapp 이하의 폴더가 없다(WEB-INF 포함)
해당 위치를 생성해줘야 한다

### 컨트롤러 구현 및 연결될 JSP 생성

### 실행