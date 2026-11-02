package com.example.project_siti.More

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.SimpleAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.project_siti.databinding.FragmentMoreBinding

class MoreFragment : Fragment() {
    private var _binding: FragmentMoreBinding? = null
    private val binding get() = _binding!!

    // Jenis penginapan (untuk ArrayAdapter + simple_list_item_1)
    private val dataList = listOf(
        "Cabin", "Villa", "Glamping", "Homestay", "Cottage",
        "Bungalow", "Guest House", "Tiny House", "Treehouse"
    )

    // Jenis penginapan + deskripsi (untuk SimpleAdapter + simple_list_item_2)
    private val dataListWithDesc = listOf(
        mapOf("title" to "Cabin", "desc" to "Rumah kayu yang hangat di tengah pepohonan pinus"),
        mapOf("title" to "Villa", "desc" to "Rumah sewa utuh, cocok untuk rombongan keluarga"),
        mapOf("title" to "Glamping", "desc" to "Berkemah di tenda nyaman tanpa repot"),
        mapOf("title" to "Homestay", "desc" to "Menginap di rumah warga, suasananya akrab"),
        mapOf("title" to "Cottage", "desc" to "Pondok mungil dengan teras dan kebun"),
        mapOf("title" to "Bungalow", "desc" to "Rumah satu lantai dengan halaman yang luas"),
        mapOf("title" to "Guest House", "desc" to "Penginapan sederhana dengan harga bersahabat"),
        mapOf("title" to "Tiny House", "desc" to "Rumah mungil yang pas untuk berdua"),
        mapOf("title" to "Treehouse", "desc" to "Kamar di atas pohon dengan pemandangan lepas")
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMoreBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (requireActivity() as AppCompatActivity).setSupportActionBar(binding.toolbar)
        (requireActivity() as AppCompatActivity).supportActionBar?.apply {
            title = "Pine & Soul"
            subtitle = "Jenis Penginapan"
        }

        // Adapter: penghubung dataList dengan layout simple_list_item_1
//        val adapter = ArrayAdapter(
//            requireContext(),
//            android.R.layout.simple_list_item_1,
//            dataList
//        )
//    // Hubungkan listViewItems dengan adapter
//        binding.listViewItems.adapter = adapter
//    // Aksi saat item diklik
//        binding.listViewItems.setOnItemClickListener { _, _, position, _ ->
//            val selectedItem = dataList[position]
//            Toast.makeText(requireContext(), "Kamu memilih: $selectedItem",
//                Toast.LENGTH_SHORT).show()
//        }

        val adapter = SimpleAdapter(
            requireContext(),
            dataListWithDesc,
            android.R.layout.simple_list_item_2,
            arrayOf("title", "desc"), // key yang diambil dari data
            intArrayOf(android.R.id.text1, android.R.id.text2) // tempat tampilnya
        )
        binding.listViewItems.adapter = adapter
        binding.listViewItems.setOnItemClickListener { _, _, position, _ ->
            val selectedItem = dataListWithDesc[position]
            val title = selectedItem["title"]
            val desc = selectedItem["desc"]
            Toast.makeText(
                requireContext(), "Kamu memilih: $title ($desc)",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
