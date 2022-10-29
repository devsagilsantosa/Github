package com.example.github

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.github.databinding.ItemRowUserBinding

class ListUserAdapter(private val listUser: ArrayList<User>): RecyclerView.Adapter<ListUserAdapter.ListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding = ItemRowUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind(listUser[position])
        holder.itemView.setOnClickListener {
            val detailUserActivity = Intent(holder.itemView.context, DetailUserActivity::class.java)
            detailUserActivity.putExtra(DetailUserActivity.EXTRA_USER, listUser[position])
            holder.itemView.context.startActivity(detailUserActivity)
        }
    }

    override fun getItemCount(): Int = listUser.size

    class ListViewHolder(var binding: ItemRowUserBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(user: User){
            Glide.with(itemView.context)
                .load(user.avatar)
                .into(binding.ivUser)

            binding.tvName.text = user.name
            binding.tvUsername.text = user.userName
        }
    }
}