package selectingImages.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.selectingimeges.R
import com.example.selectingimeges.databinding.FragmentFirstScreenBinding
import selectingImages.adapter.ImageAdapter
import selectingImages.model.ImageModel
import selectingImages.ui.actitvity.MainActivity.Companion.selectedList
import selectingImages.ui.actitvity.App

class FirstScreenFragment : Fragment() {

    private lateinit var binding: FragmentFirstScreenBinding
    private lateinit var adapter: ImageAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        binding = FragmentFirstScreenBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


            binding.itemBtnNextScr.setOnClickListener{
                for (selectedImageId in selectedList) {
                    val imageModel = ImageModel(selectedImageId)
                    App.db.getNoteDao().addImage(imageModel)
                }
            findNavController().navigate(R.id.secondScreenFragment)

        }

        val list= creatingImg()
        adapter = ImageAdapter(requireContext(),list.toMutableList())
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager= GridLayoutManager(requireContext(),3)
        binding.recyclerView.setHasFixedSize(true)

    }

    private fun creatingImg(): List<ImageModel> {
        val imgList = mutableListOf<ImageModel>()
        imgList.add(ImageModel(R.drawable.img))
        imgList.add(ImageModel(R.drawable.img_2))
        imgList.add(ImageModel(R.drawable.img_3))
        return imgList
    }

}
