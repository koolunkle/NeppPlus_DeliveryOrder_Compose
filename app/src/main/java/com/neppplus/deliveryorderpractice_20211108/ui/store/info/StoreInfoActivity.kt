package com.neppplus.deliveryorderpractice_20211108.ui.store.info

import android.Manifest
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide
import com.gun0912.tedpermission.PermissionListener
import com.gun0912.tedpermission.normal.TedPermission
import com.neppplus.deliveryorderpractice_20211108.R
import com.neppplus.deliveryorderpractice_20211108.databinding.ActivityStoreInfoBinding
import com.neppplus.deliveryorderpractice_20211108.model.StoreData

class StoreInfoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityStoreInfoBinding

    lateinit var mStoreData: StoreData

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_store_info)
        binding.apply {
            activity = this@StoreInfoActivity
            setValues()
        }
    }

    fun setActionCallListener() {
        val pl = object : PermissionListener {
            override fun onPermissionGranted() {
                val uri = Uri.parse("tel:${mStoreData.phoneNum}")
                val intent = Intent(Intent.ACTION_CALL, uri)
                startActivity(intent)
            }

            override fun onPermissionDenied(deniedPermissions: MutableList<String>?) {
                Toast.makeText(
                    this@StoreInfoActivity,
                    resources.getString(R.string.permission_denied),
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        TedPermission.create()
            .setPermissionListener(pl)
            .setPermissions(Manifest.permission.CALL_PHONE)
            .check()
    }

    fun setActionViewListener() {
        val uri = Uri.parse(mStoreData.addressLink)
        val intent = Intent(Intent.ACTION_VIEW, uri)
        startActivity(intent)
    }

    private fun ActivityStoreInfoBinding.setValues() {
        mStoreData = intent.getSerializableExtra("store") as StoreData

        txtStoreName.text = mStoreData.name
        txtPhoneNumber.text = mStoreData.phoneNum
        txtAddressLink.text = mStoreData.addressLink

        Glide.with(this@StoreInfoActivity).load(mStoreData.logoURL).into(imgLogo)
    }

}