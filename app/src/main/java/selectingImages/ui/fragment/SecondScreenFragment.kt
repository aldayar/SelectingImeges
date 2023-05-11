package selectingImages.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.selectingimeges.R
import com.example.selectingimeges.databinding.FragmentSecondScreenBinding
import selectingImages.adapter.ImageAdapter
import selectingImages.model.ImageModel
import selectingImages.ui.actitvity.MainActivity.Companion.selectedModeList

class SecondScreenFragment : Fragment() {

    private lateinit var binding: FragmentSecondScreenBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSecondScreenBinding.inflate(layoutInflater,container , false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val selectedImgs = arguments?.getIntegerArrayList("key")

        val recycler = binding.recyclerView
        recycler.layoutManager = LinearLayoutManager(requireContext())
        val adapter = ImageAdapter(requireContext(), selectedModeList)
        binding.recyclerView.adapter = adapter



        binding.itemBackScr.setOnClickListener{
            Navigation.findNavController(view).navigate(R.id.firstScreenFragment)
        }
    }



}