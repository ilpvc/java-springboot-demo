package privacy.ilpvc.regionmanage.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Description:
 *
 * @date:2023/7/13 21:57
 * @author: ilpvc
 */
@Data
@TableName(value = "tb_address",resultMap = "AddressMap")
public class Address implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    @TableField("address")
    private String address;

    @TableField("city_id")
    private Integer cityId;

    @TableField(value = "created_time",fill = FieldFill.INSERT)
    private Timestamp createdTime;
}