package com.example.loginpage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class UserDetailsAdapter extends RecyclerView.Adapter<UserDetailsAdapter.ViewHolder> {

    private final List<String> userDetailsList;

    public UserDetailsAdapter(List<String> userDetailsList) {
        this.userDetailsList = userDetailsList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user_detail, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String detail = userDetailsList.get(position);
        holder.detailTextView.setText(detail);
    }

    @Override
    public int getItemCount() {
        return userDetailsList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView detailTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            detailTextView = itemView.findViewById(R.id.user_detail_text);
        }
    }
}
