package test.navigation.ui.fragment.register

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import test.navigation.R
import test.navigation.databinding.FragmentRegisterBinding
import test.navigation.dict.Userpool
import test.navigation.dict.Word


class RegisterFragment : Fragment() {
    lateinit var binding: FragmentRegisterBinding
    private var newWord: Word? = null
    private lateinit var registerViewModel: RegisterViewModel
    private var adapter: WordAdapter? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setupViewModel(inflater, container)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
        binding.apply {
            btnSearch.setOnClickListener {
                if (!edtInputNewWord.text.isEmpty()) {
                    edtInputNewWord.error = null
                    binding.progressBar.visibility = View.VISIBLE
                    fetchData(edtInputNewWord.text.toString())
                } else {
                    edtInputNewWord.error = "Empty!"
                }

            }

            btnRegister.setOnClickListener {
                newWord?.let {
                    Userpool.wordList.add(
                        it
                    )

                    val newList: ArrayList<Word> = arrayListOf()
                    newList.addAll( Userpool.wordList)
                    adapter?.updateList(newList)

                    binding.edtInputNewWord.setText("")
                    binding.tvMeaning.text = ""
                    binding.btnRegister.isEnabled = false
                }
            }
        }
    }

    private fun initRecyclerView() {
        adapter = WordAdapter(arrayListOf())
        binding.rvWord.adapter = adapter
    }


    private fun setupViewModel(inflater: LayoutInflater, container: ViewGroup?) {
        registerViewModel = ViewModelProvider(this).get(RegisterViewModel::class.java)
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_register, container, false)
        binding.lifecycleOwner = this
        binding.registerViewModelDataBinding = registerViewModel
    }

    private fun fetchData(key: String) {

        registerViewModel.getWord(key)?.observe(viewLifecycleOwner, Observer {
            binding.progressBar.visibility = View.GONE
            if (it != null) {
                binding.btnRegister.isEnabled = true
                binding.tvMeaning.text = it.meanings[0].toString()
                newWord = it
            } else {
                newWord = null
                binding.btnRegister.isEnabled = false

                val dialog = AlertDialog.Builder(requireContext()).create()
                dialog.setMessage(resources.getString(R.string.no_word))
                dialog.setTitle("Thông báo")
                dialog.setButton(
                    Dialog.BUTTON_POSITIVE, "OK"
                ) { dialog, _ ->
                    dialog.dismiss()
                }
                dialog.show()
            }

            registerViewModel.registerResponse = null
        })
    }
}