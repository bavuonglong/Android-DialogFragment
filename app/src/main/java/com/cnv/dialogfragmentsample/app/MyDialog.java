package com.cnv.dialogfragmentsample.app;

import android.app.Activity;
import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class MyDialog extends DialogFragment implements View.OnClickListener{
    Button yes, no;
    Commucator commucator;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        commucator = (Commucator) activity;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.my_dialog, null);
        yes = (Button)view.findViewById(R.id.yes);
        no = (Button) view.findViewById(R.id.no);
        yes.setOnClickListener(this);
        no.setOnClickListener(this);
        setCancelable(false);
        return view;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.yes) {
            commucator.respond("yes");
            dismiss();
        } else {
            commucator.respond("no");
            dismiss();
        }
    }

    public interface Commucator {
        void respond(String data);
    }
}
