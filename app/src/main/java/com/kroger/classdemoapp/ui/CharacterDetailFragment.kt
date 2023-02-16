package com.kroger.classdemoapp.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.kroger.classdemoapp.R

class CharacterDetailFragment : Fragment() {

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_character_detail, container, false)

        if (arguments != null) {
            val image = requireArguments().getInt("image")
            val description = "Item's description:"
            val name = requireArguments().getString("name")
            val detail = requireArguments().getString("detail")

            view.findViewById<ImageView>(R.id.character_image).setImageResource(image)
            view.findViewById<TextView>(R.id.description).text = description
            view.findViewById<TextView>(R.id.character_name).text = name
            view.findViewById<TextView>(R.id.character_detail).text = detail
        }

        return view
    }
}
