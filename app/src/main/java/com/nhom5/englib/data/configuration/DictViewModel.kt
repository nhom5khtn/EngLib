package networking.test

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import networking.test.model.dict.WordStore
import networking.test.networking.restDictionaryAPI.RestClient

class DictViewModel : ViewModel() {

    fun getWord(priKey: String) {
        viewModelScope.launch {
            val wordResp = RestClient.getInstance().API.listWordInformation(
                word = priKey
            )
            Log.e("TAG", wordResp.get(0).meanings.toString())
            WordStore.word = wordResp.get(0)
            Log.e("WordStore", WordStore.word!!.meanings.toString())
        }
    }

}