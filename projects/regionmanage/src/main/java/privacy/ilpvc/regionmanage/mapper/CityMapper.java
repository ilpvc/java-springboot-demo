package privacy.ilpvc.regionmanage.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import privacy.ilpvc.regionmanage.entity.City;

import java.util.List;

/**
 * Description:
 *
 * @date:2023/7/13 22:06
 * @author: ilpvc
 */
@Mapper
public interface CityMapper extends BaseMapper<City> {

    List<City> selectCityListByRegionId(int id);

}
