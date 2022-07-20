package com.neppplus.deliveryorderpractice_20211108.ui.store.pizza

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.neppplus.deliveryorderpractice_20211108.R
import com.neppplus.deliveryorderpractice_20211108.databinding.FragmentPizzaStoreListBinding
import com.neppplus.deliveryorderpractice_20211108.model.StoreData
import com.neppplus.deliveryorderpractice_20211108.ui.store.info.StoreInfoActivity

class PizzaStoreFragment : Fragment() {

    private lateinit var binding: FragmentPizzaStoreListBinding

    private val mPizzaStoreList = ArrayList<StoreData>()

    private lateinit var mPizzaStoreAdapter: PizzaStoreAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil
            .inflate<FragmentPizzaStoreListBinding>(inflater, R.layout.fragment_pizza_store_list, container, false)
            .apply { initView() }
        return binding.root
    }

    private fun FragmentPizzaStoreListBinding.initView() {
        setPizzaListView()
        setPizzaItemClickListener()
        setValues()
    }

    private fun FragmentPizzaStoreListBinding.setPizzaListView() {
        mPizzaStoreAdapter = PizzaStoreAdapter(requireContext(), R.layout.store_list_item, mPizzaStoreList)
        pizzaStoreListView.adapter = mPizzaStoreAdapter
    }

    private fun FragmentPizzaStoreListBinding.setPizzaItemClickListener() {
        pizzaStoreListView.setOnItemClickListener { _, _, position, _ ->
            val clickedStore = mPizzaStoreList[position]
            val intent = Intent(requireContext(), StoreInfoActivity::class.java)

            intent.putExtra("store", clickedStore)
            startActivity(intent)
        }
    }

    private fun setValues() {
        mPizzaStoreList.clear()
        val res = resources.getStringArray(R.array.pizza_name)
        for (i in res.indices) {
            mPizzaStoreList.add(
                StoreData(
                    resources.getStringArray(R.array.pizza_name)[i],
                    resources.getStringArray(R.array.pizza_phoneNum)[i],
                    resources.getStringArray(R.array.pizza_logoURL)[i],
                    resources.getStringArray(R.array.pizza_addressLink)[i]
                )
            )
        }
    }

}