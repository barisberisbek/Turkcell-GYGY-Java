package com.turkcell.spring_cqrs.core.logging;

// imzalamak için
public interface NotLoggableRequest {}

// 40 tane requestim varsa
// 2 tanesi loglanmayacak -> 2 tanesine LOGLAMA işareti ekleyeyim.
// 38 tanesi loglanacak -> 38 tanesine işaret eklemeyeyim
