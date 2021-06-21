package com.cspsample.utilities;

import org.junit.Assert;
import org.junit.Test;

public class CommonsTest {
    @Test
    public void printStackTraceTest() {
        String ex = "";
        try {
           int i = 10/0;
        } catch (Exception e) {
            ex = Commons.printStackTrace(e);
        }
        Assert.assertTrue(ex.contains("java.lang.ArithmeticException"));
    }

    @Test
    public void CSPContentChk() {
        Assert.assertEquals("default-src  'self'", Commons.CSP_CONTENT);
    }
}
