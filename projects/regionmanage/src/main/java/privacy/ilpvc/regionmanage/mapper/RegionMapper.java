package privacy.ilpvc.regionmanage.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import privacy.ilpvc.regionmanage.VO.SearchInfo;
import privacy.ilpvc.regionmanage.VO.SearchResult;
import privacy.ilpvc.regionmanage.entity.Region;

/**
 * Description:
 *
 * @date:2023/7/13 22:04
 * @author: ilpvc
 */

@Mapper
public interface RegionMapper extends BaseMapper<Region> {
    @Options(useGeneratedKeys = true,keyColumn = "id",keyProperty = "id")
    Integer insertRegion(Region region);

    IPage<SearchResult> findByPage(Page<SearchResult> page, @Param("searchInfo")SearchInfo searchInfo);
}
