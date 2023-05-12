package com.exito.automation.enums;

public enum MsgError {

    MSG_ERROR_TEXT("El texto: \"%s\", no es igual al obtenido: \"%s\"");

    private final String msg;

    MsgError(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
