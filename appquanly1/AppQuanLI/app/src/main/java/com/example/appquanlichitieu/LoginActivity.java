package com.example.appquanlichitieu;

import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    EditText edtUsername , edtPassword ;
    Button btnLogin, btnSignUp ;
   // CheckBox mCheckboxRememberMe;
    MyDatabase myDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        edtUsername = findViewById(R.id.edtUsername);
        edtPassword = findViewById(R.id.edtPassword);
        btnLogin = findViewById(R.id.btnLogin);
        btnSignUp = findViewById(R.id.btnSignup);
        myDatabase = new MyDatabase(this);
        //mCheckboxRememberMe =(CheckBox) findViewById(R.id.chkRememberMe);
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this,SignUpActivity.class);
                startActivity(intent);
            }
        });
        //login
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = edtUsername.getText().toString();
                String password = edtPassword.getText().toString();
                if (username.isEmpty()&& password.isEmpty()){
                    Toast.makeText(LoginActivity.this, "Vui lòng nhập tài khoản và mật khẩu", Toast.LENGTH_SHORT).show();
                }
                 else  {
                     Boolean checkuserpass = myDatabase.checkusernamepassword(username,password);
                     if (checkuserpass==true ){
                         Toast.makeText(LoginActivity.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                         Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                         startActivity(intent);
                     }else {
                         Toast.makeText(LoginActivity.this, "Tên tài khoản hoặc mật khẩu không chính xác", Toast.LENGTH_SHORT).show();
                     }
                    //rememberUser(username,password,mCheckboxRememberMe.isChecked());
                }
            }
        });
    }
   // public  void rememberUser(String usename , String pass , boolean status){
      //  SharedPreferences sharedPreferences = getSharedPreferences("prefname", Context.MODE_PRIVATE);
      //  SharedPreferences.Editor editor = sharedPreferences.edit();
      //  if(!status){
        //    editor.clear();
        //}else {
            //them data vao file
          //  editor.putString("USERNAME",usename);
          //  editor.putString("PASSWORD",pass);
          //  editor.putBoolean("REMEMBER",status);
       // }
        //luu lai
       // editor.commit();
    //}
  //  private void restoringPreference(){
        //SharedPreferences sharedPreferences = this.getSharedPreferences("prefname",Context.MODE_PRIVATE);
        //if(sharedPreferences != null){
            //lấy giá trị checked ra , nếu không lấy thì mặc định là false
           // boolean status = sharedPreferences.getBoolean("checked",false);
           // if(status){
               // String user = sharedPreferences.getString("USERNAME","admin");
               // String pass = sharedPreferences.getString("PASSWORD","admin123");
               // edtUsername.setText(user);
             //   edtPassword.setText(pass);
          //  }
           // mCheckboxRememberMe.setChecked(status);
      //  }
   // }
}