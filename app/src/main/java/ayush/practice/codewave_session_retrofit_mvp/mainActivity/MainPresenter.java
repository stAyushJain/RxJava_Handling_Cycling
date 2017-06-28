package ayush.practice.codewave_session_retrofit_mvp.mainActivity;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Point;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import ayush.practice.codewave_session_retrofit_mvp.R;
import ayush.practice.codewave_session_retrofit_mvp.networking.RetrofitInit;
import ayush.practice.codewave_session_retrofit_mvp.networking.RetrofitServices;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by Ayush Jain on 6/27/17.
 */

public class MainPresenter implements MainContract.Presenter{

    private static final int NUM_OF_SIDES = 3;

    private MainContract.View uiUpdater;
    private Context context;
    private Point[] pentagonVertices;
    private Button[] buttons;

    public MainPresenter(@NonNull Context context, @NonNull MainContract.View view) {
        uiUpdater = view;
        this.context = context;
    }

    @Override
    public void loadMyData()
    {
        Retrofit retrofit = new RetrofitInit("https://api.github.com/").getRetrofitInstance();
        Call<MainModel.GetModelResponse.GitHubResponseModel> call = retrofit.create(RetrofitServices.class)
                                                                            .sendGetRequest("caspyin");
        call.enqueue(new Callback<MainModel.GetModelResponse.GitHubResponseModel>() {
            @Override
            public void onResponse(Call<MainModel.GetModelResponse.GitHubResponseModel> call, Response<MainModel.GetModelResponse.GitHubResponseModel> response) {

                uiUpdater.onSuccess();
            }

            @Override
            public void onFailure(Call<MainModel.GetModelResponse.GitHubResponseModel> call, Throwable t) {
                uiUpdater.onFailure();
            }
        });

    }
}
