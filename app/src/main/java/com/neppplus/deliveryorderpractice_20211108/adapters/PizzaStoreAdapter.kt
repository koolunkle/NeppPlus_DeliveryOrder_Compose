package com.neppplus.deliveryorder_20211108.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.neppplus.deliveryorder_20211108.datas.StoreData
import com.neppplus.deliveryorderpractice_20211108.R

class PizzaStoreAdapter(
    val mContext: Context,
    resId: Int,
//  * resID는 (멤버)변수로 지정할 필요가 없다.
    val mList: ArrayList<StoreData>) : ArrayAdapter<StoreData>(mContext, resId, mList) {
// * 각 변수를 선언하여 우리가 표현할 데이터를 적용(연결)시키자!

    val mInflater = LayoutInflater.from(mContext)
//  * LayoutInflater : View를 객체화하여 실제 활용할 수 있도록 한다.
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
//  * Adapter가 가지고 있는 데이터의 구성 방식을 정한다.
        var tempRow = convertView
        if (tempRow == null) {
            tempRow =   mInflater.inflate(R.layout.store_list_item, null)
        }
//      * View를 있는 그대로 사용하되 만약 null 상태일 시 store_list_item을 객체화하여 활용한다.
//      * 위 과정을 통해 용량 효율을 높일 수 있다. (재사용성)
        val row =  tempRow!!
//      * 위 과정을 통해 tempRow는 절대 null 상태가 될 수 없으므로 !!를 입력한다.

    val data = mList[position]

    val imgLogo = row.findViewById<ImageView>(R.id.imgLogo)
    val txtStoreName = row.findViewById<TextView>(R.id.txtStoreName)
//  * 우리가 지정한 id를 기반으로 imgLogo & txtStoreName의 데이터를 찾자!
//  * imgLogo -> ImageView & txtStoreName -> TextView 등 각 타입에 맞는 값을 찾자!

    return row
    }

}