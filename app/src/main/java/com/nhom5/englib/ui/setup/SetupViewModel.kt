package com.nhom5.englib.ui.setup

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.android.material.slider.Slider
import com.nhom5.englib.data.configuration.Configuration

class SetupViewModel(waitTimeQuest:Slider,numQuest:Slider) : ViewModel(){

    var configuration :MutableLiveData<Configuration> = MutableLiveData()

    init {
        configuration.value = Configuration(waitTimeQuest,numQuest)
    }

    fun setConfigurationWaitTimeQuest(waitTimeQuest: Slider){
        configuration.value?.waitTimeQuest=waitTimeQuest
        configuration.postValue(configuration.value)
    }

    fun setConfigurationNumberQuests(numQuest: Slider){
        configuration.value?.numQuest=numQuest
        configuration.postValue(configuration.value)
    }

}