package ayush.practice.codewave_session_retrofit_mvp.networking;


import android.util.LruCache;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import ayush.practice.codewave_session_retrofit_mvp.application.Codewave_Session_Application;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Ayush Jain on 6/27/17.
 */

public class RetrofitInit {


//    NOTE : On every call Im creating new Retrofit instance please make it in your project as singalton

    private String baseUrl;
    private static LruCache<Class<?>, Observable<?>> apiObservables;
    public static Retrofit retrofit;

    public RetrofitInit(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public Retrofit getRetrofitInstance()
    {
        if(retrofit != null)
            return retrofit;
        apiObservables = new LruCache<>(10);
        if(baseUrl != null)
        {
            if(baseUrl.length() > 0)
            {
                retrofit = new Retrofit.Builder()
                        .addConverterFactory(GsonConverterFactory.create())
                        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                        .baseUrl(baseUrl)
                        .build();
                return retrofit;
            }
        }
        return null;
    }

    public Retrofit getRetrofitInstanceWithClientUpdate()
    {
        Gson gson = provideGson();
        OkHttpClient okHttpClient = provideOkhttpClient();
        apiObservables = new LruCache<>(10);
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


    public Observable<?> getPreparedObservable(Observable<?> unPreparedObservable, Class<?> clazz, boolean cacheObservable, boolean useCache){
        Observable<?> preparedObservable = null;

        if(useCache) //this way we don't reset anything in the cache if this is the only instance of us not wanting to use it.
            preparedObservable = apiObservables.get(clazz);
        else
            apiObservables.evictAll();

        if(preparedObservable!=null)
            return preparedObservable;

        //we are here because we have never created this observable before or we didn't want to use the cache...

        preparedObservable = unPreparedObservable.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());

        if(cacheObservable){
            preparedObservable = preparedObservable.cache();
            apiObservables.put(clazz, preparedObservable);
        }

        return preparedObservable;
    }
}
