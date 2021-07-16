package xmut.ygnn.petserver.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;


@Data
@EqualsAndHashCode(callSuper = false)
public class PlayEntity implements Serializable {
    private static final long serialVersionUID = -5470245891598196978L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * The video name
     */
    private String name;

    /**
     * The url type:
     * 0: a single broadcast address
     * 1: multiple broadcast address
     */
    private int urlType = 0;

    /**
     * The video url
     */
    private String url;

    /**
     * Huawei video ID
     */
    private String appId;

    /**
     * Video format
     */
    private int videoFormat;

    private String img;


}
