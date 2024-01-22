package com.example.submission1sbx3kotlin

import android.R.color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.materialIcon
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.colorspace.WhitePoint
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.submission1sbx3kotlin.ui.theme.Submission1SBX3KotlinTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Submission1SBX3KotlinTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ScreenCV()
                }
            }
        }
    }
}

@Composable
fun ScreenCV (modifier: Modifier = Modifier) {
    Column (

        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.padding(16.dp)
            .padding(top = 120.dp),
    ) {
        ImageHeader()
        IsiFormContainer()
        Spacer(modifier = Modifier.weight(1f))
        BottomMenu()


    }
}
@Composable
fun ImageHeader(modifier: Modifier = Modifier) {

    val image = painterResource(id = R.drawable.hsisakinah)
    Image(
        painter = image,
        contentDescription = null ,
        modifier = Modifier
            .size(width = 100.dp, height = 100.dp)
            .fillMaxWidth()
    )
}
@Composable
fun IsiFormContainer (modifier : Modifier = Modifier) {
    val image = painterResource(id = R.drawable.cv_form)
    Box (

        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = Color.LightGray.copy(alpha = 0.1f),
                shape = RoundedCornerShape(16.dp)
            )
            .padding(horizontal = 16.dp, vertical = 16.dp)


    )
    {
        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {


            Text(
                text = "Isi Form CV dulu, yuk!",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.SansSerif,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()

            )

            Text(
                text = stringResource(R.string.isi_cv),
                color = Color.LightGray.copy(alpha = 0.8f),
                fontSize = 14.sp,
                //fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.SansSerif,
                modifier = Modifier
                    .padding(top = 16.dp)
                    .fillMaxWidth(),
                textAlign = TextAlign.Center

            )

            Image(
                painter =image ,
                contentDescription = null,
                modifier = Modifier
                    .size(height = 210.dp, width = 210.dp)
                    .padding(top = 24.dp, bottom = 16.dp)

                )

            Row (
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly


            ) {
                Button(
                    onClick = {},
                    colors = ButtonDefaults.buttonColors(Color.White),
                    border = BorderStroke(width = 1.dp, color = Color(40, 45, 112)),
                    modifier = Modifier
                        .width(150.dp)
                        .height(50.dp),
                    shape = RoundedCornerShape(16)

                ) {
                    Text(
                        text = "Lewati",
                        color = Color(40, 45, 112),
                        )

                }

                Button(
                    onClick = {},
                    modifier = Modifier
                        .width(150.dp)
                        .height(50.dp),
                    shape = RoundedCornerShape(16)

                ) {
                    Text(
                        text = "Isi CV",
                        color = Color.White,

                        )
                }

            }

        }



    }
}

@Composable
fun Menu (
    modifier: Modifier = Modifier,
    text: String,
    isClicked: Boolean,
    icon: ImageVector
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            icon,
            contentDescription = null,
            tint = if (isClicked) Color(7, 181, 245) else Color.LightGray.copy(alpha = 0.8f)

        )
        Text(
            text = text,
            fontSize = 10.sp,
            color = if (isClicked) Color(7, 181, 245) else Color.LightGray.copy(alpha = 0.8f)
        )
    }

}

@Composable
fun BottomMenu ( modifier: Modifier = Modifier){
    Row (
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        Menu(text = "Home", isClicked = true, icon = Icons.Outlined.Home )
        Menu(text = "Pencarian", isClicked = false, icon = Icons.Outlined.Search )
        Menu(text = "Profile", isClicked = false, icon = Icons.Filled.Person )
    }
}






@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Submission1SBX3KotlinTheme {

    }
}