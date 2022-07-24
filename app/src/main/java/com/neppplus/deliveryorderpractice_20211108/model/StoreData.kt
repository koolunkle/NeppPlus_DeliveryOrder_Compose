package com.neppplus.deliveryorderpractice_20211108.model

import java.io.Serializable

data class StoreData(
    val name: String,
    val phoneNum: String,
    val logoURL: String,
    val addressLink: String
) : Serializable