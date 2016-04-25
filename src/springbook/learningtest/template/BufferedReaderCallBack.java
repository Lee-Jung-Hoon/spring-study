package springbook.learningtest.template;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Created by kjnam on 2016. 4. 23..
 */
public interface BufferedReaderCallBack {
    Integer doSomethingWithReader(BufferedReader br) throws IOException;
}
