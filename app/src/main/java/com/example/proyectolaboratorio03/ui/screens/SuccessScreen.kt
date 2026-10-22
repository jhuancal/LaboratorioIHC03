package com.example.proyectolaboratorio03.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.proyectolaboratorio03.model.EnrollmentVoucher
import com.example.proyectolaboratorio03.model.MockData
import com.example.proyectolaboratorio03.ui.designsystem.atoms.UnsaOutlinedButton
import com.example.proyectolaboratorio03.ui.designsystem.atoms.UnsaPrimaryButton
import com.example.proyectolaboratorio03.ui.designsystem.organisms.UnsaDigitalVoucherCard
import com.example.proyectolaboratorio03.ui.theme.Gray500
import com.example.proyectolaboratorio03.ui.theme.ProyectoLaboratorio03Theme
import com.example.proyectolaboratorio03.ui.theme.UnsaGreen
import com.example.proyectolaboratorio03.ui.theme.White

/**
 * Pantalla 9: Confirmación Exitosa y Comprobante Digital con Código QR
 * Alimentada por la clase EnrollmentVoucher y MockData.
 */
@Composable
fun SuccessScreen(
    onHomeClick: () -> Unit,
    onShareClick: () -> Unit = {},
    voucher: EnrollmentVoucher = MockData.sampleVoucher,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(White)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(UnsaGreen)
                .statusBarsPadding()
                .padding(vertical = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "¡Todo listo!",
                color = White,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Column(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 24.dp, vertical = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Box(
                modifier = Modifier
                    .size(76.dp)
                    .clip(CircleShape)
                    .background(UnsaGreen),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.Check,
                    contentDescription = "Confirmado",
                    tint = White,
                    modifier = Modifier.size(42.dp)
                )
            }

            Spacer(modifier = Modifier.height(14.dp))

            Text(
                text = "Inscripción confirmada",
                color = UnsaGreen,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )

            Text(
                text = "Comprobante guardado localmente",
                color = Gray500,
                fontSize = 13.sp,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(20.dp))

            UnsaDigitalVoucherCard(
                workshopName = voucher.displayHeader,
                studentInfo = voucher.displayStudent,
                scheduleInfo = voucher.displaySchedule,
                validityBadge = voucher.semesterBadge
            )
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .navigationBarsPadding()
                .padding(horizontal = 24.dp, vertical = 20.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            UnsaOutlinedButton(
                text = "Compartir QR",
                onClick = onShareClick,
                icon = {
                    Icon(
                        imageVector = Icons.Default.Share,
                        contentDescription = null,
                        modifier = Modifier.size(18.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                }
            )

            UnsaPrimaryButton(
                text = "Mis Talleres",
                onClick = onHomeClick
            )
        }
    }
}

@Preview(showBackground = true, widthDp = 375, heightDp = 812)
@Composable
private fun SuccessScreenPreview() {
    ProyectoLaboratorio03Theme {
        SuccessScreen(
            onHomeClick = {}
        )
    }
}
