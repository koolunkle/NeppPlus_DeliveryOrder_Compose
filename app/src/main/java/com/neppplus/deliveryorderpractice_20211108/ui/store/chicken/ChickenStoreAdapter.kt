package com.neppplus.deliveryorderpractice_20211108.ui.store.chicken

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.neppplus.deliveryorderpractice_20211108.R
import com.neppplus.deliveryorderpractice_20211108.model.StoreData

class ChickenStoreAdapter(
    private val mContext: Context,
    resId: Int,
    private val mList: ArrayList<StoreData>
) : ArrayAdapter<StoreData>(mContext, resId, mList) {

    private val mInflater: LayoutInflater = LayoutInflater.from(mContext)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var tempRow = convertView

        if (tempRow == null) {
            tempRow = mInflater.inflate(R.layout.store_list_item, null)
        }

        val row = tempRow!!
        val data = mList[position]

        val imgLogo = row.findViewById<ImageView>(R.id.imgLogo)
        val txtStoreName = row.findViewById<TextView>(R.id.txtStoreName)

        txtStoreName.text = data.name

        Glide.with(mContext).load(data.logoURL).into(imgLogo)

        return row
    }

}