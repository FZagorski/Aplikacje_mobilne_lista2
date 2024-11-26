package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController

class WelcomeFragment : Fragment() {

    private val viewModel: UsersList by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_welcome, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val welcomeTextView = view.findViewById<TextView>(R.id.welcomeTextView)
        val loggedInUser = viewModel.getLoggedInUser()

        welcomeTextView.text = "Witaj ${loggedInUser?.username ?: "użytkownik"}"

        view.findViewById<Button>(R.id.logoutButton).setOnClickListener {
            viewModel.logout()
            findNavController().navigate(R.id.action_welcomeFragment_to_mainFragment)
        }
    }
}

