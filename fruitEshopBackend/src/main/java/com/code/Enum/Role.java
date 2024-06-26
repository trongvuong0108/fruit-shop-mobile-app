package com.code.Enum;

public enum Role {
    CLIENT("CLIENT"),
    ADMIN("ADMIN"),
    SUPER_ADMIN("SUPER_ADMIN");

    private String text;

    Role(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}

