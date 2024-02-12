package com.example.sbx3_kotlinquiz

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ExitToApp
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sbx3_kotlinquiz.ui.theme.SBX3KotlinQuizTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SBX3KotlinQuizTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LoginScreen()
                }
            }
        }
    }
}

@Composable
fun LoginScreen() {
    var userName by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var isTypedNIP by remember { mutableStateOf(false) }
    var isTypedPass by remember { mutableStateOf(false) }
    val toastLoginText = stringResource(id = toastLoginText(
        isTypedNIP, isTypedPass
    ))
    val toastFaq = stringResource(id = R.string.toast_faq)

    Column (
        modifier = Modifier
            .padding(horizontal = 32.dp)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        val context = LocalContext.current
        Image(
            painter = painterResource(
                id = R.drawable.hsisakinah),
            contentDescription = "Logo",
            modifier = Modifier
                .size(width = 100.dp, height = 100.dp)
        )
        TextInput(
            label = R.string.username,
            value = userName,
            onValueChange = {
                userName = it
                isTypedNIP = true
                if(userName=="") {
                    isTypedNIP=false
                }
                            },
            visualTransformation = VisualTransformation.None,
            modifier = Modifier
                .padding(vertical = 24.dp)
        )
        TextInput(
            label = R.string.password,
            value = password,
            visualTransformation = PasswordVisualTransformation(),
            onValueChange = {
                password = it
                isTypedPass = true
                if(password=="") {
                    isTypedPass=false
                }
                            },
            modifier = Modifier
        )

        Button(
            onClick = {
                Toast.makeText(context,toastLoginText,Toast.LENGTH_SHORT).show()
            },
            colors = ButtonDefaults.buttonColors(Color(0xFF4c9fc8)),
            shape = RoundedCornerShape(16.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 24.dp)
                .height(54.dp)

        ) {
            Text(
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                text = stringResource(id = R.string.Login),
            )
        }

        Text(
            text = stringResource(id = R.string.no_acces),
            modifier = Modifier
                .padding(bottom = 24.dp)
        )

        BodyText(
            label = R.string.contact_ikhwan,
            text = stringResource(id = R.string.contact_ikhwan),
            context = context,
            modifier = Modifier
                .padding(bottom = 24.dp)
        )

        BodyText(
            label = R.string.contact_akhwat,
            text = stringResource(id = R.string.contact_akhwat),
            context = context,
            modifier = Modifier
                .padding(bottom = 24.dp)
        )

        Spacer(modifier = Modifier.weight(1f))

        OutlinedButton(
            onClick = {
                      Toast.makeText(context,toastFaq,Toast.LENGTH_SHORT).show()
            },
            shape = RoundedCornerShape(16.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 24.dp)
                .height(54.dp)
                .border(
                    width = 1.dp,
                    color = Color(0xFF59a4cc),
                    shape = RoundedCornerShape(16.dp),

                    )
        ) {
            Text(
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                text = stringResource(id = R.string.faq),
                color = Color(0xFF59a4cc)
            )
            Spacer(modifier = Modifier.padding(4.dp))
            Icon(
                Icons.Outlined.ExitToApp,
                contentDescription = null,
                tint = Color(0xFF59a4cc)
                )
        }


    }
}


@Composable
fun TextInput(value: String,
              @StringRes label: Int,
              onValueChange: (String) -> Unit,
              visualTransformation: VisualTransformation,
              modifier: Modifier = Modifier) {
    Column (modifier = modifier) {
        Text(
            text = stringResource(label),
            modifier = Modifier
                .padding(bottom = 8.dp)
        )
        TextField(
            value = value,
            onValueChange = onValueChange,
            visualTransformation = visualTransformation,
            modifier = Modifier
                .background(
                    color = Color.LightGray.copy(alpha = 0.1f),
                    shape = RoundedCornerShape(16.dp)
                )
                .fillMaxWidth()
        )
    }

}

@Composable
fun BodyText(label: Int,context: Context,text: String, modifier: Modifier = Modifier){
    Text(
        color = Color(0xFF59a4cc),
        fontSize = 16.sp,
        text = stringResource(id = label),
        modifier = modifier
            .clickable {
                Toast.makeText(context,text,Toast.LENGTH_SHORT).show()
            }
    )

}

fun toastLoginText (isTypedNIP: Boolean, isTypedPass:Boolean): Int {
    if (!isTypedNIP && !isTypedPass) {
        return R.string.toast_NIP_Pass_isnt_typed
    } else if (!isTypedNIP) {
        return R.string.toast_NIP_isnt_typed
    }else if (!isTypedPass) {
        return R.string.toast_pass_isnt_typed
    }
    return R.string.Login_SUcceed
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SBX3KotlinQuizTheme {
        LoginScreen()
    }
}