package ru.sbt.mipt.oop;

public enum ButtonCode {
    A_BUTTON("A"), B_BUTTON("B");
    private String code;

    public String getCode() {
        return code;
    }

    ButtonCode(String code) {
        this.code = code;
    }
}
