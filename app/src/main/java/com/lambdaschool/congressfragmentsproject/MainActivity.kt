package com.lambdaschool.congressfragmentsproject

import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.ListFragment
import com.lambdaschool.congressfragmentsproject.api.CongressDao
import com.lambdaschool.congressfragmentsproject.api.CongresspersonDetails
import com.lambdaschool.congressfragmentsproject.api.CongresspersonOverview
import java.util.ArrayList

class MainActivity : AppCompatActivity(), CongresspersonOverviewFragment.OnListFragmentInteractionListener {
    override fun onListFragmentInteraction(item: CongresspersonOverview) {
        val fragment = DisplayFragment()
        val bundle = Bundle()

        bundle.putString("key", item.id)
        fragment.arguments = bundle



        if (!resources.getBoolean(R.bool.is_tablet)){
            supportFragmentManager.beginTransaction()
                .replace(R.id.test_first_layout, fragment)
                .addToBackStack(null)
                .commit()
        }

        else{

            val intent = Intent(this, PartFive::class.java)
            intent.putExtra("key2",item.id)
            startActivity(intent)
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragment = CongresspersonOverviewFragment()
        supportFragmentManager.beginTransaction()
            .replace(R.id.test_first_layout, fragment)
            .commit()

        // get an overview list for all members of congress
        /*val allMembers: ArrayList<CongresspersonOverview> = CongressDao.allMembers

        // get details for a single member of congress
        val singleMemberDetails: CongresspersonDetails? = allMembers[0].id?.let { CongressDao.getMemberDetails(it) }


        // get congressperson portrait
        val image: Bitmap? = allMembers[0].id?.let { CongressDao.getImage(it) }*/

    }
}
