package ru.syndicate.fluffyclouds.info_functions

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Typeface
import android.graphics.pdf.PdfDocument
import android.os.Environment
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import ru.syndicate.fluffyclouds.R
import ru.syndicate.fluffyclouds.data.model.Airplane
import java.io.File
import java.io.FileOutputStream
import java.io.IOException

fun generatePDF(context: Context, list: List<Airplane>) {
    val pageHeight = 1120
    val pageWidth = 792

    val pdfDocument = PdfDocument()
    val title = Paint()

    var pageNumber = 1
    var padding = 100f

    var myPageInfo = PdfDocument.PageInfo.Builder(pageWidth, pageHeight, pageNumber).create()
    var myPage = pdfDocument.startPage(myPageInfo)
    var canvas: Canvas = myPage.canvas
    title.typeface = Typeface.create(Typeface.DEFAULT, Typeface.NORMAL)
    title.textSize = 15f
    title.color = ContextCompat.getColor(context, R.color.black)

    for (i in list.indices) {

        if (padding == 1100f) {
            pageNumber++
            myPageInfo = PdfDocument.PageInfo.Builder(pageWidth, pageHeight, pageNumber).create()
            myPage = pdfDocument.startPage(myPageInfo)
            canvas = myPage.canvas
            padding = 100f
        }

        canvas.drawText("id: ${list[i].id}; модель: ${list[i].model}; вместимость: ${list[i].quantitySeat}", 100f, padding, title)

        padding += 50
    }

    pdfDocument.finishPage(myPage)
    val file = File("${Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).path}/airplane.pdf")

    try {
        pdfDocument.writeTo(FileOutputStream(file))
        Toast.makeText(context, "PDF file generated successfylly", Toast.LENGTH_SHORT).show()
    } catch (ex: IOException) {
        ex.printStackTrace()
    }
    pdfDocument.close()
}

private fun foregroundPermissionApproved(context: Context): Boolean {
    val writePermissionFlag = PackageManager.PERMISSION_GRANTED == ActivityCompat.checkSelfPermission(
        context, Manifest.permission.WRITE_EXTERNAL_STORAGE
    )
    val readPermissionFlag = PackageManager.PERMISSION_GRANTED == ActivityCompat.checkSelfPermission(
        context, Manifest.permission.READ_EXTERNAL_STORAGE
    )

    return writePermissionFlag && readPermissionFlag
}

fun requestForegroundPermission(context: Context) {
    val provideRationale = foregroundPermissionApproved(context = context)
    if (provideRationale) {
        ActivityCompat.requestPermissions(
            context as Activity,
            arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE),
            34
        )
    } else {
        ActivityCompat.requestPermissions(
            context as Activity,
            arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE),
            34
        )
    }
}