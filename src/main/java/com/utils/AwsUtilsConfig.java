package com.utils;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AwsUtilsConfig {
    @Value("${accessKey}")
    private  String accessKey;
    @Value("${secretKey}")
    private  String secretKey;
    @Value("${bucketName}")
    private String bucketName;
    //获取AWS 连接
    public  AWSCredentialsProvider getAwsProvider(){
        return new AWSCredentialsProvider() {
            public void refresh() {}
            public AWSCredentials getCredentials() {return new BasicAWSCredentials(accessKey, secretKey);}
        };
    }
    //dynamodb bean
    @Bean
    public  DynamoDBMapper getDynamoDBMapper(){
        AmazonDynamoDB amazonDynamoDBClient;
        amazonDynamoDBClient = AmazonDynamoDBClientBuilder.standard().withCredentials(getAwsProvider()).withRegion(Regions.US_EAST_1).build();
        return new DynamoDBMapper(amazonDynamoDBClient);
    }
    @Bean
    public AmazonS3 getS3Client(){
        AmazonS3 S3 = AmazonS3ClientBuilder.standard()
                .withCredentials(getAwsProvider()).withCredentials(getAwsProvider()).withRegion(Regions.US_EAST_1).build();
        return S3;
    }

}
