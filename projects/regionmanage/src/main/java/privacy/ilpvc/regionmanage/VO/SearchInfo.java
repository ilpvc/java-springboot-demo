package privacy.ilpvc.regionmanage.VO;

import lombok.Data;

import java.sql.Timestamp;

/**
 * Description:
 *
 * @date:2023/7/15 9:54
 * @author: ilpvc
 */

@Data
public class SearchInfo {

    private String regionName;
    private String cityName;
    private String address;
    private String createdTime;
    private String beginTime;
    private String finishTime;
}
