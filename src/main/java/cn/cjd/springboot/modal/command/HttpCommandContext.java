package cn.cjd.springboot.modal.command;

import lombok.Data;

@Data
public class HttpCommandContext<T> {

    private T bo;

    public HttpCommandContext() {
    }

    public HttpCommandContext(T bo) {
        this.bo = bo;
    }

}
