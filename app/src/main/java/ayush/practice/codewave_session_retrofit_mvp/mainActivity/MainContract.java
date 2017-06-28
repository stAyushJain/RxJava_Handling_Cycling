package ayush.practice.codewave_session_retrofit_mvp.mainActivity;

/**
 * Created by Ayush Jain on 6/27/17.
 */

public interface MainContract {

    public interface View {
      public void onSuccess();
        public void onFailure();
    }

    public interface Presenter {
        public void loadMyData();
    }

}
