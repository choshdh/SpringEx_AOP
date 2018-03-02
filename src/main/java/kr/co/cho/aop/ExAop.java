package kr.co.cho.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

//aop 클래스 생성 시

@Component //Component-scan 시에 Bean 객체로 생성 될수 있도록 컨테이너에게 인식 시켜준다
@Aspect //ExAop 클래스 관점 지향 클래스라고 인식 시켜줌
public class ExAop {
	
	//포인트 컷의 종류로써는 Around,Before,Throw 등등이 존재한다
	//포인트컷 사용시에는 항상 Advice로 사용되는 함수의 매개변수에 원래 실행되야할 함수를 처리하기위해서 ProceedingJoinPoint를 포함 하고있어야 한다. 

	//Advice : 관점 지향 프로그래밍 설계를 위한 중복 제거 대상 로직을 가지고 있으며 원래 실행되어야 하는 joinpoint 함수 실행이 포함되어있는 함수
	@Around("execution(* kr.co.cho.service..test*(..))")  //0)execution 은 Aop를 사용할 범위를 함수 크기로 정의
														  //1)..은 service 하위 모든 패키지를 의미
														  //2)test* 은 test로 시작되는 모든 함수에 적용하겠다는 의미
														  //3)(..) 는 매개변수가 0개이상라고 정의 하는 의미
	Object testAop(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("Advice 함수  실행됨. joinPoint 실행 전");
		Object obj = null;
		try {
			obj = joinPoint.proceed();
		}finally {
			System.out.println("joinPoint 실행 후. Advice 종료됨.");
		}
		return obj;
	}
	
	
	@Around("within(kr.co.cho.service2..*)") //0)within 은 Aop를 사용할 범위를 패키지 크기로 정의
	Object testAop2(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("Advice 함수  실행됨. joinPoint 실행 전");
		Object obj = null;
		try {
			obj = joinPoint.proceed();
		}finally {
			System.out.println("joinPoint 실행 후. Advice 종료됨.");
		}
		return obj;
	}
}
