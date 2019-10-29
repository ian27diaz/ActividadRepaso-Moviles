package ian.meda.abccompany.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.google.android.material.bottomnavigation.BottomNavigationView
import ian.meda.abccompany.R
import ian.meda.abccompany.fragments.FragmentABC
import ian.meda.abccompany.fragments.FragmentInicio
import ian.meda.abccompany.fragments.FragmentMateriales

class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navigation = findViewById<BottomNavigationView>(R.id.activity_main_bnv_navigation)
        navigation.setOnNavigationItemSelectedListener(this)

        supportFragmentManager
            .beginTransaction()
            .replace(
                R.id.activity_main_fl_main_content,
                FragmentInicio()
            )
            .commit()

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.action_materiales -> supportFragmentManager
                .beginTransaction()
                .replace(
                    R.id.activity_main_fl_main_content,
                    FragmentMateriales()
                )
                .commit()
            R.id.action_inicio -> supportFragmentManager
                .beginTransaction()
                .replace(R.id.activity_main_fl_main_content, FragmentInicio())
                .commit()
            R.id.action_abc -> supportFragmentManager
                .beginTransaction()
                .replace(R.id.activity_main_fl_main_content, FragmentABC())
                .commit()
        }
        return true
    }
}
