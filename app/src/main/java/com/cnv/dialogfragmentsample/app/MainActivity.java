package com.cnv.dialogfragmentsample.app;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;


public class MainActivity extends Activity implements MyDialog.Commucator {
    FragmentManager manager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        manager = getFragmentManager();
    }


    public void showDialog(View view) {
        MyDialog myDialog = new MyDialog();
        myDialog.show(manager, "my dialog");
    }

    @Override
    public void respond(String data) {
        Toast.makeText(this,data, Toast.LENGTH_SHORT).show();
    }
}
