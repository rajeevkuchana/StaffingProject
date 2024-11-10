package com.staffing.jobportal.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import software.amazon.awssdk.auth.credentials.DefaultCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;

@Configuration
public class AwsConfig {

	@Value("${aws.region}")
    private String region;

    //@Value("${aws.accessKeyId}")
    //private String accessKeyId;

    //@Value("${aws.secretAccessKey}")
    //private String secretAccessKey;

    @Bean
    public S3Client s3Client() {
        return S3Client.builder().credentialsProvider(DefaultCredentialsProvider.create())
                .region(Region.of(region))
                .build();
    }
}