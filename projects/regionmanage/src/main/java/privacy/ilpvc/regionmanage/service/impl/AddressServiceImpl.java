package privacy.ilpvc.regionmanage.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import privacy.ilpvc.regionmanage.entity.Address;
import privacy.ilpvc.regionmanage.mapper.AddressMapper;
import privacy.ilpvc.regionmanage.service.AddressService;

/**
 * Description:
 *
 * @date:2023/7/13 22:40
 * @author: ilpvc
 */
@Service
public class AddressServiceImpl extends ServiceImpl<AddressMapper, Address> implements AddressService {
}
