package com.kroger.classdemoapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kroger.classdemoapp.Character
import com.kroger.classdemoapp.CharacterAdapter
import com.kroger.classdemoapp.R
import kotlin.random.Random

class CharacterListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_character_list, container, false)
        val recyclerView = view.findViewById<RecyclerView>(R.id.character_recycler_view)

        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        val characters = mutableListOf<Character>()

        val power = mutableListOf("Weak Power of 1",
            "Better Power of 2",
            "Intermediate Power of 3",
            "Strong Power of 4",
            "Ultimate Power of 5"
            )
        val image = mutableListOf(R.mipmap.image1,R.mipmap.image2,R.mipmap.image3,R.mipmap.image4,R.mipmap.image5,R.mipmap.image6)
        val nameMods = mutableListOf("Elemental", "Magic", "Powerful", "Giant")
        val characterNames = mutableListOf("Sword", "Potion", "Power", "Strength")

        for (i in 0..30) {
            characters.add(
                createCharacter(
                    "${nameMods.random()} ${characterNames.random()}".trimStart(),
                    power.random(),
                    StringBuilder().append("CD: ").append(Random.nextInt(1,10)).append("s").toString(),
                    image.random(),
                    i
                )
            )
        }

        val adapter = CharacterAdapter(characters)
        recyclerView.adapter = adapter

        return view
    }

    private fun createCharacter(
        name: String,
        power: String,
        detail: String,
        image: Int,
        id: Int
    ) = Character(
        name = name,
        power = power,
        image = image,
        detail = detail
    )
}
