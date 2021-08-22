package lib.rest;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;

public class RestApacheImpl extends RestBase implements RestCall{
    public String doGet(){
        StringBuilder response = new StringBuilder();
        try {
            assert (getHost() != null);
            assert (getPath() != null);

            DefaultHttpClient httpClient = new DefaultHttpClient();
            HttpGet getRequest = new HttpGet(getHost() + getPath());

            //TODO add url param

            if(getHeaders() == null) {
                //Default to JSON
                getRequest.addHeader("accept", "application/json");
            } else{
                getHeaders().forEach(getRequest::addHeader);
            }

            HttpResponse resp = httpClient.execute(getRequest);

            if (resp.getStatusLine().getStatusCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + resp.getStatusLine().getStatusCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader((resp.getEntity().getContent())));

            String output;
            while ((output = br.readLine()) != null) {
                response.append(output);
            }

            httpClient.getConnectionManager().shutdown();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return response.toString();
    }

    @Override
    public String doPost() {
        throw new NotImplementedException();
    }
}
