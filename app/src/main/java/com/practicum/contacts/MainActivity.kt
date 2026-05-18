package com.practicum.contacts

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.practicum.contacts.ui.theme.ContactsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ContactsTheme {
                ContactDetails(
                    Contact(
                        name = "Иван",
                        surname = "Иванович",
                        familyName = "Иванов",
                        isFavorite = true,
                        phone = "8 (999) 999 99 99",
                        address = "г. Москва, 3-я улица\nСтроителей, д.25, кв. 12",
                        email = "Elukashin@practicum.ru",
                    )
                )
            }
        }
    }
}