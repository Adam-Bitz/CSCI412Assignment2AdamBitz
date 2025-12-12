package com.example.csci412assignment2_adambitz

import android.net.Uri
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.content.FileProvider
import com.bumptech.glide.Glide
import com.example.csci412assignment2_adambitz.ui.theme.CSCI412Assignment2AdamBitzTheme
import java.io.File

class ImageActivity : ComponentActivity() {
    private lateinit var imageFile: File
    private lateinit var imageUri: Uri
    private lateinit var cameraLauncher: ActivityResultLauncher<Uri>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        cameraLauncher =
            registerForActivityResult(ActivityResultContracts.TakePicture()) { success ->
                if (success) {
                    takenImageUriState?.value = imageUri
                }
            }
        setContent {
            CSCI412Assignment2AdamBitzTheme {
                CameraScreen(
                    onOpenCamera = {
                        imageFile = createImageFile()
                        imageUri = FileProvider.getUriForFile(
                            this,
                            "${packageName}.fileprovider",
                            imageFile
                        )
                        cameraLauncher.launch(imageUri)
                    }
                )
            }
        }
    }

    companion object {
        var takenImageUriState: MutableState<Uri?>? = null
    }

    private fun createImageFile(): File {
        val dir = File(cacheDir, "images").apply { mkdirs() }
        return File.createTempFile("captured_", ".jpg", dir)
    }
}

@Composable
fun CameraScreen(onOpenCamera: () -> Unit) {
    val photoUri = remember { mutableStateOf<Uri?>(null) }
    ImageActivity.takenImageUriState = photoUri

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Button(onClick = onOpenCamera) {
            Text("Open Camera")
        }

        Spacer(modifier = Modifier.height(130.dp))

        photoUri.value?.let { uri ->
            AndroidView(
                factory = { context ->
                    ImageView(context).apply { adjustViewBounds = true }
                },
                modifier = Modifier,
                update = { imageView ->
                    Glide.with(imageView.context)
                        .load(uri)
                        .into(imageView)
                }
            )
        }
    }
}