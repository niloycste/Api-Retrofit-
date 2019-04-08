package com.bitm.retrofit;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.MyViewHolder> {

  //  private List<Post> postList;
    private List<Comment> commentList;

    public PostAdapter(List<Comment> commentList) {
        this.commentList = commentList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        return new MyViewHolder(LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_post,viewGroup,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

       Comment comment = commentList.get(i);

       myViewHolder.id.setText("Post ID: "+ comment.getPostId());
       myViewHolder.title.setText("Name: "+ comment.getName());
       myViewHolder.body.setText("Email: "+ comment.getEmail());

    }

    @Override
    public int getItemCount() {
        return commentList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView userId,id,title,body;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            userId = itemView.findViewById(R.id.userID);
            id = itemView.findViewById(R.id.ID);
            title = itemView.findViewById(R.id.titleID);
            body = itemView.findViewById(R.id.bodyID);
        }
    }
}
