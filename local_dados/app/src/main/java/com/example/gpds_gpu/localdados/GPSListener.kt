package com.example.gpds_gpu.localdados

import android.location.Location
import android.location.LocationListener
import android.os.Bundle
import android.util.Log

/**
 * Created by gpds-gpu on 29/11/17.
 */
class GPSListener: LocationListener {
    var location = ""

    override fun toString(): String {
        return location
    }

    override fun onLocationChanged(location: Location?) {
        Log.i("APP_GPS", "${location?.latitude} - ${location?.longitude}")
        this.location = "${location?.latitude}, ${location?.longitude}"
        System.out.println("Entrou aqui: "+this.location)
    }

    override fun onStatusChanged(provider: String?, status: Int, extras: Bundle?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onProviderEnabled(provider: String?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onProviderDisabled(provider: String?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}