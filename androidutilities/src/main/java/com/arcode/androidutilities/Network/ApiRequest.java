package com.arcode.androidutilities.Network;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class ApiRequest {

    public final String GET_METHOD = "GET";
    public final String POST_METHOD = "POST";
    private String API_BASE_URL;
    private String REQUEST_METHOD;
    private HashMap<String, String> REQUEST_HEADERS;
    private String API_RESPONSE;

    public ApiRequest() { this.REQUEST_HEADERS = new HashMap<>(); }

    public ApiRequest(String API_BASE_URL, String REQUEST_METHOD) {
        this.API_BASE_URL = API_BASE_URL;
        this.REQUEST_METHOD = REQUEST_METHOD;
        this.REQUEST_HEADERS = new HashMap<>();
    }

    public void setApiUrl(String API_BASE_URL) {
        this.API_BASE_URL = API_BASE_URL;
    }

    public void setRequestMethod(String REQUEST_METHOD) {
        this.REQUEST_METHOD = REQUEST_METHOD;
    }

    public void addHeader(String headerName, String headerValue) throws Exception {
        if(!this.REQUEST_HEADERS.containsKey(headerName))
            this.REQUEST_HEADERS.put(headerName, headerValue);
        else
            throw new Exception("Header already inserted before.");
    }

    public void deleteHeader(String headerName) throws Exception {
        if(this.REQUEST_HEADERS.containsKey(headerName))
            this.REQUEST_HEADERS.remove(headerName);
        else
            throw new Exception("Header Not Found.");
    }

    public void editHeader(String headerName, String headerValue) throws Exception {
        if (this.REQUEST_HEADERS.containsKey(headerName)){
            deleteHeader(headerName);
            addHeader(headerName, headerValue);
        }
        else
            throw new Exception("Header Not Found.");
    }

    private String readStream(InputStream in) {
        BufferedReader reader = null;
        StringBuilder response = new StringBuilder();
        try {
            reader = new BufferedReader(new InputStreamReader(in));
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return response.toString();
    }

    public void request() throws IOException {
        URL url = new URL(this.API_BASE_URL);
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        urlConnection.setRequestProperty("Request Method", this.REQUEST_METHOD);
        for (Map.Entry header: this.REQUEST_HEADERS.entrySet())
            urlConnection.setRequestProperty(header.getKey().toString(), header.getValue().toString());
        InputStream in = new BufferedInputStream(urlConnection.getInputStream());
        this.API_RESPONSE = this.readStream(in);
        urlConnection.disconnect();
    }

    public String getAPI_RESPONSE() {
        return API_RESPONSE;
    }
}
