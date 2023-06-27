package com.example.cachetest;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import java.util.Collections;


/**
 * Description:
 *
 * @date:2023/6/24 16:22
 * @author: ilpvc
 */
public class Generator{
    public static void main(String[] args) {
        FastAutoGenerator.create("jdbc:mysql://192.168.137.111:3306/CacheTest?characterEncoding=UTF-8&useUnicode=true&useSSL=false", "root", "123456")
                // 全局配置
                .globalConfig(builder -> {
                    builder.author("ilpvc") // 设置作者
                            .commentDate("yyyy-MM-dd hh:mm:ss")   //注释日期
                            .outputDir(System.getProperty("user.dir") + "/projects/CacheTest/src/main/java") // 指定输出目录
                            .disableOpenDir() //禁止打开输出目录，默认打开
                    ;
                })
                // 包配置
                .packageConfig(builder -> {
                    builder.parent("com.example.cachetest") // 设置父包名
                            .pathInfo(Collections.singletonMap(OutputFile.mapperXml, System.getProperty("user.dir") + "/src/main/resources/mappers")); // 设置mapperXml生成路径
                })
                // 策略配置
                .strategyConfig(builder -> {
                    builder.addInclude("USER") // 设置需要生成的表名
//                            .addTablePrefix("sys_") // 设置过滤表前缀
                            // Entity 策略配置
                            .entityBuilder()
                            .enableLombok() //开启 Lombok
                            .naming(NamingStrategy.underline_to_camel)  //数据库表映射到实体的命名策略：下划线转驼峰命
                            .columnNaming(NamingStrategy.underline_to_camel)    //数据库表字段映射到实体的命名策略：下划线转驼峰命
                            // Mapper 策略配置
                            .mapperBuilder()
                            // Service 策略配置
                            .serviceBuilder()
                            .formatServiceFileName("%sService") //格式化 service 接口文件名称，%s进行匹配表名，如 UserService
                            .formatServiceImplFileName("%sServiceImpl") //格式化 service 实现类文件名称，%s进行匹配表名，如 UserServiceImpl
                            // Controller 策略配置
                            .controllerBuilder()
                    ;
                })
                .execute();
    }
}
