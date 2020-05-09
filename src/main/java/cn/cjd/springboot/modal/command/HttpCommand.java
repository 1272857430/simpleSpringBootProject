package cn.cjd.springboot.modal.command;

public interface HttpCommand<T> {

    boolean exec(HttpCommandContext<T> commandContext);

    boolean rollBack(HttpCommandContext<T> commandContext);
}
