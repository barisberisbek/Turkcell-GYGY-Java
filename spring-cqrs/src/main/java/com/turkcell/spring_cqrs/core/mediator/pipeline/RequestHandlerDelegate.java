package com.turkcell.spring_cqrs.core.mediator.pipeline;

@FunctionalInterface
public interface RequestHandlerDelegate<R> {
    R invoke();
}