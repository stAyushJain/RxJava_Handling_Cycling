package ayush.practice.codewave_session_retrofit_mvp.networking;

import java.util.Map;

import ayush.practice.codewave_session_retrofit_mvp.mainActivity.GitHubResponseModel;
import ayush.practice.codewave_session_retrofit_mvp.mainActivity.PostParamsModel;
import ayush.practice.codewave_session_retrofit_mvp.mainActivity.PostResponseModel;
import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Url;

/**
 * Created by Ayush Jain on 6/27/17.
 */

public interface RetrofitServices {

    //    https://api.github.com/users/caspyin
    @GET("users/{user}")
    Call<GitHubResponseModel> sendGetRequest(@Path("user") String user);

    @GET
    Call<GitHubResponseModel> sendGetRequestWithURL(@Url String subUrl);


//    https://www.***************.***/app/tokenVerification
//    ******@********.in, 24548

    @FormUrlEncoded
    @POST
    Call<PostResponseModel> getTokenAuth(@Url String subUrl, @FieldMap Map<String, String> params);

    @POST
    Call<PostResponseModel> getTokenAuthWithBody(@Url String subUrl, @Body PostParamsModel pojo);

    @FormUrlEncoded
    @POST
    Observable<PostResponseModel> getObserverTokenAuth(@Url String subUrl, @FieldMap Map<String, String> params);
//    For Image Upload WithParams or WithOutParams
//    Note : remove all @Part annotation apart from first to upload image without params

//    @Multipart
//    @POST("/profileUpdate")
//    Call<ResponseBody> postImage(@Part MultipartBody.Part image, @Part("employeeId") RequestBody name);

//    for passing data or  to upload an image a demo code is here :
//      File file = new File(getImagePath());
//      RequestBody reqFile = RequestBody.create(MediaType.parse("image/*"), file );
//      MultipartBody.Part body = MultipartBody.Part.createFormData("upload", file.getName(), reqFile);
//      RequestBody name = RequestBody.create(MediaType.parse("text/plain"), "upload_test");




//    @FormUrlEncoded
//    @POST("/api.php")
//    void postData(@Field("method") String method,
//                  @Field("username") String username,
//                  @Field("password") String password);
//


//    //Using @Query annotation we can append the url for example the below request will go like
//    First assume we called the method as :
//      foo.getData("admin","ayush","123")
//    so the request GET url will be like :
//      https://baseUrl/api?type=admin?username=ayush?password=123
//

//    @GET("/api")
//    void getData(@Query("type") String type,
//                 @Query("username") String username,
//                 @Query("password") String password);
}
