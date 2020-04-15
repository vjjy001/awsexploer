package aws.practice.s3;

import java.util.List;

import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.ListObjectsRequest;
import software.amazon.awssdk.services.s3.model.ListObjectsResponse;
import software.amazon.awssdk.services.s3.model.S3Object;


public class S3List {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// set the region
		Region region = Region.US_EAST_2;
		// init s3 client
		S3Client s3 = S3Client.builder().region(region).build();
		// list object request
		ListObjectsRequest listObjsReq = ListObjectsRequest.builder()
				.bucket("s3jamesexp")
				.build();
		
		ListObjectsResponse listResp = s3.listObjects(listObjsReq);
		List<S3Object> listBucketContent = listResp.contents();
		// list contents in the bucket
		listBucketContent.forEach(name -> System.out.println(name.key()));
				
				
	}

}
