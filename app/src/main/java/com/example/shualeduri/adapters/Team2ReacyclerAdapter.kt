package com.example.shualeduri.adapters

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.shualeduri.R
import com.example.shualeduri.databinding.*
import com.example.shualeduri.enums.ActionType
import com.example.shualeduri.enums.GoalType
import com.example.shualeduri.models.Summary
import com.example.shualeduri.models.Team2Action

class Team2RecyclerAdapter(
    private val summary: Summary
) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        private const val EMPTY_VIEW = 0
        private const val GENERAL_VIEW = 1
        private const val SUBSTITUTION_VIEW = 2
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            EMPTY_VIEW -> EmptyViewHolder(
                EmptySummaryBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
            GENERAL_VIEW -> GeneralViewHolder(
                Team2Binding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
            else -> SubstitutionViewHolder(
                Team2SubstBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is GeneralViewHolder -> holder.bind()
            is SubstitutionViewHolder -> holder.bind()
        }
    }

    override fun getItemCount(): Int = summary.team2Action?.size ?: 1

    override fun getItemViewType(position: Int): Int {

        return if (summary.team2Action != null) {
            val action = summary.team2Action[position]
            if (action.actionType == ActionType.SUBSTITUTION.type)
                SUBSTITUTION_VIEW
            else
                GENERAL_VIEW
        } else {
            EMPTY_VIEW
        }
    }

    inner class GeneralViewHolder(private val binding: Team2Binding) :
        RecyclerView.ViewHolder(binding.root) {
        private lateinit var action: Team2Action
        fun bind() {
            if (summary.team2Action != null) {
                action = summary.team2Action[adapterPosition]
                with(binding) {
                    tvPlayer.text = action.action?.player?.playerName.toString()
                    when (action.actionType) {
                        ActionType.GOAL.type -> {
                            when (action.action?.goalType) {
                                GoalType.GOAL.type -> {
                                    imgAction.setImageResource(R.drawable.ic_goal_green)
                                    val str = R.string.goal.toString()
                                    tvMinActionType1.text =
                                        String.format("${summary.actionTime}' $str", "")
                                }
                                GoalType.OWN_GOAL.type -> {
                                    imgAction.setImageResource(R.drawable.ic_goal_red)
                                    val str = R.string.own_goal.toString()
                                    tvMinActionType1.text =
                                        String.format("${summary.actionTime}' $str", "")
                                    tvMinActionType1.setTextColor(Color.RED)
                                }
                            }
                        }
                        ActionType.YELLOW_CARD.type -> {
                            imgAction.setImageResource(R.drawable.ic_yellow_card)
                            val str = R.string.yellow_card.toString()
                            tvMinActionType1.text = String.format("${summary.actionTime}' $str", "")
                        }
                        ActionType.RED_CARD.type -> {
                            imgAction.setImageResource(R.drawable.ic_red_card)
                            val str = R.string.yellow_card.toString()
                            tvMinActionType1.text = String.format("${summary.actionTime}' $str", "")
                        }
                    }
                }
            }
        }
    }

    inner class SubstitutionViewHolder(private val binding: Team2SubstBinding) :
        RecyclerView.ViewHolder(binding.root) {
        private lateinit var action: Team2Action
        fun bind() {
            if (summary.team2Action != null) {
                action = summary.team2Action[adapterPosition]
                with(binding) {
                    val str = R.string.substitution.toString()
                    tvMinActionType1.text = String.format("${summary.actionTime}' $str", "")
                    tvPlayerIn.text = action.action?.player1?.playerName.toString()
                    tvPlayerOut.text = action.action?.player2?.playerName.toString()
                }
            }
        }
    }

    inner class EmptyViewHolder(binding: EmptySummaryBinding) :
        RecyclerView.ViewHolder(binding.root)
}