/*
 * Copyright (c) 2020 Sergio Aragonés. All rights reserved.
 * Created by Sergio Aragonés on 3/11/2020
 */

package aragones.sergio.marvelpeople.fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import aragones.sergio.marvelpeople.R
import aragones.sergio.marvelpeople.fragments.base.BaseFragment
import aragones.sergio.marvelpeople.viewmodelfactories.MainViewModelFactory
import aragones.sergio.marvelpeople.viewmodels.MainViewModel

class MainFragment: BaseFragment() {

    //MARK: - Private properties

    private lateinit var viewModel: MainViewModel

    //MARK: - Lifecycle methods

    companion object {
        fun newInstance() = MainFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initializeUI()
    }

    //MARK: - Private methods

    private fun initializeUI() {

        val application = activity?.application ?: return
        viewModel = ViewModelProvider(this, MainViewModelFactory(application)).get(MainViewModel::class.java)
        setupBindings()

        viewModel.getCharactersObserver(null)
    }

    private fun setupBindings() {

        viewModel.mainCharacters.observe(requireActivity(), { charactersResponse ->
            //TODO manage characters
        })

        viewModel.mainLoading.observe(requireActivity(), { isLoading ->

            if (isLoading) {
                //TODO show loading
            } else {
                //TODO hide loading
            }
        })

        viewModel.mainError.observe(requireActivity(), { error ->
            manageError(error)
        })
    }
}