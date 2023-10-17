package com.simonllano.fragmentos.ui.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.simonllano.fragmentos.R
import com.simonllano.fragmentos.databinding.FragmentListBinding
import com.simonllano.fragmentos.model.Superheroe


class ListFragment : Fragment() { //lista fragment

    private lateinit var listBinding: FragmentListBinding // Bindeo del list fragment
    private var superheroesList = mutableListOf<Superheroe>() // Se declara una lista vacia
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle? ): View? {
        listBinding = FragmentListBinding.inflate(inflater, container,false)  // Configuracion del view binding
        val root : View = listBinding.root

        loadSuperheroes()  // llamado de funcion loadSuperheroes

        val SuperheroeRecyclerViewAdapter = superheroeRecyclerViewAdapter(superheroesList, onItemClicked = {onSuperheroeClicked(it)}) // configuracion del recycler view
        listBinding.superheroesRecyclerView.apply{
            layoutManager = LinearLayoutManager(this@ListFragment.requireContext()) // El linearlayout manager organiza los elementos en una lista vertical u horizontal, similar a una lista simple.
            adapter = SuperheroeRecyclerViewAdapter // se utiliza para proporcionar datos a una vista, como un ListView, RecyclerView o Spinner, y controlar cómo se muestran estos datos en la interfaz de usuario.
            setHasFixedSize(false)
        }

        return root
    }

    private fun loadSuperheroes() {
        superheroesList.clear()
       var superheroe = Superheroe(id = 0,  //Objeto de tipo superheroe
           name = resources.getString(R.string.batman_name),
           alias = resources.getString(R.string.batman_alias),
           powers = resources.getString(R.string.batman_powers),
           image = R.drawable.batman)
        superheroesList.add(superheroe)

        superheroe = Superheroe(id = 1,  //Objeto de tipo superheroe
            name = resources.getString(R.string.flash_name),
            alias = resources.getString(R.string.flash_alias),
            powers = resources.getString(R.string.flash_powers),
            image = R.drawable.flash)
        superheroesList.add(superheroe)

        superheroe = Superheroe(id = 2,  //Objeto de tipo superheroe
            name = resources.getString(R.string.wonderwoman_name),
            alias = resources.getString(R.string.wonderwoman_alias),
            powers = resources.getString(R.string.wonderwoman_powers),
            image = R.drawable.wonderwoman)
        superheroesList.add(superheroe)

        superheroe = Superheroe(id = 3,  //Objeto de tipo superheroe
            name = resources.getString(R.string.superman_name),
            alias = resources.getString(R.string.superman_alias),
            powers = resources.getString(R.string.superman_powers),
            image = R.drawable.superman)
        superheroesList.add(superheroe)
    }

    private fun onSuperheroeClicked(superheroe: Superheroe) {
            when(superheroe.id){
                0 -> findNavController().navigate(ListFragmentDirections.actionListFragmentToBatmanFragment())
                1 -> findNavController().navigate(ListFragmentDirections.actionListFragmentToWonderwomanFragment())
                2 -> findNavController().navigate(ListFragmentDirections.actionListFragmentToFlashFragment())
                else -> findNavController().navigate(ListFragmentDirections.actionListFragmentToSupermanFragment())
            }
    }
}