package com.nipun.binaryveda.data


import com.google.gson.annotations.SerializedName

/**
 * fetch the json form my own api
 */
data class ModelItem(
    @SerializedName("id")
    var id: String?,
    @SerializedName("image")
    var image: String?,
    @SerializedName("summary")
    var summary: String?,
    @SerializedName("title")
    var title: String?
)