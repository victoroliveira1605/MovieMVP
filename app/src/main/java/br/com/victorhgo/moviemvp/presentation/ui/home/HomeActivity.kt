package br.com.victorhgo.moviemvp.presentation.ui.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import br.com.victorhgo.moviemvp.R
import br.com.victorhgo.moviemvp.presentation.ui.launch.LaunchFragment
import br.com.victorhgo.moviemvp.presentation.ui.upcoming.UpcomingFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity(), HomeContract.View {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        openFragment(UpcomingFragment.newInstance())
    }

    private val mOnNavigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_bottom_upcoming -> {
                    openFragment(UpcomingFragment.newInstance())
                    return@OnNavigationItemSelectedListener true
                }
                R.id.nav_bottom_launch -> {
                    openFragment(LaunchFragment.newInstance())
                    return@OnNavigationItemSelectedListener true
                }
            }
            false
        }


    private fun openFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    override fun initView() {
    }
}
