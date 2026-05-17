package com.practicum.contacts

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ContactDetails(contact: Contact) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .statusBarsPadding()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ContactIcon(contact)
        ContactHeader(contact)
        Column(
            modifier = Modifier.padding(top = 48.dp)
        ) {
            InfoRow(stringResource(R.string.phone), contact.phone)
            InfoRow(stringResource(R.string.address), contact.address)
            contact.email?.let {
                InfoRow(stringResource(R.string.email), contact.email)
            }
        }
    }
}

@Composable
fun ContactIcon(contact: Contact) {
    Box(
        contentAlignment = Alignment.Center
    ) {
        if (contact.imageRes != null) {
            Image(
                modifier = Modifier.size(80.dp),
                painter = painterResource(contact.imageRes),
                contentDescription = null,
            )
        } else {
            Icon(
                modifier = Modifier.size(80.dp),
                painter = painterResource(R.drawable.circle),
                tint = Color.LightGray,
                contentDescription = null
            )
            Text(
                text = remember { contact.name.take(1) + contact.familyName.take(1).uppercase() }
            )
        }
    }
}

@Composable
fun ContactHeader(contact: Contact) {
    Box {
        Column(
            modifier = Modifier
                .padding(top = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    text = remember { contact.name },
                    style = MaterialTheme.typography.titleLarge
                )
                if (contact.surname != null) {
                    Text(
                        text = remember { contact.surname },
                        style = MaterialTheme.typography.titleLarge
                    )
                }
            }
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = remember { contact.familyName },
                    style = MaterialTheme.typography.headlineMedium
                )
                if (contact.isFavorite) {
                    Image(
                        modifier = Modifier.padding(start = 4.dp),
                        painter = painterResource(id = android.R.drawable.star_big_on),
                        contentDescription = null
                    )
                }
            }

        }
    }
}

@Composable
fun InfoRow(label: String, value: String) {
    Row(
        modifier = Modifier.padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            text = remember { label },
            modifier = Modifier.weight(5f),
            textAlign = TextAlign.End,
        )
        Text(
            modifier = Modifier.padding(end = 8.dp),
            text = remember { ":" },
        )
        Text(
            text = remember { value },
            modifier = Modifier.weight(5f)
        )
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun ContactDetailsPreview() {
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

@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun ContactDetailsPreviewWithImage() {
    ContactDetails(
        Contact(
            name = "Иван",
            surname = null,
            familyName = "Иванов",
            imageRes = R.drawable.ic_launcher_background,
            isFavorite = false,
            phone = "8 (999) 999 99 99",
            address = "г. Москва, 3-я улица\nСтроителей, д.25, кв. 12",
            email = "Elukashin@practicum.ru",
        )
    )
}