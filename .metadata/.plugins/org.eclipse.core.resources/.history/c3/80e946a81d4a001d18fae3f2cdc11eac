package kr.or.common;

import org.aspectj.lang.JoinPoint;

//비즈니스로직 수행 시 결과값이 에러없이 리턴되는 경우
public class AfterReturningAdvice {
	public void afterReturn(JoinPoint jp) {
		String methdName = jp.getSignature().getName();
		System.out.println(methdName);
	}
}
