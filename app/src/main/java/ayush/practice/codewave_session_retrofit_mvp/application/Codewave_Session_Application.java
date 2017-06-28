package ayush.practice.codewave_session_retrofit_mvp.application;

import android.app.Application;

/**
 * Created by Ayush Jain on 6/26/17.
 */

public class Codewave_Session_Application extends Application {

    public static Codewave_Session_Application applicationObject;

    private Codewave_Session_Application() {
    }
    public static Codewave_Session_Application getApplicationObject()
    {
        if(applicationObject != null)
            return applicationObject;
        else
            applicationObject = new Codewave_Session_Application();
        return applicationObject;
    }

}
