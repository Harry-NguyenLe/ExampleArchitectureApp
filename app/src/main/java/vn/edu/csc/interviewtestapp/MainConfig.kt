package vn.edu.csc.interviewtestapp

object MainConfig {
    const val DEV_DOMAIN_URL = ""
    const val TEST_DOMAIN_URL = ""
    const val SANDBOX_DOMAIN_URL = "https://moneyforwardvietnam.github.io/"
    const val STAGING_DOMAIN_URL = ""
    const val PRODUCTION_DOMAIN_URL = ""

    val env: ENV = ENV.SANDBOX

    enum class ENV {
        DEV,
        TEST,
        SANDBOX,
        STAGING,
        PRODUCTION
    }
}