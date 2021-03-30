package com.otex.homamrestaurant.view.home.model

import android.os.Parcel
import android.os.Parcelable

data class ModelHomeDashBord(
    val accepted: Int,
    val canceled: Int,
    val delivered: Int,
    val pending: Int,
    val revenue: Int
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(accepted)
        parcel.writeInt(canceled)
        parcel.writeInt(delivered)
        parcel.writeInt(pending)
        parcel.writeInt(revenue)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ModelHomeDashBord> {
        override fun createFromParcel(parcel: Parcel): ModelHomeDashBord {
            return ModelHomeDashBord(parcel)
        }

        override fun newArray(size: Int): Array<ModelHomeDashBord?> {
            return arrayOfNulls(size)
        }
    }
}