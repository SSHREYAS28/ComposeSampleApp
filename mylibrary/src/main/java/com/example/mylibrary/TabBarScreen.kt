package com.example.mylibrary

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTagsAsResourceId
import androidx.compose.ui.unit.dp
import com.philips.filament.components.tabbar.DlsTabBar
import com.philips.filament.components.tabbar.DlsTabBarItem


@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun TabBarScreen() {
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .semantics { testTagsAsResourceId = true },
        topBar = {
            NavigationBar {
                Text(
                    text = "TabBarScreen",
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        },
    ) { innerPadding ->
        val dlsLoginTabBar = DlsTabBarItem(
            label = "Login", enabled = true,
        ) {
            Box(
                modifier = Modifier.padding(horizontal = 24.dp)
            ) {
                LoginScreen()
            }
        }
        val dlsSignUpTabBar = DlsTabBarItem(
            label = "SignUp", enabled = true) {
            Box (
                modifier = Modifier.padding(horizontal = 24.dp)
            ){
                SignUpScreen()

            }
        }

        val listDlsTabBar = listOf(dlsLoginTabBar, dlsSignUpTabBar)
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .padding(24.dp)
            ) {
                DlsTabBar(
                    tabBarItems = listDlsTabBar, initialPage = 0, userScrollEnabled = true
                )
            }
    }
}
