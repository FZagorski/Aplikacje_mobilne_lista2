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

class RegisterFragment : Fragment() {

    private val viewModel: UsersList by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_register, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val usernameField = view.findViewById<EditText>(R.id.RegisterEditText)
        val passwordField = view.findViewById<EditText>(R.id.RegisterPasswordEditText)
        val repeatPasswordField = view.findViewById<EditText>(R.id.RepeatPasswordEditText)

        view.findViewById<Button>(R.id.RegisterButton).setOnClickListener {
            val username = usernameField.text.toString()
            val password = passwordField.text.toString()
            val repeatPassword = repeatPasswordField.text.toString()

            if (password == repeatPassword) {
                if (viewModel.addUser(username, password)) {
                    Toast.makeText(requireContext(), "Użytkownik dodany!", Toast.LENGTH_SHORT).show()
                    findNavController().navigate(R.id.action_registerFragment_to_loginFragment)
                } else {
                    Toast.makeText(requireContext(), "Użytkownik już istnieje!", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(requireContext(), "Hasła nie pasują!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}