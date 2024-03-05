package com.example.sbx3quiz3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.ArrowForwardIos
import androidx.compose.material.icons.outlined.ChevronRight
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.rounded.ExpandLess
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sbx3quiz3.data.Profile
import com.example.sbx3quiz3.data.profiles
import com.example.sbx3quiz3.ui.theme.SBX3Quiz3Theme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SBX3Quiz3Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TheApp()
                }
            }
        }
    }
}

@Composable
fun TheApp() {
    Scaffold(
topBar = {
    TopBar()
},
        bottomBar = {
            BottomMenu()
        }
    )  { it ->

        LazyColumn(contentPadding = it) {
            items(profiles) {
                ItemPeserta(
                    profile = it,
                    modifier = Modifier
                        .padding(horizontal = 16.dp, vertical = 8.dp)
                        .fillMaxWidth()
                )
            }
        }
    }
}

@Composable
fun InitialIcon (initialText: String, modifier: Modifier = Modifier) {
    Box(modifier = Modifier, contentAlignment = Alignment.Center) {
        Canvas(modifier = Modifier
            .size(50.dp)
            .fillMaxSize()) {
            drawCircle(SolidColor(Color(0xFFf283d8)))
        }
        Text(text = initialText, color = Color.White,
            style = MaterialTheme.typography.displayMedium)


    }
}


@Composable
fun ItemPeserta (
    modifier: Modifier = Modifier,
    profile: Profile
) {
    Card(modifier = modifier
    ) {
        Row (modifier = Modifier.padding(8.dp),
            verticalAlignment = Alignment.CenterVertically) {
            InitialIcon(profile.name.first().toString())
            Column (modifier = Modifier.padding(8.dp)) {
                Text(text = "${profile.name} (${profile.id})",
                    style = MaterialTheme.typography.labelSmall)
                Spacer(modifier = Modifier.padding(2.dp))
                Text(text = "${profile.age} Tahun \u2022 (${profile.town})",
                    style = MaterialTheme.typography.bodyLarge)
            }
            Spacer(modifier = Modifier.weight(1f))
            Icon(imageVector = Icons.Outlined.ChevronRight, contentDescription = "Next" )
        }
    }
}

@Composable
fun TopBar (modifier: Modifier = Modifier) {
    Card(colors = CardDefaults.cardColors(
        containerColor = MaterialTheme.colorScheme.secondaryContainer,
    ),
        shape = RectangleShape
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row {
                Text(
                    text = stringResource(id = R.string.title),
                    style = MaterialTheme.typography.displaySmall
                )
                Spacer(modifier = Modifier.weight(1f))
                Icon(imageVector = Icons.Outlined.Menu, contentDescription = "Page Info")
            }
            Spacer(modifier = Modifier.padding(4.dp))
            Text(
                text = stringResource(id = R.string.subtitle),
                style = MaterialTheme.typography.bodyLarge,
                color = Color.LightGray,
                lineHeight = 20.sp
            )

        }
    }
}

@Composable
fun BottomMenu ( modifier: Modifier = Modifier){
    Card (colors = CardDefaults.cardColors(
        containerColor = MaterialTheme.colorScheme.secondaryContainer,
    ),
        shape = RectangleShape
    ){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Menu(text = "Home", isClicked = true, icon = Icons.Outlined.Home)
            Menu(text = "Pencarian", isClicked = false, icon = Icons.Outlined.Search)
            Menu(text = "Profile", isClicked = false, icon = Icons.Filled.Person)
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