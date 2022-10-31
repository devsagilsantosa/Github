package com.example.github

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.github.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val list = ArrayList<User>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvUsers.setHasFixedSize(true)
        list.addAll(listUsers)
        showRecylerList()
    }

    private val listUsers: ArrayList<User>
        get() {
            val dataName = resources.getStringArray(R.array.name)
            val dataUserName = resources.getStringArray(R.array.username)
            val dataAvatar = resources.obtainTypedArray(R.array.avatar)
            val dataFollowing = resources.getStringArray(R.array.following)
            val dataFollowers = resources.getStringArray(R.array.followers)
            val dataRepository = resources.getStringArray(R.array.repository)
            val listUser = ArrayList<User>()
            for (i in dataName.indices){
                val user = User(
                    dataName[i],
                    dataUserName[i],
                    dataAvatar.getResourceId(i, -1),
                    dataFollowing[i],
                    dataFollowers[i],
                    dataRepository[i]
                )
                listUser.add(user)
            }
            return listUser
        }


    private fun showRecylerList(){
        binding.apply {
            rvUsers.layoutManager = LinearLayoutManager(this@MainActivity)
            val listUserAdapter = ListUserAdapter(list)
            rvUsers.adapter = listUserAdapter
        }
    }
}