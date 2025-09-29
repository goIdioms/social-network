package com.example.nemax

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.nemax.ui.theme.NeMaxTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NeMaxTheme {
                AppScreen()
            }
        }
    }
}

@Composable
fun AppScreen() {
    Scaffold(
        content = { innerPadding: PaddingValues ->
            Box(
                modifier = Modifier.fillMaxSize()
            ) {
                Image(
                    painter = painterResource(R.drawable.fon_start),
                    contentDescription = "Background at the start",
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(innerPadding)
                        .padding(top = 100.dp, bottom = 8.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Image(
                        modifier = Modifier,
                        painter = painterResource(R.drawable.max_logo_horizontal),
                        contentDescription = "Not Max logo"
                    )

                }

                var areButtonsStartVisible by remember { mutableStateOf(true) }

                if (areButtonsStartVisible) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                            .padding(top = 200.dp, bottom = 8.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        Text(
                            text = "Бобро дожаловать в Не Макс, уважаеиые, как вы себе там думаете друзья и враги!",
                            modifier = Modifier
                                .padding(vertical = 50.dp),
                            textAlign = TextAlign.Center,
                            fontSize = 18.sp,
                            fontFamily = FontFamily(Font(R.font.roboto_condensed_semi_bold)),
                        )
                        Button(
                            onClick = {
                                areButtonsStartVisible = false
                            }
                        ) {
                            Text(
                                text = "Регистрация",
                                modifier = Modifier
                                    .widthIn(min = 180.dp)
                                    .heightIn(min = 30.dp),
                                textAlign = TextAlign.Center,
                                fontSize = 25.sp,
                            )
                        }

                        Button(
                            onClick = {
                                areButtonsStartVisible = false
                            },
                            modifier = Modifier
                                .padding(top = 10.dp)
                        ) {
                            Text(
                                text = "Войти",
                                modifier = Modifier
                                    .widthIn(min = 180.dp)
                                    .heightIn(min = 30.dp),
                                textAlign = TextAlign.Center,
                                fontSize = 25.sp,
                            )
                        }
                    }
                }


            }


        }
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun CombinedPreview() {
    NeMaxTheme {
        AppScreen()
    }
}