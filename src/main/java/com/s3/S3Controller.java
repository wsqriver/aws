package com.s3;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.SdkClientException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.PutObjectResult;
import com.utils.AOPUtils;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/s3")
@Slf4j
public class S3Controller {
    private  final Logger logger = LoggerFactory.getLogger(S3Controller.class);
    @Autowired
    AmazonS3 S3;
    @Value("${bucketName}")
    private String bucketName;
    @PostMapping(value = "/upload")
    public void upLoad(){
        try {
            List<Bucket> buckets = S3.listBuckets();
            S3.putObject(bucketName,"test/CV.docx",new File("C:\\Users\\86138\\Desktop\\CV.docx"));
        }catch (Exception exception){
            exception.printStackTrace();
        }

    }
    @GetMapping
    public static void downLoad(){

    }
}
