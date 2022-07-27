package com.neppplus.deliveryorderpractice_20211108.util

import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_NEW_TASK
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.neppplus.deliveryorderpractice_20211108.R
import com.neppplus.deliveryorderpractice_20211108.model.StoreData
import com.neppplus.deliveryorderpractice_20211108.ui.nickname.EditNicknameActivity
import com.neppplus.deliveryorderpractice_20211108.ui.store.StoreActivity
import com.skydoves.landscapist.glide.GlideImage

object Content {

    @Composable
    fun ProfileContent() {
        var content by rememberSaveable { mutableStateOf(Application.context().resources.getString(R.string.nickname)) }
        val resultLauncher =
            rememberLauncherForActivityResult(ActivityResultContracts.StartActivityForResult()) {
                if (it.resultCode == AppCompatActivity.RESULT_OK) {
                    content = it.data?.getStringExtra("nickname").toString()
                    Toast.makeText(
                        Application.context(),
                        Application.context().resources.getString(R.string.complete_new_nickname),
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

        Column(modifier = Modifier.padding(20.dp)) {
            Text(text = Application.context().resources.getString(R.string.title_nickname))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(content)
                Button(onClick = {
                    val intent = Intent(Application.context(), EditNicknameActivity::class.java)
                    resultLauncher.launch(intent)
                }) {
                    Text(text = Application.context().resources.getString(R.string.change_nickname))
                }
            }
        }
    }

    @Composable
    fun ChickenStoreContent() {
        val chickenStoreList = rememberSaveable { DataProvider.chickenStoreList }

        LazyColumn(contentPadding = PaddingValues(horizontal = 10.dp, vertical = 5.dp)) {
            itemsIndexed(chickenStoreList) { index, item ->
                Box(Modifier.clickable {
                    val clickedStore = chickenStoreList[index]
                    val intent = Intent(Application.context(), StoreActivity::class.java)

                    intent.putExtra("store", clickedStore)
                    Application.context().startActivity(intent.addFlags(FLAG_ACTIVITY_NEW_TASK))
                }) {
                    ChickenStoreListItem(store = item)
                }
            }
        }
    }

    @Composable
    fun ChickenStoreListItem(store: StoreData) {
        Card(
            shape = RoundedCornerShape(corner = CornerSize(5.dp)),
            backgroundColor = Color.White,
            elevation = 3.dp,
            modifier = Modifier
                .padding(5.dp)
                .fillMaxWidth()
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth()
            ) {
                GlideImage(
                    imageModel = store.logoURL,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .padding(10.dp)
                        .size(40.dp)
                        .clip(RoundedCornerShape(corner = CornerSize(20.dp)))
                )
                Text(text = store.name)
            }
        }
    }

    @Composable
    fun PizzaStoreContent() {
        val pizzaStoreList = rememberSaveable { DataProvider.pizzaStoreList }

        LazyColumn(contentPadding = PaddingValues(horizontal = 10.dp, vertical = 5.dp)) {
            itemsIndexed(pizzaStoreList) { index, item ->
                Box(Modifier.clickable {
                    val clickedStore = pizzaStoreList[index]
                    val intent = Intent(Application.context(), StoreActivity::class.java)

                    intent.putExtra("store", clickedStore)
                    Application.context().startActivity(intent.addFlags(FLAG_ACTIVITY_NEW_TASK))
                }) {
                    PizzaStoreListItem(store = item)
                }
            }
        }
    }

    @Composable
    fun PizzaStoreListItem(store: StoreData) {
        Card(
            shape = RoundedCornerShape(corner = CornerSize(5.dp)),
            backgroundColor = Color.White,
            elevation = 3.dp,
            modifier = Modifier
                .padding(5.dp)
                .fillMaxWidth()
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth()
            ) {
                GlideImage(
                    imageModel = store.logoURL,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .padding(10.dp)
                        .size(40.dp)
                        .clip(RoundedCornerShape(corner = CornerSize(20.dp)))
                )
                Text(text = store.name)
            }
        }
    }

}