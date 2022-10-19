package com.example.myapplicationnewmotion.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.updatePadding
import androidx.fragment.app.Fragment
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplicationnewmotion.R
import com.example.myapplicationnewmotion.adapter.AdapterCardInfo
import com.example.myapplicationnewmotion.dataModel.DataCardInfo
import com.example.myapplicationnewmotion.databinding.FragmentCardInfoBinding
import com.example.myapplicationnewmotion.navigator.Navigator
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class CardInfoFragment : Fragment() {

    private lateinit var binding: FragmentCardInfoBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentCardInfoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        insets()

        val arg: String? = arguments?.getString(Navigator.MY_ARG)
        val argPos: Int? = arguments?.getInt(Navigator.MY_ARG_POS)

        val myAdapter = AdapterCardInfo(getBundleArrayData(arg!!)) { _, _ -> }

        binding.let {
            it.backButton.setOnClickListener { requireActivity().onBackPressedDispatcher.onBackPressed() }

            it.itemCardInfo.let { rv ->
                rv.layoutManager =
                    LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
                (rv.layoutManager as LinearLayoutManager).scrollToPosition(argPos!!)
                rv.adapter = myAdapter
            }

            it.navigationCardDetailsMenu.setOnItemSelectedListener { item ->
                when (item.itemId) {
                    R.id.limits -> {
                        findNavController().navigate(
                            CardInfoFragmentDirections.actionCardInfoFragmentToLimitFragment2(),
                            NavOptions.Builder()
                                .setEnterAnim(androidx.appcompat.R.anim.abc_slide_in_bottom)
                                .setExitAnim(androidx.appcompat.R.anim.abc_fade_out)
                                .setPopEnterAnim(androidx.appcompat.R.anim.abc_slide_in_bottom)
                                .setPopExitAnim(androidx.appcompat.R.anim.abc_fade_out)
                                .build()
                        )
                    }
                    R.id.operations -> {
                        findNavController().navigate(
                            CardInfoFragmentDirections.actionCardInfoFragmentToCardOptionsFragment()
                        )
//                    activity?.supportFragmentManager?.beginTransaction()
//                        ?.add(R.id.fragmentContainerView2, CardOptionsFragment())?.addToBackStack(null)?.commit()
                    }
                }
                true

            }

        }

    }

    private fun insets() {
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { _, insets ->
            val statusBarHeight = insets.getInsets(WindowInsetsCompat.Type.statusBars()).top
            val navBarHeight = insets.getInsets(WindowInsetsCompat.Type.navigationBars()).bottom
            binding.root.updatePadding(top = statusBarHeight, bottom = navBarHeight)
            binding.navigationCardDetailsMenu.setOnApplyWindowInsetsListener { _, inset ->
                binding.navigationCardDetailsMenu.updatePadding(top = 0, bottom = 0)
                inset
            }
            insets
        }
    }

    private fun getBundleArrayData(arg: String): ArrayList<DataCardInfo> {
        val listType = object : TypeToken<ArrayList<DataCardInfo?>?>() {}.type
        return Gson().fromJson(arg, listType)
    }

}

