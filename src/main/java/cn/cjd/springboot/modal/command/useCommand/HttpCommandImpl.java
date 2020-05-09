package cn.cjd.springboot.modal.command.useCommand;


import cn.cjd.springboot.modal.command.HttpCommand;
import cn.cjd.springboot.modal.command.HttpCommandContext;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HttpCommandImpl implements HttpCommand<ApprovalFormData> {

    @Override
    public boolean exec(HttpCommandContext<ApprovalFormData> commandContext) {
        log.info("exec bo constructor variables {}", JSON.toJSONString(commandContext.getBo()));
        return false;
    }

    @Override
    public boolean rollBack(HttpCommandContext<ApprovalFormData> commandContext) {
        log.info("rollBack bo constructor variables {}", JSON.toJSONString(commandContext.getBo()));
        return false;
    }


    public static void main(String[] args) {

    }
}
