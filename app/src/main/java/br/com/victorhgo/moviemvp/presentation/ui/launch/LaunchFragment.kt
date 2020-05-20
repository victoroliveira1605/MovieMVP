package br.com.victorhgo.moviemvp.presentation.ui.launch

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import br.com.victorhgo.moviemvp.R

class LaunchFragment : Fragment(), LaunchContract.View {
    private lateinit var mPresenter: LaunchPresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_launch, container, false)
    }

    override fun initView() {
        mPresenter = LaunchPresenter()
        mPresenter.start()
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            LaunchFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}
