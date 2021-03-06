package com.lvmoney.mysql.rwseparate.config;/**
 * 描述:
 * 包名:com.lvmoney.mysql.separate.config
 * 版本信息: 版本1.0
 * 日期:2019/9/6
 * Copyright XXXXXX科技有限公司
 */


import com.alibaba.druid.pool.DruidDataSource;
import com.lvmoney.common.constant.CommonConstant;
import com.lvmoney.mysql.rwseparate.enums.DbType;
import com.lvmoney.mysql.rwseparate.properties.DatabaseConfigProp;
import com.lvmoney.mysql.rwseparate.properties.DruidConfigProp;
import com.lvmoney.mysql.rwseparate.vo.DatabaseConfig;
import com.lvmoney.mysql.rwseparate.vo.FrameMasterSlaveRule;
import org.apache.shardingsphere.api.config.masterslave.MasterSlaveRuleConfiguration;
import org.apache.shardingsphere.shardingjdbc.api.MasterSlaveDataSourceFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @describe：
 * @author: lvmoney/XXXXXX科技有限公司
 * @version:v1.0 2019/9/6 18:29
 */
@Configuration
public class DataSourceConfig {
    @Autowired
    private DatabaseConfigProp databaseConfigProp;
    @Autowired
    private DruidConfigProp druidConfigProp;

    @Bean
    public DataSource getDataSource() throws SQLException {
        return buildDataSource();
    }


    private DataSource buildDataSource() {
        FrameMasterSlaveRule frameMasterSlaveRule = databaseConfigProp.getMasterSlaveRule();
        List<DatabaseConfig> databaseConfigList = databaseConfigProp.getDatabase();
        Set<String> salveList = new HashSet();
        Map<String, DataSource> dataSourceMap = new HashMap<>(CommonConstant.MAP_DEFAULT_SIZE);
        databaseConfigList.stream().filter(
                //过滤slave
                b -> b.getType().toUpperCase().equals(DbType.SLAVE.getValue().toUpperCase())
        )
                .forEach(e -> {
                    salveList.add(e.getDatabaseName());
                    dataSourceMap.put(e.getDatabaseName(), createDruidDataSource(e));
                });
        AtomicReference<String> masterName = new AtomicReference<>("");
        databaseConfigList.stream().filter(
                //过滤master
                b -> b.getType().toUpperCase().equals(DbType.MASTER.getValue().toUpperCase())
        )
                //主节点只允许一个，所以默认获得第一条数据
                .limit(1)
                .forEach(e -> {
                    masterName.set(e.getDatabaseName());
                    dataSourceMap.put(e.getDatabaseName(), createDruidDataSource(e));

                });
        MasterSlaveRuleConfiguration masterSlaveRuleConfig = new MasterSlaveRuleConfiguration(frameMasterSlaveRule.getName(), masterName.get(), salveList);
        try {
            DataSource dataSource = MasterSlaveDataSourceFactory.createDataSource(dataSourceMap, masterSlaveRuleConfig, new Properties());
            return dataSource;
        } catch (SQLException e) {
            return null;
        }
    }

    private DataSource createDruidDataSource(DatabaseConfig databaseConfig) {
        DruidDataSource result = druidConfigProp.getDruid();
        result.setDriverClassName(databaseConfig.getDriverClassName());
        result.setUrl(databaseConfig.getUrl());
        result.setUsername(databaseConfig.getUsername());
        result.setPassword(databaseConfig.getPassword());
        return result;
    }

}
