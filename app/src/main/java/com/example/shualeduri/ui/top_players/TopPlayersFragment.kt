package com.example.shualeduri.ui.top_players

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.shualeduri.databinding.FragmentTopPlayersBinding

class TopPlayersFragment : Fragment() {

    private lateinit var topPlayersViewModel: TopPlayersViewModel
    private var _binding: FragmentTopPlayersBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        topPlayersViewModel =
            ViewModelProvider(this).get(TopPlayersViewModel::class.java)

        _binding = FragmentTopPlayersBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textDashboard
        topPlayersViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}