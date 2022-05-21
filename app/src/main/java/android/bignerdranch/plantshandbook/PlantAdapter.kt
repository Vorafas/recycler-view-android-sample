package android.bignerdranch.plantshandbook

import android.bignerdranch.plantshandbook.databinding.PlantItemBinding
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class PlantAdapter : RecyclerView.Adapter<PlantAdapter.PlantHolder>() {

    val plantList = ArrayList<Plant>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlantHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.plant_item, parent, false)
        return PlantHolder(view)
    }

    override fun onBindViewHolder(holder: PlantHolder, position: Int) {
        holder.bind(plantList[position])
    }

    override fun getItemCount(): Int {
        return plantList.size
    }

    fun addPlant(plant: Plant) {
        plantList.add(plant)
        notifyDataSetChanged()
    }

    class PlantHolder(item: View) : RecyclerView.ViewHolder(item) {

        private val binding = PlantItemBinding.bind(item)

        fun bind(plant: Plant) = with(binding) {
            plantImage.setImageResource(plant.imageId)
            plantTitle.text = plant.title
        }
    }
}