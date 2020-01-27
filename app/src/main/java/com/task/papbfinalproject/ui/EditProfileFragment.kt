package com.task.papbfinalproject.ui


import android.os.Bundle
import android.view.Gravity
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.task.papbfinalproject.R
import com.task.papbfinalproject.databinding.FragmentEditProfileBinding
import com.task.papbfinalproject.model.Avatar
import com.task.papbfinalproject.ui.adapter.AvatarAdapter
import com.task.papbfinalproject.ui.adapter.AvatarListener
import com.task.papbfinalproject.ui.adapter.EventAdapter
import kotlinx.android.synthetic.main.fragment_edit_profile.view.*

class EditProfileFragment : Fragment() {
    private lateinit var binding: FragmentEditProfileBinding
    private var imageAvatar: Int? = 0
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEditProfileBinding.inflate(inflater, container, false)
        imageAvatar = arguments?.let { EditProfileFragmentArgs.fromBundle(it).avatarArg }
        val shared = requireContext().getSharedPreferences("shared", AppCompatActivity.MODE_WORLD_READABLE)
        binding.ivAvatar.setImageResource(imageAvatar!!)
        val data = listOf<Avatar>(
            Avatar("0", R.drawable.ic_beard_man),
            Avatar("1", R.drawable.ic_blonde_girl),
            Avatar("2", R.drawable.ic_blonde_man),
            Avatar("3", R.drawable.ic_bob_man),
            Avatar("4", R.drawable.ic_bowl_man),
            Avatar("5", R.drawable.ic_brown_boy),
            Avatar("6", R.drawable.ic_frizzy_boy),
            Avatar("7", R.drawable.ic_long_girl),
            Avatar("8", R.drawable.ic_old_man)
        )
        binding.rvAvatar.adapter = AvatarAdapter(AvatarListener {
            binding.ivAvatar.setImageResource(it.image)
            imageAvatar = it.image
        })

        val adapter = binding.rvAvatar.adapter as AvatarAdapter
        adapter.submitList(data)


        binding.btnSave.setOnClickListener{
            val edit = shared.edit()
            edit.putInt("avatar", imageAvatar!!)
            edit.apply()
            val toast = Toast.makeText(
                requireContext(),
                "Avatar has been changed",
                Toast.LENGTH_SHORT
            )
            toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0)
            toast.show()
        }
        return binding.root
    }
}
