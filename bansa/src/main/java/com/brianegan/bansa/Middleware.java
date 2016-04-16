package com.brianegan.bansa;

public interface Middleware<S, A> {
    void invoke(Store<S, A> store, A action, NextDispatcher<A> next);
}
