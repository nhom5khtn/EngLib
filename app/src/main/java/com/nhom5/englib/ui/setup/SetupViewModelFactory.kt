package com.nhom5.englib.ui.setup

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.slider.Slider

class SetupViewModelFactory(val waitTimeQuest: Slider, val numQuest: Slider) :ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SetupViewModel::class.java)) {
            return SetupViewModel(waitTimeQuest, numQuest) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}