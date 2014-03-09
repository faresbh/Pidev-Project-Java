package com.abstractTeam.IHM.GestionRestaurant;
import java.io.File;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.ContentBody;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.CoreProtocolPNames;
import org.apache.http.util.EntityUtils;
 
public class UploadFile2 {
public static void main(String[] args) throws Exception {
HttpClient httpclient = new DefaultHttpClient();
httpclient.getParams().setParameter(CoreProtocolPNames.PROTOCOL_VERSION, HttpVersion.HTTP_1_1);
 
HttpPost httppost = new HttpPost("http://localhost/pidev/test.php");
File file = new File("D:\\1932174_466486176814568_669595729_n.jpg");
 
MultipartEntity mpEntity = new MultipartEntity();
ContentBody cbFile = new FileBody(file, "image/jpeg");
mpEntity.addPart("userfile", cbFile);
 
httppost.setEntity(mpEntity);
System.out.println("executing request " + httppost.getRequestLine());
HttpResponse response = httpclient.execute(httppost);
HttpEntity resEntity = response.getEntity();
 
System.out.println(response.getStatusLine());
if (resEntity != null) {
System.out.println(EntityUtils.toString(resEntity));
}
if (resEntity != null) {
resEntity.consumeContent();
}
 
httpclient.getConnectionManager().shutdown();
}
}