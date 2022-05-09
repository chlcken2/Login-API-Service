package service.dev.model.response;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CommonResult {

    private boolean success;

    private int code;

    private String msg;

}
