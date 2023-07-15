package privacy.ilpvc.regionmanage.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.AllArgsConstructor;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import privacy.ilpvc.regionmanage.VO.SearchInfo;
import privacy.ilpvc.regionmanage.VO.SearchResult;
import privacy.ilpvc.regionmanage.entity.Address;
import privacy.ilpvc.regionmanage.entity.City;
import privacy.ilpvc.regionmanage.entity.Region;
import privacy.ilpvc.regionmanage.mapper.AddressMapper;
import privacy.ilpvc.regionmanage.mapper.CityMapper;
import privacy.ilpvc.regionmanage.mapper.RegionMapper;
import privacy.ilpvc.regionmanage.service.RegionService;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 *
 * @date:2023/7/13 22:37
 * @author: ilpvc
 */
@Service
@AllArgsConstructor
public class RegionServiceImpl extends ServiceImpl<RegionMapper, Region> implements RegionService {

    final CityMapper cityMapper;
    final AddressMapper addressMapper;
    final RegionMapper regionMapper;

    @Override
    public boolean save(Region entity) {
        List<City> cityList = entity.getCityList();
        List<Address> addressList = new ArrayList<>();
        regionMapper.insertRegion(entity);
        if (cityList!=null){
            for (City city :cityList) {
                city.setRegionId(entity.getId());
                cityMapper.deleteById(city);
                cityMapper.insert(city);
                if (city.getAddressList()!=null)
                    addressList.addAll(city.getAddressList());
            }
        }
        if (addressList.size()!=0){
            for (Address address :addressList) {
                addressMapper.insert(address);
            }
        }
        return true;
    }


    public IPage<SearchResult> findByPage(int pageNo,int pageCount,SearchInfo searchInfo){
        Page<SearchResult> resultPage = new Page<>(pageNo,pageCount);
        IPage<SearchResult> queryPage = regionMapper.findByPage(resultPage,searchInfo);
        return queryPage;
    }

}
