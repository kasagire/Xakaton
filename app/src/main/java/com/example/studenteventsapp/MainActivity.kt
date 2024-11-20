import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import com.example.studenteventsapp.R
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Кнопка для перехода к выбору интересов
        val selectInterestsButton: Button = findViewById(R.id.selectInterestsButton)
        selectInterestsButton.setOnClickListener {
            val intent = Intent(this, SelectInterestsActivity::class.java)
            startActivity(intent)
        }

        // Кнопка для перехода к мероприятиям (если интересы уже выбраны)
        val viewEventsButton: Button = findViewById(R.id.viewEventsButton)
        viewEventsButton.setOnClickListener {
            val intent = Intent(this, EventsActivity::class.java)
            startActivity(intent)
        }
    }
}