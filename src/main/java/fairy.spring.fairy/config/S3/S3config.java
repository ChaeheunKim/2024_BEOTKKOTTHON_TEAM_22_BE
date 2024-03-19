package fairy.spring.fairy.config.S3;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class S3config {

        @Value("${AWS_ACCESS_KEY_ID}")
        private String accessKey;
        @Value("${AWS_SECRET_ACCESS_KEY}")
        private String secretKey;

        @Value("${region}")
        private String region;

        @Value("${bucket}")
        private String bucket;




        

        @Bean
        public AmazonS3Client amazonS3Client() {
            BasicAWSCredentials credentials= new BasicAWSCredentials(accessKey, secretKey);
            return (AmazonS3Client) AmazonS3ClientBuilder.standard()
                    .withRegion(region)
                    .withCredentials(new AWSStaticCredentialsProvider(credentials))
                    .build();
        }
    }

