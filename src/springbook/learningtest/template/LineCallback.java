package springbook.learningtest.template;

/**
 * Created by kjnam on 2016. 4. 25..
 */
public interface LineCallback<T> {
    T doSomethingWithLine(String line, T value);
}
