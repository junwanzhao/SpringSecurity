package top.hyzhu.utils;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Collections;
/**
 * @Author: zhy
 * @Description: MyBatis Plus 生成工具类
 * @Date: 2024-11-13 18:38
 **/

public class AutoGeneratorUtils {

    public static void main(String[] args) {
        FastAutoGenerator.create("jdbc:mysql://localhost:3306/spring_security?zeroDateTimeBehavior=convertToNull&useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai&autoReconnect=true",
                        "root",
                        "123456")
                .globalConfig(builder -> {
                    // 设置作者
                    builder.author("hyzhu")
                            // 覆盖已生成文件
                            .fileOverride()
                            // 指定 Java 代码输出目录
                            .outputDir("E:/Projects/Spring-Security/2-auth-database/src/main/java");
                })
                .packageConfig(builder -> {
                    // 设置父包名
                    builder.parent("top.hyzhu")
                            .pathInfo(Collections.singletonMap(OutputFile.xml, "E:/Projects/Spring-Security/2-auth-database/src/main/resources/mapper")); // 设置 mapperXml 生成路径
                })
                .strategyConfig(builder -> {
                    // 设置需要生成的表名
                    builder.addInclude("user")
                            // 设置过滤表前缀
                            .addTablePrefix("t_", "c_");
                })
                // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .templateEngine(new FreemarkerTemplateEngine())
                .execute();
    }
}
