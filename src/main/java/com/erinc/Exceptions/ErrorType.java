package com.erinc.Exceptions;


    public enum ErrorType {
        ERROR (4000,"Hata" ),
        ERROR_NOTFOUND_BYID(4001,"Aradiginiz Kitap id'si Bulunamadi"),
        ERROR_EMPTY(4002, "Musteri Listesi Bos."),
        ERROR_DONT_CREATE(4003, "Kiralama Yapilamadi."),
        ERROR_INVALID_PARAMETER(4004, "Gecersiz Musteri Girdiniz.");

        private int code;
        private String message;

        ErrorType() {}
        ErrorType(int code, String message) {
            this.code = code;
            this.message = message;
        }

        public int getCode() {
            return code;
        }

        public String getMessage() {
            return message;
        }
    }

