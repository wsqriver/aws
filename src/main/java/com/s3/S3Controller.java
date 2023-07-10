package com.s3;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.SdkClientException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.PutObjectResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/s3")
public class S3Controller {
    @Autowired
    AmazonS3 S3;
    @PostMapping
    public static void upLoad(){
        long startMillis = System.currentTimeMillis();
        long endMillis;
        PutObjectResult result = null;
        try {
//            PutObjectRequest putObjectRequest = new PutObjectRequest("devbucket-wsq", "", file);
//            String name = file.getName();
//            //新增文件目录 performanceFile
//            // 记录文件类型
//            ObjectMetadata metadata = new ObjectMetadata();
//            metadata.addUserMetadata(FILE_TYPE, name.substring(name.lastIndexOf(".") + 1));
//            putObjectRequest.setMetadata(metadata);
//            result = S3.putObject(putObjectRequest);
            endMillis = System.currentTimeMillis();
        } catch (AmazonServiceException e) {
            endMillis = System.currentTimeMillis();
        } catch (SdkClientException e) {
            // Amazon S3 couldn't be contacted for a response, or the client
            // couldn't parse the response from Amazon S3.

        }

    }
    @GetMapping
    public static void downLoad(){

    }
}
