package com.simonllano.fragmentos.ui.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView.OnItemClickListener
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView
import com.simonllano.fragmentos.R
import com.simonllano.fragmentos.databinding.CardViewItemSuperheroesBinding
import com.simonllano.fragmentos.model.Superheroe

class superheroeRecyclerViewAdapter(
    private var superheroesList: MutableList<Superheroe>,
    private var onItemClicked: (Superheroe) ->Unit
) : RecyclerView.Adapter<superheroeRecyclerViewAdapter.SuperheroeViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuperheroeViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.card_view_item_superheroes, parent, false)
        return SuperheroeViewHolder(itemView)
    }

    override fun getItemCount(): Int= superheroesList.size



    override fun onBindViewHolder(holder: SuperheroeViewHolder, position: Int) {
        val superheroe = superheroesList[position]
        holder.bindSuperheroe(superheroe)
        holder.itemView.setOnClickListener{ onItemClicked(superheroe)}

    }

    class SuperheroeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){


        private val binding =CardViewItemSuperheroesBinding.bind(itemView)
        fun bindSuperheroe(superheroe: Superheroe){ //Funcion que se encarga de pintar dentro de cada item de la lista los diferentes superheroes  en este caso
            with(binding){
                nameTextView.text = superheroe.name
                superheroeImageView.setImageResource(superheroe.image)
            }

        }

    }
}