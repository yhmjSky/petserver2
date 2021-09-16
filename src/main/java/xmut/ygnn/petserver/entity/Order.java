package xmut.ygnn.petserver.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = false)
public class Order implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId(value = "order_id", type = IdType.AUTO)
    private Long order_id;

    private Integer store_id;

    private Integer user_id;

    private String user_name;

    private String user_tel;

    private String user_address;

    private double order_price;

    private java.sql.Timestamp order_data;

    private Integer state;

    private Integer state_s;

    private String order_reason;

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }
}
