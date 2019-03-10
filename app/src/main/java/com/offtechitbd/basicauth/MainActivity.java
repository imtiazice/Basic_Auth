package com.offtechitbd.basicauth;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.offtechitbd.basicauth.Model.User;
import com.offtechitbd.basicauth.Service.UserClient;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private UserLoginTask mAuthTask = null;
    Retrofit retrofit;
    String BASE_URL = "http://test.selliscope.com/api/v1/";
    static ProgressDialog loadingbar;

    EditText etEmail, etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etEmail = findViewById(R.id.email_ET);
        etPassword = findViewById(R.id.password_ET);
        loadingbar = new ProgressDialog(this);

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();



    }
    public void LogInClicked(View view) {

        String inputEmail = etEmail.getText().toString();
        String inputPassword = etPassword.getText().toString();

        showLoading();
        mAuthTask = new UserLoginTask(inputEmail, inputPassword);
        mAuthTask.execute((Void) null);

    }
    public void showLoading(){
        loadingbar.setTitle("Loading...");
        loadingbar.setMessage("Please Wait");
        loadingbar.setCanceledOnTouchOutside(false);
        loadingbar.show();
    }


    class UserLoginTask extends AsyncTask <Void, Void, Boolean> {
        String email;
        String password;

        UserLoginTask(String email, String password){
            this.email = email;
            this.password = password;
        }

        @Override
        protected Boolean doInBackground(Void... voids) {

            UserClient userClient = retrofit.create(UserClient.class);

//            String username = "leon@hll.com";
//            String password = "1234";

            String base = email+":"+password;

            String authHeader = "Basic " + Base64.encodeToString(base.getBytes(), Base64.NO_WRAP);
            Call<User> call = userClient.getUser(authHeader);
            try {
                Response<User> response = call.execute();
                if (response.isSuccessful()){
                    return true;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            return false;
        }
        @Override
        protected void onPostExecute(Boolean success) {
            mAuthTask = null;
            loadingbar.dismiss();

            if (success){
                Toast.makeText(MainActivity.this, "Login Successfull", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity.this, MapsActivity.class));
            }else {
                Toast.makeText(MainActivity.this, "Incorrect Password", Toast.LENGTH_SHORT).show();

            }
        }

        @Override
        protected void onCancelled() {
            mAuthTask = null;
            loadingbar.dismiss();
            super.onCancelled();
        }
    }
}

