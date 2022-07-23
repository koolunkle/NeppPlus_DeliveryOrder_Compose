package com.neppplus.deliveryorderpractice_20211108.ui.profile

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.neppplus.deliveryorderpractice_20211108.R
import com.neppplus.deliveryorderpractice_20211108.databinding.FragmentProfileBinding
import com.neppplus.deliveryorderpractice_20211108.ui.nickname.EditNicknameActivity

class ProfileFragment : Fragment() {

    private lateinit var binding: FragmentProfileBinding

    private lateinit var resultLauncher: ActivityResultLauncher<Intent>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil
            .inflate<FragmentProfileBinding>(inflater, R.layout.fragment_profile, container, false)
            .apply {
                fragment = this@ProfileFragment
                setActivityResult()
            }
        return binding.root
    }

    private fun FragmentProfileBinding.setActivityResult() {
        resultLauncher =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
                if (it.resultCode == Activity.RESULT_OK) {
                    val newNickname = it.data?.getStringExtra("nickname")
                    txtNickname.text = newNickname

                    Toast.makeText(
                        requireContext(),
                        resources.getString(R.string.complete_new_nickname),
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
    }

    fun editNicknameListener() {
        val intent = Intent(requireActivity(), EditNicknameActivity::class.java)
        resultLauncher.launch(intent)
    }

}