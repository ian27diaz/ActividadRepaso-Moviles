package ian.meda.abccompany.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.parse.ParseFile
import com.parse.ParseObject
import ian.meda.abccompany.R

class AdapterMaterial(var materials : List<ParseObject>): RecyclerView.Adapter<MaterialViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MaterialViewHolder {
        Log.d("AdapterUser", materials.size.toString())
        val layoutInflater = LayoutInflater.from(parent.context).inflate(R.layout.item_material, parent, false)
        return MaterialViewHolder(layoutInflater)
    }

    override fun getItemCount(): Int = materials.size

    override fun onBindViewHolder(holder: MaterialViewHolder, position: Int) {
        holder.bind(materials[position])
    }
}

class MaterialViewHolder(view: View) : RecyclerView.ViewHolder(view){
    private var creator   : TextView = view.findViewById(R.id.item_material_creator_tv)
    private var quantity    : TextView = view.findViewById(R.id.item_material_quantity_tv)
    private var mainphoto   : ImageView = view.findViewById(R.id.item_material_main_image_iv)
    private var  rm  = Glide.with(view);

    fun bind(photo : ParseObject){
        creator.text = photo.getString("name")
        quantity.text = photo.getInt("quantity").toString() + " en existencia!"
        var imagen : ParseFile = photo.getParseFile("photo")!!
        rm.load(imagen.url).into(mainphoto)
        //photo.text = user.get("photo"). oString()
    }
}