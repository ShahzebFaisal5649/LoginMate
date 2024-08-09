package com.example.loginpage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class UserDetailsActivity extends AppCompatActivity {

    private List<String> userDetailsList;
    private UserDetailsAdapter adapter;
    private EditText detailInput;
    private RecyclerView userDetailsRecyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_details);

        String username = getIntent().getStringExtra("username");
        String email = getIntent().getStringExtra("email");

        TextView usernameDisplay = findViewById(R.id.username_display);
        TextView emailDisplay = findViewById(R.id.email_display);
        detailInput = findViewById(R.id.detail_input);
        Button addDetailButton = findViewById(R.id.add_detail_button);
        Button addMoreDetailButton = findViewById(R.id.add_more_detail_button);
        Button logoutButton = findViewById(R.id.logout_button);
        userDetailsRecyclerView = findViewById(R.id.user_details_recycler_view);

        // Display the username and email
        usernameDisplay.setText("Username: " + username);
        emailDisplay.setText("Email: " + email);

        // Initialize RecyclerView and adapter
        userDetailsList = new ArrayList<>();
        adapter = new UserDetailsAdapter(userDetailsList);
        userDetailsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        userDetailsRecyclerView.setAdapter(adapter);

        // Handle add detail button
        addDetailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String detail = detailInput.getText().toString().trim();
                if (!detail.isEmpty()) {
                    userDetailsList.add(detail);
                    adapter.notifyItemInserted(userDetailsList.size() - 1);
                    detailInput.setText("");
                } else {
                    Toast.makeText(UserDetailsActivity.this, "Please enter detail", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Handle add more detail button
        addMoreDetailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Add more detail input functionality
                detailInput.setVisibility(View.VISIBLE);
                addDetailButton.setVisibility(View.VISIBLE);
            }
        });

        // Handle logout button
        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserDetailsActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
