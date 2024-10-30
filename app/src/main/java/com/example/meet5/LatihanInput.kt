package com.example.meet5

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.selects.select

@Preview(showBackground = true)
@Composable
fun LatihanInput(modifier: Modifier = Modifier) {

    var nama by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var noHp by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }

    var simpanNama by remember { mutableStateOf("") }
    var simpanEmail by remember { mutableStateOf("") }
    var simpanNoHp by remember { mutableStateOf("") }
    var simpanAlamat by remember { mutableStateOf("") }

    var jenisK by remember { mutableStateOf("") }
    var simpanJenisK by remember { mutableStateOf("") }
    val dataJK = listOf("Laki - Laki","Perempuan")

    Column (modifier = modifier
        .fillMaxSize()
        .padding(16.dp),

        horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Biodata",
            fontWeight = FontWeight.Bold,
            fontSize = 28.sp)
        Spacer(modifier = Modifier .padding(20.dp))
        TextField(
            modifier = Modifier .fillMaxWidth().padding(5.dp),
            value = nama,
            onValueChange = {nama = it},
            label = { Text("Nama")
            },
            placeholder = {
                Text("Masukkan Nama Anda")
            }
        )

        Row (modifier = Modifier.padding(5.dp),
            verticalAlignment = Alignment.CenterVertically)
        {
            dataJK.forEach { selectedJK ->
                Row (
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .padding(5.dp))
                {
                    RadioButton(selected = jenisK == selectedJK,
                        onClick = {
                            jenisK = selectedJK
                        })
                    Text(selectedJK)
                }
            }
        }

        TextField(
            modifier = Modifier .fillMaxWidth().padding(5.dp),
            value = email,
            onValueChange = {email = it},
            label = { Text("Email")
            },
            placeholder = {
                Text("Masukkan Email Anda")
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
        )


        TextField(
            modifier = Modifier .fillMaxWidth().padding(5.dp),
            value = noHp,
            onValueChange = {noHp = it},
            label = { Text("No HP")
            },
            placeholder = {
                Text("Masukkan No HP Anda")
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        TextField(
            modifier = Modifier .fillMaxWidth().padding(5.dp),
            value = alamat,
            onValueChange = {alamat = it},
            label = { Text("Alamat")
            },
            placeholder = {
                Text("Masukkan Alamat Anda")
            }
        )

        Button(onClick = {simpanNama = nama
                         simpanEmail = email
                         simpanNoHp = noHp
                         simpanAlamat = alamat
                         simpanJenisK = jenisK},
            modifier = Modifier
                .padding(vertical = 10.dp )) {
            Text("Simpan")
        }
        Card(modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp))
        {
            Column {
                TampilData(
                    judul = "Nama",
                    isinya = simpanNama
                )
                TampilData(
                    judul = "Jenis Kelamin",
                    isinya = simpanJenisK
                )
                TampilData(
                    judul = "Email",
                    isinya = simpanEmail
                )
                TampilData(
                    judul = "No HP",
                    isinya = simpanNoHp
                )
                TampilData(
                    judul = "Alamat",
                    isinya = simpanAlamat
                )
            }
        }
    }
}

@Composable
fun TampilData(
    judul :String,
    isinya :String
){
    Row (modifier = Modifier
        .padding(16.dp)
        .fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween){
        Text(judul, modifier = Modifier .weight(0.8f))
        Text(":", modifier = Modifier .weight(0.2f))
        Text(isinya, modifier = Modifier .weight(2f))

    }
}