package se.ralwert.uppgift1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import se.ralwert.uppgift1.databinding.FragmentCalcBinding
import se.ralwert.uppgift1.databinding.FragmentStartBinding

class CalcFragment : Fragment() {
    lateinit var Numberinput : EditText

    private var _binding: FragmentCalcBinding? = null
    private  val binding get() = _binding!!

    var sum = 0
    private var input = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentCalcBinding.inflate(inflater,container,false)
        val view = binding.root
        return view    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Numberinput = binding.Numberinput

        binding.Sumtext.text = sum.toString()

        binding.minusbutton.setOnClickListener {
            if (Numberinput.text.isNotEmpty()) {
                val inputValue = Numberinput.text.toString().toInt()

                sum -= inputValue

                binding.Sumtext.text = sum.toString()
            }
        }
        binding.plusbutton.setOnClickListener {
            if (Numberinput.text.isNotEmpty()) {
                val inputValue = Numberinput.text.toString().toInt()

                sum += inputValue

                binding.Sumtext.text = sum.toString()
            }
        }

        binding.multibutton.setOnClickListener {
            if (Numberinput.text.isNotEmpty()) {
                val inputValue = Numberinput.text.toString().toInt()

                sum *= inputValue

                binding.Sumtext.text = sum.toString()
            }
        }
        binding.Divbutton.setOnClickListener {
            if (Numberinput.text.isNotEmpty()) {
                val inputValue = Numberinput.text.toString().toInt()

                sum /= inputValue

                binding.Sumtext.text = sum.toString()
            }
        }
        binding.Resetbutton.setOnClickListener {
            sum = 0
            binding.Sumtext.text = sum.toString()

        }
    binding.NextButton.setOnClickListener {
        var golist = ListaFragment()
            golist.resultnumb = sum
        requireActivity().supportFragmentManager
            .beginTransaction()
            .add(R.id.fragcon,golist)
            .addToBackStack(null)
            .commit()
    }
    }

}