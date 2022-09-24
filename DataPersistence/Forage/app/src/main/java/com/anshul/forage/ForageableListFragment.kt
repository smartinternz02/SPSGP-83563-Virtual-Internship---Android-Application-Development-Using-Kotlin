package com.anshul.forage
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.anshul.forage.databinding.FragmentForageableListBinding

class ForageableListFragment : Fragment() {
    private val viewModel: ForageableViewModel by activityViewModels() {
        ForageableViewModelFactory(
            (activity?.application as BaseApplication).database.foragableDao()
        )
    }

    private var _binding: FragmentForageableListBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentForageableListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = ForageableListAdapter { forageable ->
            val action = ForageableListFragmentDirections
                .actionForageableListFragmentToForageableDetailFragment(forageable.id)
            findNavController().navigate(action)
        }

        // TODO: observe the list of forageables from the view model and submit it the adapter
        viewModel.allForageable.observe(this.viewLifecycleOwner) {
            forageables -> forageables.let {
                adapter.submitList(it)
            }
        }

        binding.apply {
            recyclerView.adapter = adapter
            addForageableFab.setOnClickListener {
                findNavController().navigate(
                    R.id.action_forageableListFragment_to_addForageableFragment
                )
            }
        }
    }
}
