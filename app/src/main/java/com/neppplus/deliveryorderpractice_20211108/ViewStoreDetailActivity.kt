package com.neppplus.deliveryorderpractice_20211108

import android.Manifest
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bumptech.glide.Glide
import com.gun0912.tedpermission.PermissionListener
import com.gun0912.tedpermission.normal.TedPermission
import com.neppplus.deliveryorderpractice_20211108.datas.StoreData
import kotlinx.android.synthetic.main.activity_view_store_detail.*

class ViewStoreDetailActivity : AppCompatActivity() {

    lateinit var mStoreData : StoreData

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_store_detail)
        setupEvents()
        setValues()
    }

    fun setupEvents() {

        btnCall.setOnClickListener {

        val pl = object : PermissionListener {
            override fun onPermissionGranted() {

                val myUri = Uri.parse("tel:${mStoreData.phoneNum}")
                val myIntent = Intent( Intent.ACTION_CALL, myUri )
                startActivity(myIntent)

            }

            override fun onPermissionDenied(deniedPermissions: MutableList<String>?) {
                Toast.makeText(this@ViewStoreDetailActivity, "권한이 거부되어 전화 불가.",
                Toast.LENGTH_SHORT).show()
            }


        }

            TedPermission.create()
                .setPermissionListener( pl )
                .setPermissions(Manifest.permission.CALL_PHONE)
                .check()

        }

    }

    fun setValues() {

        mStoreData = intent.getSerializableExtra("store") as StoreData

        txtStoreName.text = mStoreData.name
        txtPhoneNum.text = mStoreData.phoneNum

        Glide.with(this).load(mStoreData.logoURL).into(imgLogo)

    }

}