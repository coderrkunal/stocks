package lib.rest;

import java.util.HashMap;
import java.util.Map;

abstract public class RestBase {
    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void addHeader(String headerKey, String headerValue){
        if(this.headers == null) this.headers = new HashMap<>();
        this.headers.put(headerKey, headerValue);
    }

    public Map<String, String> getHeaders(){
        return this.headers;
    }

    public void addUrlParams(String key, String value){
        if(this.urlParams == null) this.urlParams = new HashMap<>();
        this.urlParams.put(key, value);
    }

    public Map<String, String> getUrlParams() {
        return urlParams;
    }

    private String host;
    private String path;
    private Map<String, String> headers;
    private Map<String, String> urlParams;
}
