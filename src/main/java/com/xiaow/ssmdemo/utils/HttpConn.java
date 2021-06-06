package com.xiaow.ssmdemo.utils;

//import org.apache.http.conn.ConnectTimeoutException;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

/**
 * Created by silence on 2016/9/15.
 */
public final class HttpConn {
    public static int mTimeOutDuration = 15000;
//    public static String mStrSplit = "lizx_silence";
    public static Map<String, String> mMapHeader = null;
    public static int UNAUTH_CODE = 401;

    /**
     * Get请求方式
     */
    public static String get(String url) throws Exception {
//    public static String get(String url) {
        String retJson = null;
        BufferedReader reader = null;
        URL tUrl = null;
        HttpURLConnection conn = null;
//        try {
            tUrl = new URL(url);
            conn = (HttpURLConnection) tUrl.openConnection();
            conn.setConnectTimeout(mTimeOutDuration);
            conn.setReadTimeout(mTimeOutDuration);
            conn.setRequestProperty("connection", "keep-alive");
            conn.setRequestProperty("Charset", "UTF-8");
            if (mMapHeader != null && mMapHeader.size() > 0) {
                for (Map.Entry<String, String> entry : mMapHeader.entrySet()) {
                    String key = (String) entry.getKey();
                    String value = (String) entry.getValue();
                    conn.setRequestProperty(key, value);
                }
            }
            conn.setRequestMethod("GET");
            conn.connect();
            if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
                reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                StringBuilder strBuilder = new StringBuilder();
                while ((retJson = reader.readLine()) != null) {
                    strBuilder.append(retJson);
                }
                retJson = strBuilder.toString();
            } else if (conn.getResponseCode() == HttpURLConnection.HTTP_NOT_FOUND) {
//                retJson = TASK_FAIL._404_ERROR.name();
            	retJson = null;
            } else if (conn.getResponseCode() == UNAUTH_CODE) {
//                retJson = TASK_FAIL._401_ERROR.name();
                retJson = null;
            } else {
//                retJson = TASK_FAIL._5___ERROR.name() + mStrSplit + conn.getResponseCode();
            	retJson = null;
            }
//        } catch (IOException e) {
//            if (e instanceof ConnectException) {
//                String detailMessage = e.getLocalizedMessage();
//                if (detailMessage != null && detailMessage.contains("Connection refused")) {
//                    retJson = TASK_FAIL._5___ERROR.name() + mStrSplit + 503;
//                } else {
//                    retJson = TASK_FAIL.NET_CONNECT_ERROR.name();
//                }
//            } else if (e instanceof UnknownHostException) {
//                retJson = TASK_FAIL._404_ERROR.name();
//            } else if (e instanceof ConnectTimeoutException ||
//                    e instanceof SocketTimeoutException ||
//                    e instanceof InterruptedIOException) {
//                retJson = TASK_FAIL.TIME_OUT_ERROR.name();
//            } else {
//                retJson = TASK_FAIL.NETWORK_ERROR.name() + mStrSplit + e.getLocalizedMessage();
//            }
//        } finally {
            if (reader != null) {
//                try {
                    reader.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
            }
            if (conn != null) {
                conn.disconnect();
            }
//        }
        return retJson;
    }


    /**
     * Post请求方式
     */
    public static String post(String url, String json) throws Exception {
//    public static String post(String url, String json) {
        String retJson = null;
        PrintWriter writer = null;
        BufferedReader reader = null;
        URL tUrl = null;
        HttpURLConnection conn = null;
//        try {
            tUrl = new URL(url);
            conn = (HttpURLConnection) tUrl.openConnection();
            conn.setConnectTimeout(mTimeOutDuration);
            conn.setReadTimeout(mTimeOutDuration);
            conn.setDoInput(true);
            conn.setDoOutput(true);
            conn.setRequestProperty("connection", "keep-alive");
            conn.setRequestProperty("Charset", "UTF-8");
            if (mMapHeader != null && mMapHeader.size() > 0) {
                for (Map.Entry<String, String> entry : mMapHeader.entrySet()) {
                    String key = (String) entry.getKey();
                    String value = (String) entry.getValue();
                    conn.setRequestProperty(key, value);
                }
            }
            conn.setRequestMethod("POST");
            conn.setUseCaches(false);
            conn.setInstanceFollowRedirects(true);
            conn.connect();
            writer = new PrintWriter(new OutputStreamWriter(conn.getOutputStream()));
            writer.print(json);
            writer.flush();
            if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
                reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                StringBuilder strBuilder = new StringBuilder();
                while ((retJson = reader.readLine()) != null) {
                    strBuilder.append(retJson);
                }
                retJson = strBuilder.toString();
            } else if (conn.getResponseCode() == HttpURLConnection.HTTP_NOT_FOUND) {
//                retJson = TASK_FAIL._404_ERROR.name();
            	retJson = null;
            } else if (conn.getResponseCode() == UNAUTH_CODE) {
//                retJson = TASK_FAIL._401_ERROR.name();
                retJson = null;
            } else {
//                retJson = TASK_FAIL._5___ERROR.name() + mStrSplit + conn.getResponseCode();
            	retJson = null;
            }
//        } catch (IOException e) {
//            if (e instanceof ConnectException) {
//                String detailMessage = e.getLocalizedMessage();
//                if (detailMessage != null && detailMessage.contains("Connection refused")) {
//                    retJson = TASK_FAIL._5___ERROR.name() + mStrSplit + 503;
//                } else {
//                    retJson = TASK_FAIL.NET_CONNECT_ERROR.name();
//                }
//            } else if (e instanceof UnknownHostException) {
//                retJson = TASK_FAIL._404_ERROR.name();
//            } else if (e instanceof ConnectTimeoutException ||
//                    e instanceof SocketTimeoutException ||
//                    e instanceof InterruptedIOException) {
//                retJson = TASK_FAIL.TIME_OUT_ERROR.name();
//            } else {
//                retJson = TASK_FAIL.NETWORK_ERROR.name() + mStrSplit + e.getLocalizedMessage();
//            }
//        } finally {
            if (writer != null) {
                /**
                 * 关闭\释放资源
                 */
                writer.close();
            }
            if (reader != null) {
//                try {
                    reader.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
            }
            if (conn != null) {
                conn.disconnect();
            }
//        }
        return retJson;
    }


}
