package com.farhad.example.coffeeorder.infrastructure.adapter.out.persistance.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import com.farhad.example.coffeeorder.architecture.UseCase;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

@Aspect
@RequiredArgsConstructor
public class TransactionalUseCaseAspect {
	

	private final TransactionalUseCaseExecutor transactionalUseCaseExecutor;

	@Pointcut("@within(useCase)")
	void inUseCase(UseCase useCase) {

	}

	@Around("inUseCase(useCase)")
	Object useCase(ProceedingJoinPoint proceedingJoinPoint, UseCase useCase ) {
		return transactionalUseCaseExecutor.executeInTransaction(() ->  proceed(proceedingJoinPoint));
	}

	@SneakyThrows
    Object proceed(ProceedingJoinPoint jaJoinPoint) {
        return jaJoinPoint.proceed();
    }
}
