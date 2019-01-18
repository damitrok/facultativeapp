package dmitry.com.facultativeapp.sync;

import java.util.List;

import dmitry.com.facultativeapp.Model.AccessToken;
import dmitry.com.facultativeapp.Model.GitHubRepo;
import dmitry.com.facultativeapp.Model.User;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface Api {

    //Интерфейс который описывает наши запросы на сервер

    @Headers("Accept: application/json")
    @POST("/login/oauth/access_token")
    @FormUrlEncoded
    Call<AccessToken> getAccessToken(
            @Field("client_id") String clientId,
            @Field("client_secret") String clientSecret,
            @Field("code") String code);

    //Метод для получения юзера по токену
    @GET("/user")
    Call<User>getCurrentUser();

    //метод для получения репозиторие пользователя
    @GET("/users/{user}/repos")
    Call<List<GitHubRepo>>getReposForUser(@Path("user") String user);

    //Метод для сброса авторизации
    @DELETE("/applications/{clientId}/tokens/{token}")
    Call<String>logOut(@Path("clientId") String clientId,
                       @Path("token") String token);


//    https://github.com/settings/applications/952021/revoke_all_tokens
//    @POST("/settings/applications/952021/revoke_all_tokens")
//    Call<String>deleteToken();

}
