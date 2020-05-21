package com.dehaat.dehaatassignment.router

import android.content.Intent
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.dehaat.dehaatassignment.activity.LoginActivity

class MainRouter(private val activity: AppCompatActivity) : IMainRouter {
    override fun showErrorToast(message: String?) {
        Toast.makeText(activity, message, Toast.LENGTH_SHORT).show()
    }

    override fun openLoginActivity() {
        val intent = Intent(activity, LoginActivity::class.java)
        activity.startActivity(intent)
    }
}