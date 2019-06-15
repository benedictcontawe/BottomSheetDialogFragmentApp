package com.example.bottomsheetdialogfragmentapp;

import android.app.ActionBar;
import android.content.Context;
import android.graphics.Typeface;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

public class RoundedButton extends AppCompatButton {

    public RoundedButton(Context context) {
        super(context);
        init();
    }

    public RoundedButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public RoundedButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init(){
        setBackgroundResource(R.drawable.capsule_rounded_button_blue);
        setTypeface(getTypeface(), Typeface.BOLD);
        setAllCaps(false);
        setTextColor(ContextCompat.getColor(getContext(),R.color.colorAccent));

        this.setLayoutParams(new LinearLayout.LayoutParams(ActionBar.LayoutParams.MATCH_PARENT,100));
    }

    @Override
    public void setOnClickListener(final View.OnClickListener l) {
        super.setOnClickListener(new DebouncedOnClickListener() {
            @Override
            public void onDebouncedClick(View v) {
                l.onClick(v);
            }
        });
    }
}
