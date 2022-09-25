package com.anshul.dogglers

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.anshul.dogglers.Layout.GRID


/**
 * Adapter to inflate the appropriate list item layout and populate the view with information
 * from the appropriate data source
 */
class DogCardAdapter(
    private val context: Context?,
    private val layout: Int
): RecyclerView.Adapter<DogCardAdapter.DogCardViewHolder>() {

    // Initialize the data using the List found in data/DataSource
    private val dogList = DataSource.dogs

    /**
     * Initialize view elements
     */
    class DogCardViewHolder(view: View?): RecyclerView.ViewHolder(view!!) {
        // Declare and initialize all of the list item UI components
        val dogImageView: ImageView? = view!!.findViewById(R.id.dog_image)
        val dogNameTextView: TextView? = view!!.findViewById(R.id.dog_name)
        val dogAgeTextView: TextView? = view!!.findViewById(R.id.dog_age)
        val dogHobbyTextView: TextView? = view!!.findViewById(R.id.dog_hobby)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogCardViewHolder {
        //  Use a conditional to determine the layout type and set it accordingly.
        //  if the layout variable is Layout.GRID the grid list item should be used. Otherwise the
        //  the vertical/horizontal list item should be used.
        val adapterLayout = when (layout) {
            // Inflate the layout
            GRID -> LayoutInflater.from(parent.context).inflate(R.layout.grid_list_item, parent, false)
            else -> LayoutInflater.from(parent.context).inflate(R.layout.vertical_horizontal_list_item, parent, false)
        }

        //  Null should not be passed into the view holder. This should be updated to reflect
        //  the inflated layout.
        return DogCardViewHolder(adapterLayout)
    }

    override fun getItemCount(): Int {
        return dogList.size
    } // return the size of the data set

    override fun onBindViewHolder(holder: DogCardViewHolder, position: Int) {
        // Get the data at the current position
        val dogData = dogList[position]
        // Set the image resource for the current dog
        holder.dogImageView?.setImageResource(dogData.imageResourceId)
        // Set the text for the current dog's name
        holder.dogNameTextView?.text = dogData.name
        // Set the text for the current dog's age
        val resources = context?.resources
        holder.dogAgeTextView?.text = resources?.getString(R.string.dog_age, dogData.age)
        // Set the text for the current dog's hobbies by passing the hobbies to the
        // R.string.dog_hobbies string constant.
        // Passing an argument to the string resource looks like:
        // resources?.getString(R.string.dog_hobbies, dog.hobbies)
        holder.dogHobbyTextView?.text = resources?.getString(R.string.dog_hobbies, dogData.hobbies)
    }
}
