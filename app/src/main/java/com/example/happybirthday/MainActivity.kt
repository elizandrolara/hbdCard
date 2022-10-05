package com.example.happybirthday

import android.os.Bundle
import android.os.Message
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.happybirthday.ui.theme.HappyBirthdayTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HappyBirthdayTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    val name:String= getString(R.string.place_name)
                    BirthdayGreetingWithImage(
                        message = getString(R.string.happy_birthday_txt) +  " $name" + "!" ,
                        from = getString(R.string.signature_text),
                    )
                }
            }
        }
    }
}

@Composable
fun BirthdayGreetingWithText(message: String, from : String){
    Column() {
        Text(
            text = message,
            fontSize = 36.sp,

            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(Alignment.CenterHorizontally)
                .padding(start = 16.dp, top = 16.dp)

        )
        Text(
            text = from,
            fontSize = 26.sp,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(Alignment.End)
                .padding(start = 16.dp, top = 16.dp)
        )
    }
}

@Composable
fun BirthdayGreetingWithImage(message: String, from : String){
    val image = painterResource(id = R.drawable.androidparty)
    Box {
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth(),
            contentScale = ContentScale.Crop
        )
        BirthdayGreetingWithText(message = message, from = from)
    }
}

@Preview(showBackground = false)
@Composable
fun BirthdayCardPreview() {
    val name :String = "Meredit"
    HappyBirthdayTheme {
        BirthdayGreetingWithImage(
            message = "Happy Birthday $name !!",
            from = "- from Elizandro",
        )

    }
}