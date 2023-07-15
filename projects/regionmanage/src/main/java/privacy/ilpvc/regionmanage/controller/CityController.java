package privacy.ilpvc.regionmanage.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;
import privacy.ilpvc.regionmanage.VO.R;
import privacy.ilpvc.regionmanage.entity.City;
import privacy.ilpvc.regionmanage.entity.Region;
import privacy.ilpvc.regionmanage.service.CityService;


import java.util.List;

/**
 * Description:
 *
 * @date:2023/7/13 22:41
 * @author: ilpvc
 */
@RestController
@RequestMapping("/city")
@CrossOrigin
@Slf4j
@AllArgsConstructor
public class CityController {

    public final CityService cityService;

    @GetMapping("/{id}")
    public R getCityById(@PathVariable int id) {
        City city = cityService.getById(id);
        return ObjectUtils.isEmpty(city) ? R.error().message("不存在") : R.ok().data("item", city);
    }

    @GetMapping("/")
    public R getAllCity() {
        List<City> cityList = cityService.list();
        return cityList == null ?
                R.error().message("获取失败") : cityList.size() == 0 ?
                R.error().message("没有城市") : R.ok().data("list", cityList);
    }

    @PostMapping("/addCity")
    public R addCity(@RequestBody City city) {
        if ("".equals(city.getCityName()))
            return R.error().message("参数不全，添加失败");
        return cityService.save(city) ? R.ok() : R.error();
    }

    @PutMapping("/updateCity")
    public R updateCity(@RequestBody City city) {
        boolean b = cityService.updateById(city);
        return b ? R.ok() : R.error();
    }

    @DeleteMapping("/{id}")
    public R deleteCityById(@PathVariable int id) {
        boolean b = cityService.removeById(id);
        return b ? R.ok() : R.error();
    }

    @GetMapping("/pageCity/{pageNo}/{pageCount}")
    public R pageCity(@PathVariable int pageNo,
                      @PathVariable int pageCount) {
        Page<City> page = new Page<>(pageNo, pageCount);
        cityService.page(page);
        return R.ok().data("list", page);
    }

}
