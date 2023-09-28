package com.code.Enum;

public enum TokenType {
        SIGNUP("SIGNUP"),
        REPASSWORD("REPASSWORD");
        private String text;

        TokenType(String text) {
            this.text = text;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }
}
