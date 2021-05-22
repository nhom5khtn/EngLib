package com.nhom5.englib.ui.register

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.nhom5.englib.R

class RegisterFragment :Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_print,container,false)
        return view
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val button = view.findViewById<Button>(R.id.btnSubmit)
        val edtText = view.findViewById<EditText>(R.id.edtNewWord)
        button.setOnClickListener{
            //check in word list

            // if the typed word is available
                //dialog

            //if the typed word is unavailable
                //add to the list
                //dialog
        }
    }

}