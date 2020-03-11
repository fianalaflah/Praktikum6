package android.latihan.rv_intent

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_phone_detail.*

class PhoneDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_phone_detail)

        var intentThatStartedThisActivity = getIntent()

        if (intentThatStartedThisActivity.hasExtra(Intent.EXTRA_TEXT)){
            var partid = intentThatStartedThisActivity.getStringExtra(Intent.EXTRA_TEXT)
            var partnama = intentThatStartedThisActivity.getStringExtra(Intent.EXTRA_COMPONENT_NAME)
            var partemail = intentThatStartedThisActivity.getStringExtra(Intent.EXTRA_EMAIL)
//            var partid = intentThatStartedThisActivity.getStringArrayListExtra(Intent.EXTRA_TEXT)
            part_item_id.text = partid
            part_name_id.text = partnama
            part_email_id.text = partemail
        }
    }
}