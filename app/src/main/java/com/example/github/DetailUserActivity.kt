package com.example.github

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.github.databinding.ActivityDetailUserBinding

class DetailUserActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailUserBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val user = intent.getParcelableExtra<User>(EXTRA_USER) as User
        binding.apply {
            tvDetailName.text = user.name
            tvDetailUsername.text = user.userName
            tvFollower.text = user.follower
            tvFollowing.text = user.following
            tvRepository.text = user.repository
            Glide.with(this@DetailUserActivity)
                .load(user.avatar)
                .into(binding.ivAvatar)
        }

    }

    companion object{
        const val EXTRA_USER = "extra_user"
    }
}