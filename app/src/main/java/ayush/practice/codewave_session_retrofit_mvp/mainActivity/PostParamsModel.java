package ayush.practice.codewave_session_retrofit_mvp.mainActivity;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Ayush Jain on 6/26/17.
 */

public class PostParamsModel
{
    @SerializedName("email")
    private String email;

    @SerializedName("token")
    private String token;


    public PostParamsModel() {
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "PostParamsModel{" +
                "email='" + email + '\'' +
                ", token='" + token + '\'' +
                '}';
    }

    public PostParamsModel(String email, String token) {
        this.email = email;
        this.token = token;
    }

    public String getEmail() {

        return email;
    }

    public String getToken() {
        return token;
    }
}
