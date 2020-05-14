package edu.stanford.rmoktad.yelpclone

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import edu.stanford.rmoktad.myapplication.R
import kotlinx.android.synthetic.main.item_restaurant.view.*

class RestaurantsAdapter(val context: Context, val restaurants: List<YelpRestaurant>) :
    RecyclerView.Adapter<RestaurantsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_restaurant, parent, false))
    }

    override fun getItemCount() = restaurants.size

    override fun onBindViewHolder(holder: RestaurantsAdapter.ViewHolder, position: Int) {
        val restaurant = restaurants[position]
        holder.bind(restaurant)
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bind(restaurant: YelpRestaurant){
            itemView.tvName.text = restaurant.name
//            itemView.ratingBar.rating = restaurant.rating.toFloat()

            if(restaurant.rating.toFloat() < 1){
                itemView.ratingStars.setImageResource(R.drawable.stars_small_0)
            }

            else if(restaurant.rating.toFloat() < 1.5){
                itemView.ratingStars.setImageResource(R.drawable.stars_small_1)
            }

            else if(restaurant.rating.toFloat() >= 1.5 && restaurant.rating.toFloat() < 2){
                itemView.ratingStars.setImageResource(R.drawable.stars_small_1_half)
            }

            else if(restaurant.rating.toFloat() >= 2 && restaurant.rating.toFloat() < 2.5){
                itemView.ratingStars.setImageResource(R.drawable.stars_small_2)
            }

            else if(restaurant.rating.toFloat() >= 2.5 && restaurant.rating.toFloat() < 3){
                itemView.ratingStars.setImageResource(R.drawable.stars_small_2_half)
            }

            else if(restaurant.rating.toFloat() >= 3 && restaurant.rating.toFloat() < 3.5){
                itemView.ratingStars.setImageResource(R.drawable.stars_small_3)
            }

            else if(restaurant.rating.toFloat() >= 3.5 && restaurant.rating.toFloat() < 4){
                itemView.ratingStars.setImageResource(R.drawable.stars_small_3_half)
            }

            else if(restaurant.rating.toFloat() >= 4 && restaurant.rating.toFloat() < 4.5){
                itemView.ratingStars.setImageResource(R.drawable.stars_small_4)
            }

            else if(restaurant.rating.toFloat() >= 4.5 && restaurant.rating.toFloat() < 5){
                itemView.ratingStars.setImageResource(R.drawable.stars_small_4_half)
            }

            else{
                itemView.ratingStars.setImageResource(R.drawable.stars_small_5)
            }


            itemView.tvNumReviews.text = "${restaurant.numRevies} Reviews"
            itemView.tvAddress.text = restaurant.location.address
            itemView.tvCategory.text = restaurant.categories[0].title
            itemView.tvDistance.text = restaurant.displayDistance()
            itemView.tvPrice.text = restaurant.price
            Glide.with(context).load(restaurant.imageUrl).apply(RequestOptions().transform(CenterCrop(), RoundedCorners(20))).into(itemView.imageView)
        }
    }

}
