package privacy.ilpvc.regionmanage.config;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Description:
 *
 * @date:2023/7/13 23:02
 * @author: ilpvc
 */
@Configuration
//@EnableTransactionManagement
@MapperScan("privacy.ilpvc.regionmanage.mapper")
@EnableTransactionManagement
public class MybatisPlusConfig {

//    TransactionManager transactionManager;
//    @Autowired
//    public MybatisPlusConfig(TransactionManager transactionManager) {
//        this.transactionManager = transactionManager;
//    }

    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor(){
        MybatisPlusInterceptor mybatisPlusInterceptor = new MybatisPlusInterceptor();
        mybatisPlusInterceptor.addInnerInterceptor(new PaginationInnerInterceptor());
        return mybatisPlusInterceptor;
    }


}