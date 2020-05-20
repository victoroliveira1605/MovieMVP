package br.com.victorhgo.moviemvp.presentation.ui.launch

interface LaunchContract {
    interface View {
        fun initView()
    }

    interface Presenter {
        fun start()
    }
}