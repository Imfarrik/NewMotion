package com.example.myapplicationnewmotion.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplicationnewmotion.adapter.MyAdapter
import com.example.myapplicationnewmotion.databinding.FragmentMainBinding
import com.google.gson.Gson


class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val item: List<String> = (0..6).map { it.toString() }

        val myAdapter = MyAdapter(item) { it, position ->
            val gson = Gson().toJson(it)
            val bundle = bundleOf("myArg" to it)

//            val intent = Intent(context, CardHolderActivity::class.java)
//            intent.putExtra("myArg", bundle)
//            startActivity(intent)

//            findNavController().navigate(R.id.mainFragmentToCardInfoFragment, bundle)

            MainFragmentDirections.mainFragmentToCardInfoFragment().let {
                findNavController().navigate(
                    it.actionId,
                    bundle
                )
            }

        }

        binding.itemBgRecycle.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

        binding.itemBgRecycle.adapter = myAdapter


    }

    companion object {
        @JvmStatic
        fun newInstance() = MainFragment()
    }
}