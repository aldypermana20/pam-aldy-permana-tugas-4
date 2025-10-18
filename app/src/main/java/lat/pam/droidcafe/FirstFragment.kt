package lat.pam.droidcafe

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import lat.pam.droidcafe.databinding.FragmentFirstBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null
    // This property is only valid between onCreateView and onDestroyView.
    private val binding get() = _binding!!

    // Variabel untuk menyimpan pesan pesanan
    private var mOrderMessage: String? = null

    companion object {
        // Definisikan key untuk mengirim data via Intent
        const val EXTRA_MESSAGE = "lat.pam.droidcafe.extra.MESSAGE"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Menambahkan Aksi Klik pada gambar Donut
        binding.donut.setOnClickListener {
            mOrderMessage = getString(R.string.donut_order_message)
            displayToast(mOrderMessage!!)
        }

        // Menambahkan Aksi Klik pada gambar Ice Cream Sandwich
        binding.iceCream.setOnClickListener {
            mOrderMessage = getString(R.string.ice_cream_order_message)
            displayToast(mOrderMessage!!)
        }

        // Menambahkan Aksi Klik pada gambar Froyo
        binding.froyo.setOnClickListener {
            mOrderMessage = getString(R.string.froyo_order_message)
            displayToast(mOrderMessage!!)
        }
    }

    /**
     * Method untuk menampilkan pesan Toast.
     */
    private fun displayToast(message: String) {
        Toast.makeText(activity, message, Toast.LENGTH_SHORT).show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}