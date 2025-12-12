package com.example.csci412assignment2_adambitz

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.uiautomator.By
import androidx.test.uiautomator.UiDevice
import androidx.test.uiautomator.Until
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class UITest {

    lateinit var device: UiDevice
    val timeout = 5000L

    @Before
    fun startApp() {
        device = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())
        device.pressHome()
        device.wait(Until.hasObject(By.desc("CSCI 412 Assignment 2 - Adam Bitz")), timeout)
        val appIcon = device.findObject(By.desc("CSCI 412 Assignment 2 - Adam Bitz"))
        appIcon.click()
    }
    @Test
    fun testSecondActivity() {
        device.wait(Until.hasObject(By.text("Start Activity Explicitly")), timeout)
        val startButton = device.findObject(By.text("Start Activity Explicitly"))
        startButton.click()
        device.wait(Until.hasObject(By.textContains("Main Activity")), timeout)
        val challengeText = device.findObject(By.textContains("1. There are a large number of device configurations and specifications in circulation."))
        assertTrue(challengeText != null)
    }
}
