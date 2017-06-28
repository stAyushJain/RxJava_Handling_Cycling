package ayush.practice.codewave_session_retrofit_mvp.networking;


import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import ayush.practice.codewave_session_retrofit_mvp.application.Codewave_Session_Application;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Ayush Jain on 6/27/17.
 */

public class RetrofitInit {

    private String baseUrl;

    public RetrofitInit(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public Retrofit getRetrofitInstance()
    {
        if(baseUrl != null)
        {
            if(baseUrl.length() > 0)
            {
                return new Retrofit.Builder()
                         .addConverterFactory(GsonConverterFactory.create())
                        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                        .baseUrl(baseUrl)
                        .build();
            }
        }
        return null;
    }

    public Retrofit getRetrofitInstanceWithClientUpdate()
    {
        Gson gson = provideGson();
        OkHttpClient okHttpClient = provideOkhttpClient();
        if(baseUrl != null)
        {
            if(baseUrl.length() > 0)
            {
                return  new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(baseUrl)
                .client(okHttpClient)
                .build();
            }
        }
        return null;
    }


    private Cache provideHttpCache(Codewave_Session_Application application) {
        int cacheSize = 10 * 1024 * 1024;
        Cache cache = new Cache(application.getCacheDir(), cacheSize);
        return cache;
    }


    private Gson provideGson() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);
        return gsonBuilder.create();
    }


    private OkHttpClient provideOkhttpClient() {
        Cache cache = provideHttpCache(Codewave_Session_Application.getApplicationObject());
        OkHttpClient.Builder client = new OkHttpClient.Builder();
        client.cache(cache);
        return client.build();
    }
}
