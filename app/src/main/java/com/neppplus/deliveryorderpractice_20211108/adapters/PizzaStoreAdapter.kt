package com.neppplus.deliveryorder_20211108.adapters

import android.content.Context
import android.widget.ArrayAdapter
import com.neppplus.deliveryorder_20211108.datas.StoreData

class PizzaStoreAdapter(
    val mContext: Context,
    val resId: Int,
    val mList: ArrayList<StoreData>) : ArrayAdapter<StoreData>(mContext, resId, mList) {
// * 각 변수를 선언하여 우리가 표현할 데이터를 적용(연결)시키자!


}