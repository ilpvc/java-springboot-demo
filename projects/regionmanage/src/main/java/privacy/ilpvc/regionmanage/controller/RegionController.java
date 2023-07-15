package privacy.ilpvc.regionmanage.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;
import privacy.ilpvc.regionmanage.VO.R;
import privacy.ilpvc.regionmanage.VO.SearchInfo;
import privacy.ilpvc.regionmanage.VO.SearchResult;
import privacy.ilpvc.regionmanage.entity.City;
import privacy.ilpvc.regionmanage.entity.Region;
import privacy.ilpvc.regionmanage.service.RegionService;

import java.sql.Timestamp;
import java.util.List;

/**
 * Description:
 *
 * @date:2023/7/13 22:41
 * @author: ilpvc
 */

@RestController
@RequestMapping("/region")
@CrossOrigin
@Slf4j
@AllArgsConstructor
public class RegionController {

    public final RegionService regionService;


    @GetMapping("/{id}")
    public R getRegionById(@PathVariable int id){
        Region region = regionService.getById(id);
        return ObjectUtils.isEmpty(region)?R.error().message("不存在"):R.ok().data("item",region);
    }

    @GetMapping("/")
    public R getAllRegion(){
        List<Region> regionList = regionService.list();
        return regionList==null?
                R.error().message("获取失败") : regionList.size()==0?
                R.error().message("没有城市") : R.ok().data("list",regionList);
    }

    @PostMapping("/addRegion")
    public R addRegion(@RequestBody Region region){
        log.info(region.toString());
        if ("".equals(region.getRegionName()))
            return R.error().message("参数不全，添加失败");
        return regionService.save(region) ? R.ok() : R.error();
    }

    @PutMapping("/updateRegion")
    @Transactional
    public R updateRegion(@RequestBody Region region){
        regionService.removeById(region.getId());
        boolean b = regionService.save(region);
        return b ? R.ok() : R.error();
    }

    @DeleteMapping("/{id}")
    public R deleteRegionById(@PathVariable int id){
        boolean b = regionService.removeById(id);
        return b ? R.ok() : R.error();
    }


    @PostMapping("/pageRegionCondition/{pageNo}/{pageCount}")
    public R pageRegionCondition(@PathVariable int pageNo,
                               @PathVariable int pageCount,
                               @RequestBody SearchInfo searchInfo) {
        System.out.println(searchInfo);
        IPage<SearchResult> page = regionService.findByPage(pageNo,pageCount,searchInfo);
        return R.ok().data("list", page);
    }

    @GetMapping("/pageRegion/{pageNo}/{pageCount}")
    public R pageRegion(@PathVariable int pageNo,
                        @PathVariable int pageCount) {
        Page<Region> page = new Page<>(pageNo,pageCount);
        regionService.page(page);
        return R.ok().data("list",page);
    }

//    @GetMapping("/test")
//    public R test(){
//        SearchInfo info = new SearchInfo();
//        info.setRegionName("华北地区");
//        IPage<SearchResult> page = regionService.findByPage(info);
//        System.out.println(page.getRecords().toString());
//        return R.ok();
//    }
}
