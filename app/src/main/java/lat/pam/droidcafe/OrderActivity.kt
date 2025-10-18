package lat.pam.droidcafe

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.RadioButton
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class OrderActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_order)

        // Mengatur padding otomatis agar layout tidak tertutup status bar/navigation bar
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // 🔹 Inisialisasi Spinner (City)
        val citySpinner: Spinner = findViewById(R.id.city_spinner)
        ArrayAdapter.createFromResource(
            this,
            R.array.city_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            citySpinner.adapter = adapter
        }
    }

    // 🔹 Fungsi ini dipanggil ketika user klik RadioButton
    fun onRadioButtonClicked(view: View) {
        val checked = (view as RadioButton).isChecked

        when (view.id) {
            R.id.sameday -> if (checked) {
                displayToast(getString(R.string.same_day_messenger_service))
            }
            R.id.nextday -> if (checked) {
                displayToast(getString(R.string.next_day_ground_delivery))
            }
            R.id.pickup -> if (checked) {
                displayToast(getString(R.string.pick_up))
            }
        }
    }

    // 🔹 Fungsi untuk menampilkan Toast
    private fun displayToast(message: String) {
        Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show()
    }
}
