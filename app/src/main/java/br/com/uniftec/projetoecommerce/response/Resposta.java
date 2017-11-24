package br.com.uniftec.projetoecommerce.response;

import com.fasterxml.jackson.annotation.JsonInclude;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

/**
 * Created by willi on 23/11/2017.
 */

public class Resposta<T> {

    private ResponseStatus status;
    private String message;
    @JsonInclude(NON_NULL)
    private T data;

    public static <X> Resposta<X> success(X data) {
        return success(null, data);
    }

    public static <X> Resposta<X> success(String message) {
        return response(ResponseStatus.SUCCESS, message, null);
    }

    public static <X> Resposta<X> success(String message, X data) {
        return response(ResponseStatus.SUCCESS, message, data);
    }

    public static <X> Resposta<X> failure(String message) {
        return failure(message, null);
    }

    public static <X> Resposta<X> failure(String message, X data) {
        return response(ResponseStatus.ERROR, message, data);
    }

    private static <X> Resposta<X> response(ResponseStatus status, String message, X data) {
        return new Resposta<X>(status, message, data);
    }

    private Resposta(ResponseStatus status, String message, T data) {
        super();
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public ResponseStatus getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }

}
