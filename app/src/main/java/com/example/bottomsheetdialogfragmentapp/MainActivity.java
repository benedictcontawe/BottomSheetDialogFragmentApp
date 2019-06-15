package com.example.bottomsheetdialogfragmentapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, CustomBottomSheetDialogListener {

    Button btnShow;
    CustomBottomSheetDialogFragment customBottomSheetDialogFragment;
    Boolean isFragmentActive;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnShow = (Button)findViewById(R.id.btnShow);

        btnShow.setOnClickListener(this);

        isFragmentActive = false;
    }


    @Override
    public void onClick(View v) {
        if(v.getId() == btnShow.getId()){
            showBottomSheetFragment();
        }
    }

    private void showBottomSheetFragment(){
        customBottomSheetDialogFragment = new CustomBottomSheetDialogFragment();
        customBottomSheetDialogFragment.setListener(this);
        customBottomSheetDialogFragment.setTitle("My Title");
        customBottomSheetDialogFragment.setSubTitle("My Subtitle");
        customBottomSheetDialogFragment.setHint("My Hint");
        customBottomSheetDialogFragment.setCancelable(false);
        customBottomSheetDialogFragment.show(getSupportFragmentManager(), customBottomSheetDialogFragment.getTag());
        isFragmentActive = true;
    }

    @Override
    protected void onPause() {
        super.onPause();

        customBottomSheetDialogFragment.dismiss();
        customBottomSheetDialogFragment = null;
    }

    @Override
    protected void onResume() {
        super.onResume();

        if (isFragmentActive) {
            showBottomSheetFragment();
        }
    }

    @Override
    public void submit(String answer) {
        Toast.makeText(this,"submit("+ answer +")",Toast.LENGTH_SHORT).show();
        isFragmentActive = false;
    }

    @Override
    public void cancel() {
        Toast.makeText(this,"cancel()",Toast.LENGTH_SHORT).show();
        isFragmentActive = false;
    }

    @Override
    public void close() {
        Toast.makeText(this,"close()",Toast.LENGTH_SHORT).show();
        isFragmentActive = false;
    }
}
