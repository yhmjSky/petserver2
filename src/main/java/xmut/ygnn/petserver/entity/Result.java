package xmut.ygnn.petserver.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class Result {
    private int code;
    private String msg;
    private String result;
    public void setSuccess(String msg, String result){
        this.code=200;
        this.msg="success-"+msg;
        this.result=result;
    }
    public void setInfo(String msg, String result){
        this.code=400;
        this.msg="warning-"+msg;
        this.result=result;
    }
}
