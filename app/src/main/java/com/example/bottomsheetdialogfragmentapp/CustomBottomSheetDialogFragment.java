package com.example.bottomsheetdialogfragmentapp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomBottomSheetDialogFragment extends BottomSheetDialogFragment {

    private View view;
    private TextView lblTitle,lblSubtitle,btnCancel;
    private TextInputLayout lblAnswer;
    private TextInputEditText txtAnswer;
    private RoundedButton btnSubmit;
    private ImageView btnClose;
    private CustomBottomSheetDialogListener customBottomSheetDialogListener;
    String title,subTitle,hint;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void setListener(CustomBottomSheetDialogListener customBottomSheetDialogListener){
        this.customBottomSheetDialogListener = customBottomSheetDialogListener;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public void setSubTitle(String subTitle){
        this.subTitle = subTitle;
    }

    public void setHint(String hint){
        this.hint = hint;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_custom_dynamic_bottom_sheet_dialog, container, false);

        lblTitle = (TextView) view.findViewById(R.id.lblTitle);
        lblSubtitle = (TextView) view.findViewById(R.id.lblSubtitle);
        btnCancel = (TextView) view.findViewById(R.id.btnCancel);
        lblAnswer = (TextInputLayout) view.findViewById(R.id.lblAnswer);
        txtAnswer = (TextInputEditText) view.findViewById(R.id.txtAnswer);
        btnSubmit = (RoundedButton) view.findViewById(R.id.btnSubmit);
        btnClose = (ImageView) view.findViewById(R.id.btnClose);

        setView();

        setEvents();

        return view;
    }

    private void setView(){
        lblTitle.setText(title);
        lblSubtitle.setText(subTitle);
        lblAnswer.setHint(hint);
    }

    private void setEvents(){
        btnSubmit.setOnClickListener(new DebouncedOnClickListener() {
            @Override
            public void onDebouncedClick(View v) {
                customBottomSheetDialogListener.submit(txtAnswer.getText().toString());
                dismiss();
            }
        });
        btnCancel.setOnClickListener(new DebouncedOnClickListener() {
            @Override
            public void onDebouncedClick(View v) {
                customBottomSheetDialogListener.cancel();
                dismiss();
            }
        });
        btnClose.setOnClickListener(new DebouncedOnClickListener() {
            @Override
            public void onDebouncedClick(View v) {
                customBottomSheetDialogListener.close();
                dismiss();
            }
        });
    }
}
