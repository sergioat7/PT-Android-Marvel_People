/*
 * Copyright (c) 2020 Sergio Aragonés. All rights reserved.
 * Created by Sergio Aragonés on 4/11/2020
 */

package aragones.sergio.marvelpeople.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import aragones.sergio.marvelpeople.R
import aragones.sergio.marvelpeople.fragments.base.BaseFragment
import aragones.sergio.marvelpeople.utils.Constants
import aragones.sergio.marvelpeople.viewmodelfactories.CharacterDetailViewModelFactory
import aragones.sergio.marvelpeople.viewmodels.CharacterDetailViewModel

class CharacterDetailFragment: BaseFragment() {

    //MARK: - Private properties

    private var characterId: Int? = null
    private lateinit var viewModel: CharacterDetailViewModel

    //MARK: - Lifecycle methods

    companion object {
        fun newInstance() = CharacterDetailFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        characterId = this.arguments?.getInt(Constants.CHARACTER_ID)
        return inflater.inflate(R.layout.character_detail_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initializeUI()
    }

    //MARK: - Private methods

    private fun initializeUI() {

        val application = activity?.application ?: return
        viewModel = ViewModelProvider(this, CharacterDetailViewModelFactory(application)).get(CharacterDetailViewModel::class.java)
        // TODO: Use the ViewModel
    }
}