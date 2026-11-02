package com.example.project_siti.Message

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.project_siti.R
import com.example.project_siti.databinding.FragmentMessageBinding

class MessageFragment : Fragment() {
    private var _binding: FragmentMessageBinding? = null
    private val binding get() = _binding!!

    // Pesan dari pengelola penginapan Pine & Soul
    private val messageList = listOf(
        MessageModel("Bu Ratna", "Cabin Kabut Pagi sudah siap, check-in mulai 14.00 ya", "https://i.pravatar.cc/150?img=1"),
        MessageModel("Pak Dimas", "Terima kasih sudah memesan, kami tunggu kedatangannya", "https://i.pravatar.cc/150?img=2"),
        MessageModel("Teh Sari", "Perapian sudah dinyalakan, selamat beristirahat", "https://i.pravatar.cc/150?img=3"),
        MessageModel("Mas Bagas", "Sarapan diantar ke teras jam 07.30 ya", "https://i.pravatar.cc/150?img=4"),
        MessageModel("Kak Lina", "Jangan lupa bawa jaket, malam di sini dingin", "https://i.pravatar.cc/150?img=5"),
        MessageModel("Pak Hendra", "Parkir tersedia tepat di depan cabin", "https://i.pravatar.cc/150?img=6"),
        MessageModel("Bu Wulan", "Wi-Fi sudah aktif, kata sandinya ada di meja tamu", "https://i.pravatar.cc/150?img=7"),
        MessageModel("Mas Rizky", "Check-out paling lambat jam 11.00 ya", "https://i.pravatar.cc/150?img=8"),
        MessageModel("Teh Nisa", "Mau tambah selimut? Kabari saja ya", "https://i.pravatar.cc/150?img=9"),
        MessageModel("Pak Joko", "Sampai jumpa lagi di Pine & Soul!", "https://i.pravatar.cc/150?img=10")
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMessageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (requireActivity() as AppCompatActivity).setSupportActionBar(binding.toolbar)
        (requireActivity() as AppCompatActivity).supportActionBar?.apply {
            title = "Pine & Soul"
            subtitle = "Pesan"
        }
        val adapter = MessageAdapter(requireContext(), messageList)
        binding.listMessageItems.adapter = adapter

        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.message_toolbar_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_tutorial -> {
                val intent = Intent(requireContext(), TutorialMessageActivity::class.java)
                startActivity(intent)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
