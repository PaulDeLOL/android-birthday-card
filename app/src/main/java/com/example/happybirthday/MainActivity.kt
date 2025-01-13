/*
 * Name: Pablo Guardia
 * Date: January 13, 2025
 * Assignment: Birthday Card App
 * Due Date: January 19th, 2025
 * About this project: Basic birthday card app using Android Studio and Jetpack Compose.
 * The git repository has two branches, one following the Android Developer course to the letter
 * and the other with a more personalized birthday card with my own customizations as a result
 * of experimenting to solidify my understanding of Jetpack Compose.
 * Git repository link: https://github.com/PaulDeLOL/android-birthday-card/tree/master
 * All work below was performed by Pablo Guardia
 */

package com.example.happybirthday

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.happybirthday.ui.theme.HappyBirthdayTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HappyBirthdayTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    GreetingImage(
                        message = stringResource(R.string.happy_birthday_text),
                        from = stringResource(R.string.signature_text)
                    )
                }
            }
        }
    }
}

// Custom font added by me
val CustomFont = FontFamily(
    Font(R.font.winner_sans_bold, FontWeight.Bold)
)

@Composable
fun GreetingText(message: String, from: String, modifier: Modifier = Modifier) {
    Column(
        // Vertical arrangement changed to add room for a second image
        verticalArrangement = Arrangement.SpaceAround,
        modifier = modifier
    ) {
        Text(
            // Font family changed to custom font
            text = message,
            fontSize = 64.sp,
            lineHeight = 116.sp,
            textAlign = TextAlign.Center,
            fontFamily = CustomFont
        )
        Image(
            // Second image added
            painter = painterResource(R.drawable.congrats),
            contentDescription = null,
            modifier = Modifier
                .size(350.dp)
                .align(alignment = Alignment.CenterHorizontally)
        )
        Text(
            text = from,
            fontSize = 36.sp,
            fontFamily = CustomFont,
            modifier = Modifier
                .padding(16.dp)
                .align(alignment = Alignment.CenterHorizontally)
        )
    }
}

@Composable
fun GreetingImage(message: String, from: String, modifier: Modifier = Modifier) {
    // Image changed from original given by Android Developer Course
    val image = painterResource(R.drawable.rebar_resolve_player_card_icon)
    Box(modifier) {
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            alpha = 0.75F,
            modifier = Modifier.fillMaxSize()
        )
        GreetingText(
            message = message,
            from = from,
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BirthdayCardPreview() {
    HappyBirthdayTheme {
        GreetingImage(
            message = stringResource(R.string.happy_birthday_text),
            from = stringResource(R.string.signature_text)
        )
    }
}