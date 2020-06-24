package com.lange.game.exception;


import com.lange.enums.ResponseEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BackstageException extends RuntimeException {

    private Integer code;
    private String msg;

    public BackstageException(ResponseEnum r) {
        this.code = r.getCode();
        this.msg = r.getMsg();
    }

    public BackstageException(ResponseEnum r, String msg) {
        this.code = r.getCode();
        this.msg = msg;
    }
}
