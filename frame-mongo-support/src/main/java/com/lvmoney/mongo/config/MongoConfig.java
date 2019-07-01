/**
 * 描述:
 * 包名:com.lvmoney.mongo.config
 * 版本信息: 版本1.0
 * 日期:2019年1月10日  下午2:20:05
 * Copyright xxxx科技有限公司
 */

package com.lvmoney.mongo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.gridfs.GridFSBucket;
import com.mongodb.client.gridfs.GridFSBuckets;

/**
 * @describe：
 * @author: lvmoney /xxxx科技有限公司
 * @version:v1.0 2019年1月10日 下午2:20:05
 */
@Configuration
public class MongoConfig {
    @Value("${spring.data.mongodb.database}")
    String mongoDb;

    @Bean
    public GridFSBucket getGridFSBucket(MongoClient mongoClient) {
        MongoDatabase mongoDatabase = mongoClient.getDatabase(mongoDb);
        GridFSBucket bucket = GridFSBuckets.create(mongoDatabase);
        return bucket;
    }
}
