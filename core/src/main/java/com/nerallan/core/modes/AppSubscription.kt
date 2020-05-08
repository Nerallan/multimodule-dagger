package com.nerallan.core.modes

import com.nerallan.core.R
import com.nerallan.core.utils.IStringProvider
import javax.inject.Inject

class AppSubscription @Inject constructor(private val stringsProvider: IStringProvider): IAppSubscription  {
    override fun getUserSubscription(): String {
        //Currently just one app type, so one suscription
        return stringsProvider.getString(R.string.subscription_free_title)
    }
}
