package privacy.ilpvc.regionmanage.VO;

import lombok.Data;

import java.sql.Timestamp;

/**
 * Description:
 *
 * @date:2023/7/15 10:45
 * @author: ilpvc
 */
@Data
public class SearchResult {
    private Integer id;
    private String regionName;
    private String cityName;
    private String address;
    private Timestamp createdTime;

}
