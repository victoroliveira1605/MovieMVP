package br.com.victorhgo.moviemvp.presentation.ui.upcoming

interface UpcomingContract {
    interface View {
        fun initView()
    }

    interface Presenter {
        fun start()
    }
}