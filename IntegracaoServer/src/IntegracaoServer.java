  
import java.util.ArrayList;  
import java.util.List;  
  
import org.apache.http.Consts;  
import org.apache.http.HttpEntity;  
import org.apache.http.NameValuePair;  
import org.apache.http.client.entity.UrlEncodedFormEntity;  
import org.apache.http.client.methods.CloseableHttpResponse;  
import org.apache.http.client.methods.HttpPost;  
import org.apache.http.impl.client.CloseableHttpClient;  
import org.apache.http.impl.client.HttpClients;  
import org.apache.http.message.BasicNameValuePair;  
  
public class IntegracaoServer {  
    public static final String apiKey = "AIzaSyBcVemzq116fzWfAue8szbQfo6JzGraPns";
 public static void main(String[] args) throws Exception {  
  // Creating an instance of HttpClient.  
  CloseableHttpClient httpclient = HttpClients.createDefault();  
    
   // Creating an instance of HttpPost.  
   HttpPost httpost = new HttpPost("http://developer.android.com/google/gcm/index.html");  
   httpost.setHeader("Authorization","key ="+apiKey);
   httpost.setHeader("Content-Type", "application/x-www-form-urlencoded.charset=UTF-8");
   // Adding all form parameters in a List of type NameValuePair  
  
   List<NameValuePair> nvps = new ArrayList<NameValuePair>();  
   nvps.add(new BasicNameValuePair("registration_id", "cliente_dispositivo"));  
   nvps.add(new BasicNameValuePair("data.price", "teste"));  
  
   /** 
    * UrlEncodedFormEntity encodes form parameters and produce an 
    * output like param1=value1&param2=value2 
    */  
   httpost.setEntity(new UrlEncodedFormEntity(nvps, Consts.UTF_8));  
  
   // Executing the request.  
   CloseableHttpResponse response = httpclient.execute(httpost);  
   System.out.println("Response Status line :" + response.getStatusLine());  
   try {  
    // Do the needful with entity.  
    HttpEntity entity = response.getEntity();  
   } finally {  
    // Closing the response  
    response.close();  
   }  
   
   httpclient.close();  
   
 } 
}  