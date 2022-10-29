package com.example.github

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.github.databinding.ActivityDetailUserBinding

class DetailUserActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailUserBinding

    companion object{
        const val EXTRA_USER = "extra_user"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val user = intent.getParcelableExtra<User>(EXTRA_USER) as User
        binding.tvDetailUsername.text = user.userName
        binding.tvDetailName.text = user.name
        Glide.with(this)
            .load(user.avatar)
            .into(binding.ivAvatar)
        binding.tvFollower.text = user.follower
        binding.tvFollowing.text = user.following
        binding.tvRepository.text = user.repository
    }
}