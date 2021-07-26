package com.ilyabuhlakou.mps.app.configuration

import com.ilyabuhlakou.mps.data.DataComponentScanMarker
import com.mongodb.client.MongoClient
import com.mongodb.client.MongoClients
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories

@Configuration
@EnableMongoRepositories(basePackageClasses = [DataComponentScanMarker::class])
class MongoConfiguration {

//    @Value("\${database.hostname}")
//    lateinit var host: String
//    @Value("\${database.port}")
//    lateinit var port: String
//    @Value("\${database.name}")
//    lateinit var dbName: String
//
//    @Bean
//    fun mongoClient(): MongoClient? {
//        return MongoClients.create("mongodb://${host}:${port}")
//    }
//
//    @Bean
//    fun mongoTemplate(): MongoTemplate? {
//        return MongoTemplate(mongoClient()!!, dbName)
//    }

}