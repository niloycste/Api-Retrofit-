package com.bitm.retrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface Post_service {

    @GET("/post")
    Call<List<Post>> getAllPost();

    @GET("/comments")
    Call<List<Comment>> getCommentByPostID(@Query("postId") int id);

    @GET("/posts/{id}/comments")
    Call<List<Comment>> getComment(@Path("id") int id);

    @POST("/posts")
    Call<Post> setPost(@Body Post post);

}
