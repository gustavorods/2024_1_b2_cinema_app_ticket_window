package com.example.cinemaapp_ticket_window

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cinemaapp_ticket_window.data.DataEscolherHorario
import com.example.cinemaapp_ticket_window.data.dataEscolherDia
import com.example.cinemaapp_ticket_window.model.modeloEscolherDia
import com.example.cinemaapp_ticket_window.model.modeloEscolherHorario
import com.example.cinemaapp_ticket_window.ui.theme.CinemaApp_ticket_windowTheme
import com.example.cinemaapp_ticket_window.ui.theme.poppinsFontFamily

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CinemaApp_ticket_windowTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(0xff323232)
                ) {
                    App()
                }
            }
        }
    }
}

@Composable
fun header(modifier: Modifier = Modifier) {
    Box(
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .height(50.dp)
                .background(Color(0xFF212121)),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically  // Centralize verticalmente os itens na Row
        ) {
            Image(
                painter = painterResource(R.drawable.menuicon),
                contentDescription = "Menu Icon",
                modifier = Modifier
                    .padding(5.dp)
            )
            Text(
                text = "CineSync",
                textAlign = TextAlign.Center,
                style = TextStyle(color = Color.White, fontSize = 20.sp),
                modifier = Modifier
                    .padding(5.dp)
            )
            Image(
                painter = painterResource (R.drawable.searchicon),
                contentDescription = "Search Icon",
                modifier = Modifier
                    .padding(5.dp)
            )
        }
    }
}

@Composable
fun TicketWindow(modifier: Modifier = Modifier) {
    Box(){
        Column(modifier = Modifier
            .background(color = Color.Black, RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp))
            .align(Alignment.BottomCenter)
            .padding(15.dp)
            .height(650.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(25.dp))

            Text(text = "Duna Parte 2",
                style = TextStyle(color = Color.White, fontSize = 25.sp),
                fontFamily = poppinsFontFamily,
                fontWeight = FontWeight.SemiBold
            )
            Spacer(modifier = Modifier.height(25.dp))

            Row  {
                Image(painter = painterResource(R.drawable.dunaposter),
                    contentDescription = "Duna parte 2 poster",
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .size(175.dp)
                )
                Column {
                    Row(modifier = Modifier,
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(painter = painterResource(R.drawable.icone_tempo_filme),
                            contentDescription = "Icone tempo de duração do filme",
                            modifier = Modifier
                                .size(26.dp))
                        Spacer(modifier = Modifier.width(7.dp))
                        Text(text = "3h01m",
                            style = TextStyle(color = Color.White, fontSize = 15.sp),
                            fontFamily = poppinsFontFamily,
                            fontWeight = FontWeight.Medium
                        )
                    }

                    Spacer(modifier = Modifier.height(15.dp))

                    Row(modifier = Modifier,
                            horizontalArrangement = Arrangement.Center,
                            verticalAlignment = Alignment.CenterVertically

                    ) {
                        Image(painter = painterResource(R.drawable.icone_valor_do_filme),
                            contentDescription = "Icone valor do ingresso",
                            modifier = Modifier
                                .size(27.dp))
                        Spacer(modifier = Modifier.width(7.dp))
                        Text(text = "R$30",
                            style = TextStyle(color = Color.White, fontSize = 15.sp),
                            fontFamily = poppinsFontFamily,
                            fontWeight = FontWeight.Medium
                            )
                    }

                    Spacer(modifier = Modifier.height(15.dp))

                    Row(modifier = Modifier,
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically

                    ) {
                        Image(painter = painterResource(R.drawable.icone_tipo_do_filme),
                            contentDescription = "Icone gênero do filme",
                            modifier = Modifier
                                .size(27.dp))
                        Spacer(modifier = Modifier.width(7.dp))
                        Text(text = "Ação | Aventura",
                            style = TextStyle(color = Color.White, fontSize = 15.sp),
                            fontFamily = poppinsFontFamily,
                            fontWeight = FontWeight.Medium
                        )
                    }

                    Spacer(modifier = Modifier.height(20.dp))
                    Box() {
                        Row(modifier = Modifier
                            .background(color = Color(0xff1c1b1b), RoundedCornerShape(19.dp))
                            .padding(8.dp),
                            horizontalArrangement = Arrangement.Center,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Image(painter = painterResource(R.drawable.icone_play),
                                contentDescription = "Icone de Play",
                                modifier = Modifier
                                    .size(30.dp)
                            )
                            Spacer(modifier = Modifier.width(7.dp))
                            Text(text = "Assistir trailer",
                                style = TextStyle(color = Color.White, fontSize = 15.sp),
                                fontFamily = poppinsFontFamily,
                                fontWeight = FontWeight.Medium
                            )                        }
                    }
                }
            }
            Spacer(modifier = Modifier.height(25.dp))

            Text(text = "Escolha o dia",
                style = TextStyle(color = Color.White, fontSize = 20.sp),
                fontFamily = poppinsFontFamily,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier
                    .align(Alignment.Start)
            )
            Spacer(modifier = Modifier.height(20.dp))

            CardDiaGrid()
            Spacer(modifier = Modifier.height(25.dp))

            Text(text = "Escolha o horário",
                style = TextStyle(color = Color.White, fontSize = 20.sp),
                fontFamily = poppinsFontFamily,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier
                    .align(Alignment.Start)
            )
            Spacer(modifier = Modifier.height(20.dp))

            CardHorarioGrid()
            Spacer(modifier = Modifier.height(30.dp))

            Button(onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(
                    Color(0xff006cfa)
                ),
                shape = RoundedCornerShape(15.dp),
                modifier = Modifier
                    .width(300.dp)
                    .height(50.dp)
            ) {
                Text(text = "Comprar ingresso",
                    style = TextStyle(color = Color.White, fontSize = 20.sp),
                    fontFamily = poppinsFontFamily,
                    fontWeight = FontWeight.SemiBold
                )
            }
        }
    }
}


