package br.com.victorhgo.moviemvp.presentation.ui.upcoming

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import br.com.victorhgo.moviemvp.R
import br.com.victorhgo.moviemvp.network.MovieRepository

class UpcomingFragment : Fragment(), UpcomingContract.View {
    private lateinit var mPresenter: UpcomingPresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_upcoming, container, false)
    }

    override fun onStart() {
        super.onStart()
        initView()
    }

    override fun initView() {
        mPresenter = UpcomingPresenter(MovieRepository(), context!!)
        mPresenter.start()
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            UpcomingFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}
