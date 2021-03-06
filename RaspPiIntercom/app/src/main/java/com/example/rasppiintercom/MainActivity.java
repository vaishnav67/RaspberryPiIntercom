package com.example.rasppiintercom;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.EditText;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void sendMessage(View view){
        /*
    Intent intent = new Intent(this, MainActivity.class);
    EditText editText = (EditText) findViewById(R.id.editText);
    String message = editText.getText().toString();
    intent.putExtra(EXTRA_MESSAGE, message);
    startActivity(intent);
    */
        EditText editText1 = (EditText) findViewById(R.id.editText);
        EditText editText2 = (EditText) findViewById(R.id.editTextMotion);
        String ip = editText1.getText().toString();
        String motion = editText2.getText().toString();
        boolean ip_ad = Pattern.matches("(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)(\\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)){3}",ip);
        if(ip_ad==false) {
            Snackbar mySnackbar = Snackbar.make(view, "Not an IP address", BaseTransientBottomBar.LENGTH_LONG);
            mySnackbar.show();
        }
        else {
            WebView mWebView = (WebView) findViewById(R.id.camView);
            mWebView.loadUrl("http://"+ip+":"+motion);
        }
    }
    public void unlockDoor(View view){
        EditText editText1 = (EditText) findViewById(R.id.editText);
        EditText editText2 = (EditText) findViewById(R.id.editTextFlask);
        String ip = editText1.getText().toString();
        String flask = editText2.getText().toString();
        boolean ip_ad = Pattern.matches("(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)(\\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)){3}",ip);
        if(ip_ad==false) {
            Snackbar mySnackbar = Snackbar.make(view, "Not an IP address", BaseTransientBottomBar.LENGTH_LONG);
            mySnackbar.show();
        }
        else {
            WebView mWebView = (WebView) findViewById(R.id.camView);
            mWebView.loadUrl("http://"+ip+":"+flask+"/unlock");
        }
    }
}