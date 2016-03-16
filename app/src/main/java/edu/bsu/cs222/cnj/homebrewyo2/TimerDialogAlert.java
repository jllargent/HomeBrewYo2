package edu.bsu.cs222.cnj.homebrewyo2;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;

public class TimerDialogAlert extends DialogFragment{
    public TimerDialogAlert(){}

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){
        Bundle args = getArguments();
        String title = args.getString("title", "");
        String message = args.getString("message", "");

        return new AlertDialog.Builder(getActivity())
            .setTitle(title)
            .setMessage(message)
            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    getTargetFragment().onActivityResult(getTargetRequestCode(), Activity.RESULT_OK, null);
                }
            })
            .create();

    }
}
