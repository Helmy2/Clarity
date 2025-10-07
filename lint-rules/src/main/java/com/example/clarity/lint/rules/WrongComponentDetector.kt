package com.example.clarity.lint.rules

import com.android.tools.lint.client.api.UElementHandler
import com.android.tools.lint.detector.api.Category
import com.android.tools.lint.detector.api.Detector
import com.android.tools.lint.detector.api.Implementation
import com.android.tools.lint.detector.api.Issue
import com.android.tools.lint.detector.api.JavaContext
import com.android.tools.lint.detector.api.LintFix
import com.android.tools.lint.detector.api.Scope
import com.android.tools.lint.detector.api.Severity
import org.jetbrains.uast.UCallExpression

class WrongComponentDetector : Detector(), Detector.UastScanner {

    override fun getApplicableUastTypes() = listOf(UCallExpression::class.java)

    override fun createUastHandler(context: JavaContext): UElementHandler {
        return object : UElementHandler() {
            override fun visitCallExpression(node: UCallExpression) {
                val qualifiedName = node.resolve()?.let {
                    it.containingClass?.qualifiedName + "." + it.name
                }

                replacements[qualifiedName]?.let { replacement ->
                    val fix = LintFix.create()
                        .replace().text(node.methodIdentifier?.name)
                        .with("com.example.clarity.core.ui.components.$replacement").shortenNames()
                        .range(context.getLocation(node.methodIdentifier ?: node)).build()

                    context.report(
                        issue = ISSUE,
                        location = context.getLocation(node),
                        message = "Use $replacement from the :core-ui module instead.",
                        quickfixData = fix.autoFix()
                    )
                }
            }
        }
    }

    companion object {
        @JvmField
        val ISSUE: Issue = Issue.create(
            id = "WrongComponentUsage",
            briefDescription = "Incorrect component used.",
            explanation = "Use components from the `:core-ui` module instead of Material Design components.",
            category = Category.CORRECTNESS,
            priority = 6,
            severity = Severity.ERROR,
            implementation = Implementation(
                WrongComponentDetector::class.java, Scope.JAVA_FILE_SCOPE
            )
        )

        private val replacements = mapOf(
            "androidx.compose.material3.ButtonKt.Button" to "ClarityButton",
            "androidx.compose.material3.CardKt.Card" to "ClarityCard",
            "androidx.compose.material3.ScaffoldKt.Scaffold" to "ClarityScaffold",
            "androidx.compose.material3.TextFieldKt.TextField" to "ClarityTextField",
            "androidx.compose.material3.TopAppBarKt.TopAppBar" to "ClarityTopAppBar",
            "androidx.compose.material3.TextKt.Text" to "ClarityText",
            "androidx.compose.material3.CheckboxKt.Checkbox" to "ClarityCheckbox",
            "androidx.compose.material3.IconKt.Icon" to "ClarityIcon",
        )
    }
}
