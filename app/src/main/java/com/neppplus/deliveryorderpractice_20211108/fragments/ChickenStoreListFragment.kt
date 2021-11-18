package com.neppplus.deliveryorderpractice_20211108.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.neppplus.deliveryorderpractice_20211108.R
import com.neppplus.deliveryorderpractice_20211108.adapters.ChickenStoreAdapter
import com.neppplus.deliveryorderpractice_20211108.datas.StoreData
import kotlinx.android.synthetic.main.fragment_chicken_store_list.*

class ChickenStoreListFragment : Fragment() {

    val mChickenStoreList = ArrayList<StoreData>()
    lateinit var mChickenStoreAdapter : ChickenStoreAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_chicken_store_list, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

//        동작 관련 코드 작성 예정

        mChickenStoreList.add(  StoreData("BBQ", "1588-9282", "https://mblogthumb-phinf.pstatic.net/20160507_267/ppanppane_1462548783710FjRMn_PNG/Untitled-1-34.png?type=w800")  )
        mChickenStoreList.add(  StoreData("네네치킨", "1599-4479", "https://t1.daumcdn.net/cfile/tistory/252B7248586EE8E017")  )
        mChickenStoreList.add(  StoreData("굽네치킨", "1688-9292", "https://www.shuttledelivery.co.kr/uploads/c787d35b08bfaf5cecd583a4307992ea.jpg")  )
        mChickenStoreList.add(  StoreData("페리카나", "1588-9292", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQJTaNUsZVUd3xxYux8DQv5oxkQOtaWB1TdRi8VMOidfbU5XpvziP4WXjmuJo-DMlF2pl4&usqp=CAU")  )


        mChickenStoreAdapter = ChickenStoreAdapter(requireContext(), R.layout.store_list_item, mChickenStoreList)
        chickenStoreListView.adapter = mChickenStoreAdapter


    }


}