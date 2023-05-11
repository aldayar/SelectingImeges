package selectingImages.adapter
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.selectingimeges.databinding.ItemImageLayoutBinding
import selectingImages.model.ImageModel
import selectingImages.ui.actitvity.MainActivity.Companion.selectedList
import selectingImages.ui.actitvity.MainActivity.Companion.selectedModeList

class ImageAdapter( var context: Context, var list : MutableList<ImageModel>): RecyclerView.Adapter<ImageAdapter.ViewHolder>(){

    inner class ViewHolder(private val binding: ItemImageLayoutBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(imgModel: ImageModel){
            binding.itemImg.setImageResource(imgModel.itemImage)
        }
        val image = binding.itemImg
        val selected = binding.selectedImg
    }
    fun addImage(img:ImageModel){
        list.add(img)
        notifyDataSetChanged()
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemImageLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)

    }

    override fun getItemCount() = list.size



    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       holder.bind(list[position])
        val model = list[position]
        // Selecting imeges
        if (!selectedList.contains(model.itemImage)){
            holder.selected.visibility= View.GONE
        } else{holder.selected.visibility=View.VISIBLE}

        holder.image.setOnClickListener{
            if (!selectedList.contains(model.itemImage)){
                selectedList.add(model.itemImage)
                selectedModeList.add(model)
                holder.selected.visibility= View.VISIBLE
            }else{
                holder.selected.visibility=View.GONE
                selectedList.remove(model.itemImage)
                selectedModeList.remove(model)
            }
        }

    }






}