package com.example.cinemaapp_ticket_window.data

import com.example.cinemaapp_ticket_window.R
import com.example.cinemaapp_ticket_window.model.modeloEscolherDia

object dataEscolherDia {
    var dias = listOf(
        modeloEscolherDia(R.string.segunda, R.string.um),
        modeloEscolherDia(R.string.terca, R.string.dois),
        modeloEscolherDia(R.string.quarta, R.string.tres),
        modeloEscolherDia(R.string.quinta, R.string.quatro),
        modeloEscolherDia(R.string.sexta, R.string.cinco),
        modeloEscolherDia(R.string.sabado, R.string.seis),
        modeloEscolherDia(R.string.domingo, R.string.sete),

    )
}