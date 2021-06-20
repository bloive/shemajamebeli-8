package com.example.shualeduri.ui.matches

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.shualeduri.adapters.ParentRecyclerAdapter
import com.example.shualeduri.databinding.FragmentMatchesBinding
import com.example.shualeduri.extensions.glideImg
import com.example.shualeduri.models.Result
import com.example.shualeduri.models.Summary

class MatchesFragment : Fragment() {

    private lateinit var matchesViewModel: MatchesViewModel
    private var _binding: FragmentMatchesBinding? = null
    private lateinit var adapter: ParentRecyclerAdapter

    private lateinit var itemList: MutableList<Summary>

    private lateinit var res: Result

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        matchesViewModel =
            ViewModelProvider(this).get(MatchesViewModel::class.java)

        _binding = FragmentMatchesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecycler()
        observe()
        matchesViewModel.getData()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun initRecycler() {
        adapter = ParentRecyclerAdapter()
        binding.recyclerParent.layoutManager = LinearLayoutManager(requireActivity())
        binding.recyclerParent.adapter = adapter
    }

    private fun observe() {
        matchesViewModel.resultLiveData.observe(viewLifecycleOwner, {
            itemList = it.match?.matchSummary?.summaries?.let { it1 -> adapter.setData(it1.toMutableList()) }!!
            res = it
            init(it)
        })
    }

    private fun init(res: Result) {
        with(binding) {
            tvPlace.text = res.match?.stadiumAdress
            tvDay.text = res.match?.matchDate.toString()
            tvTeam1Name.text = res.match?.team1?.teamName
            tvTeam2Name.text = res.match?.team2?.teamName
            imgTeam1.glideImg(res.match?.team1?.teamImage.toString())
            imgTeam2.glideImg(res.match?.team2?.teamImage.toString())
            tvScore.text = "${res.match?.team1?.score} : ${res.match?.team2?.score}"
            tvMinute.text = res.match?.matchTime.toString()
            tvTeam1Possession.text = "${res.match?.team1?.ballPosition.toString()}%"
            tvTeam2Possession.text = "${res.match?.team2?.ballPosition.toString()}%"
            progressBar.progress = res.match?.team1?.ballPosition!!
        }
    }

}