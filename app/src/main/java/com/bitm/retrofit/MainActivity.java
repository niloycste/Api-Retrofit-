package com.bitm.retrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private PostAdapter postAdapter;
    private List<Post> posts;
    private List<Comment> comments;
    Post_service postService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerCiewID);
        posts = new ArrayList<>();
        comments = new ArrayList<>();
        postService = RetrofitClass.getRetrofitInstance().create(Post_service.class);

        //getAllPostResponse();

        getCommentByID();
    }

    private void getCommentByID() {

        Call<List<Comment>> serviceCommentResponse = postService.getCommentByPostID(1);

        serviceCommentResponse.enqueue(new Callback<List<Comment>>() {
            @Override
            public void onResponse(Call<List<Comment>> call, Response<List<Comment>> response) {
                if (response.code()==200){

                   comments= response.body();
                    postAdapter = new PostAdapter(comments);
                    recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                    recyclerView.setAdapter(postAdapter);
                }
            }

            @Override
            public void onFailure(Call<List<Comment>> call, Throwable t) {

            }
        });
    }

    private void getAllPostResponse() {

        Call<List<Post>> serviceResponse= postService.getAllPost();

        serviceResponse.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                if (response.code() == 200){
                    posts = response.body();
                  /*  postAdapter = new PostAdapter(posts);
                    recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                    recyclerView.setAdapter(postAdapter);*/
                }

            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }
}
