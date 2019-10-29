package ian.meda.abccompany.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.parse.FindCallback
import com.parse.ParseException
import com.parse.ParseObject
import com.parse.ParseQuery
import ian.meda.abccompany.R
import ian.meda.abccompany.adapters.AdapterMaterial
import org.jetbrains.anko.doAsync

class FragmentMateriales : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_materiales, container, false)

        doAsync{
            val query = ParseQuery.getQuery<ParseObject>("Materials")
            query.findInBackground(object : FindCallback<ParseObject> {
                var recyclerView = view.findViewById<RecyclerView>(R.id.fragment_material_recyclerview)
                var materials: List<ParseObject> = arrayListOf<ParseObject>()

                override fun done(postList: List<ParseObject>, e: ParseException?) {
                    if (e == null) {
                        materials = postList
                        activity?.runOnUiThread {
                            recyclerView.adapter = AdapterMaterial(materials)
                            recyclerView.adapter?.notifyDataSetChanged();
                            recyclerView.layoutManager = LinearLayoutManager(context)
                        }
                        Log.d("score", "Retrieved " + materials.size + " scores")

                    } else {
                        Log.d("score", "Error: " + e.getStackTrace())
                    }
                }
            })

        }

        return view
    }
}