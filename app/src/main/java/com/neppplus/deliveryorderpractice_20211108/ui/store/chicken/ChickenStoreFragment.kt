package com.neppplus.deliveryorderpractice_20211108.ui.store.chicken

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.neppplus.deliveryorderpractice_20211108.R
import com.neppplus.deliveryorderpractice_20211108.databinding.FragmentChickenStoreListBinding
import com.neppplus.deliveryorderpractice_20211108.model.StoreData
import com.neppplus.deliveryorderpractice_20211108.ui.store.info.StoreInfoActivity

class ChickenStoreFragment : Fragment() {

    private lateinit var binding: FragmentChickenStoreListBinding

    private val mChickenStoreList = ArrayList<StoreData>()

    private lateinit var mChickenStoreAdapter: ChickenStoreAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil
            .inflate<FragmentChickenStoreListBinding>(inflater, R.layout.fragment_chicken_store_list, container, false)
            .apply { initView() }
        return binding.root
    }

    private fun FragmentChickenStoreListBinding.initView() {
        setChickenListView()
        setChickenItemClickListener()
        setValues()
    }

    private fun FragmentChickenStoreListBinding.setChickenListView() {
        mChickenStoreAdapter = ChickenStoreAdapter(requireContext(), R.layout.store_list_item, mChickenStoreList)
        chickenStoreListView.adapter = mChickenStoreAdapter
    }

    private fun FragmentChickenStoreListBinding.setChickenItemClickListener() {
        chickenStoreListView.setOnItemClickListener { _, _, position, _ ->
            val clickedStore = mChickenStoreList[position]
            val intent = Intent(requireContext(), StoreInfoActivity::class.java)

            intent.putExtra("store", clickedStore)
            startActivity(intent)
        }
    }

    private fun setValues() {
        mChickenStoreList.clear()
        val res = resources.getStringArray(R.array.chicken_name)
        for (i in res.indices) {
            mChickenStoreList.add(
                StoreData(
                    resources.getStringArray(R.array.chicken_name)[i],
                    resources.getStringArray(R.array.chicken_phoneNum)[i],
                    resources.getStringArray(R.array.chicken_logoURL)[i],
                    resources.getStringArray(R.array.chicken_addressLink)[i]
                )
            )
        }
    }

}