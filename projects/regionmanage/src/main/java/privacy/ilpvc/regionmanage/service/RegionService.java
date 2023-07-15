package privacy.ilpvc.regionmanage.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import privacy.ilpvc.regionmanage.VO.SearchInfo;
import privacy.ilpvc.regionmanage.VO.SearchResult;
import privacy.ilpvc.regionmanage.entity.Region;

/**
 * Description:
 *
 * @date:2023/7/13 22:36
 * @author: ilpvc
 */
public interface RegionService extends IService<Region> {
    IPage<SearchResult> findByPage(int pageNo,int pageCount,SearchInfo searchInfo);

}
