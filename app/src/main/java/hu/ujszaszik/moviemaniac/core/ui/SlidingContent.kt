package hu.ujszaszik.moviemaniac.core.ui

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.togetherWith
import androidx.compose.runtime.Composable

private const val TARGET_OFFSET = 1000

@Composable
fun SlidingContent(target: Boolean, content: @Composable (Boolean) -> Unit) {
    AnimatedContent(
        targetState = target,
        transitionSpec = {
            if (targetState) {
                (slideInHorizontally(initialOffsetX = { -TARGET_OFFSET }) + fadeIn()).togetherWith(
                    slideOutHorizontally(targetOffsetX = { TARGET_OFFSET }) + fadeOut()
                )
            } else {
                (slideInHorizontally(initialOffsetX = { TARGET_OFFSET }) + fadeIn()).togetherWith(
                    slideOutHorizontally(targetOffsetX = { -TARGET_OFFSET }) + fadeOut()
                )
            }
        }, label = ""
    ) { targetPage -> content.invoke(targetPage) }
}