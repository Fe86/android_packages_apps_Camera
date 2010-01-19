/*
 * Copyright (C) 2009 The Android Open Source Project
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

package com.android.camera;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.TypedArray;
import android.preference.PreferenceManager;
import android.util.AttributeSet;

/**
 * The base class of all Preferences used in Camera. The preferences can be
 * loaded from XML resource by <code>PreferenceInflater</code>.
 */
public abstract class CameraPreference {

    private String mTitle;
    private SharedPreferences mSharedPreferences;
    private Context mContext;

    public CameraPreference(Context context, AttributeSet attrs) {
        mContext = context;
        TypedArray a = context.obtainStyledAttributes(
                attrs, R.styleable.CameraPreference, 0, 0);
        mTitle = a.getString(R.styleable.CameraPreference_title);
        a.recycle();
    }

    public String getTitle() {
        return mTitle;
    }

    protected SharedPreferences getSharedPreferences() {
        if (mSharedPreferences == null) {
            mSharedPreferences =
                    PreferenceManager.getDefaultSharedPreferences(mContext);
        }
        return mSharedPreferences;
    }
}