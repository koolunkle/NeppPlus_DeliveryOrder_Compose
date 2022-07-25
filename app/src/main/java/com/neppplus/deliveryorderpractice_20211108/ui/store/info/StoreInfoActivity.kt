package com.neppplus.deliveryorderpractice_20211108.ui.store.info

import android.Manifest
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.appcompattheme.AppCompatTheme
import com.gun0912.tedpermission.PermissionListener
import com.gun0912.tedpermission.normal.TedPermission
import com.neppplus.deliveryorderpractice_20211108.R
import com.neppplus.deliveryorderpractice_20211108.model.StoreData
import com.skydoves.landscapist.glide.GlideImage

class StoreInfoActivity : AppCompatActivity() {

    private lateinit var mStoreData: StoreData

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppCompatTheme {
                StoreInfoPreview()
            }
        }
    }

    @Composable
    fun StoreInfoDraw() {
        mStoreData = intent.getSerializableExtra("store") as StoreData

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
        ) {
            StoreImage(store = mStoreData)
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
            ) {
                StoreName(store = mStoreData)
                StoreAddressLink(store = mStoreData)
                StorePhoneNum(store = mStoreData)
            }
        }
    }

    @Composable
    fun StoreImage(store: StoreData) {
        GlideImage(
            imageModel = store.logoURL,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(120.dp)
                .padding(10.dp)
                .clip(RoundedCornerShape(corner = CornerSize(20.dp)))
                .border(width = 2.dp, color = Color.Black, shape = CircleShape)
        )
        Spacer(modifier = Modifier.padding(20.dp))
    }

    @Composable
    fun StoreName(store: StoreData) {
        Text(
            text = resources.getString(R.string.title_store_name),
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.padding(5.dp))
        Text(text = store.name)
    }

    @Composable
    fun StoreAddressLink(store: StoreData) {
        val uriHandler = LocalUriHandler.current
        val buildAnnotatedStr = buildAnnotatedString {
            val str = store.addressLink
            val startIndex = 0
            val endIndex = store.addressLink.length

            append(str)

            addStyle(
                style = SpanStyle(
                    color = Color(0xFF6A0DAD),
                    fontSize = 17.sp,
                    textDecoration = TextDecoration.Underline
                ),
                start = startIndex,
                end = endIndex
            )

            addStringAnnotation(
                tag = "URL",
                annotation = str,
                start = startIndex,
                end = endIndex
            )
        }

        Spacer(modifier = Modifier.padding(30.dp))
        Text(
            text = resources.getString(R.string.homepage_address),
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.padding(5.dp))
        ClickableText(
            text = buildAnnotatedStr,
            onClick = {
                buildAnnotatedStr.getStringAnnotations("URL", start = it, end = it)
                    .firstOrNull()?.let { stringAnnotation ->
                        uriHandler.openUri(stringAnnotation.item)
                    }
            }
        )
    }

    @Composable
    fun StorePhoneNum(store: StoreData) {
        Spacer(modifier = Modifier.padding(30.dp))
        Text(
            text = resources.getString(R.string.title_phone_number),
            fontWeight = FontWeight.Bold
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = store.phoneNum)
            Button(onClick = { setActionCallListener() }) {
                Text(text = resources.getString(R.string.phone_order))
            }
        }
    }

    @Preview
    @Composable
    fun StoreInfoPreview() {
        AppCompatTheme {
            StoreInfoDraw()
        }
    }

    private fun setActionCallListener() {
        val permissionListener = object : PermissionListener {
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
            .setPermissionListener(permissionListener)
            .setPermissions(Manifest.permission.CALL_PHONE)
            .check()
    }

}