package com.example.art

import android.os.Bundle
import com.google.android
    .material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app
    .AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment
    .findNavController
import androidx.navigation.ui
    .AppBarConfiguration
import androidx.navigation.ui
    .setupActionBarWithNavController
import androidx.navigation.ui
    .setupWithNavController
import com.example.art
    .data.RetrofitClient
import com.example.art
    .databinding.ActivityMainBinding
import com.example.art
    .domain.Artwork
import retrofit2.Call
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView
        var navController: NavController? = null//go to purpose screen
        val navHostFragment = supportFragmentManager.findFragmentById(R.id
            .nav_host_fragment_activity_main)
        if (navHostFragment != null) navController = navHostFragment.findNavController()//obtaining navigation controller associated with fragment container
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications
            )
        )
        setupActionBarWithNavController(navController!!, appBarConfiguration)
        navView.setupWithNavController(navController)
        fetchArt(3, 1)
    }
}
fun fetchArt(ending: Int, leaf: Int) {
    val call = RetrofitClient.artApi.getArt(end = ending, webPage = leaf)//handling network responses
    call.enqueue(object : retrofit2.Callback<Artwork> {
        override fun onResponse(call: Call<Artwork>, response: Response<Artwork>) {
            if (response.isSuccessful) {
                val artData = response.body()//result
                println(artData)
            }
            else println(response.code())
        }
        override fun onFailure(call: Call<Artwork>, t: Throwable) = println(t.message)
    })
}