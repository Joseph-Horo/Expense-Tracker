package com.example.auth.signup


import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
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
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.core.ui.icons.Visibility
import com.example.core.ui.icons.VisibilityOff
import com.google.firebase.auth.FirebaseAuth

@Composable
fun SignUpScreen(navController: NavController) {
    var name by remember {
        mutableStateOf("")
    }

    var email by remember {
        mutableStateOf("")
    }

    var password by remember {
        mutableStateOf("")
    }

    var loading by remember {
        mutableStateOf(false)
    }

    var passwordVisible by remember {
        mutableStateOf(false)
    }

    val context = LocalContext.current
    val auth = FirebaseAuth.getInstance()

    Column(verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()) {
        Text("SignUp", fontSize = 30.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(40.dp))

        BasicTextField(
            value = name,
            onValueChange = {
                name = it
            },
            modifier = Modifier
                .fillMaxWidth()
                .size(70.dp)
                .padding(10.dp)
                .clip(RoundedCornerShape(30.dp))
                .background(Color(0xFFF1F5F9)),
            textStyle = TextStyle(fontSize = 24.sp),
            decorationBox = { innerTextField ->
                Row(
                    modifier = Modifier.fillMaxWidth()
                        .padding(horizontal = 10.dp),
                    verticalAlignment = Alignment.CenterVertically

                ) {
                    Icon(
                        imageVector = Icons.Default.Person,
                        contentDescription = "name"
                    )

                    Box(
                        modifier = Modifier.weight(1f)
                            .padding(10.dp),
                        contentAlignment = Alignment.CenterStart
                    ) {

                        if (name.isBlank()) {
                            Text("Name")
                        }
                        innerTextField()
                    }

                }

            }
        )
        Spacer(modifier = Modifier.height(4.dp))

        BasicTextField(
            value = email,
            onValueChange = {
                email = it
            },
            modifier = Modifier
                .fillMaxWidth()
                .size(70.dp)
                .padding(10.dp)
                .clip(RoundedCornerShape(30.dp))
                .background(Color(0xFFF1F5F9)),
            textStyle = TextStyle(fontSize = 24.sp),
            decorationBox = { innerTextField ->
                Row(
                    modifier = Modifier.fillMaxWidth()
                        .padding(horizontal = 10.dp),
                    verticalAlignment = Alignment.CenterVertically

                ) {
                    Icon(
                        imageVector = Icons.Default.Email,
                        contentDescription = "email"
                    )

                    Box(
                        modifier = Modifier.weight(1f)
                            .padding(10.dp),
                        contentAlignment = Alignment.CenterStart
                    ) {

                        if (email.isBlank()) {
                            Text("Email")
                        }
                        innerTextField()
                    }

                }

            }
        )
        Spacer(modifier = Modifier.height(4.dp))
        BasicTextField(
            value = password,
            onValueChange = {
                password = it
            },
            modifier = Modifier
                .fillMaxWidth()
                .size(70.dp)
                .padding(10.dp)
                .clip(RoundedCornerShape(30.dp))
                .background(Color(0xFFF1F5F9)),
            textStyle = TextStyle(fontSize = 24.sp),
            visualTransformation = if (passwordVisible) {
                VisualTransformation.None
            } else {
                PasswordVisualTransformation()
            },
            decorationBox = { innerTextField ->
                Row(
                    modifier = Modifier.fillMaxWidth()
                        .padding(horizontal = 10.dp),
                    verticalAlignment = Alignment.CenterVertically

                ) {
                    Icon(
                        imageVector = Icons.Default.Lock,
                        contentDescription = "password"
                    )

                    Box(
                        modifier = Modifier.weight(1f)
                            .padding(10.dp),
                        contentAlignment = Alignment.CenterStart
                    ) {

                        if (password.isBlank()) {
                            Text("Password")
                        }
                        innerTextField()
                    }
                    Icon(
                        imageVector = if (passwordVisible) {
                            VisibilityOff
                        } else {
                            Visibility
                        }, contentDescription = if (passwordVisible) {
                            "Hide Password"
                        } else {
                            "Show Password"
                        },
                        modifier = Modifier.clickable {
                            passwordVisible = !passwordVisible
                        })

                }

            }
        )
        Spacer(modifier = Modifier.height(8.dp))

        Button(
            onClick = {
                if (name.isBlank() || email.isBlank() || password.isBlank()) {
                    Toast.makeText(
                        context,
                        "Please fill all the fields",
                        Toast.LENGTH_SHORT
                    ).show()
                    return@Button
                }
                loading = true
                auth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener { task ->
                        loading = false
                        if (task.isSuccessful) {
                            Toast.makeText(
                                context,
                                "SignUp Successful",
                                Toast.LENGTH_SHORT
                            ).show()
                            navController.navigate("home")
                        } else {
                            Toast.makeText(
                                context,
                                task.exception?.message ?: "SignUp Failed",
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    }
            },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFC4B5FD))

        ) {
            if (loading) {
                CircularProgressIndicator()
            } else {
                Text("SignUp", color = Color.White)
            }
        }
        Spacer(modifier = Modifier.height(30.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {

            Text("Have an account?")
            Spacer(modifier = Modifier.width(4.dp))
            Text("Login", color = Color.Blue, modifier = Modifier.clickable {
                navController.popBackStack()
            })

        }
    }

}