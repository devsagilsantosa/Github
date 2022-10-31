package com.example.github

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class User(
    var userName: String,
    var name: String,
    var avatar: Int,
    var repository: String,
    var follower: String,
    var following: String
): Parcelable
