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

    // No changes needed here
    override fun getApplicableUastTypes() = listOf(UCallExpression::class.java)

    override fun createUastHandler(context: JavaContext): UElementHandler {
        return object : UElementHandler() {
            override fun visitCallExpression(node: UCallExpression) {
                // We will check for the fully qualified name of the function
                val qualifiedName = node.resolve()?.let {
                    it.containingClass?.qualifiedName + "." + it.name
                }

                if (qualifiedName == "androidx.compose.material3.ButtonKt.Button") {
                    // This is where we build the quick fix
                    val fix = LintFix.create()
                        .replace().text("Button").with("com.example.clarity.core.ui.ClarityButton").shortenNames()
                        .range(context.getLocation(node.methodIdentifier ?: node)).build()

                    context.report(
                        issue = ISSUE,
                        location = context.getLocation(node),
                        message = "Use ClarityButton from the :core-ui module instead.",
                        quickfixData = fix.autoFix()
                    )
                }
            }
        }
    }

    companion object {
        @JvmField
        val ISSUE: Issue = Issue.create(
            // No changes needed in the Issue definition
            id = "WrongComponentUsage",
            briefDescription = "Incorrect component used.",
            explanation = "Use `ClarityButton` from the `:core-ui` module instead of `androidx.compose.material3.Button`.",
            category = Category.CORRECTNESS,
            priority = 6,
            severity = Severity.ERROR,
            implementation = Implementation(
                WrongComponentDetector::class.java, Scope.JAVA_FILE_SCOPE
            )
        )
    }
}