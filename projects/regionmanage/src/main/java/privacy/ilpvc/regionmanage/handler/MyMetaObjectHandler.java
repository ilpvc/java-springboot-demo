package privacy.ilpvc.regionmanage.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

/**
 * Description:
 *
 * @date:2023/7/14 0:01
 * @author: ilpvc
 */
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        this.strictInsertFill(metaObject,"createdTime", Timestamp.class,new Timestamp(System.currentTimeMillis()));

    }

    @Override
    public void updateFill(MetaObject metaObject) {

    }
}
