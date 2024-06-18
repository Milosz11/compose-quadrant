package com.example.composequadrant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composequadrant.ui.theme.ComposeQuadrantTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeQuadrantTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ComposeGridApp()
                }
            }
        }
    }
}

@Composable
fun ComposeGridApp() {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier.weight(1f)
        ) {
            Quadrant(
                header = "Text composable",
                sentence = "Displays text and follows the recommended Material Design guidelines.",
                color = Color(0xFFEADDFF),
                modifier = Modifier.weight(1f)
            )
            Quadrant(
                header = "Image composable",
                sentence = "Creates a composable that lays out and draws a given Painter class object.",
                color = Color(0xFFD0BCFF),
                modifier = Modifier.weight(1f)
            )
        }
        Row(
            modifier = Modifier.weight(1f)
        ) {
            Quadrant(
                header = "Row composable",
                sentence = "A layout composable that places its children in a horizontal sequence.",
                color = Color(0xFFB69DF8),
                modifier = Modifier.weight(1f)
            )
            Quadrant(
                header = "Column composable",
                sentence = "A layout composable that places its children in a vertical sequence.",
                color = Color(0xFFF6EDFF),
                modifier = Modifier.weight(1f)
            )
        }
    }
}

@Composable
fun Quadrant(header: String, sentence: String, color: Color, modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
            .background(color)
            .fillMaxSize()
    ) {
        Text(
            text = header,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp, bottom = 16.dp)
        )
        Text(
            text = sentence,
            textAlign = TextAlign.Justify,
            modifier = Modifier
                .padding(horizontal = 16.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ComposeGridPreview() {
    ComposeQuadrantTheme {
        ComposeGridApp()
    }
}
