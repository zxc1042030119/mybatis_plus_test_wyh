package com.wyh.generate;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.util.ArrayList;

/**
 * 代码自动生成
 */
public class CodeGenerate {

    public static void main(String[] args) {
        // 创建代码生成器
        AutoGenerator mpg = new AutoGenerator();
        // 配置策略

        /*
         * 1.全局配置
         * */
        GlobalConfig gc = new GlobalConfig();
        // 获取项目路径
        String projectPath = System.getProperty("user.dir");
        // 设置代码生成地址
        gc.setOutputDir(projectPath + "/src/main/java");
        // 设置作者
        gc.setAuthor("王宇浩");
        // 设置生成后是否打开文件夹 默认为true
        gc.setOpen(false);
        // 是否覆盖之前生成的代码 默认是false
        gc.setFileOverride(false);
        gc.setServiceName("%sService");
        gc.setIdType(IdType.ID_WORKER_STR);
        gc.setDateType(DateType.ONLY_DATE);
        gc.setSwagger2(true);
        mpg.setGlobalConfig(gc);

        /*
         * 2.设置数据源
         * */
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.MYSQL);
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUrl("jdbc:mysql://localhost:3306/mybatis-plus?useSSL=false&useUnicode=true&characterEncoding=utf-8&serverTime=GMT%2B8");
        dsc.setUsername("root");
        dsc.setPassword("root");
        mpg.setDataSource(dsc);

        /*
         * 3.配置包
         * */
        PackageConfig pc = new PackageConfig();
        pc.setParent("com.wyh.generate");
        pc.setModuleName("code");
        pc.setEntity("entity");
        pc.setMapper("mapper");
        pc.setService("service");
        pc.setController("controller");
        mpg.setPackageInfo(pc);

        /*
         * 4.策略配置
         * */
        StrategyConfig strategy = new StrategyConfig();
        // 设置要映射的表名
        strategy.setInclude("user");
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setEntityLombokModel(true); // 自动lombok；
        strategy.setLogicDeleteFieldName("isDel");
        // 自动填充配置
        TableFill gmtCreate = new TableFill("createTime", FieldFill.INSERT);
        TableFill gmtModified = new TableFill("updateTime", FieldFill.INSERT_UPDATE);
        ArrayList<TableFill> tableFills = new ArrayList<>();
        tableFills.add(gmtCreate);
        tableFills.add(gmtModified);
        strategy.setTableFillList(tableFills);
        // 乐观锁
        strategy.setVersionFieldName("version");
        strategy.setRestControllerStyle(true);
        strategy.setControllerMappingHyphenStyle(true); // localhost:8080/hello_id_2
        mpg.setStrategy(strategy);

        //执行代码生成
        mpg.execute();
    }
}
