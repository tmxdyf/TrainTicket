package com.cy.src.trainticket.data.api;

import android.util.Log;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.SecureRandom;
import java.security.cert.CertificateFactory;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManagerFactory;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by CY on 2016/9/26.
 */

public class RequestHelper {

    //    https://github.com/tmxdyf/widuu

//    获取余票信息
//    http://kyfw.12306.cn/otn/lcxxcx/query?purpose_codes=ADULT&queryDate=$date&from_station=$startstaion&to_station=$endstation

//    获取价格信息
//    http://kyfw.12306.cn/otn/leftTicket/queryTicketPrice?train_no=".$data[$key]["train_no"]."&from_station_no=".$data[$key]["from_station_no"]."&to_station_no=".$data[$key]["to_station_no"]."&seat_types=".$data[$key]["seat_types"]."&train_date=$date

//    12305证书问题
//    http://www.jcodecraeer.com/a/anzhuokaifa/androidkaifa/2015/0831/3393.html
//    获取车票最佳路线
//    A->B
//    A->.............->B

    private static ApiService mApiService;

    static {

        OkHttpClient client = new OkHttpClient.Builder()

                .addInterceptor(chain -> {
                    Request request = chain.request();
                    Response response = chain.proceed(request);
                    ResponseBody responseBody = response.body();
                    String body = responseBody.string();
                    ResponseBody newResponseBody = ResponseBody.create(responseBody.contentType(), body);
                    Log.e("RequestHelper", "request url=" + request.url());
                    Log.e("RequestHelper", "body=" + body);
                    Response newResponse = response.newBuilder().body(newResponseBody).build();
                    return newResponse;
                })
                .sslSocketFactory(setCertificates(get12306Cer()))
                .build();

        Retrofit retrofit = new Retrofit.Builder().client(client)
                .baseUrl("https://kyfw.12306.cn")//https://kyfw.12306.cn/otn/lcxxcx/query?purpose_codes=ADULT&queryDate=2016-09-30&from_station=IOQ&to_station=WHN
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        mApiService = retrofit.create(ApiService.class);
    }

    public static ApiService getApiService() {
        return mApiService;
    }


    /**
     * 12306证书
     * @return
     */
    public static InputStream get12306Cer() {
//        context.getAssets().open("src")
        String CER_12306 = "-----BEGIN CERTIFICATE-----\n" +
                "MIICmjCCAgOgAwIBAgIIbyZr5/jKH6QwDQYJKoZIhvcNAQEFBQAwRzELMAkGA1UEBhMCQ04xKTAn\n" +
                "BgNVBAoTIFNpbm9yYWlsIENlcnRpZmljYXRpb24gQXV0aG9yaXR5MQ0wCwYDVQQDEwRTUkNBMB4X\n" +
                "DTA5MDUyNTA2NTYwMFoXDTI5MDUyMDA2NTYwMFowRzELMAkGA1UEBhMCQ04xKTAnBgNVBAoTIFNp\n" +
                "bm9yYWlsIENlcnRpZmljYXRpb24gQXV0aG9yaXR5MQ0wCwYDVQQDEwRTUkNBMIGfMA0GCSqGSIb3\n" +
                "DQEBAQUAA4GNADCBiQKBgQDMpbNeb34p0GvLkZ6t72/OOba4mX2K/eZRWFfnuk8e5jKDH+9BgCb2\n" +
                "9bSotqPqTbxXWPxIOz8EjyUO3bfR5pQ8ovNTOlks2rS5BdMhoi4sUjCKi5ELiqtyww/XgY5iFqv6\n" +
                "D4Pw9QvOUcdRVSbPWo1DwMmH75It6pk/rARIFHEjWwIDAQABo4GOMIGLMB8GA1UdIwQYMBaAFHle\n" +
                "tne34lKDQ+3HUYhMY4UsAENYMAwGA1UdEwQFMAMBAf8wLgYDVR0fBCcwJTAjoCGgH4YdaHR0cDov\n" +
                "LzE5Mi4xNjguOS4xNDkvY3JsMS5jcmwwCwYDVR0PBAQDAgH+MB0GA1UdDgQWBBR5XrZ3t+JSg0Pt\n" +
                "x1GITGOFLABDWDANBgkqhkiG9w0BAQUFAAOBgQDGrAm2U/of1LbOnG2bnnQtgcVaBXiVJF8LKPaV\n" +
                "23XQ96HU8xfgSZMJS6U00WHAI7zp0q208RSUft9wDq9ee///VOhzR6Tebg9QfyPSohkBrhXQenvQ\n" +
                "og555S+C3eJAAVeNCTeMS3N/M5hzBRJAoffn3qoYdAO1Q8bTguOi+2849A==\n" +
                "-----END CERTIFICATE-----";

        return new ByteArrayInputStream(CER_12306.getBytes());
    }

    /**
     * 设置证书
     *
     * @param certificates
     */
    public static SSLSocketFactory setCertificates(InputStream... certificates) {
        try {
            CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
            KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
            keyStore.load(null);
            int index = 0;
            for (InputStream certificate : certificates) {
                String certificateAlias = Integer.toString(index++);
                keyStore.setCertificateEntry(certificateAlias, certificateFactory.generateCertificate(certificate));

                try {
                    if (certificate != null)
                        certificate.close();
                } catch (IOException e) {
                }
            }

            SSLContext sslContext = SSLContext.getInstance("TLS");

            TrustManagerFactory trustManagerFactory =
                    TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());

            trustManagerFactory.init(keyStore);
            sslContext.init
                    (
                            null,
                            trustManagerFactory.getTrustManagers(),
                            new SecureRandom()
                    );
            SSLSocketFactory socketFactory = sslContext.getSocketFactory();
            return socketFactory;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
