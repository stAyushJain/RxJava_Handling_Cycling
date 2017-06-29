package ayush.practice.codewave_session_retrofit_mvp.mainActivity;

import android.content.Context;
import android.graphics.Point;
import android.support.annotation.NonNull;
import android.widget.Button;

import org.reactivestreams.Subscription;

import java.util.HashMap;
import java.util.Map;

import ayush.practice.codewave_session_retrofit_mvp.networking.RetrofitInit;
import ayush.practice.codewave_session_retrofit_mvp.networking.RetrofitServices;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by Ayush Jain on 6/27/17.
 */

public class MainPresenter implements MainContract.Presenter{


    private MainContract.View uiUpdater;
    private Context context;
    private Disposable disposable;

    public MainPresenter(@NonNull Context context, @NonNull MainContract.View view) {
        uiUpdater = view;
        this.context = context;
    }

    @Override
    public void rxUnSubscribe() {
        if(disposable != null)
        disposable.dispose();
    }

    @Override
    public void loadMyObserver(boolean useCache) {

        Map<String, String> mParams = new HashMap<>();
        mParams.put("email","neha@codewave.in");
        mParams.put("token","24548");
        RetrofitInit retrofitInit = new RetrofitInit("https://www.stafftimes.com/app/");
        Retrofit retrofit = retrofitInit.getRetrofitInstance();
        Observable<PostResponseModel> responseModelObservable = retrofit.create(RetrofitServices.class)
                .getObserverTokenAuth("tokenVerification",mParams);
        Observable<PostResponseModel> myPreparedObservable = (Observable<PostResponseModel>)retrofitInit.getPreparedObservable(responseModelObservable, PostResponseModel.class,true,useCache);

        myPreparedObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.io())
                .subscribe(new Observer<PostResponseModel>() {
            @Override
            public void onSubscribe(Disposable d) {
                disposable = d;
            }

            @Override
            public void onNext(PostResponseModel postResponseModel) {
                    uiUpdater.onSuccess();
            }

            @Override
            public void onError(Throwable e) {
                uiUpdater.onFailure();
            }

            @Override
            public void onComplete() {

            }
        });


    }



    @Override
    public void loadMyData()
    {
        Retrofit retrofit = new RetrofitInit("https://api.github.com/").getRetrofitInstance();
        Call<GitHubResponseModel> call = retrofit.create(RetrofitServices.class).sendGetRequest("caspyin");
        call.enqueue(new Callback<GitHubResponseModel>() {
            @Override
            public void onResponse(Call<GitHubResponseModel> call, Response<GitHubResponseModel> response) {

                uiUpdater.onSuccess();
            }

            @Override
            public void onFailure(Call<GitHubResponseModel> call, Throwable t) {
                uiUpdater.onFailure();
            }
        });

    }
}
