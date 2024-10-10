package com.example.mylibrary

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.TabRow
import androidx.compose.material3.LeadingIconTab
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTagsAsResourceId
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.pagerTabIndicatorOffset
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch


@OptIn(ExperimentalComposeUiApi::class, ExperimentalPagerApi::class)
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

        val loginTabBar = TabScreens(title = "Login") { LoginScreen() }
        val signUpTabBar = TabScreens(title = "SignUp") { SignUpScreen() }

        val list = listOf(loginTabBar, signUpTabBar)
        val pagerState = rememberPagerState(initialPage = 0)


        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            Tabs(tabs = list, pagerState = pagerState)
            TabContent(tabs = list, pagerState = pagerState)
        }


    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun Tabs(tabs: List<TabScreens>, pagerState: com.google.accompanist.pager.PagerState) {
    val scope = rememberCoroutineScope()
    TabRow(selectedTabIndex = pagerState.currentPage,
        indicator = { tabPositions ->
            Modifier.pagerTabIndicatorOffset(pagerState = pagerState, tabPositions = tabPositions)
        }) {
        tabs.forEachIndexed { index, tabItem ->
            LeadingIconTab(
                selected = pagerState.currentPage == index,

                onClick = {
                    scope.launch {
                        pagerState.animateScrollToPage(index)
                    }
                },
                text = {Text(tabItem.title) },
                icon = {null},
                selectedContentColor = Color.Green,
                unselectedContentColor = Color.White,
                enabled = true
            )
        }
    }
}
@OptIn(ExperimentalPagerApi::class)
@Composable
fun TabContent(tabs:List<TabScreens>, pagerState: com.google.accompanist.pager.PagerState) {
    HorizontalPager(count = tabs.size,state=pagerState) { page ->
        tabs[page].screens()

    }
}

class TabScreens(
    val title: String,
    val screens: @Composable () -> Unit
)
