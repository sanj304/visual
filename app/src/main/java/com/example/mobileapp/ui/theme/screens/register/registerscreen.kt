package com.example.mobileapp.ui.theme.screens.register

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
import com.example.mobileapp.data.AuthViewModel
import com.example.mobileapp.navigation.ROUTE_HOME
import com.example.mobileapp.navigation.ROUTE_LOGIN


@Composable
fun Greeting(name: String, navController: NavController) {
    var firstName by remember {
        mutableStateOf(value = "")
    }
    var secondName by remember {
        mutableStateOf(value = "")
    }
    var email by remember {
        mutableStateOf(value = "")
    }
    var phonenumber by remember {
        mutableStateOf(value = "")
    }
    var password by remember {
        mutableStateOf(value = "")
    }
    val context = LocalContext.current


    Column(
        modifier = Modifier
            .clip(shape = RoundedCornerShape(10.dp))
            .fillMaxWidth()
            .fillMaxHeight(),
        verticalArrangement = Arrangement.Center

    ) {
        Text(
            text = "Good morning $name",
            fontSize = 20.sp,
            fontFamily = FontFamily.Serif,
            fontStyle = FontStyle.Normal,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .background(Color.LightGray)
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
            label = { Text(text = "Enter first name") },
            placeholder = { Text(text = "Please enter first name") },
            value = firstName,
            onValueChange = { newName ->
                firstName = newName
            })
        Spacer(modifier = Modifier.height(10.dp))
        OutlinedTextField(modifier = Modifier
            .wrapContentWidth()
            .align(Alignment.CenterHorizontally),
            label = { Text(text = "Enter last name") },
            placeholder = { Text(text = "Please enter last name") },
            value = secondName,
            onValueChange = { newName ->
                secondName = newName
            })
        Spacer(modifier = Modifier.height(10.dp))
        OutlinedTextField(modifier = Modifier
            .wrapContentWidth()
            .align(Alignment.CenterHorizontally),
            label = { Text(text = "Enter email") },
            placeholder = { Text(text = "Please enter email") },
            value = email,
            onValueChange = { newName ->
                email = newName
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
                val register = AuthViewModel(navController, context)
                register.signup(firstName.trim(),secondName.trim(),email.trim(), password.trim())
                navController.navigate(ROUTE_HOME)
            },
            colors = ButtonDefaults.buttonColors(Color.Cyan),
            modifier = Modifier
                .wrapContentWidth()
                .align(Alignment.CenterHorizontally)
        ) {
            Text(
                modifier = Modifier.padding(10.dp),
                text = "REGISTER HERE"
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        Row {
            Button(
                onClick = {
                    navController.navigate(ROUTE_LOGIN)
                },
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
fun GreetingPreview(){
    Greeting("Brian", rememberNavController())
}