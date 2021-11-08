package com.neppplus.deliveryorder_20211108.datas

import java.io.Serializable

class StoreData(
    val name: String,
    val phoneNum: String,
    val logoURL: String ) : Serializable {
//  * 우리가 표현할 가게 이름(name) & 전화번호(phoneNum) & 로고(logoURL)를 표현하자!
//  * Serializable를 활용하여 putExtra의 에러를 해결하자!
}