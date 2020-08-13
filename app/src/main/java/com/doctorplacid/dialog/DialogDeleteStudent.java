package com.doctorplacid.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;

import com.doctorplacid.activity.ITableListener;
import com.doctorplacid.R;

public class DialogDeleteStudent extends AppCompatDialogFragment {

    ITableListener listener;

    private String name;

    public DialogDeleteStudent(String name) {
        this.name = name;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        View view = getActivity()
                .getLayoutInflater()
                .inflate(R.layout.fragment_dialog_delete, null);

        builder.setView(view)
                .setTitle("Delete " + name + "?")
                .setNegativeButton("Cancel", (dialog, which) ->
                        DialogDeleteStudent.super.onDestroy())
                .setPositiveButton("Delete", (dialog, which) ->
                        listener.deleteStudent());
        return builder.create();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            listener = (ITableListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + "Must implement ITableListener");
        }
    }
}
