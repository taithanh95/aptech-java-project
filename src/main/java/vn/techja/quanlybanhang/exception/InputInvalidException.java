/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.techja.quanlybanhang.exception;


public class InputInvalidException extends Exception {
    public InputInvalidException(String message, Throwable cause){
        super(message, cause);
    }

    public InputInvalidException(String message) {
        super(message);
    }
}
