package com.example.gpds_gpu.localdados

import android.graphics.Bitmap
import android.media.Image
import android.os.Parcel
import android.os.Parcelable

/**
 * Created by gpds-gpu on 29/11/17.
 */
data class LocalClasse (var location: String, var descricao : String, var imagem : Bitmap) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString(),
            parcel.readParcelable(Bitmap::class.java.classLoader)) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(location)
        parcel.writeString(descricao)
        parcel.writeParcelable(imagem, flags)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<LocalClasse> {
        override fun createFromParcel(parcel: Parcel): LocalClasse {
            return LocalClasse(parcel)
        }

        override fun newArray(size: Int): Array<LocalClasse?> {
            return arrayOfNulls(size)
        }
    }
}