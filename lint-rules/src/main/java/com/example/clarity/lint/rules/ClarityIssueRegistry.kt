package com.example.clarity.lint.rules

import com.android.tools.lint.client.api.IssueRegistry
import com.android.tools.lint.client.api.Vendor
import com.android.tools.lint.detector.api.CURRENT_API
import com.android.tools.lint.detector.api.Issue

class ClarityIssueRegistry : IssueRegistry() {
    override val issues: List<Issue>
        get() = listOf(WrongComponentDetector.ISSUE)

    override val api: Int
        get() = CURRENT_API

    override val vendor: Vendor = Vendor(
        vendorName = "Clarity",
        feedbackUrl = "https://github.com/your-org/clarity/issues",
        contact = "clarity@your-org.com"
    )
}
