package privacy.ilpvc.regionmanage.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import privacy.ilpvc.regionmanage.entity.Address;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * Description:
 *
 * @date:2023/7/13 22:07
 * @author: ilpvc
 */
@Mapper
public interface AddressMapper extends BaseMapper<Address> {

    List<Address> selectAddressListByCityId(int id);
}
