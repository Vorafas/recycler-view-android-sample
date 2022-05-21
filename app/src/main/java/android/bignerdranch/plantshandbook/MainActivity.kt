package android.bignerdranch.plantshandbook

import android.bignerdranch.plantshandbook.databinding.ActivityMainBinding
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    private val adapter = PlantAdapter()

    private val imageIdList = listOf(
        R.drawable.plant1,
        R.drawable.plant2,
        R.drawable.plant3,
        R.drawable.plant4,
        R.drawable.plant5
    )

    private var index = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }

    private fun init() {
        binding.apply {
            recyclerView.layoutManager = GridLayoutManager(this@MainActivity, 3)
            recyclerView.adapter = adapter
            buttonAdd.setOnClickListener {
                val plant = Plant(imageIdList[index], "Plant $index")
                adapter.addPlant(plant)
                ++index
                if (index == imageIdList.size) {
                    index = 0
                }
            }
        }
    }
}