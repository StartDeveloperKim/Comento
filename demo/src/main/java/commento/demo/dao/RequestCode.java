package commento.demo.dao;

import lombok.Getter;

@Getter
public enum RequestCode {
    ACCESS("O"), LOGIN("L");

    private final String code;

    RequestCode(String code) {
        this.code = code;
    }
}
