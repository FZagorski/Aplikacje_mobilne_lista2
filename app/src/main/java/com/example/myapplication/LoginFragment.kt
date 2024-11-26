package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController


class LoginFragment : Fragment() {

    private val user_name: String = ""

    private val viewModel: UsersList by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val usernameField = view.findViewById<EditText>(R.id.loginEditText)
        val passwordField = view.findViewById<EditText>(R.id.PasswordEditText)

        view.findViewById<Button>(R.id.loginConfirmButton).setOnClickListener {
            val username = usernameField.text.toString()
            val password = passwordField.text.toString()

            if (viewModel.authenticate(username, password)) {
                findNavController().navigate(R.id.action_loginFragment_to_welcomeFragment)
            } else {
                Toast.makeText(requireContext(), "Niepoprawne dane logowania!", Toast.LENGTH_SHORT).show()
            }
        }

        view.findViewById<Button>(R.id.goToRegisterButton).setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
        }
    }
}