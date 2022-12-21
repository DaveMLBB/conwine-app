package it.conwine.android.retrofit;

import it.conwine.android.models.User;
import retrofit2.Call;
import retrofit2.http.POST;

public interface UserApi {

    @POST("/api/auth/signup")
    Call<User> save(User user);
}
