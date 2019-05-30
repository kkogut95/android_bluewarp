package app.bluebay.features.splash

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import app.bluebay.features.menu.SignInMenuActivity

class SplashScreenActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startActivity(Intent(this, SignInMenuActivity::class.java))
    }
}