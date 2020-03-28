package com.example.alertdialogs;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    private Button mShowDialogBtn;
    private CharSequence[] mAlertItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mShowDialogBtn = findViewById(R.id.show_dialog_button);

        mAlertItem = new CharSequence[]{
                "Movies",
                "Photos",
                "Music",
                "all"
        };

        mShowDialogBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(MainActivity.this);
                builder.setTitle("Show Option");
                builder.setBackground(getResources().getDrawable(R.drawable.alert_dialog_bg));
                builder.setIcon(R.drawable.ic_sync_disabled_black_24dp);
                //builder.setMessage("This Is A Sample Alert Dialog Example");
                // add multi item to alertDialog radioButton
                builder.setSingleChoiceItems(mAlertItem, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //do something here
                        Snackbar.make(mShowDialogBtn,"You Have Selected : "+i,Snackbar.LENGTH_LONG).show();
                        dialogInterface.dismiss();
                    }
                });

                builder.show();
            }
        });
    }
}
