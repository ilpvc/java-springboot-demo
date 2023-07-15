package privacy.ilpvc.regionmanage.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

/**
 * Description:
 *
 * @date:2023/7/13 22:01
 * @author: ilpvc
 */

@Data
@TableName(value = "tb_region",resultMap = "RegionMap")
public class Region implements Serializable {

    private static final long serialVersionUID = 1L;
    @TableId(type = IdType.AUTO)
    private Integer id;

    @TableField("region_name")
    private String regionName;

    @TableField(value = "created_time",fill = FieldFill.INSERT)
    private Timestamp createdTime;

    @TableField(exist = false)
    private List<City> cityList;
}
