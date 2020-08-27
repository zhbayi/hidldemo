package com.aaron.hidldemo;

import androidx.appcompat.app.AppCompatActivity;
import android.hardware.aaron.V1_0.IAaron;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
	IAaron iAaronService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            iAaronService = IAaron.getService();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public void hidlTest(View view){
        if (iAaronService != null){
            Log.d("aaron", "service is connect.");
            String s = null;
            try {
                s = iAaronService.helloWorld("hidl demo success");
            } catch (RemoteException e) {
                e.printStackTrace();
            }
            Log.d("aaron", s);
            Toast.makeText(this, s, Toast.LENGTH_LONG).show();
        }
    }
}