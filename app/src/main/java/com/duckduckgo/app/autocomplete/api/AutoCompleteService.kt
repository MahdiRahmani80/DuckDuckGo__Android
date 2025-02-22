/*
 * Copyright (c) 2018 DuckDuckGo
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.duckduckgo.app.autocomplete.api

import com.duckduckgo.anvil.annotations.ContributesNonCachingServiceApi
import com.duckduckgo.common.utils.AppUrl
import com.duckduckgo.di.scopes.AppScope
import java.util.*
import retrofit2.http.GET
import retrofit2.http.Query

@ContributesNonCachingServiceApi(AppScope::class)
interface AutoCompleteService {

    @GET("${AppUrl.Url.API}/ac/")
    suspend fun autoComplete(
        @Query("q") query: String,
        @Query("kl") languageCode: String = Locale.getDefault().language,
        @Query("is_nav") nav: String = "1",
    ): List<AutoCompleteServiceRawResult>
}

data class AutoCompleteServiceRawResult(
    val phrase: String,
    val isNav: Boolean?,
)
