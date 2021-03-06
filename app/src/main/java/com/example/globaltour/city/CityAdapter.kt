package com.example.globaltour.city

import android.content.Context
import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.globaltour.City
import com.example.globaltour.R
import com.example.globaltour.VacationSpots

class CityAdapter(val context: Context, var cityList: ArrayList<City>) :
    RecyclerView.Adapter<CityAdapter.CityViewHolder>() {

    inner class CityViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {
        private var currentposition: Int = -1
        private var currenctCity: City? = null
        private val txtcityname = itemView.findViewById<TextView>(R.id.txv_city_name)
        private val imgvw = itemView.findViewById<ImageView>(R.id.imv_city)
        private val dlvw = itemView.findViewById<ImageView>(R.id.imv_delete)
        private val fvw = itemView.findViewById<ImageView>(R.id.imv_favorite)

        private val icfavariteFilledImage = ResourcesCompat.getDrawable(
            context.resources,
            R.drawable.ic_favorite_filled, null
        )
        private val icfavariteBorderedImage = ResourcesCompat.getDrawable(
            context.resources,
            R.drawable.ic_favorite_bordered, null
        )


        fun setdata(city: City, position: Int) {


            txtcityname.text = city.name
            imgvw.setImageResource(city.imageId)
            if (city.isFavorite)
                fvw.setImageDrawable(icfavariteBorderedImage)
            else
                fvw.setImageDrawable(icfavariteFilledImage)




            this.currentposition = position
            this.currenctCity = city
        }

        fun setlisterners() {
            dlvw.setOnClickListener(this@CityViewHolder)
            fvw.setOnClickListener(this@CityViewHolder)
        }

        override fun onClick(v: View?) {
            when (v!!.id) {
                R.id.imv_delete -> deleteItem()
                R.id.imv_favorite -> addToFavorite()


            }


        }

        fun deleteItem() {
            cityList.removeAt(currentposition)
            notifyItemMoved(currentposition, position)
            notifyItemRangeChanged(currentposition, cityList.size)
            VacationSpots.favoriteCityList.remove(currenctCity!!)

        }

        fun addToFavorite() {
            currenctCity?.isFavorite = !(currenctCity?.isFavorite!!)  //toggle to boolean
            if (currenctCity?.isFavorite!!) {
                fvw.setImageDrawable(icfavariteFilledImage)
                VacationSpots.favoriteCityList.add(currenctCity!!)
                }else{
                fvw.setImageDrawable(icfavariteBorderedImage)
                VacationSpots.favoriteCityList.remove(currenctCity!!)
            }


        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CityViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.grid_item_city, parent, false)
        return CityViewHolder(itemView)
    }

    override fun onBindViewHolder(cityViewHolder: CityViewHolder, position: Int) {
        val city = cityList[position]

        cityViewHolder.setdata(city, position)
        cityViewHolder.setlisterners()


    }

    override fun getItemCount(): Int {
        return cityList.size
    }
}