package com.lambdaschool.congressfragmentsproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.lambdaschool.congressfragmentsproject.api.CongresspersonOverview

class PartFive : AppCompatActivity(), CongresspersonOverviewFragment.OnListFragmentInteractionListener {

    override fun onListFragmentInteraction(item: CongresspersonOverview) {
        val fragment = DisplayFragment()
        val bundle = Bundle()

        bundle.putString("key", item.id)
        fragment.arguments = bundle

        supportFragmentManager.beginTransaction()
            .replace(R.id.test_first_layout, fragment)
            .addToBackStack(null)
            .commit()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_part_five)



    }
}
