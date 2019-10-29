package ian.meda.abccompany.activities

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import ian.meda.abccompany.R
import ian.meda.abccompany.utils.SHARED_PREFERENCES
import ian.meda.abccompany.utils.USERNAME
import org.jetbrains.anko.find
import org.jetbrains.anko.startActivity

class ActivityLogin : AppCompatActivity() {
    private lateinit var mLogin: Button
    private lateinit var mUserName: EditText
    private lateinit var mPassword: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        mUserName = findViewById(R.id.activity_login_username_input)
        mPassword = findViewById(R.id.activity_login_password_input)
        mLogin = find(R.id.activity_login_btn_login)

        mLogin.setOnClickListener {
            val sharedPreferences = getSharedPreferences(SHARED_PREFERENCES, Context.MODE_PRIVATE)
            val editor = sharedPreferences.edit()
            editor.putString(USERNAME, mUserName.text.toString())
            editor.apply()
            startActivity<MainActivity>()
        }
    }
}
