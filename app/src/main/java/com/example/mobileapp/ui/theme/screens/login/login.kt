package com.example.mobileapp.ui.theme.screens.login

import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.mobileapp.R


@Composable
fun Login(navController: NavController) {
    var username by remember {
        mutableStateOf(value = "")
    }
    var password by remember {
        mutableStateOf(value = "")
    }
    Column(
        modifier = Modifier
            .clip(shape = RoundedCornerShape(10.dp))
            .fillMaxWidth()
            .fillMaxHeight(),
        verticalArrangement = Arrangement.Center

    ) {
        Text(
            text = "Please login first",
            fontSize = 20.sp,
            color = Color.White,
            fontFamily = FontFamily.Serif,
            fontStyle = FontStyle.Normal,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .background(Color.Magenta)
                .padding(20.dp)
                .fillMaxWidth()

        )
        Spacer(modifier = Modifier.height(10. dp))
        Image(
            modifier = Modifier
                .wrapContentHeight()
                .fillMaxWidth()
                .height(80.dp),
            painter = painterResource(id = R.drawable.xr),
            contentDescription = "xr image"
        )
        Spacer(modifier = Modifier.height(10.dp))
        OutlinedTextField(modifier = Modifier
            .wrapContentWidth()
            .align(Alignment.CenterHorizontally),
            label = { Text(text = "Enter username") },
            placeholder = { Text(text = "Please enter username") },
            value = username,
            onValueChange = { newName ->
                username = newName
            })
        Spacer(modifier = Modifier.height(10.dp))
        OutlinedTextField(modifier = Modifier
            .wrapContentWidth()
            .align(Alignment.CenterHorizontally),
            label = { Text(text = "Enter password") },
            placeholder = { Text(text = "Please enter password") },
            value = password,
            onValueChange = { newName ->
                password = newName
            })
        Spacer(modifier = Modifier.height(20.dp))
        Button(
            onClick = {
//                val intent = Intent(context,Dash::class.java)
//                context.startActivity(intent)
            },
            colors = ButtonDefaults.buttonColors(Color.Cyan),
            modifier = Modifier
                .wrapContentWidth()
                .align(Alignment.CenterHorizontally)
        ) {
            Text(
                modifier = Modifier.padding(10.dp),
                color = Color.Green,
                text = "LOGIN HERE"
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        Row {
            Button(
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(Color.Cyan))
            {
                Text(text = "LOGIN HERE")
                Spacer(modifier = Modifier.width(80.dp))
                Button(onClick = { /*TODO*/ },
                    colors = ButtonDefaults.buttonColors(Color.Cyan))
                {
                    Text(text = "FORGET PASSWORD")
                }
            }
        }
    }


}
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun LoginPreview(){
    Login(rememberNavController())
}