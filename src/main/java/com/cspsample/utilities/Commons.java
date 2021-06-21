package com.cspsample.utilities;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Commons {
    public static final String CSP_NONCE_ATTRIBUTE = "nonceForCSP";
    public static final String CSP_CONTENT = "default-src  'self'; script-src 'nonce-{nonce_value}' 'self'";
    private static final int NONCE_SIZE = 32;
    static Logger log = Logger.getLogger(Commons.class.getName());

    public static String printStackTrace(Throwable e) {
        if (e == null) {
            return "";
        }
        StringWriter str = new StringWriter();
        PrintWriter writer = new PrintWriter(str);
        String exception = "";
        try {
            e.printStackTrace(writer);
            exception = str.getBuffer().toString();
            log.log(Level.WARNING, exception);

        } finally {
            try {
                str.close();
                writer.close();
            } catch (Exception ex) {
                //ignore
            }
        }
        return exception;
    }

    public static String generateNonce() {
        byte[] nonceArray = new byte[NONCE_SIZE];
        new SecureRandom().nextBytes(nonceArray);
        return Base64.getEncoder().encodeToString(nonceArray);
    }
}