@Composable
fun CardDia(modeloEscolherDia: modeloEscolherDia, modifier: Modifier = Modifier) {
    Box {
        Column(modifier = Modifier
            .background(Color(0xff1c1b1b), RoundedCornerShape(18.dp))
            .height(80.dp)
            .width(50.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally

        ) {
            Text(text = stringResource(id = modeloEscolherDia.diaSemana),
                style = TextStyle(color = Color.White, fontSize = 17.sp),
                fontFamily = poppinsFontFamily,
                fontWeight = FontWeight.Light)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = stringResource(id = modeloEscolherDia.diaMes),
                style = TextStyle(color = Color.White, fontSize = 17.sp),
                fontFamily = poppinsFontFamily,
                fontWeight = FontWeight.Medium)
        }
    }
}

@Composable
fun CardDiaGrid(modifier: Modifier = Modifier) {
    LazyHorizontalGrid(modifier = Modifier
        .height(80.dp),
        rows = GridCells.Fixed(1),
        horizontalArrangement = Arrangement.spacedBy(18.dp)
        )
    {
        items(dataEscolherDia.dias) { x ->
            CardDia(x)
        }
    }

}

@Composable
fun CardHorario(modeloEscolherHorario: modeloEscolherHorario, modifier: Modifier = Modifier) {
    Box() {
        Row(modifier = Modifier
            .background(Color(0xff1c1b1b), RoundedCornerShape(19.dp))
            .height(35.dp)
            .width(85.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = stringResource(id = modeloEscolherHorario.horario),
                style = TextStyle(color = Color.White, fontSize = 16.sp),
                fontFamily = poppinsFontFamily,
                fontWeight = FontWeight.Medium,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(5.dp)
            )
        }
    }
}

@Composable
fun CardHorarioGrid(modifier: Modifier = Modifier) {
    LazyHorizontalGrid(modifier = Modifier
        .height(35.dp),
        rows = GridCells.Fixed(1),
        horizontalArrangement = Arrangement.spacedBy(18.dp)
    ) {
        items(DataEscolherHorario.horarios) { x ->
            CardHorario(x)
        }
    }
}

@Composable
fun App(modifier: Modifier = Modifier) {
    Column(
    ) {
        header()
        Spacer(modifier = Modifier.weight(1f))
        TicketWindow()
    }
}

@Composable
@Preview
fun prev() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(0xff323232)
    ) {
        App()
    }
}

