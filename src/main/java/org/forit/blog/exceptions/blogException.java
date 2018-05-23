/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.forit.blog.exceptions;

/**
 *
 * @author forIT
 */
public class blogException extends Exception{
    
     public blogException() {
    }

    public blogException(String message) {
        super(message);
    }

    public blogException(String message, Throwable cause) {
        super(message, cause);
    }

    public blogException(Throwable cause) {
        super(cause);
    }

    public blogException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
