package privacy.ilpvc.regionmanage.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

/**
 * Description:
 *
 * @date:2023/7/13 21:48
 * @author: ilpvc
 */

@Data
@TableName(value = "tb_city",resultMap = "CityMap")
public class City implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    @TableField("city_name")
    private String cityName;

    @TableField("region_id")
    private Integer regionId;

    @TableField(value = "created_time",fill = FieldFill.INSERT)
    private Timestamp createdTime;

    @TableField(exist = false)
    private List<Address> addressList;
}
