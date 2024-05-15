package com.uam.loginapp

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.uam.loginapp.ui.theme.LoginAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LoginAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                   Content(Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun Content(modifier : Modifier){
    var usuario by remember{ mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    val context = LocalContext.current

    Column(horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
        ,modifier=Modifier.fillMaxSize()) {
        Image(painter = painterResource(id = R.drawable.usuario)
            , contentDescription = null)
        Spacer(modifier=Modifier.height(10.dp))
        TextField(value=usuario,
            onValueChange = {usuario = it},
            label={Text(text= stringResource(id = R.string.usuario))})
        Spacer(modifier=Modifier.height(10.dp))
        TextField(value=password,
            onValueChange = {password = it},
            label={Text(text= stringResource(id = R.string.password))})
        Spacer(modifier=Modifier.height(10.dp))
        CheckBoxExample()
        Spacer(modifier=Modifier.height(10.dp))
        Button(onClick = {
            Toast.makeText(
                context,
                "usuario: $usuario, password : $password",
                Toast.LENGTH_LONG
            ).show()
        }) {
           Text(text= stringResource(id = R.string.bottonLogin))
        }
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LoginAppTheme {
        Content(Modifier.padding(10.dp))
    }
}

@Composable
fun CheckBoxExample() {
    val isChecked = remember { mutableStateOf(false) }
    Row(horizontalArrangement = Arrangement.Center) {
        Checkbox(checked = isChecked.value
            , onCheckedChange = {isChecked.value=it}
            , enabled = true
            ,modifier = Modifier
                .size(3.dp)
        )
        Spacer(modifier=Modifier.width(2.dp))
        Text(text= stringResource(id = R.string.privacidad),
            textAlign = TextAlign.Center,
            fontSize = 12.sp)
    }
}