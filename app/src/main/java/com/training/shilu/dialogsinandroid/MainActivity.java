package com.training.shilu.dialogsinandroid;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /*
    A dialog is a small window that prompts the user to make a decision or enter additional information.
    A dialog does not fill the screen and is normally used for modal events that require users to take an action before they can proceed.
     */
    public void showDialog(View view) {
        Dialog dialog = new Dialog(this);
        dialog.setTitle("Lorem Ipsum");

        // creating view for dialog message
        TextView textView = new TextView(this);
        textView.setText("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer nec magna nibh. Quisque ac lectus nunc. Morbi sed semper ligula, at rutrum felis.");
        textView.setPadding(50, 50, 50, 50);

        dialog.setContentView(textView);

        dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {
                Toast.makeText(MainActivity.this, "Dialog Dismissed", Toast.LENGTH_SHORT).show();
            }
        });

        dialog.setOnShowListener(new DialogInterface.OnShowListener() {
            @Override
            public void onShow(DialogInterface dialog) {
                Toast.makeText(MainActivity.this, "Showing Dialog", Toast.LENGTH_SHORT).show();
            }
        });

        dialog.show();

    }

    public void showCustomDialog(View view) {
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_view);

        TextView tvMessage = (TextView) dialog.findViewById(R.id.tv_dialog_message);
        tvMessage.setText("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer nec magna nibh. Quisque ac lectus nunc. Morbi sed semper ligula, at rutrum felis.");

        dialog.setTitle("Lorem Ipsum");
        dialog.show();
    }

    /*
     A subclass of Dialog that can display one, two or three buttons.
     If you only want to display a String in this dialog box, use the setMessage() method.
     Alert Dialogs extends dialogs
    */
    public void showAlertDialog(View view) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                MainActivity.this);

        // set title
        alertDialogBuilder.setTitle("Lorem Ipsum");

        // set dialog message
        alertDialogBuilder
                .setMessage("Click yes to exit!")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // if this button is clicked, close
                        // current activity
                        MainActivity.this.finish();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // if this button is clicked, just close
                        // the dialog box and do nothing
                        dialog.cancel();
                    }
                });

        // create alert dialog
        AlertDialog alertDialog = alertDialogBuilder.create();

        // show it
        alertDialog.show();
    }

    public void showLongToast(View view) {
        Toast.makeText(MainActivity.this, "Long Toast", Toast.LENGTH_LONG).show();
    }

    public void showShortToast(View view) {
        Toast.makeText(MainActivity.this, "Short Toast", Toast.LENGTH_LONG).show();
    }

    public void showCustomToast(View view) {
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.toast_layout,
                (ViewGroup) findViewById(R.id.toast_layout_root));

        ImageView image = (ImageView) layout.findViewById(R.id.image);
        image.setImageResource(R.mipmap.ic_launcher);
        TextView text = (TextView) layout.findViewById(R.id.text);
        text.setText("This is a custom toast!");

        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);
        toast.show();
    }

}
