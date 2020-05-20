package br.com.victorhgo.moviemvp.presentation.ui.home

interface HomeContract {
    interface View {
        fun initView()
    }

    interface Presenter {
        fun start()
    }
}