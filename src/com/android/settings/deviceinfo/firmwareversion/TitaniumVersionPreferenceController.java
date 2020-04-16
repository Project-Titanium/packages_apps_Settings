/*
 * Copyright (C) 2017 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.android.settings.deviceinfo.firmwareversion;

import android.content.Context;
import android.os.SystemProperties;
import androidx.annotation.VisibleForTesting;

import com.android.settings.R;
import com.android.settings.core.BasePreferenceController;

public class TitaniumVersionPreferenceController extends BasePreferenceController {

    @VisibleForTesting
    private static final String TITANIUM_NUM_VERSION = "ro.titanium.build.version";
    private static final String TITANIUM_BUILD_TYPE = "ro.titanium.buildtype";
    private static final String TITANIUM_BUILD_DATE = "ro.titanium.build.date";


    public TitaniumVersionPreferenceController(Context context, String preferenceKey) {
        super(context, preferenceKey);
    }

    @Override
    public int getAvailabilityStatus() {
        return AVAILABLE;
    }

    @Override
    public CharSequence getSummary() {
       /* return SystemProperties.get(TITANIUM_VERSION_PROPERTY,
                mContext.getString(R.string.device_info_default)); */
     String titaniumVer =  SystemProperties.get(TITANIUM_NUM_VERSION);
     String titaniumDate = SystemProperties.get(TITANIUM_BUILD_DATE);
     String titaniumType = SystemProperties.get(TITANIUM_BUILD_TYPE);

      if (!titaniumVer.isEmpty() && !titaniumDate.isEmpty() && !titaniumType.isEmpty())
	    return titaniumVer + " | " + titaniumDate + " | " + titaniumType;
	else
            return mContext.getString(R.string.unknown);

    }
}
