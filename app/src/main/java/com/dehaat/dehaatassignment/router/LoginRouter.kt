package com.dehaat.dehaatassignment.router

import android.R
import android.content.DialogInterface
import android.content.Intent
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.startActivity
import com.dehaat.dehaatassignment.activity.MainActivity


class LoginRouter(val activity: AppCompatActivity): ILoginRouter {

    override fun showEmailErrorDialog() {
        AlertDialog.Builder(activity)
                .setTitle("Invalid Email!")
                .setMessage("The email that you have entered is not valid")
                .setPositiveButton(R.string.yes, DialogInterface.OnClickListener { dialog, _ ->
                    dialog.dismiss()
                })
                .setNegativeButton(R.string.no, null)
                .setIcon(R.drawable.ic_dialog_alert)
                .show()
    }

    override fun showPasswordErrorDialog() {
        AlertDialog.Builder(activity)
                .setTitle("Invalid Password!")
                .setMessage("The password can not contain less than 8 characters")
                .setPositiveButton(R.string.yes, DialogInterface.OnClickListener { dialog, _ ->
                    dialog.dismiss()
                })
                .setNegativeButton(R.string.no, null)
                .setIcon(R.drawable.ic_dialog_alert)
                .show()
    }

    override fun showErrorToast(message: String?) {
        message?.apply {
            Toast.makeText(activity, message, Toast.LENGTH_SHORT).show()
        }
    }

    override fun openMainActivity() {
        val intent = Intent(activity.baseContext, MainActivity::class.java)
        activity.startActivity(intent)
    }


}