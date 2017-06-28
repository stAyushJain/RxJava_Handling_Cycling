package ayush.practice.codewave_session_retrofit_mvp.mainActivity;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.graphics.Color;
import android.graphics.Point;
import android.os.PersistableBundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.LruCache;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

import ayush.practice.codewave_session_retrofit_mvp.R;
import ayush.practice.codewave_session_retrofit_mvp.networking.RetrofitInit;
import ayush.practice.codewave_session_retrofit_mvp.networking.RetrofitServices;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, MainContract.View{

    private static final int Num_OF_CIRCLE = 5;
    private final int CIRCLE_ANGEL = 11;

    int height, width, radius;
    int ANIMATION_DURATION = 300;
    int startPositionX = 0;
    int startPositionY = 0;
    int whichAnimation = 0;
    int[] enterDelay = {80, 120, 160, 40, 0};
    int[] exitDelay = {80, 40, 0, 120, 160};

    private TextView tvGo;
    private ConstraintLayout clRootView;
    private MainPresenter mPresenter;
    private Point[] buttonPoints;
    private Button[] buttons;

    boolean checkForMethodOpenClick = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        connectViewAndListeneres();
        height = (int) getResources().getDimension(R.dimen.button_height);
        width = (int) getResources().getDimension(R.dimen.button_width);
        radius = (int) getResources().getDimension(R.dimen.radius);
    }

    @Override
    public void onSuccess() {
        Toast.makeText(MainActivity.this, "Success", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onFailure() {
        Toast.makeText(MainActivity.this, "Fail", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStart() {
        super.onStart();


    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
    }

    private void connectViewAndListeneres() {
        clRootView = (ConstraintLayout)findViewById(R.id.rootView);
        tvGo = (TextView)findViewById(R.id.tvGo);
        tvGo.setOnClickListener(this);

        mPresenter = new MainPresenter(this,this);
        setButtonPositions(radius, CIRCLE_ANGEL);
    }

    @Override
    public void onClick(View view) {


        if(view.getId() == R.id.tvGo)
        {
            if(!checkForMethodOpenClick) {
                startPositionX = (int) view.getX() + 50;
                startPositionY = (int) view.getY() + 50;

                for (Button button : buttons) {
                    button.setX(startPositionX);
                    button.setY(startPositionY);
                    button.setVisibility(View.VISIBLE);
                }
                for (int i = 0; i < buttons.length; i++) {
                    showAnmatedButtons(buttons[i], i);
                }
                whichAnimation = 1;
                checkForMethodOpenClick = true;
            }
            else
            {
                for (int i = 0; i < buttons.length; i++) {
                    hideAnmatedButtons(buttons[i], i);
                }
                checkForMethodOpenClick = false;
            }
        }
        else
        {
            int tag = (int)view.getTag();
            switch (tag)
            {
                case 0:
                    mPresenter.loadMyData();
                    break;
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                default:
                    Toast.makeText(this, "Not Implemented", Toast.LENGTH_SHORT).show();
                    break;
            }

        }

    }

    private void hideAnmatedButtons(final Button button, int position) {

        AnimatorSet buttonAnimator = new AnimatorSet();

        ValueAnimator buttonAnimatorX = ValueAnimator.ofFloat(buttonPoints[position].x - button.getLayoutParams().width / 2,
                startPositionX);
        buttonAnimatorX.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                button.setX((float) animation.getAnimatedValue());
                button.requestLayout();
            }
        });
        buttonAnimatorX.setDuration(ANIMATION_DURATION);

        ValueAnimator buttonAnimatorY = ValueAnimator.ofFloat(buttonPoints[position].y,
                startPositionY + 5);
        buttonAnimatorY.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                button.setY((float) animation.getAnimatedValue());
                button.requestLayout();
            }
        });
        buttonAnimatorY.setDuration(ANIMATION_DURATION);

        ValueAnimator buttonSizeAnimator = ValueAnimator.ofInt(width, 5);
        buttonSizeAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                button.getLayoutParams().width = (int) animation.getAnimatedValue();
                button.getLayoutParams().height = (int) animation.getAnimatedValue();
                button.requestLayout();
            }
        });
        buttonSizeAnimator.setDuration(ANIMATION_DURATION);

        buttonAnimator.play(buttonAnimatorX).with(buttonAnimatorY).with(buttonSizeAnimator);
        buttonAnimator.setStartDelay(exitDelay[position]);
        buttonAnimator.start();

        buttonAnimator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {
                button.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });


    }

    private void showAnmatedButtons(final Button button, int position) {
            AnimatorSet buttonAnimator = new AnimatorSet();

            ValueAnimator buttonAnimatorX = ValueAnimator.ofFloat(startPositionX + button.getLayoutParams().width / 2,
                    buttonPoints[position].x);
            buttonAnimatorX.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    button.setX((float) animation.getAnimatedValue() - button.getLayoutParams().width / 2);
                    button.requestLayout();
                }
            });
            buttonAnimatorX.setDuration(ANIMATION_DURATION);

            ValueAnimator buttonAnimatorY = ValueAnimator.ofFloat(startPositionY + 5,
                    buttonPoints[position].y);
            buttonAnimatorY.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    button.setY((float) animation.getAnimatedValue());
                    button.requestLayout();
                }
            });
            buttonAnimatorY.setDuration(ANIMATION_DURATION);

            ValueAnimator buttonSizeAnimator = ValueAnimator.ofInt(5, width);
            buttonSizeAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    button.getLayoutParams().width = (int) animation.getAnimatedValue();
                    button.getLayoutParams().height = (int) animation.getAnimatedValue();
                    button.requestLayout();
                }
            });
            buttonSizeAnimator.setDuration(ANIMATION_DURATION);

            buttonAnimator.play(buttonAnimatorX).with(buttonAnimatorY).with(buttonSizeAnimator);
            buttonAnimator.setStartDelay(enterDelay[position]);
            buttonAnimator.start();

    }

    public void setButtonPositions(int radius, int rotation) {

        buttonPoints = new Point[Num_OF_CIRCLE];

        /**
         * Calculating the center of pentagon
         */
        Display display = getWindowManager().getDefaultDisplay();
        int centerX = display.getWidth() / 2;
        int centerY = display.getHeight() / 2;

        for (int i = 0; i < Num_OF_CIRCLE; i++) {
            buttonPoints[i] = new Point((int) (radius * Math.cos(rotation + i * 2 * Math.PI / Num_OF_CIRCLE)) + centerX,
                    (int) (radius * Math.sin(rotation + i * 2 * Math.PI / Num_OF_CIRCLE)) + centerY - 100);
        }

        buttons = new Button[buttonPoints.length];
        for (int i = 0; i < buttonPoints.length; i++) {
            buttons[i] = new Button(this);
            buttons[i].setLayoutParams(new ConstraintLayout.LayoutParams(5,5));
            buttons[i].setX(0);
            buttons[i].setY(0);
            buttons[i].setVisibility(View.INVISIBLE);
            buttons[i].setOnClickListener(this);
            buttons[i].setTag(i);
            buttons[i].setBackgroundResource(R.drawable.rounded_grey);
            buttons[i].setTextColor(Color.WHITE);
            switch (i)
            {
                case 0:
                    buttons[i].setText(R.string.get);
                    break;
                case 1:
                    buttons[i].setText(R.string.post1);
                    break;
                case 2:
                    buttons[i].setText(R.string.post2);
                    break;
                case 3:
                    buttons[i].setText(R.string.image);
                    break;
                case 4:
                    buttons[i].setText("?");
                    break;
            }

            buttons[i].setTextSize(15);
            clRootView.addView(buttons[i]);
        }
    }

    private void observer()
    {
        Map<String, String> paramsMap = new HashMap<String, String>();
        paramsMap.put("email","neha@codewave.in");
        paramsMap.put("token","24548");

        Retrofit retrofit = new RetrofitInit("https://www.stafftimes.com/").getRetrofitInstance();
         Observable<MainModel.PostModelResponse.PostResponseModel> observable = retrofit.create(RetrofitServices.class)
                .getObserverTokenAuth("app/tokenVerification",paramsMap);

        observable.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .unsubscribeOn(Schedulers.io())
                .subscribe(new Observer<MainModel.PostModelResponse.PostResponseModel>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(MainModel.PostModelResponse.PostResponseModel value) {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }


    private LruCache<Class<?>, Observable<?>> apiObservables = new LruCache<>(10);
    public Observable<?> getPreparedObservable(Observable<?> unPreparedObservable, Class<?> clazz, boolean cacheObservable, boolean useCache){
        Observable<?> preparedObservable = null;

        if(useCache) //this way we don't reset anything in the cache if this is the only instance of us not wanting to use it.
            preparedObservable = apiObservables.get(clazz);

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
