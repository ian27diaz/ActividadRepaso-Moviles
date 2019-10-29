package ian.meda.abccompany.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ian.meda.abccompany.R
import ian.meda.abccompany.utils.SHARED_PREFERENCES
import ian.meda.abccompany.utils.USERNAME

class ActivitySplashScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        val sharedPreferences = getSharedPreferences(SHARED_PREFERENCES, Context.MODE_PRIVATE)
        val username = sharedPreferences.getString(USERNAME, "")

        val intent = if (username == "")
            Intent(this, ActivityLogin::class.java)
        else
            Intent(this, MainActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP)
        startActivity(intent)
    }
}
