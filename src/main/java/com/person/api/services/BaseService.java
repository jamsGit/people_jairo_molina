package com.person.api.services;

import java.util.List;

import io.reactivex.Observable;

public interface BaseService<E> {
  public Observable<List<E>> findAll() throws Exception;
}
