package android.latihan.rv_intent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val testData = createPhoneData()
        rv_parts.layoutManager = LinearLayoutManager(this)
        rv_parts.setHasFixedSize(true)
        rv_parts.adapter = ContactAdapter(testData, { phoneItem : PhoneData -> phoneItemClicked(phoneItem) })
    }

    private fun phoneItemClicked(phoneItem : PhoneData){
        val showDetailActivityIntent = Intent(this, PhoneDetailActivity::class.java)
        showDetailActivityIntent.putExtra(Intent.EXTRA_TEXT, phoneItem.phone.toString())
        showDetailActivityIntent.putExtra(Intent.EXTRA_EMAIL, phoneItem.contactEmail)
        showDetailActivityIntent.putExtra(Intent.EXTRA_COMPONENT_NAME, phoneItem.contactName)
//        showDetailActivityIntent.putExtra(Intent.EXTRA_COMPONENT_NAME, arrayOf(phoneItem))
        startActivity(showDetailActivityIntent)
    }

    private fun createPhoneData() : List<PhoneData>{
        val partList = ArrayList<PhoneData>()
        partList.add(PhoneData(2362718,"Alpha", "akasa@gmail"))
        partList.add(PhoneData(3461723,"Bravo", "baba@gmail"))
        partList.add(PhoneData(8917234,"Charlie", "gogo@gmail"))
        return partList
    }
}
