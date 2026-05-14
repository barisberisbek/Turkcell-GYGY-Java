package com.turkcell.spring_cqrs.core.mediator.cqrs;

public interface CommandHandler<C extends Command<R>, R> {
    R handle(C command);
}
