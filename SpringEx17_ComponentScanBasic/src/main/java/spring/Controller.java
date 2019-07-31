package spring;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Component;

@Target(ElementType.TYPE)
/*
@Target(적용대상)
TYPE				:클래스/인터페이스/열거형
ANNOTATION_TYPE		:어노테이션
FIELD				:필드
CONSTRUCTOR			:생성자
METHOD				:메서드
LOCAL_VARIABLE		:로컬 변수
PACKAGE				:패키지
 */
@Retention(RetentionPolicy.RUNTIME)
/*
유지정책
@Retention(RetentionPolicy.키워드)
SOURCE	: 소스 상에서만 어노테이션 정보 유지
CLASS	: 바이트 코드 파일까지 어노테이션 정보 유지
RUNTIME : 실행할 때 Reflection API로 정보를 얻을 수 있다
 */
@Documented
/*javadoc으로 api 문서를 만들 때 애노테이션에 대한 설명도 포함하도록 지정*/
@Component
public @interface Controller {

	@AliasFor(annotation = Component.class)
	String value() default "";
	
}
